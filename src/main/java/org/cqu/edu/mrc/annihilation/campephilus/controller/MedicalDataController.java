package org.cqu.edu.mrc.annihilation.campephilus.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.common.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.common.utils.R;
import org.cqu.edu.mrc.annihilation.campephilus.exception.ParseException;
import org.cqu.edu.mrc.annihilation.campephilus.dto.DeviceDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.OperationInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.PatientInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ResultDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.form.MedicalDataForm;
import org.cqu.edu.mrc.annihilation.campephilus.service.DataSearchService;
import org.cqu.edu.mrc.annihilation.campephilus.service.impl.DataStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * campephilus
 *
 * @author lx
 * @version V1.1
 * @date 2019/01/26 14:59
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/data")
@Slf4j
public class MedicalDataController {

    private final DataSearchService dataSearchService;
    private final DataStorageServiceImpl dataProcessService;

    @Autowired
    public MedicalDataController(DataSearchService dataSearchService, DataStorageServiceImpl dataProcessService) {
        this.dataSearchService = dataSearchService;
        this.dataProcessService = dataProcessService;
    }

    @PostMapping("/update")
    public R processMedicalData(@Valid MedicalDataForm medicalDataForm, BindingResult bindingResult) {
        log.info("{}", medicalDataForm);

        if (bindingResult.hasErrors()) {
            String msg = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
            throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), "Data format error", "Data format error", msg);
        }

        ResultDataDTO resultDataDTO = dataProcessService.processMedicalData(medicalDataForm);
        return new R(resultDataDTO.getCode(), resultDataDTO.getMsg());
    }

    @GetMapping("/operationData")
    public R listOperationData(@RequestParam(value = "operationNumber", defaultValue = "-1") Integer operationNumber,
                               @RequestParam(value = "collectorMacAddress", defaultValue = "") String collectorMacAddress,
                               @RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "20") Integer size) {

        //TODO 目前不支持传入collectorMacAddress来查询
        if (operationNumber == -1) {
            return R.requestParameterError();
        }

        PageRequest pageRequest = PageRequest.of(page, size);

        List<OperationInformationDTO> result = dataSearchService.listOperationData(operationNumber, collectorMacAddress, pageRequest);
        return result.size() < 1 ? R.dataNotExist() : new R(ResponseEnum.SUCCESS.getCode(), result);
    }

    @GetMapping("/deviceData")
    public R listDeviceData(@RequestParam(value = "operationNumber", defaultValue = "-1") Integer operationNumber,
                            @RequestParam(value = "deviceId", defaultValue = "") String deviceId,
                            @RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "size", defaultValue = "20") Integer size) {

        // 必须传输deviceId与operationNumber，否则直接返回参数错误
        if (deviceId.length() == 0 || operationNumber == -1) {
            return R.requestParameterError();
        }

        PageRequest pageRequest = PageRequest.of(page, size);

        List<DeviceDTO> result = dataSearchService.listDeviceData(operationNumber, deviceId, pageRequest);
        return result.size() < 1 ? R.dataNotExist() : new R(ResponseEnum.SUCCESS.getCode(), result);
    }

    @GetMapping("/patientData")
    public R listPatientData(@RequestParam(value = "operationNumber", defaultValue = "-1") Integer operationNumber,
                             @RequestParam(value = "patientId", defaultValue = "") String patientId,
                             @RequestParam(value = "page", defaultValue = "0") Integer page,
                             @RequestParam(value = "size", defaultValue = "20") Integer size) {

        // 没有接收到deviceId与operationNumber，返回缺少参数
        if (patientId.length() == 0 && operationNumber == -1) {
            return R.requestParameterError();
        }

        PageRequest pageRequest = PageRequest.of(page, size);

        List<PatientInformationDTO> result = dataSearchService.listPatientData(operationNumber, patientId, pageRequest);
        return result.size() < 1 ? R.dataNotExist() : new R(ResponseEnum.SUCCESS.getCode(), result);
    }
}
