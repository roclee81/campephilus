package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.CollectorInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalUploadRequestDO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.CollectorStateEnum;
import org.cqu.edu.mrc.annihilation.campephilus.exception.SaveException;
import org.cqu.edu.mrc.annihilation.campephilus.service.CollectorInformationService;
import org.cqu.edu.mrc.annihilation.campephilus.service.ScheduledService;
import org.cqu.edu.mrc.annihilation.campephilus.service.StatisticalUploadRequestService;
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

import static org.cqu.edu.mrc.annihilation.campephilus.aspect.StatisticalAspect.minuteRequest;
import static org.cqu.edu.mrc.annihilation.campephilus.aspect.StatisticalAspect.hourRequest;
import static org.cqu.edu.mrc.annihilation.campephilus.aspect.StatisticalAspect.hourRequestValid;
import static org.cqu.edu.mrc.annihilation.campephilus.aspect.StatisticalAspect.minuteRequestValid;

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

    private StatisticalUploadRequestDO statisticalUploadRequestDO;

    private final CollectorInformationService collectorInformationService;
    private final StatisticalUploadRequestService statisticalUploadRequestService;

    @Autowired
    public ScheduledServiceImpl(CollectorInformationService collectorInformationService, StatisticalUploadRequestService statisticalUploadRequestService) {
        this.collectorInformationService = collectorInformationService;
        this.statisticalUploadRequestService = statisticalUploadRequestService;
    }

    @Scheduled(cron = "0 * * * * *")
    @Override
    public void checkCollectorState() {

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

    @Scheduled(cron = "0 * * * * ?")
    @Override
    public void handleRequestsMinuteSecond() {
        hourRequest += minuteRequest;
        hourRequestValid += minuteRequestValid;
        hourRequest = 0;
        hourRequestValid = 0;
    }

    @Scheduled(cron = "0 0 * * * ?")
    @Override
    public void handleRequestsPerHour() {
        if (null == statisticalUploadRequestDO) {
            statisticalUploadRequestDO = new StatisticalUploadRequestDO();
        }
        statisticalUploadRequestDO.getPerHourRequestNumber().add(hourRequest);
        statisticalUploadRequestDO.getPerHourValidRequestNumber().add(hourRequestValid);
        hourRequestValid = 0;
        hourRequest = 0;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void handleRequestsPerDay() {
        // 目前为存储一天再存入数据库中
        // 任务设置时间单位为天，同时将数据保存到数据库中，同时新建一个对象
        statisticalUploadRequestDO.setTotalValidRequestNumber();
        statisticalUploadRequestDO.setTotalRequestNumber();
        statisticalUploadRequestDO.setGmtCreate(new Date());
        statisticalUploadRequestDO.setGmtModified(new Date());
        statisticalUploadRequestDO.setStatisticalDate(DateUtil.getCurrentDateString());
        statisticalUploadRequestService.saveStatisticalUploadRequestDO(statisticalUploadRequestDO);
        statisticalUploadRequestDO = new StatisticalUploadRequestDO();
    }
}
