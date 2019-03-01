package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalRequestDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.CurrentStatisticsRequestDTO;
import org.cqu.edu.mrc.annihilation.campephilus.repository.StatisticalRequestRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.StatisticalRequestService;
import org.cqu.edu.mrc.annihilation.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/25 23:31
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class StatisticalRequestServiceImpl implements StatisticalRequestService {

    private final StatisticalRequestRepository statisticalRequestRepository;

    @Autowired
    public StatisticalRequestServiceImpl(StatisticalRequestRepository statisticalRequestRepository) {
        this.statisticalRequestRepository = statisticalRequestRepository;
    }

    @Override
    public StatisticalRequestDO getStatisticalRequestDOByStatisticalDate(String statisticalDate) {
        return statisticalRequestRepository.findStatisticalRequestDOByStatisticalDate(statisticalDate);
    }

    @Override
    public Page<StatisticalRequestDO> listStatisticalRequestDOByGmtCreateBetween(Date gmtCreateBefore, Date gmtCreateAfter, Pageable pageable) {
        return statisticalRequestRepository.findStatisticalRequestDOByGmtCreateBetween(gmtCreateBefore, gmtCreateAfter, pageable);
    }

    @Override
    public Page<StatisticalRequestDO> listStatisticalRequestDOByGmtModifiedBetween(Date gmtModifiedBefore, Date gmtModifiedAfter, Pageable pageable) {
        return statisticalRequestRepository.findStatisticalRequestDOByGmtModifiedBetween(gmtModifiedBefore, gmtModifiedAfter, pageable);
    }

    @Override
    public StatisticalRequestDO saveStatisticalRequestDO(StatisticalRequestDO statisticalRequestDO) {
        return statisticalRequestRepository.save(statisticalRequestDO);
    }

    @Override
    public StatisticalRequestDO getLastStatisticalRequestDO() {
        return statisticalRequestRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public StatisticalRequestDO updateStatisticalRequestDO(StatisticalRequestDO statisticalRequestDO) {
        return statisticalRequestRepository.save(statisticalRequestDO);
    }

    @Override
    public CurrentStatisticsRequestDTO updateCurrentStatisticsRequestDTO(CurrentStatisticsRequestDTO currentStatisticsRequestDTO) {
        currentStatisticsRequestDTO.setCurrentSecondRequestNumber(ScheduledServiceImpl.secondRequest);
        currentStatisticsRequestDTO.setCurrentSecondValidRequestNumber(ScheduledServiceImpl.secondValidRequest);
        currentStatisticsRequestDTO.setCurrentHourRequestNumber(ScheduledServiceImpl.hourRequest);
        currentStatisticsRequestDTO.setCurrentHourValidRequestNumber(ScheduledServiceImpl.hourRequestValid);

        // 开始统计当天的数据
        // 首先查询数据库，得到是否存在对象
        StatisticalRequestDO statisticalRequestDO = this.getStatisticalRequestDOByStatisticalDate(DateUtil.getCurrentDateString());
        if (null == statisticalRequestDO) {
            // 如果不存在则当天的统计信息仅为当前小时的
            currentStatisticsRequestDTO.setCurrentDayRequestNumber(ScheduledServiceImpl.hourRequest);
            currentStatisticsRequestDTO.setCurrentDayValidRequestNumber(ScheduledServiceImpl.hourRequestValid);
            currentStatisticsRequestDTO.setAverageHourRequestNumber(ScheduledServiceImpl.hourRequest);
            currentStatisticsRequestDTO.setAverageHourValidRequestNumber(ScheduledServiceImpl.hourRequestValid);
        } else {
            // 存在就需要将数据取出，计算总和与平均值
            int hourRequestSum = statisticalRequestDO.getTotalRequestNumber() + ScheduledServiceImpl.hourRequest;
            int hourValidRequestSum = statisticalRequestDO.getTotalValidRequestNumber() + ScheduledServiceImpl.hourRequestValid;

            currentStatisticsRequestDTO.setCurrentDayRequestNumber(hourRequestSum);
            currentStatisticsRequestDTO.setCurrentDayValidRequestNumber(hourValidRequestSum);

            currentStatisticsRequestDTO.setAverageHourRequestNumber(hourRequestSum / (statisticalRequestDO.getPerHourRequestNumber().size() + 1));
            currentStatisticsRequestDTO.setAverageHourValidRequestNumber(hourValidRequestSum / (statisticalRequestDO.getPerHourValidRequestNumber().size() + 1));
        }
        return currentStatisticsRequestDTO;
    }

}
