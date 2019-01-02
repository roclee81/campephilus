package org.cqu.edu.mrc.realdata.modules.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.realdata.common.constant.DataConstants;
import org.cqu.edu.mrc.realdata.common.enums.ReplyEnum;
import org.cqu.edu.mrc.realdata.common.utils.R;
import org.cqu.edu.mrc.realdata.modules.app.dto.ResultDataDTO;
import org.cqu.edu.mrc.realdata.modules.app.form.MedicalDataForm;
import org.cqu.edu.mrc.realdata.modules.app.service.impl.DataProcessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping(value = "/data/")
@Slf4j
public class MedicalDataController {

    private final DataProcessServiceImpl dataProcessService;

    @Autowired
    public MedicalDataController(DataProcessServiceImpl dataProcessService) {
        this.dataProcessService = dataProcessService;
    }

    @PostMapping("/")
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
}
