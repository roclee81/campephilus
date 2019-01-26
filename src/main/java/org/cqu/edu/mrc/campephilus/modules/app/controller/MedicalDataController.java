package org.cqu.edu.mrc.campephilus.modules.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.campephilus.common.enums.ResponseEnum;
import org.cqu.edu.mrc.campephilus.common.utils.R;
import org.cqu.edu.mrc.campephilus.modules.app.exception.ParseException;
import org.cqu.edu.mrc.campephilus.modules.app.dto.DeviceDTO;
import org.cqu.edu.mrc.campephilus.modules.app.dto.OperationInformationDTO;
import org.cqu.edu.mrc.campephilus.modules.app.dto.PatientInformationDTO;
import org.cqu.edu.mrc.campephilus.modules.app.dto.ResultDataDTO;
import org.cqu.edu.mrc.campephilus.modules.app.form.MedicalDataForm;
import org.cqu.edu.mrc.campephilus.modules.app.service.impl.DataProcessServiceImpl;
import org.cqu.edu.mrc.campephilus.modules.app.service.impl.DeviceServiceImpl;
import org.cqu.edu.mrc.campephilus.modules.app.service.impl.OperationInformationServiceImpl;
import org.cqu.edu.mrc.campephilus.modules.app.service.impl.PatientInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * campephilus
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/28 17:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/data")
@Slf4j
public class MedicalDataController {

    private final DataProcessServiceImpl dataProcessService;
    private final OperationInformationServiceImpl operationInformationService;
    private final DeviceServiceImpl deviceService;
    private final PatientInformationServiceImpl patientInformationService;

    @Autowired
    public MedicalDataController(DataProcessServiceImpl dataProcessService, OperationInformationServiceImpl operationInformationService, DeviceServiceImpl deviceService, PatientInformationServiceImpl patientInformationService) {
        this.dataProcessService = dataProcessService;
        this.operationInformationService = operationInformationService;
        this.deviceService = deviceService;
        this.patientInformationService = patientInformationService;
    }

    @PostMapping("/update")
    public R processMedicalData(@Valid MedicalDataForm medicalDataForm, BindingResult bindingResult) {
        //TODO 根据测试情况实现考虑多线程需求
        System.out.println(Thread.currentThread());
        log.info("MedicalDataForm{}", medicalDataForm);

        if (bindingResult.hasErrors()) {
            String msg = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
            throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), "Data format error", "Data format error", msg);
        }

        ResultDataDTO resultDataDTO = dataProcessService.processMedicalData(medicalDataForm);
        return new R(resultDataDTO.getCode(), resultDataDTO.getMsg());
    }

    @GetMapping("/operationInformation")
    public R getOperationInformation(@RequestParam(value = "operationNumber", defaultValue = "-1") Integer operationNumber,
                                     @RequestParam(value = "collectorMacAddress", defaultValue = "") String collectorMacAddress,
                                     @RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "20") Integer size) {

        System.out.println(Thread.currentThread());

        //TODO 目前不支持传入collectorMacAddress来查询
        if (operationNumber == -1 && collectorMacAddress.length() == 0) {
            return R.requestParameterError();
        }

        PageRequest pageRequest = PageRequest.of(page, size);

        if (operationNumber == 0) {
            List<OperationInformationDTO> result = operationInformationService.getOperationInformationDTOS(pageRequest);
            return result.size() < 1 ? R.dataNotExist() : new R(ResponseEnum.SUCCESS.getCode(), result);
        }

        // 如果传入了不为0，则是查询特定的OperationInformationDTO
        if (operationNumber > 1) {
            OperationInformationDTO result = operationInformationService.getOperationInformationDTOByOperationNumber(operationNumber);
            return null == result ? R.dataNotExist() : new R(ResponseEnum.SUCCESS.getCode(), result);
        }

        return R.unknownError();
    }

    @GetMapping("/deviceInformation")
    public R getDeviceInformation(@RequestParam(value = "operationNumber", defaultValue = "-1") Integer operationNumber,
                                  @RequestParam(value = "deviceId", defaultValue = "") String deviceId,
                                  @RequestParam(value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(value = "size", defaultValue = "20") Integer size) {

        System.out.println(Thread.currentThread());

        // 没有接收到deviceId与operationNumber，返回缺少参数
        if (deviceId.length() == 0 && operationNumber == -1) {
            return R.requestParameterError();
        }

        PageRequest pageRequest = PageRequest.of(page, size);

        if (operationNumber == -1 && deviceId.length() > 0) {
            List<DeviceDTO> result = deviceService.getDeviceDTOSByDeviceId(deviceId, pageRequest);
            return result.size() < 1 ? R.dataNotExist() : new R(ResponseEnum.SUCCESS.getCode(), result);
        }

        if (operationNumber > 0 && deviceId.length() == 0) {
            Map<String, Object> result = deviceService.getDeviceDOSByOperationNumber(operationNumber, pageRequest);
            return result.size() < 1 ? R.dataNotExist() : new R(ResponseEnum.SUCCESS.getCode(), result);
        }

        if (operationNumber > 0 && deviceId.length() > 0) {
            List<DeviceDTO> result = deviceService.getDeviceDTOSByDeviceIdAndOperationNumber(deviceId, operationNumber, pageRequest);
            return result.size() < 1 ? R.dataNotExist() : new R(ResponseEnum.SUCCESS.getCode(), result);
        }

        return R.unknownError();
    }

    @GetMapping("/patientInformation")
    public R getPatientInformation(@RequestParam(value = "operationNumber", defaultValue = "-1") Integer operationNumber,
                                   @RequestParam(value = "patientId", defaultValue = "") String patientId,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", defaultValue = "20") Integer size) {

        // 没有接收到deviceId与operationNumber，返回缺少参数
        if (patientId.length() == 0 && operationNumber == -1) {
            return R.requestParameterError();
        }

        PageRequest pageRequest = PageRequest.of(0, 100);

        if (operationNumber == -1 && patientId.length() > 0) {
            List<PatientInformationDTO> result = patientInformationService.getPatientInformationDTOSByPatientId(patientId, pageRequest);
            return result.size() < 1 ? R.dataNotExist() : new R(ResponseEnum.SUCCESS.getCode(), result);
        }

        if (operationNumber > 0 && patientId.length() == 0) {
            PatientInformationDTO result = patientInformationService.getPatientInformationDTOByOperationNumber(operationNumber);
            return null == result ? R.dataNotExist() : new R(ResponseEnum.SUCCESS.getCode(), result);
        }

        if (operationNumber > 0 && patientId.length() > 0) {
            PatientInformationDTO result = patientInformationService.getPatientInformationDTOByPatientIdAndOperationNumber(patientId, operationNumber);
            return null == result ? R.dataNotExist() : new R(ResponseEnum.SUCCESS.getCode(), result);
        }

        return R.unknownError();
    }


}
