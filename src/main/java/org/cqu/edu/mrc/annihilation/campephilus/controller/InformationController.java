package org.cqu.edu.mrc.annihilation.campephilus.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ResultDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.campephilus.exception.ParseException;
import org.cqu.edu.mrc.annihilation.campephilus.form.InformationForm;
import org.cqu.edu.mrc.annihilation.campephilus.form.MedicalDataForm;
import org.cqu.edu.mrc.annihilation.campephilus.service.VersionInformationService;
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
 * @date 2019/2/22 14:02
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@RestController
@RequestMapping(value = "/information")
@Slf4j
public class InformationController {

    private final VersionInformationService versionInformationService;

    @Autowired
    public InformationController(VersionInformationService versionInformationService) {
        this.versionInformationService = versionInformationService;
    }

    @PostMapping(value = "version/update")
    public ResultVO updateVersionData(@Valid InformationForm informationForm, BindingResult bindingResult) {
        BindingResultUtil.checkBindingResult(bindingResult);

        boolean result = versionInformationService.saveInformation(informationForm);

        if (result) {
            return ResultVO.success("success");
        } else {
            ResultVO.error(ResponseEnum.UNKNOWN_ERROR.getCode(), "error");
        }
        return null;
    }

}
