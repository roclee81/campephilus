package org.cqu.edu.msc.annihilation.campephilus.module.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.*;
import org.cqu.edu.msc.annihilation.campephilus.module.app.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.app.form.InformationForm;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.DataSearchService;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.VersionInformationService;
import org.cqu.edu.msc.annihilation.campephilus.module.app.vo.ResultVO;
import org.cqu.edu.msc.annihilation.common.utils.BeanUtil;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * campephilus
 *
 * @author lx
 * @version V1.1
 * @date 2019/01/26 14:59
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 提供数据库搜索的API接口
 * 用于通过HTTP接口来获取数据库数据
 */
@RestController
@RequestMapping(value = "/data")
@Slf4j
public class DataController {

    private final DataSearchService dataSearchService;
    private final VersionInformationService versionInformationService;

    @Autowired
    public DataController(DataSearchService dataSearchService, VersionInformationService versionInformationService) {
        this.dataSearchService = dataSearchService;
        this.versionInformationService = versionInformationService;
    }

    @PostMapping(value = "/version")
    public ResultVO updateVersionData(@Valid InformationForm informationForm, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);

        boolean result = versionInformationService.saveInformation(informationForm);
        if (result) {
            return ResultVO.success("success");
        } else {
            return ResultVO.error(ResponseEnum.UNKNOWN_ERROR.getCode(), "error");
        }
    }

    @GetMapping("/operation")
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

    @GetMapping("/device")
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

    @GetMapping("/patient")
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

    @GetMapping("/feedback")
    public ResultVO listFeedbackData(@RequestParam(value = "page", defaultValue = "0") int page,
                                     @RequestParam(value = "size", defaultValue = "20") int size) {

        List<FeedbackInformationDTO> result = dataSearchService.listFeedbackData(BeanUtil.getPageable(page, size));
        return result.get(0) == null ? ResultVO.dataNotExist() : new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }

    @GetMapping("/version")
    public ResultVO getVersionData() {
        VersionInformationDTO result = dataSearchService.getVersionData();
        return new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }
}
