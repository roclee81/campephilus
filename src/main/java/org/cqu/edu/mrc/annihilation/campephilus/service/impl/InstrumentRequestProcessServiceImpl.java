package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.constant.DataConstants;
import org.cqu.edu.mrc.annihilation.campephilus.convertor.VersionInformationDOConvertVersionInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.campephilus.form.InstrumentRequestForm;
import org.cqu.edu.mrc.annihilation.campephilus.service.*;
import org.cqu.edu.mrc.annihilation.campephilus.enums.RequestEnum;
import org.cqu.edu.mrc.annihilation.campephilus.exception.ParseException;
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
public class InstrumentRequestProcessServiceImpl implements InstrumentRequestProcessService {

    private final DeviceService deviceService;
    private final OperationMarkService operationMarkService;
    private final OperationInformationService operationInformationService;
    private final PatientInformationService patientInformationService;
    private final CollectorInformationService collectorInformationService;
    private final VersionInformationService versionInformationService;
    private final FeedbackInformationService feedbackInformationService;
    private final StatisticalService statisticalService;

    @Autowired
    public InstrumentRequestProcessServiceImpl(DeviceServiceImpl deviceService, OperationMarkService operationMarkService, OperationInformationService operationInformationService, PatientInformationService patientInformationService, CollectorInformationService collectorInformationService, VersionInformationService versionInformationService, FeedbackInformationService feedbackInformationService, StatisticalService statisticalService) {
        this.deviceService = deviceService;
        this.operationMarkService = operationMarkService;
        this.operationInformationService = operationInformationService;
        this.patientInformationService = patientInformationService;
        this.collectorInformationService = collectorInformationService;
        this.versionInformationService = versionInformationService;
        this.feedbackInformationService = feedbackInformationService;
        this.statisticalService = statisticalService;
    }

    @Override
    public ResultDataDTO processInstrumentData(InstrumentRequestForm instrumentRequestForm) {

        if (null == instrumentRequestForm) {
            throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), "Data format error", "InstrumentRequestForm is null", "");
        }

        ParseDataDTO parseDataDTO = processMsg(instrumentRequestForm);

        ParseResultObject parseResultObject = processCode(parseDataDTO);

        Map<String, Object> map = new HashMap<>(16);
        map.put(DataConstants.MAC, parseDataDTO.getMacAddress());
        map.put(DataConstants.OPERATION_NUMBER, parseDataDTO.getOperationNumber());
        map.put(DataConstants.DATA_MAP, parseResultObject.getReturnData());

        if (!parseResultObject.isReturnResult()) {
            return new ResultDataDTO(ResponseEnum.DATA_FORMAT_ERROR.getCode(), map);
        }
        // 保存成功，将对CollectorInformation表进行更改
        collectorInformationService.updateCollectorInformationDOWhenUpdateSuccess(parseDataDTO);
        // 添加/更新StatisticalDO表
        statisticalService.updateStatisticalDO(parseDataDTO);
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
     * @param instrumentRequestForm 表单信息
     * @return 初次解析后的ParseDataDTO，不会返回空值
     */
    private ParseDataDTO processMsg(InstrumentRequestForm instrumentRequestForm) {
        return new ParseDataDTO(instrumentRequestForm.getCode(), instrumentRequestForm.getMac(),
                instrumentRequestForm.getOperationNumber(), instrumentRequestForm.getData());
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
    private ParseResultObject processCode(ParseDataDTO parseDataDTO) {
        ParseResultObject parseResultObject = new ParseResultObject();
        parseResultObject.setReturnResult(false);
        // 解析标志位
        boolean flag = false;
        int code = parseDataDTO.getCode();

        // 准备开始手术，获取手术顺序号的情况，同时处理上传病人Id和手术号以及手术过程中的设备信息的情况
        if (RequestEnum.OPERATION_READY.getCode().equals(code)) {
            parseDataDTO.setOperationNumber(getNewOperationNumber());
            parseResultObject.setReturnResult(operationInformationService.saveOperationInformationDO(parseDataDTO));
            flag = true;
        }

        // 更新手术过程基本信息，即手术结束的信息
        if (RequestEnum.OPERATION_END.getCode().equals(code)) {
            parseResultObject.setReturnResult(operationInformationService.updateOperationInformationDO(parseDataDTO));
            flag = true;
        }

        // 处理传输的医疗仪器数据的情况
        if (RequestEnum.DEVICE_DATA.getCode().equals(code)) {
            parseResultObject.setReturnResult(deviceService.saveDeviceDO(parseDataDTO));
            flag = true;
        }

        // 处理上传或者更新的患者数据的情况
        if (RequestEnum.PATIENT_INFO.getCode().equals(code)) {
            parseResultObject.setReturnResult(patientInformationService.savePatientInformationDO(parseDataDTO));
            flag = true;
        }

        if (RequestEnum.POSTOPERATIVE_PATIENT_INFO.getCode().equals(code)) {
            parseResultObject.setReturnResult(patientInformationService.updatePatientInformationDO(parseDataDTO));
            flag = true;
        }

        // 处理上传的手术过程中标记的情况
        if (RequestEnum.OPERATION_MARK.getCode().equals(code)) {
            parseResultObject.setReturnResult(operationMarkService.saveOperationMarkDO(parseDataDTO));
            flag = true;
        }

        // 处理上传的反馈数据
        if (RequestEnum.FEEDBACK_INFO.getCode().equals(code)) {
            parseResultObject.setReturnResult(feedbackInformationService.saveFeedbackInformationDO(parseDataDTO));
            flag = true;
        }

        // 处理获取版本的请求
        if (RequestEnum.VERSION_REQUEST.getCode().equals(code)) {
            parseResultObject.setReturnData(VersionInformationDOConvertVersionInformationDTO.convert(versionInformationService.getFirstByOrderByIdDesc()));
            flag = true;
        }

        // 需要特殊处理的情况都没有的，枚举其余请求，是否存在
        if (!flag) {
            for (RequestEnum requestEnum : RequestEnum.values()) {
                if (requestEnum.getCode().equals(code)) {
                    parseResultObject.setReturnResult(true);
                }
            }
        }

        return parseResultObject;
    }

    /**
     * 包装解析后的结果的内部类
     */
    @Data
    private class ParseResultObject {
        /**
         * 解析后的结果
         * 不能为空
         * true解析成功
         * false解析失败
         */
        private boolean returnResult;

        /**
         * 解析后返回的消息体，可以为空
         * 如果没有消息将返回null
         */
        private Object returnData;
    }
}