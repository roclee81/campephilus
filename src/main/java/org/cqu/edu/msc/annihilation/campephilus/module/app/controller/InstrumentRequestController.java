package org.cqu.edu.msc.annihilation.campephilus.module.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.form.InstrumentRequestForm;
import org.cqu.edu.msc.annihilation.campephilus.module.core.vo.ResultVO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.ResultDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.InstrumentRequestProcessService;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/30 11:36
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/instrument")
@Slf4j
public class InstrumentRequestController {

    private final InstrumentRequestProcessService instrumentRequestProcessService;

    @Autowired
    public InstrumentRequestController(InstrumentRequestProcessService instrumentRequestProcessService) {
        this.instrumentRequestProcessService = instrumentRequestProcessService;
    }

    @PostMapping("/")
    public ResultVO processInstrumentData(@Valid InstrumentRequestForm instrumentRequestForm, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);

        ResultDataDTO resultDataDTO = instrumentRequestProcessService.processInstrumentData(instrumentRequestForm);
        return new ResultVO(resultDataDTO.getCode(), resultDataDTO.getMsg());
    }
}
