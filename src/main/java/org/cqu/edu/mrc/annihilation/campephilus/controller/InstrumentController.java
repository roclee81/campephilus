package org.cqu.edu.mrc.annihilation.campephilus.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ResultDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.form.MedicalDataForm;
import org.cqu.edu.mrc.annihilation.campephilus.service.DataSearchService;
import org.cqu.edu.mrc.annihilation.campephilus.service.InstrumentRequestProcessService;
import org.cqu.edu.mrc.annihilation.campephilus.vo.ResultVO;
import org.cqu.edu.mrc.annihilation.common.utils.BindingResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/28 16:57
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/instrument")
@Slf4j
public class InstrumentController {

    private final DataSearchService dataSearchService;
    private final InstrumentRequestProcessService dataProcessService;

    @Autowired
    public InstrumentController(DataSearchService dataSearchService, InstrumentRequestProcessService dataProcessService) {
        this.dataSearchService = dataSearchService;
        this.dataProcessService = dataProcessService;
    }

    @PostMapping("/data")
    public ResultVO processInstrumentData(@Valid MedicalDataForm medicalDataForm, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);

        ResultDataDTO resultDataDTO = dataProcessService.processMedicalData(medicalDataForm);
        return new ResultVO(resultDataDTO.getCode(), resultDataDTO.getMsg());
    }
}
