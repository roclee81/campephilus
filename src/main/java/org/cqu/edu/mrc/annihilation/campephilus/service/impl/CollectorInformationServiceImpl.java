package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.CollectorInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.repository.CollectorInformationRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.CollectorInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/21 14:41
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class CollectorInformationServiceImpl implements CollectorInformationService {

    private final CollectorInformationRepository collectorInformationRepository;

    @Autowired
    public CollectorInformationServiceImpl(CollectorInformationRepository collectorInformationRepository) {
        this.collectorInformationRepository = collectorInformationRepository;
    }

    @Override
    public CollectorInformationDO getCollectorInformationDOByCollectorMacAddress(String collectorMacAddress) {
        return collectorInformationRepository.getCollectorInformationDOByCollectorMacAddress(collectorMacAddress);
    }

    @Override
    public Page<CollectorInformationDO> listCollectorInformationDOSByCollectorState(Integer collectorState, Pageable pageable) {
        return collectorInformationRepository.getCollectorInformationDOSByCollectorState(collectorState, pageable);
    }

    @Override
    public CollectorInformationDO saveCollectorInformationDO(CollectorInformationDO collectorInformationDO) {
        return collectorInformationRepository.save(collectorInformationDO);
    }

    @Override
    public CollectorInformationDO updateCollectorInformationDO(String collectorMacAddress, Integer collectorState, Long collectorUploadDataTimes, int collectorOperationTimes) {
        CollectorInformationDO oldCollectorInformationDO = collectorInformationRepository.getCollectorInformationDOByCollectorMacAddress(collectorMacAddress);
        CollectorInformationDO collectorInformationDO;
        if (null == oldCollectorInformationDO) {
            collectorInformationDO = new CollectorInformationDO();
            collectorInformationDO.setCollectorMacAddress(collectorMacAddress);
            collectorInformationDO.setGmtCreate(new Date());
            collectorInformationDO.setCollectorUploadDataTimes(collectorUploadDataTimes);
            collectorInformationDO.setCollectorOperationTimes(collectorOperationTimes);
        } else {
            collectorInformationDO = oldCollectorInformationDO;
            collectorInformationDO.setCollectorOperationTimes(collectorInformationDO.getCollectorOperationTimes() + collectorOperationTimes);
            collectorInformationDO.setCollectorUploadDataTimes(oldCollectorInformationDO.getCollectorUploadDataTimes() + collectorUploadDataTimes);
        }
        collectorInformationDO.setCollectorState(collectorState);
        collectorInformationDO.setGmtCollectorLastUploadData(new Date());
        collectorInformationDO.setGmtModified(new Date());
        return this.saveCollectorInformationDO(collectorInformationDO);
    }

}
