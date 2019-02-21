package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.CollectorInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.repository.CollectorInformationRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.CollectorInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
