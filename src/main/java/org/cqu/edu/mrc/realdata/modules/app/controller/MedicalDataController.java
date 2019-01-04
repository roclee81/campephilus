package org.cqu.edu.mrc.realdata.modules.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.ReplyConstants;
import org.cqu.edu.mrc.realdata.common.enums.ReplyEnum;
import org.cqu.edu.mrc.realdata.common.utils.R;
import org.cqu.edu.mrc.realdata.modules.app.dto.OperationInformationDTO;
import org.cqu.edu.mrc.realdata.modules.app.dto.ResultDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.form.MedicalDataForm;
import org.cqu.edu.mrc.realdata.modules.app.service.impl.DataProcessServiceImpl;
import org.cqu.edu.mrc.realdata.modules.app.service.impl.OperationInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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

    @Autowired
    public MedicalDataController(DataProcessServiceImpl dataProcessService, OperationInformationServiceImpl operationInformationService) {
        this.dataProcessService = dataProcessService;
        this.operationInformationService = operationInformationService;
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
    public R getOperationInformation(@RequestParam("page") int page,
                                     @RequestParam("size") int size) {

        PageRequest pageRequest = PageRequest.of(page, size);

        List<OperationInformationDTO> result = operationInformationService.getOperationInformationDTOS(pageRequest);

        if (result.size() < 1) {
            return new R(ReplyEnum.DATA_DOES_NOT_EXIST.getCode(), ReplyConstants.DATA_DOES_NOT_EXIST);
        }

        return new R(ReplyEnum.SUCCESS.getCode(), operationInformationService.getOperationInformationDTOS(pageRequest));
    }

}
