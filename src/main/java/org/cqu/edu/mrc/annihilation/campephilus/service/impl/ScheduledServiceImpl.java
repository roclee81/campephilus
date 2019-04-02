package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.CollectorInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.CurrentStatisticsRequestDTO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.CollectorStateEnum;
import org.cqu.edu.mrc.annihilation.campephilus.exception.SaveException;
import org.cqu.edu.mrc.annihilation.campephilus.service.CollectorInformationService;
import org.cqu.edu.mrc.annihilation.campephilus.service.ScheduledService;
import org.cqu.edu.mrc.annihilation.campephilus.service.StatisticalService;
import org.cqu.edu.mrc.annihilation.campephilus.value.StatisticalRequestValue;
import org.cqu.edu.mrc.annihilation.campephilus.value.StatisticalValue;
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

    private final CollectorInformationService collectorInformationService;
    private final StatisticalService statisticalService;
    private final StatisticalValue statisticalValue;

    @Autowired
    public ScheduledServiceImpl(CollectorInformationService collectorInformationService, StatisticalService statisticalService, StatisticalValue statisticalValue) {
        this.collectorInformationService = collectorInformationService;
        this.statisticalService = statisticalService;
        this.statisticalValue = statisticalValue;
    }

    /**
     * 检测采集器状态，每分钟检测一次
     * 通过采集器的最后上传时间进行检测，
     * 如果超过10分钟没有上传数据而且状态为在线的采集器，则将该采集器的状态改为离线
     */
    @Scheduled(cron = "0 * * * * *")
    private void checkCollectorStatePreMinute() {
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
                throw new SaveException(ErrorEnum.SAVE_ERROR, "Save Exception", result.toString());
            }
        }
    }

    /**
     * 统计每秒钟的采集器请求数量以及无效请求
     * 将每秒的数据叠加到<code>hourRequest</code>和<code>hourRequestValid</code>里面
     */
    @Scheduled(cron = "* * * * * ?")
    private void handleRequestPreSecond() {
//        //TODO 在多线程下，统计值会丢失
        StatisticalRequestValue.hourRequest += StatisticalRequestValue.secondRequest;
        StatisticalRequestValue.hourRequestValid += StatisticalRequestValue.secondValidRequest;
        updateCurrentStatisticsRequestDTO(currentStatisticsRequestDTO);
        StatisticalRequestValue.secondRequest = 0;
        StatisticalRequestValue.secondValidRequest = 0;
    }

    /**
     * 处理每小时采集器的请求，即将每小时的请求数量存储，保存成在一个小时的请求量，以及无效请求
     * 每一小时存储一次，直接存储到数据中
     * 无需数据是否存在
     * 在*：59：59触发具体时间如下：
     * 2019/3/2 2:59:59
     * 2019/3/2 3:59:59
     * 2019/3/2 4:59:59
     * 2019/3/2 5:59:59
     * 2019/3/2 6:59:59
     */
    @Scheduled(cron = "59 59 * * * ?")
    private void handleRequestPerHour() {
        // TODO 1.日期之后未更新，检查到可能是该方法调用时，输入的日期还是前一天的
        //  2.在调用时，如果在更新数据时调用了查询数据库，再将查询得到的值写入到数据库，如果在多线程时另一个aop中的调用也
        //  会导致数据覆盖，目前应该采用锁

        StatisticalDO statisticalDO = StatisticalDO.getStatisticalDOInstance();

        // 保存采集器目前的上传数量
        statisticalDO.setCollectorUpload(StatisticalRequestValue.hourRequest);

        // 保存采集器目前的有效上传数量
        statisticalDO.setCollectorValidUpload(StatisticalRequestValue.hourRequestValid);

        // 保存采集器每小时的请求
        statisticalDO.getPerHourCollectorUploadList().add(StatisticalRequestValue.hourRequest);

        // 保存采集器每小时的有效请求
        statisticalDO.getPerHourCollectorValidUploadList().add(StatisticalRequestValue.hourRequestValid);

        // 保存目前的上传数量
        statisticalDO.setRequest(StatisticalRequestValue.hourRequest);

        // 保存目前的有效上传数量
        statisticalDO.setValidRequest(StatisticalRequestValue.hourRequestValid);

        // 保存每小时的请求
        statisticalDO.getPerHourRequestList().add(StatisticalRequestValue.hourRequest);

        // 保存每小时的有效请求
        statisticalDO.getPerHourValidRequestList().add(StatisticalRequestValue.hourRequestValid);

        // TODO 没有判断result是否保存要求，是否保存成功
        boolean result = statisticalService.updateStatisticalDO(statisticalDO);

        // 清零
        StatisticalRequestValue.hourRequestValid = 0;
        StatisticalRequestValue.hourRequest = 0;
    }

    /**
     * 得到实时统计的CurrentStatisticsRequestDTO
     * 该方法将定时进行调用，每秒进行调用，但该方式目前仅存放于内存中，并未存入到数据库中
     * 方法将调用数据库，查询数据库中当天的数据，进行统计
     * 将通过查询数据库中保存的数据进行统计，数据库中只有前一个小时的数据
     * 在统计当天的统计时将加上当前小时的统计信息
     *
     * @param currentStatisticsRequestDTO 存储于内存中，实时更新
     */
    private void updateCurrentStatisticsRequestDTO(CurrentStatisticsRequestDTO currentStatisticsRequestDTO) {
        currentStatisticsRequestDTO.setCurrentSecondRequestNumber(StatisticalRequestValue.secondRequest);
        currentStatisticsRequestDTO.setCurrentSecondValidRequestNumber(StatisticalRequestValue.secondValidRequest);
        currentStatisticsRequestDTO.setCurrentHourRequestNumber(StatisticalRequestValue.hourRequest);
        currentStatisticsRequestDTO.setCurrentHourValidRequestNumber(StatisticalRequestValue.hourRequestValid);

        // 开始统计当天的数据
        // 首先查询数据库，得到是否存在对象
        StatisticalDO statisticalDO = statisticalService.getStatisticalDOByStatisticalDate(DateUtil.getCurrentDateString());
        if (null == statisticalDO) {
            // 如果不存在则当天的统计信息仅为当前小时的
            currentStatisticsRequestDTO.setCurrentDayRequestNumber(currentStatisticsRequestDTO.getCurrentHourRequestNumber());
            currentStatisticsRequestDTO.setCurrentDayValidRequestNumber(currentStatisticsRequestDTO.getCurrentHourValidRequestNumber());
            currentStatisticsRequestDTO.setAverageHourRequestNumber(currentStatisticsRequestDTO.getCurrentHourRequestNumber());
            currentStatisticsRequestDTO.setAverageHourValidRequestNumber(currentStatisticsRequestDTO.getCurrentHourValidRequestNumber());
        } else {
            // 存在就需要将数据取出，计算总和与平均值
            int hourRequestSum = statisticalDO.getRequest() + currentStatisticsRequestDTO.getCurrentHourRequestNumber();
            int hourValidRequestSum = statisticalDO.getCollectorValidUpload() + currentStatisticsRequestDTO.getCurrentHourValidRequestNumber();

            currentStatisticsRequestDTO.setCurrentDayRequestNumber(hourRequestSum);
            currentStatisticsRequestDTO.setCurrentDayValidRequestNumber(hourValidRequestSum);

            currentStatisticsRequestDTO.setAverageHourRequestNumber(
                    hourRequestSum / (statisticalDO.getPerHourCollectorUploadList().size() + 1));

            currentStatisticsRequestDTO.setAverageHourValidRequestNumber(
                    hourValidRequestSum / (statisticalDO.getPerHourCollectorValidUploadList().size() + 1));
        }
    }
}