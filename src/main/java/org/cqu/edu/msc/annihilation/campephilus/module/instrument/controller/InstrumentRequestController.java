package org.cqu.edu.msc.annihilation.campephilus.module.instrument.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.common.utils.BindingResultUtils;
import org.cqu.edu.msc.annihilation.common.utils.ResultUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.form.InstrumentRequestForm;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.dto.ResultDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.service.InstrumentRequestProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
 * 该Controller仅用于与医疗仪器通信的API
 * 医疗仪器端与服务器端通信主要采用CODE方式，仅通过判断CODE的方式来进行相应
 * 暂不提供任何数据搜索服务接口
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
    public ResponseEntity processInstrumentData(@Valid InstrumentRequestForm instrumentRequestForm, BindingResult bindingResult) {
        BindingResultUtils.checkBindingResult(bindingResult);

        ResultDataDTO resultDataDTO = instrumentRequestProcessService.processInstrumentData(instrumentRequestForm);
        return ResultUtils.success(resultDataDTO);
    }
}
