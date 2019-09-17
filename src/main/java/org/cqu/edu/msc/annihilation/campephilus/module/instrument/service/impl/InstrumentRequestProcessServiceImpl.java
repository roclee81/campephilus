package org.cqu.edu.msc.annihilation.campephilus.module.instrument.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.BeforeOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationDeviceInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.info.PatientInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.RequestEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.ParseException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.*;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ResultDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentForm;
//import org.cqu.edu.msc.annihilation.campephilus.module.instrument.service.DeviceDataService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.service.InstrumentRequestProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    private final BeforeOperationInfoService beforeOperationInfoService;
    private final DeviceInfoService deviceInfoService;
    private final HospitalInfoService hospitalInfoService;
    private final OperationInfoService operationInfoService;
    private final OperationMarkInfoService operationMarkInfoService;
    private final PatientInfoService patientInfoService;
    private final OperationDeviceInfoService operationDeviceInfoService;
    //    private final DeviceDataService deviceDataService;
    private final LogInfoService logInfoService;

    @Autowired
    private EvaluationInfoService evaluationInfoService;

    @Autowired
    public InstrumentRequestProcessServiceImpl(BeforeOperationInfoService beforeOperationInfoService, DeviceInfoService deviceInfoService, HospitalInfoService hospitalInfoService, OperationInfoService operationInfoService, OperationMarkInfoService operationMarkInfoService, PatientInfoService patientInfoService, OperationDeviceInfoService operationDeviceInfoService, LogInfoService logInfoService) {
        this.beforeOperationInfoService = beforeOperationInfoService;
        this.deviceInfoService = deviceInfoService;
        this.hospitalInfoService = hospitalInfoService;
        this.operationInfoService = operationInfoService;
        this.operationMarkInfoService = operationMarkInfoService;
        this.patientInfoService = patientInfoService;
        this.operationDeviceInfoService = operationDeviceInfoService;
//        this.deviceDataService = deviceDataService;
        this.logInfoService = logInfoService;
    }

    @Override
    public ResultDataDTO processInstrumentData(InstrumentForm instrumentForm) {
        if (Objects.isNull(instrumentForm)) {
            ParseException.dataFormatException();
        }

        verifyParameter(instrumentForm);
        processCode(instrumentForm);

//        if (instrumentForm.getCode().equals(RequestEnum.DEVICE_DATA.getCode())) {
//            sendMessage(instrumentForm);
//        } else {
//            processCode(instrumentForm);
//        }

        return ResultDataDTO.convert(instrumentForm.getCode() + 1,
                instrumentForm.getMac(),
                instrumentForm.getOperationNumber());
    }

    /**
     * 检查表单的参数
     * 只有通过检查才能发送到MQ
     * 否则抛出异常
     *
     * @param instrumentForm
     */
    private void verifyParameter(InstrumentForm instrumentForm) {

    }

    /**
     * 目前只有仪器输出数据才发送到MQ
     *
     * @param instrumentForm
     */
    private void sendMessage(InstrumentForm instrumentForm) {
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
     * @param instrumentForm 初次解析的DTO
     */
    @Override
    public void processCode(InstrumentForm instrumentForm) {
        RequestEnum requestEnum = RequestEnum.matchRequestEnum(instrumentForm.getCode());
        // 如果没有找到请求码，抛出错误
        if (Objects.isNull(requestEnum)) {
            ParseException.codeException();
        }
        switch (requestEnum) {
            // 准备开始手术，获取手术顺序号的情况，同时处理上传病人Id和手术号以及手术过程中的设备信息的情况
            case OPERATION_READY: {
                // 事务，手动回滚
                PatientInfo patientInfo = null;
                OperationInfo operationInfo = null;
                OperationDeviceInfo operationDeviceInfo = null;
                BeforeOperationInfo beforeOperationInfo = null;
                try {
                    instrumentForm.setOperationNumber(getNewOperationNumber());
                    patientInfo = patientInfoService.savePatientInfoFromInstrumentForm(instrumentForm);
                    operationInfo = operationInfoService.saveOperationInfoFromInstrumentForm(instrumentForm);
                    operationDeviceInfo = operationDeviceInfoService.saveOperationDeviceInfoFromInstrumentForm(instrumentForm);
                    beforeOperationInfo = beforeOperationInfoService.saveBeforeOperationInfoFromInstrumentForm(instrumentForm);
                } catch (Exception e) {
                    patientInfoService.delete(patientInfo);
                    operationInfoService.delete(operationInfo);
                    operationDeviceInfoService.delete(operationDeviceInfo);
                    throw e;
                }
            }
            // 更新手术过程基本信息，即手术结束的信息
            case OPERATION_END: {
                operationInfoService.updateOperationEndTimeFromInstrumentForm(instrumentForm);
                break;
            }
            case OPERATION_START: {
                operationInfoService.updateOperationStartTimeFromInstrumentForm(instrumentForm);
                break;
            }
            // 处理传输的医疗仪器数据的情况
            case DEVICE_DATA: {
//                deviceDataService.saveDeviceData(instrumentForm.getOperationNumber(), instrumentForm.getData());
                break;
            }
            case POSTOPERATIVE_PATIENT_INFO: {
                // TODO 是外包还是接入数据库，待定
                break;
            }
            // 处理上传的手术过程中标记的情况
            case OPERATION_MARK: {
                operationMarkInfoService.saveOperationMarkInfoFromInstrumentForm(instrumentForm);
                break;
            }
            // 处理上传的反馈错误数据
            case FEEDBACK_ERROR_INFO: {
                logInfoService.saveLogInfoFromInstrumentFrom(instrumentForm);
                break;
            }
            // 处理获取版本的请求
            case VERSION_REQUEST: {
                // TODO 目前先不管，返回空即可，可能会变为http restful方式实现
                break;
            }
            case EVALUATION_INFO: {
                evaluationInfoService.saveEvaluationInfoFromInstrumentForm(instrumentForm);
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    public Integer getNewOperationNumber() {
        return operationInfoService.countOperationInfo() + 1;
    }
}