package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalUploadRequestDO;
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

    private final StatisticalUploadRequestService statisticalUploadRequestService;

    @Autowired
    public StatisticalUploadRequestServiceImpl(StatisticalUploadRequestService statisticalUploadRequestService) {
        this.statisticalUploadRequestService = statisticalUploadRequestService;
    }

    @Override
    public StatisticalUploadRequestDO getStatisticalUploadRequestDOByStatisticalDate(String statisticalDate) {
        return statisticalUploadRequestService.getStatisticalUploadRequestDOByStatisticalDate(statisticalDate);
    }

    @Override
    public Page<StatisticalUploadRequestDO> listStatisticalUploadRequestDOByGmtCreateBetween(Date gmtCreateBefore, Date gmtCreateAfter, Pageable pageable) {
        return statisticalUploadRequestService.listStatisticalUploadRequestDOByGmtCreateBetween(gmtCreateBefore, gmtCreateAfter, pageable);
    }

    @Override
    public Page<StatisticalUploadRequestDO> listStatisticalUploadRequestDOByGmtModifiedBetween(Date gmtModifiedBefore, Date gmtModifiedAfter, Pageable pageable) {
        return statisticalUploadRequestService.listStatisticalUploadRequestDOByGmtModifiedBetween(gmtModifiedBefore, gmtModifiedAfter, pageable);
    }
}
