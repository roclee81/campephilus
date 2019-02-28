package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalRequestDO;
import org.cqu.edu.mrc.annihilation.campephilus.repository.StatisticalRequestRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.StatisticalRequestService;
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
    public StatisticalRequestDO getCurrentStatisticalRequestDO() {
        return statisticalRequestRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public StatisticalRequestDO updateStatisticalRequestDO(StatisticalRequestDO statisticalRequestDO) {
        return statisticalRequestRepository.save(statisticalRequestDO);
    }

}
