package org.cqu.edu.mrc.annihilation.campephilus.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ResultDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.campephilus.exception.ParseException;
import org.cqu.edu.mrc.annihilation.campephilus.form.MedicalDataForm;
import org.cqu.edu.mrc.annihilation.campephilus.vo.ResultVO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 14:02
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/information")
@Slf4j
public class InformationController {

//    @PostMapping(value = "version/update")
//    public ResultVO updateVersionData(@Valid MedicalDataForm medicalDataForm, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            String msg = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
//            throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR.getCode(), "Data format error", "Data format error", msg);
//        }
//
//        ResultDataDTO resultDataDTO = dataProcessService.processMedicalData(medicalDataForm);
//        return new ResultVO(resultDataDTO.getCode(), resultDataDTO.getMsg());
}
