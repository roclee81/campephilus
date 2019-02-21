package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.CollectorInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.CollectorInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.CollectorStateEnum;
import org.cqu.edu.mrc.annihilation.campephilus.repository.CollectorInformationRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.CollectorInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public List<CollectorInformationDO> saveCollectorInformationDOS(List<CollectorInformationDO> collectorInformationDOIterable) {
        return collectorInformationRepository.saveAll(collectorInformationDOIterable);
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

    @Override
    public Page<CollectorInformationDO> listCollectorInformationDOSByCollectorStateIn(List<Integer> collectorStateList, Pageable pageable) {
        return collectorInformationRepository.getCollectorInformationDOSByCollectorStateIn(collectorStateList, pageable);
    }

    @Override
    public Page<CollectorInformationDO> listCollectorInformationDOS(Pageable pageable) {
        List<Integer> collectorStateList = getAllCollectorState();
        return this.listCollectorInformationDOSByCollectorStateIn(collectorStateList, pageable);
    }

    @Override
    public Integer countCollectorInformationDOSByCollectorStateIn(List<Integer> collectorStateList) {
        return collectorInformationRepository.countCollectorInformationDOSByCollectorStateIn(collectorStateList);
    }

    @Override
    public Integer countCollectorInformationDOS() {
        List<Integer> collectorStateList = getAllCollectorState();
        return this.countCollectorInformationDOSByCollectorStateIn(collectorStateList);
    }

    @Override
    public Page<CollectorInformationDO> listCollectorInformationDOSByCollectorStateInAndGmtCollectorLastUploadDataBefore(List<Integer> collectorStateList, Date gmtCollectorLastUploadDataBefore, Pageable pageable) {
        return collectorInformationRepository.getCollectorInformationDOSByCollectorStateInAndGmtCollectorLastUploadDataBefore(collectorStateList, gmtCollectorLastUploadDataBefore, pageable);
    }

    @Override
    public CollectorInformationDTO getCollectorInformationDTO(Pageable pageable) {
        CollectorInformationDTO collectorInformationDTO = new CollectorInformationDTO();
        int collectorTotalNumber = this.countCollectorInformationDOS();
        int runningCollectorNumber = this.countCollectorInformationDOSByCollectorStateIn(new ArrayList<>(Collections.singletonList(CollectorStateEnum.RUNNING.getCode())));
        int offlineCollectorNumber = collectorTotalNumber - runningCollectorNumber;
        collectorInformationDTO.setCollectorTotalNumber(collectorTotalNumber);
        collectorInformationDTO.setOfflineCollectorNumber(offlineCollectorNumber);
        collectorInformationDTO.setRunningCollectorNumber(runningCollectorNumber);
        if (null != pageable) {
            collectorInformationDTO.setCollectorInformationDOList(this.listCollectorInformationDOS(pageable).getContent());
        }
        return collectorInformationDTO;
    }

    private List<Integer> getAllCollectorState() {
        List<Integer> collectorStateList = new ArrayList<>();

        for (CollectorStateEnum collectorState : CollectorStateEnum.values()) {
            collectorStateList.add(collectorState.getCode());
        }
        return collectorStateList;
    }

}
