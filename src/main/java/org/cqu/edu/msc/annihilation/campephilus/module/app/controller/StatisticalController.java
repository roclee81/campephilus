package org.cqu.edu.msc.annihilation.campephilus.module.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.CollectorInformationDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.CurrentStatisticsRequestDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.enums.ResponseEnum;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.StatisticalDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.StatisticalRequestDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.service.DataSearchService;
import org.cqu.edu.msc.annihilation.campephilus.module.app.vo.ResultVO;
import org.cqu.edu.msc.annihilation.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 14:02
 * @email vinicolor.violet.end@gmail.com
 * Description:
 * 用于将统计的信息提供API
 * 主要是对服务器自动的数据进行统计
 */
@RestController
@RequestMapping(value = "/statistical")
@CrossOrigin
@Slf4j
public class StatisticalController {

    private final DataSearchService dataSearchService;

    @Autowired
    public StatisticalController(DataSearchService dataSearchService) {
        this.dataSearchService = dataSearchService;
    }

    @GetMapping("/collector")
    public ResultVO listCollectorData(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "size", defaultValue = "20") int size) {

        CollectorInformationDTO result = dataSearchService.listCollectorData(BeanUtil.getPageable(page, size));
        return new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }

    @GetMapping(value = "/statistical")
    public ResultVO listStatisticalData(@RequestParam(value = "page", defaultValue = "0") int page,
                                        @RequestParam(value = "size", defaultValue = "20") int size) {
        StatisticalRequestDTO result = dataSearchService.listStatisticalData();
        return new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }

    @GetMapping(value = "/day")
    public ResultVO getStatisticsData() {
        StatisticalDataDTO result = dataSearchService.getStatisticsDataDTO();
        return new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }

    @GetMapping(value = "/current")
    public ResultVO getCurrentStatisticsData() {
        CurrentStatisticsRequestDTO result = dataSearchService.getCurrentStatisticsRequestDTO();
        return new ResultVO(ResponseEnum.SUCCESS.getCode(), result);
    }
}