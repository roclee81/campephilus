package org.cqu.edu.msc.annihilation.campephilus.module.instrument.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.*;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.service.DeviceDataService;
import org.cqu.edu.msc.annihilation.common.constant.DataConstants;
import org.cqu.edu.msc.annihilation.common.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.ParseException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.enums.RequestEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.form.InstrumentRequestForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ResultDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.service.InstrumentRequestProcessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
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
    private final DeviceDataService deviceDataService;

    public InstrumentRequestProcessServiceImpl(BeforeOperationInfoService beforeOperationInfoService, DeviceInfoService deviceInfoService, HospitalInfoService hospitalInfoService, OperationInfoService operationInfoService, OperationMarkInfoService operationMarkInfoService, PatientInfoService patientInfoService, OperationDeviceInfoService operationDeviceInfoService, DeviceDataService deviceDataService) {
        this.beforeOperationInfoService = beforeOperationInfoService;
        this.deviceInfoService = deviceInfoService;
        this.hospitalInfoService = hospitalInfoService;
        this.operationInfoService = operationInfoService;
        this.operationMarkInfoService = operationMarkInfoService;
        this.patientInfoService = patientInfoService;
        this.operationDeviceInfoService = operationDeviceInfoService;
        this.deviceDataService = deviceDataService;
    }

    @Override
    public ResultDataDTO processInstrumentData(InstrumentRequestForm instrumentRequestForm) {
        if (null == instrumentRequestForm) {
            throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR);
        }
        ParseDataDTO parseDataDTO = processMsg(instrumentRequestForm);

        String parseReturnData = processCode(parseDataDTO);

        Map<String, Object> map = new HashMap<>(16);
        map.put(DataConstants.MAC, parseDataDTO.getCollectorMacAddress());
        map.put(DataConstants.OPERATION_NUMBER, parseDataDTO.getOperationNumber());
        map.put(DataConstants.DATA_MAP, parseReturnData);

        return new ResultDataDTO(parseDataDTO.getCode() + 1, map);
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
    @Transactional()
    String processCode(ParseDataDTO parseDataDTO) {
        // 解析后的结果，等待返回结果
        String parseReturnData = null;
        switch (Objects.requireNonNull(RequestEnum.matchRequestEnum(parseDataDTO.getCode()))) {
            // 准备开始手术，获取手术顺序号的情况，同时处理上传病人Id和手术号以及手术过程中的设备信息的情况
            case OPERATION_READY: {
                // TODO 需要添加事务
                parseDataDTO.setOperationNumber(getNewOperationNumber());
                operationInfoService.saveOperationInfoFromParseDataDTO(parseDataDTO);
                operationDeviceInfoService.saveOperationDeviceInfoFromParseDataDTO(parseDataDTO);
                patientInfoService.savePatientInfoFromParseDataDTO(parseDataDTO);
                beforeOperationInfoService.saveBeforeOperationInfoFromDataDTO(parseDataDTO);
                break;
            }
            // 更新手术过程基本信息，即手术结束的信息
            case OPERATION_END: {
                operationInfoService.updateOperationTimeParseDataDTO(parseDataDTO);
                break;
            }
            case OPERATION_START: {
                deviceDataService.saveDeviceData(parseDataDTO.getOperationNumber(), parseDataDTO.getJsonData());
                break;
            }
            // 处理传输的医疗仪器数据的情况
            case DEVICE_DATA: {

                //TODO 等待解析过程
                break;
            }
            case POSTOPERATIVE_PATIENT_INFO: {
                // TODO 是外包还是接入数据库，待定
                break;
            }
            // 处理上传的手术过程中标记的情况
            case OPERATION_MARK: {
                operationMarkInfoService.saveOperationMarkInfoFromParseDTO(parseDataDTO);
                break;
            }
            // 处理上传的反馈数据
            case FEEDBACK_INFO: {
                // TODO 是外包还是接入数据库，待定
                break;
            }
            // 处理获取版本的请求
            case VERSION_REQUEST: {
                // TODO 目前先不管，可能会变为http restful方式实现
                break;
            }
            default: {
                throw new ParseException(ResponseEnum.CODE_ERROR);
            }
        }
        return parseReturnData;
    }


    @Override
    public Integer getNewOperationNumber() {
        return operationInfoService.countOperationInfo() + 1;
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
}