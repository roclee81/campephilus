package org.cqu.edu.mrc.annihilation.campephilus.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.dto.*;
import org.cqu.edu.mrc.annihilation.campephilus.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.campephilus.exception.ParseException;
import org.cqu.edu.mrc.annihilation.campephilus.form.MedicalDataForm;
import org.cqu.edu.mrc.annihilation.campephilus.service.DataSearchService;
import org.cqu.edu.mrc.annihilation.campephilus.service.DataStorageService;
import org.cqu.edu.mrc.annihilation.campephilus.vo.ResultVO;
import org.cqu.edu.mrc.annihilation.common.utils.BeanUtil;
import org.cqu.edu.mrc.annihilation.common.utils.BindingResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DataController {

    private final DataSearchService dataSearchService;
    private final DataStorageService dataProcessService;

    @Autowired
    public DataController(DataSearchService dataSearchService, DataStorageService dataProcessService) {
        this.dataSearchService = dataSearchService;
        this.dataProcessService = dataProcessService;
    }

    @PostMapping("/update")
    public ResultVO processMedicalData(@Valid MedicalDataForm medicalDataForm, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);

        ResultDataDTO resultDataDTO = dataProcessService.processMedicalData(medicalDataForm);
        return new ResultVO(resultDataDTO.getCode(), resultDataDTO.getMsg());
    }

    @GetMapping("/operationData")
    public ResultVO listOperationData(@RequestParam(value = "operationNumber", defaultValue = "-1") int operationNumber,
                                      @RequestParam(value = "collectorMacAddress", defaultValue = "") String collectorMacAddress,
                                      @RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "size", defaultValue = "20") int size) {

        //TODO 目前不支持传入collectorMacAddress来查询
        if (operationNumber == -1) {
            return ResultVO.requestParameterError();
        }

        List<OperationInformationDTO> result = dataSearchService.listOperationData(operationNumber, collectorMacAddress, BeanUtil.getPageable(page, size));
        return result.get(0) == null ? ResultVO.dataNotExist() : new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }

    @GetMapping("/deviceData")
    public ResultVO listDeviceData(@RequestParam(value = "operationNumber", defaultValue = "-1") int operationNumber,
                                   @RequestParam(value = "deviceId", defaultValue = "") String deviceId,
                                   @RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "size", defaultValue = "20") int size) {

        // 必须传输deviceId与operationNumber，否则直接返回参数错误
        if (deviceId.length() == 0 || operationNumber == -1) {
            return ResultVO.requestParameterError();
        }

        List<DeviceDTO> result = dataSearchService.listDeviceData(operationNumber, deviceId, BeanUtil.getPageable(page, size));
        return result.get(0) == null ? ResultVO.dataNotExist() : new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }

    @GetMapping("/patientData")
    public ResultVO listPatientData(@RequestParam(value = "operationNumber", defaultValue = "-1") Integer operationNumber,
                                    @RequestParam(value = "patientId", defaultValue = "") String patientId,
                                    @RequestParam(value = "page", defaultValue = "0") int page,
                                    @RequestParam(value = "size", defaultValue = "20") int size) {

        // 没有接收到deviceId与operationNumber，返回缺少参数
        if (patientId.length() == 0 && operationNumber == -1) {
            return ResultVO.requestParameterError();
        }

        List<PatientInformationDTO> result = dataSearchService.listPatientData(operationNumber, patientId, BeanUtil.getPageable(page, size));
        return result.get(0) == null ? ResultVO.dataNotExist() : new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }

    @GetMapping("/collectorData")
    public ResultVO listPatientData(@RequestParam(value = "page", defaultValue = "0") int page,
                                    @RequestParam(value = "size", defaultValue = "20") int size) {

        CollectorInformationDTO result = dataSearchService.listCollectorData(BeanUtil.getPageable(page, size));
        return new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }

    @GetMapping("/feedbackData")
    public ResultVO listFeedbackData(@RequestParam(value = "page", defaultValue = "0") int page,
                                     @RequestParam(value = "size", defaultValue = "20") int size) {

        List<FeedbackInformationDTO> result = dataSearchService.listFeedbackData(BeanUtil.getPageable(page, size));
        return result.get(0) == null ? ResultVO.dataNotExist() : new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }

    @GetMapping("/versionData")
    public ResultVO getVersionData() {

        VersionInformationDTO result = dataSearchService.getVersionData();
        return new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }
}
