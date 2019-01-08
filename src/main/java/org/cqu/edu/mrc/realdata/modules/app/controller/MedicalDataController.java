package org.cqu.edu.mrc.realdata.modules.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.ReplyConstants;
import org.cqu.edu.mrc.realdata.common.enums.ReplyEnum;
import org.cqu.edu.mrc.realdata.common.utils.R;
import org.cqu.edu.mrc.realdata.modules.app.dto.DeviceDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.OperationInformationDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ResultDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.form.MedicalDataForm;
import org.cqu.edu.mrc.realdata.modules.app.service.impl.DataProcessServiceImpl;
import org.cqu.edu.mrc.realdata.modules.app.service.impl.DeviceServiceImpl;
import org.cqu.edu.mrc.realdata.modules.app.service.impl.OperationInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * realdata
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

    @Autowired
    public MedicalDataController(DataProcessServiceImpl dataProcessService, OperationInformationServiceImpl operationInformationService, DeviceServiceImpl deviceService) {
        this.dataProcessService = dataProcessService;
        this.operationInformationService = operationInformationService;
        this.deviceService = deviceService;
    }

    @PostMapping("/update")
    public R processMedicalData(@Valid MedicalDataForm medicalDataForm, BindingResult bindingResult) {
        //TODO 根据测试情况实现考虑多线程需求

        log.info("MedicalDataForm{}", medicalDataForm);

        if (bindingResult.hasErrors()) {
            String msg = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
            return new R(ReplyEnum.DATA_FORMAT_ERROR.getCode(), msg);
        }

        ResultDataDTO resultDataDTO = dataProcessService.processMedicalData(medicalDataForm);
        return new R(resultDataDTO.getCode(), resultDataDTO.getMsg());
    }

    @GetMapping("/operationInformation")
    public R getOperationInformation(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "20") Integer size) {

        PageRequest pageRequest = PageRequest.of(page, size);

        List<OperationInformationDTO> result = operationInformationService.getOperationInformationDTOS(pageRequest);

        if (result.size() < 1) {
            return new R(ReplyEnum.DATA_DOES_NOT_EXIST.getCode(), ReplyConstants.DATA_DOES_NOT_EXIST);
        }

        return new R(ReplyEnum.SUCCESS.getCode(), result);
    }

    @GetMapping("/deviceInformation")
    public R getDeviceInformation(@RequestParam(value = "deviceId", defaultValue = "") String deviceId,
                                  @RequestParam(value = "operationNumber", defaultValue = "-1") Integer operationNumber,
                                  @RequestParam(value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(value = "size", defaultValue = "20") Integer size) {

        // 没有接收到deviceId与operationNumber，返回缺少参数
        if (deviceId.length() == 0 && operationNumber == -1) {
            return new R(ReplyEnum.REQUEST_PARAMETER_DOES_NOT_EXIST.getCode(), ReplyConstants.REQUEST_PARAMETER_DOES_NOT_EXIST);
        }

        PageRequest pageRequest = PageRequest.of(page, size);

        if (deviceId.length() > 0 && operationNumber == -1) {
            List<DeviceDTO> result = deviceService.getDeviceDTOSByDeviceId(deviceId, pageRequest);
            if (result.size() < 1) {
                return new R(ReplyEnum.DATA_DOES_NOT_EXIST.getCode(), ReplyConstants.DATA_DOES_NOT_EXIST);
            }
            return new R(ReplyEnum.SUCCESS.getCode(), result);
        }

        if (deviceId.length() == 0 && operationNumber > 0) {
            Map<String, Object> result = deviceService.getDeviceDOSByOperationNumber(operationNumber, pageRequest);
            if (result.size() < 1) {
                return new R(ReplyEnum.DATA_DOES_NOT_EXIST.getCode(), ReplyConstants.DATA_DOES_NOT_EXIST);
            }
            return new R(ReplyEnum.SUCCESS.getCode(), result);
        }

        if (deviceId.length() > 0 && operationNumber > 0) {
            List<DeviceDTO> result = deviceService.getDeviceDTOSByDeviceIdAndOperationNumber(deviceId, operationNumber, pageRequest);
            if (result.size() < 1) {
                return new R(ReplyEnum.DATA_DOES_NOT_EXIST.getCode(), ReplyConstants.DATA_DOES_NOT_EXIST);
            }
            return new R(ReplyEnum.SUCCESS.getCode(), result);
        }

        return new R(ReplyEnum.UNKNOWN_ERROR.getCode(), ReplyConstants.UNKNOWN_ERROR);
    }
}
