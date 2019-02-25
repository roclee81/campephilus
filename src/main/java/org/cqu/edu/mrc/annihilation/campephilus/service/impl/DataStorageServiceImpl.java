package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.constant.DataConstants;
import org.cqu.edu.mrc.annihilation.campephilus.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.campephilus.service.*;
import org.cqu.edu.mrc.annihilation.campephilus.enums.RequestEnum;
import org.cqu.edu.mrc.annihilation.campephilus.exception.ParseException;
import org.cqu.edu.mrc.annihilation.campephilus.form.MedicalDataForm;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ResultDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/24 21:41
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
@Slf4j
public class DataStorageServiceImpl implements DataStorageService {

    private final DeviceService deviceService;
    private final OperationMarkService operationMarkService;
    private final OperationInformationService operationInformationService;
    private final PatientInformationService patientInformationService;
    private final CollectorInformationService collectorInformationService;
    private final VersionInformationService versionInformationService;
    private final FeedbackInformationService feedbackInformationService;

    @Autowired
    public DataStorageServiceImpl(DeviceServiceImpl deviceService, OperationMarkService operationMarkService, OperationInformationService operationInformationService, PatientInformationService patientInformationService, CollectorInformationService collectorInformationService, VersionInformationService versionInformationService, FeedbackInformationService feedbackInformationService) {
        this.deviceService = deviceService;
        this.operationMarkService = operationMarkService;
        this.operationInformationService = operationInformationService;
        this.patientInformationService = patientInformationService;
        this.collectorInformationService = collectorInformationService;
        this.versionInformationService = versionInformationService;
        this.feedbackInformationService = feedbackInformationService;
    }

    /**
     * 仅解析JSON数据，如果数据有错误，则返回null
     * 将传入的值为{},将返回一个空的HashMap
     *
     * @param jsonBuffer JSON 字符串
     * @return MedicalDataDTO实体类
     */
    private Map parseJson(String jsonBuffer) {
        try {
            return new Gson().fromJson(jsonBuffer, Map.class);
        } catch (JsonSyntaxException jsonSyntaxException) {
            throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), DataConstants.DATA_FIELD_FORMAT_ERROR, DataConstants.DATA_FIELD_FORMAT_ERROR, jsonBuffer);
        }
    }

    @Override
    public ResultDataDTO processMedicalData(MedicalDataForm medicalDataForm) {

        if (null == medicalDataForm) {
            throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), "Data format error", "MedicalDataForm is null", "");
        }

        ParseDataDTO parseDataDTO = processMsg(medicalDataForm);

        boolean result = processCode(parseDataDTO);

        // 如果保存成功，将对CollectorInformation表进行更改
        if (result) {
            collectorInformationService.updateCollectorInformationDOWhenUpdateSuccess(parseDataDTO);
        }

        Map<String, Object> map = new HashMap<>(16);
        map.put(DataConstants.MAC, parseDataDTO.getMacAddress());
        map.put(DataConstants.OPERATION_NUMBER, parseDataDTO.getOperationNumber());

        if (!result) {
            return new ResultDataDTO(ResponseEnum.DATA_FORMAT_ERROR.getCode(), map);
        }
        return new ResultDataDTO(parseDataDTO.getCode() + 1, map);
    }

    @Override
    public Integer getNewOperationNumber() {
        return operationInformationService.countOperationInformationDOS() + 1;
    }

    @Override
    public Integer getCurrentOperationNumber() {
        return operationInformationService.countOperationInformationDOS();
    }

    /**
     * 对接收到的实体类MedicalDataForm进行第一步解析
     * 将MedicalDataForm转换成ParseDataDTO
     * 缺少code、mac、operationNumber、dataMap字段直接返回null
     * 因为手术准备开启阶段也会传operationNumber字段，但值为-1
     * 由于之前对表单进行了验证，所有4个值都应该不为空
     * data字段将进行验证，如何没有值需要传入{}
     *
     * @param medicalDataForm 表单信息
     * @return 初次解析后的ParseDataDTO，不会返回空值
     */
    private ParseDataDTO processMsg(MedicalDataForm medicalDataForm) {
        return new ParseDataDTO(medicalDataForm.getCode(), medicalDataForm.getMac(),
                medicalDataForm.getOperationNumber(), parseJson(medicalDataForm.getData()));
    }

    /**
     * <ul>
     * <li>通过解析Code判断请求方式并回复</li>
     * <li>处理一个大型的分支，目前没有想到有什么其余的方式写该方法
     * 运行到分支后将进行数据存储处理，将返回执行的结果</li>
     * <li>在此处不检查传入参数ParseDataDTO的非空情况，因为在表单
     * 验证后必定不为空</li>
     * </ul>
     *
     * @param parseDataDTO 初次解析的DTO
     * @return 成功为true，失败false
     */
    private boolean processCode(ParseDataDTO parseDataDTO) {
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

        // 处理上传或者更新的患者数据的情况
        if (RequestEnum.PATIENT_INFO.getCode().equals(code) || RequestEnum.POSTOPERATIVE_PATIENT_INFO.getCode().equals(code)) {
            return patientInformationService.savePatientInformationDO(parseDataDTO);
        }

        // 处理上传的手术过程中标记的情况
        if (RequestEnum.OPERATION_MARK.getCode().equals(code)) {
            return operationMarkService.saveOperationMarkDO(parseDataDTO);
        }

        // 处理上传的反馈数据
        if (RequestEnum.FEEDBACK_INFO.getCode().equals(code)) {
            return feedbackInformationService.saveFeedbackInformationDO(parseDataDTO);
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