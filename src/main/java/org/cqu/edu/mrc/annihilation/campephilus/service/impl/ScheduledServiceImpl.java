package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.CollectorInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalRequestDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.CurrentStatisticsRequestDTO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.CollectorStateEnum;
import org.cqu.edu.mrc.annihilation.campephilus.exception.SaveException;
import org.cqu.edu.mrc.annihilation.campephilus.service.CollectorInformationService;
import org.cqu.edu.mrc.annihilation.campephilus.service.ScheduledService;
import org.cqu.edu.mrc.annihilation.campephilus.service.StatisticalRequestService;
import org.cqu.edu.mrc.annihilation.common.constant.DataBaseConstant;
import org.cqu.edu.mrc.annihilation.common.enums.ErrorEnum;
import org.cqu.edu.mrc.annihilation.common.utils.DateUtil;
import org.cqu.edu.mrc.annihilation.common.utils.TimeStampUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/21 16:39
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
@Slf4j
public class ScheduledServiceImpl implements ScheduledService {

    static CurrentStatisticsRequestDTO currentStatisticsRequestDTO = new CurrentStatisticsRequestDTO();

    /**
     * 每秒数据上传的请求数量
     */
    public static int secondRequest = 0;

    /**
     * 每秒数据上传的请求有效数量
     */
    public static int secondValidRequest = 0;

    /**
     * 每小时数据上传的请求数量
     */
    public static int hourRequest = 0;

    /**
     * 每小时数据上传的请求有效数量
     */
    public static int hourRequestValid = 0;

    private final CollectorInformationService collectorInformationService;
    private final StatisticalRequestService statisticalRequestService;

    @Autowired
    public ScheduledServiceImpl(CollectorInformationService collectorInformationService, StatisticalRequestService statisticalRequestService) {
        this.collectorInformationService = collectorInformationService;
        this.statisticalRequestService = statisticalRequestService;
    }

    @Scheduled(cron = "0 * * * * *")
    @Override
    public void checkCollectorStatePreMinute() {
        List<CollectorInformationDO> collectorInformationDOList = new ArrayList<>();
        // 1. 获取当前时间前十分钟的时间戳
        Date gmtCollectorLastUploadDataBefore = TimeStampUtil.getMinuteDate(-10);
        // 2. 生成状态为在线采集器的列表
        List<Integer> collectorStateList = new ArrayList<>();
        collectorStateList.add(CollectorStateEnum.RUNNING.getCode());
        // 3. 获得采集器总数
        int collectorNumber = collectorInformationService.countCollectorInformationDOS();
        // 4. 进行分页获取处理，一页50个数据
        int pageTotal = (int) Math.ceil(collectorNumber / DataBaseConstant.F_PAGE_SIZE);
        for (int page = 0; page < pageTotal; page++) {
            // 5. 循环获取所有超过10分钟没有上传数据而且状态为在线的采集器
            Pageable pageable = PageRequest.of(page, DataBaseConstant.I_PAGE_SIZE);
            Page<CollectorInformationDO> collectorInformationDOPage =
                    collectorInformationService.listCollectorInformationDOSByCollectorStateInAndGmtCollectorLastUploadDataBefore(
                            collectorStateList, gmtCollectorLastUploadDataBefore, pageable);
            // 6. 获取后取出每一个，将状态改为离线;
            collectorInformationDOPage.stream().forEach((collectorInformationDO -> {
                collectorInformationDO.setGmtModified(new Date());
                collectorInformationDO.setCollectorState(CollectorStateEnum.OFFLINE.getCode());
                collectorInformationDOList.add(collectorInformationDO);
            }));
            List<CollectorInformationDO> result = collectorInformationService.saveCollectorInformationDOS(collectorInformationDOList);
            if (result.size() != collectorInformationDOList.size()) {
                throw new SaveException(ErrorEnum.SAVE_ERROR.getCode(), "Save Exception", "Save Exception", result.toString());
            }
        }
    }

    @Scheduled(cron = "* * * * * ?")
    @Override
    public void handleRequestPreSecond() {
        hourRequest += secondRequest;
        hourRequestValid += secondValidRequest;
        statisticalRequestService.updateCurrentStatisticsRequestDTO(currentStatisticsRequestDTO);
        secondRequest = 0;
        secondValidRequest = 0;
    }

    @Scheduled(cron = "0 0 * * * ?")
    @Override
    public void handleRequestPerHour() {

        // 首先查找有没有该条数据，通过statisticalDate字段去查找
        StatisticalRequestDO statisticalRequestDO = statisticalRequestService.getStatisticalRequestDOByStatisticalDate(DateUtil.getCurrentDateString());
        if (null == statisticalRequestDO) {
            // 数据库中没有该数据，新建一条
            statisticalRequestDO = StatisticalRequestDO.getStatisticalUploadRequestDOInstance();
        }
        // 保存每小时的请求
        List<Integer> perHourRequestList = statisticalRequestDO.getPerHourRequestNumber();
        perHourRequestList.add(hourRequest);
        statisticalRequestDO.setPerHourRequestNumber(perHourRequestList);

        // 保存每小时的有效请求
        List<Integer> perHourValidRequestList = statisticalRequestDO.getPerHourValidRequestNumber();
        perHourValidRequestList.add(hourRequestValid);
        statisticalRequestDO.setPerHourValidRequestNumber(perHourValidRequestList);

        statisticalRequestDO.setGmtModified(new Date());
        statisticalRequestDO.setTotalRequestNumber(statisticalRequestDO.getTotalRequestNumber() + hourRequest);
        statisticalRequestDO.setTotalValidRequestNumber(statisticalRequestDO.getTotalValidRequestNumber() + hourRequestValid);

        // TODO 没有判断result是否保存要求，是否保存成功
        StatisticalRequestDO result = statisticalRequestService.saveStatisticalRequestDO(statisticalRequestDO);

        // 清零
        hourRequestValid = 0;
        hourRequest = 0;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void handleRequestPerDay() {
        // 目前没有操作、主要是在每小时的数据中将数据已经存储
    }
}