package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalUploadRequestDO;
import org.cqu.edu.mrc.annihilation.campephilus.repository.StatisticalUploadRequestRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.StatisticalUploadRequestService;
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
public class StatisticalUploadRequestServiceImpl implements StatisticalUploadRequestService {

    private final StatisticalUploadRequestRepository statisticalUploadRequestRepository;

    @Autowired
    public StatisticalUploadRequestServiceImpl(StatisticalUploadRequestRepository statisticalUploadRequestRepository) {
        this.statisticalUploadRequestRepository = statisticalUploadRequestRepository;
    }

    @Override
    public StatisticalUploadRequestDO getStatisticalUploadRequestDOByStatisticalDate(String statisticalDate) {
        return statisticalUploadRequestRepository.findStatisticalUploadRequestDOByStatisticalDate(statisticalDate);
    }

    @Override
    public Page<StatisticalUploadRequestDO> listStatisticalUploadRequestDOByGmtCreateBetween(Date gmtCreateBefore, Date gmtCreateAfter, Pageable pageable) {
        return statisticalUploadRequestRepository.findStatisticalUploadRequestDOByGmtCreateBetween(gmtCreateBefore, gmtCreateAfter, pageable);
    }

    @Override
    public Page<StatisticalUploadRequestDO> listStatisticalUploadRequestDOByGmtModifiedBetween(Date gmtModifiedBefore, Date gmtModifiedAfter, Pageable pageable) {
        return statisticalUploadRequestRepository.findStatisticalUploadRequestDOByGmtModifiedBetween(gmtModifiedBefore, gmtModifiedAfter, pageable);
    }

    @Override
    public StatisticalUploadRequestDO saveStatisticalUploadRequestDO(StatisticalUploadRequestDO statisticalUploadRequestDO) {
        return statisticalUploadRequestRepository.save(statisticalUploadRequestDO);
    }

    @Override
    public StatisticalUploadRequestDO getCurrentStatisticalUploadRequestDO() {
        return statisticalUploadRequestRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public StatisticalUploadRequestDO updateStatisticalUploadRequestDO(StatisticalUploadRequestDO statisticalUploadRequestDO) {
        return statisticalUploadRequestRepository.save(statisticalUploadRequestDO);
    }

}
