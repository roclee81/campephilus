package org.cqu.edu.mrc.annihilation.campephilus.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.dto.CollectorInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.StatisticalUploadRequestDTO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.ResponseEnum;
import org.cqu.edu.mrc.annihilation.campephilus.form.InformationForm;
import org.cqu.edu.mrc.annihilation.campephilus.service.DataSearchService;
import org.cqu.edu.mrc.annihilation.campephilus.service.VersionInformationService;
import org.cqu.edu.mrc.annihilation.campephilus.vo.ResultVO;
import org.cqu.edu.mrc.annihilation.common.utils.BeanUtil;
import org.cqu.edu.mrc.annihilation.common.utils.BindingResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 14:02
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 用于显示给前端的Controller
 */
@RestController
@RequestMapping(value = "/display")
@Slf4j
public class DisplayController {

    private final DataSearchService dataSearchService;

    @Autowired
    public DisplayController(DataSearchService dataSearchService) {
        this.dataSearchService = dataSearchService;
    }

    @GetMapping("/collectorData")
    public ResultVO listPatientData(@RequestParam(value = "page", defaultValue = "0") int page,
                                    @RequestParam(value = "size", defaultValue = "20") int size) {

        CollectorInformationDTO result = dataSearchService.listCollectorData(BeanUtil.getPageable(page, size));
        return new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }

    @GetMapping(value = "/currentStatisticalAspect")
    public ResultVO listCurrentStatisticalAspect() {
        StatisticalUploadRequestDTO result = dataSearchService.listCurrentStatisticalAspect();
        return new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }
}
