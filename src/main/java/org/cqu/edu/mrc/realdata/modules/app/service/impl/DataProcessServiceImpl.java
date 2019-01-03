package org.cqu.edu.mrc.realdata.modules.app.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.common.enums.ReplyEnum;
import org.cqu.edu.mrc.realdata.common.enums.RequestEnum;
import org.cqu.edu.mrc.realdata.modules.app.form.MedicalDataForm;
import org.cqu.edu.mrc.realdata.modules.app.dto.ParseDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ResultDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.service.DataProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/24 21:41
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
@Slf4j
public class DataProcessServiceImpl implements DataProcessService {

    private final DeviceServiceImpl deviceService;
    private final OperationMarkServiceImpl operationMarkService;
    private final PreoperativePatientServiceImpl preoperativePatientService;
    private final OperationInformationServiceImpl operationInformationService;

    @Autowired
    public DataProcessServiceImpl(DeviceServiceImpl deviceService, OperationMarkServiceImpl operationMarkService, PreoperativePatientServiceImpl preoperativePatientService, OperationInformationServiceImpl operationInformationService) {
        this.deviceService = deviceService;
        this.operationMarkService = operationMarkService;
        this.preoperativePatientService = preoperativePatientService;
        this.operationInformationService = operationInformationService;
    }

    /**
     * 仅解析JSON数据，如果数据有错误，则返回null
     *
     * @param jsonBuffer JSON 字符串
     * @return MedicalDataDTO实体类
     */
    private Map parseJson(String jsonBuffer) {
        try {
            return new Gson().fromJson(jsonBuffer, Map.class);
        } catch (JsonSyntaxException jsonSyntaxException) {
            return null;
        }
    }

    @Override
    public ResultDataDTO processMedicalData(MedicalDataForm medicalDataForm) {

        if (null == medicalDataForm) {
            return new ResultDataDTO(ReplyEnum.DATA_FORMAT_ERROR.getCode(), null);
        }

        ParseDataDTO parseDataDTO = processMsg(medicalDataForm);

        if (null == parseDataDTO) {
            return new ResultDataDTO(ReplyEnum.DATA_FORMAT_ERROR.getCode(), null);
        }

        boolean result = processCode(parseDataDTO);

        Map<String, Object> map = new HashMap<>(16);
        map.put(DataConstants.MAC, parseDataDTO.getMacAddress());
        map.put(DataConstants.OPERATION_NUMBER, parseDataDTO.getOperationNumber());

        if (!result) {
            return new ResultDataDTO(ReplyEnum.DATA_FORMAT_ERROR.getCode(), map);
        }
        return new ResultDataDTO(parseDataDTO.getCode() + 1, map);
    }

    @Override
    public synchronized Integer getNewOperationNumber() {
        return operationInformationService.countAll() + 1;
    }

    @Override
    public Integer getCurrentOperationNumber() {
        return operationInformationService.countAll();
    }

    /**
     * 对接收到的实体类MedicalDataDTO进行第一步解析
     * 缺少mac、operationNumber字段直接返回null
     * 因为手术准备开启阶段也会传operationNumber字段，但值为-1
     * 由于之前对表单进行了验证，code以及mac必定存在
     *
     * @param medicalDataForm 表单信息
     * @return 初次解析后的DTO
     */
    private ParseDataDTO processMsg(MedicalDataForm medicalDataForm) {
        try {
            int code = medicalDataForm.getCode();

            String macAddress = medicalDataForm.getMac();

            if (null == macAddress) {
                return null;
            }

            // 检查operationNumber字段，如果没有直接返回null,因为前面已经判断了，只有准备阶段才不需要opn
            int operationNumber = medicalDataForm.getOperationNumber();

            // 检查data属性，表单接收为String，需要转换为Map形式，所以将进行JSON解析，data属性可以为空
            Map dataMap = null;
            if (null != medicalDataForm.getData()) {
                dataMap = parseJson(medicalDataForm.getData());
            }

            return new ParseDataDTO(code, macAddress, operationNumber, dataMap);
        } catch (ClassCastException | NullPointerException | NumberFormatException exception) {
            log.error("medicalDataForm:{},Exception:{}", medicalDataForm.toString(), exception.toString());
            return null;
        }
    }

    /**
     * <ul>
     * <li>通过解析Code判断请求方式并回复</li>
     * <li>处理一个大型的分支，目前没有想到有什么其余的方式写该方法
     * 运行到分支后将进行数据存储处理，将返回执行的结果</li>
     * </ul>
     *
     * @param parseDataDTO 初次解析的DTO
     * @return 成功为true，失败false
     */
    private boolean processCode(ParseDataDTO parseDataDTO) {

        if (null == parseDataDTO) {
            return false;
        }

        int code = parseDataDTO.getCode();

        // 准备开始手术，获取手术顺序号的情况，同时处理上传病人Id和手术号以及手术过程中的设备信息的情况
        if (RequestEnum.OPERATION_READY.getCode().equals(code)) {
            parseDataDTO.setOperationNumber(getNewOperationNumber());
            return operationInformationService.saveOperationInformationDO(parseDataDTO);
        }

        // 更新手术过程基本信息，即手术结束的信息
        if (RequestEnum.OPERATION_END.getCode().equals(code)) {
            return operationInformationService.updateOperationInformationDO(parseDataDTO);
        }

        // 处理传输的医疗仪器数据的情况
        if (RequestEnum.DEVICE_DATA.getCode().equals(code)) {
            return deviceService.saveDeviceDO(parseDataDTO);
        }

        // 处理上传的患者数据的情况
        if (RequestEnum.PATIENT_INFO.getCode().equals(code)) {
            return preoperativePatientService.savePreoperativePatientDO(parseDataDTO);
        }

        // 处理上传的手术过程中标记的情况
        if (RequestEnum.OPERATION_MARK.getCode().equals(code)) {
            return operationMarkService.saveOperationMarkDO(parseDataDTO);
        }

        // 需要特殊处理的情况都没有的，枚举其余请求，是否存在
        for (RequestEnum requestEnum : RequestEnum.values()) {
            if (requestEnum.getCode().equals(code)) {
                return true;
            }
        }

        return false;
    }

}