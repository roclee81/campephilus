package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.CollectorInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.CollectorInformationDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.CollectorStateEnum;
import org.cqu.edu.mrc.annihilation.campephilus.enums.RequestEnum;
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
        return collectorInformationRepository.findCollectorInformationDOByCollectorMacAddress(collectorMacAddress);
    }

    @Override
    public Page<CollectorInformationDO> listCollectorInformationDOSByCollectorState(Integer collectorState, Pageable pageable) {
        return collectorInformationRepository.findCollectorInformationDOSByCollectorState(collectorState, pageable);
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
    public CollectorInformationDO updateCollectorInformationDOWhenUpdateSuccess(ParseDataDTO parseDataDTO) {
        String collectorMacAddress = parseDataDTO.getMacAddress();
        CollectorInformationDO oldCollectorInformationDO = collectorInformationRepository.findCollectorInformationDOByCollectorMacAddress(collectorMacAddress);
        CollectorInformationDO collectorInformationDO;
        // 如果数据库中没有对应collectorMacAddress的地址，新建一个，并将CollectorUploadDataTimes、CollectorOperationTimes设置为1
        if (null == oldCollectorInformationDO) {
            collectorInformationDO = new CollectorInformationDO();
            collectorInformationDO.setCollectorMacAddress(collectorMacAddress);
            collectorInformationDO.setGmtCreate(new Date());
            collectorInformationDO.setCollectorUploadDataTimes(1L);
            collectorInformationDO.setCollectorOperationTimes(1);
        } else {
            collectorInformationDO = oldCollectorInformationDO;
            if (parseDataDTO.getCode().equals(RequestEnum.OPERATION_READY.getCode())) {
                collectorInformationDO.setCollectorOperationTimes(collectorInformationDO.getCollectorOperationTimes() + 1);
            }
            collectorInformationDO.setCollectorUploadDataTimes(oldCollectorInformationDO.getCollectorUploadDataTimes() + 1L);
        }
        collectorInformationDO.setCollectorState(CollectorStateEnum.RUNNING.getCode());
        collectorInformationDO.setGmtCollectorLastUploadData(new Date());
        collectorInformationDO.setGmtModified(new Date());
        return this.saveCollectorInformationDO(collectorInformationDO);
    }

    @Override
    public Page<CollectorInformationDO> listCollectorInformationDOSByCollectorStateIn(List<Integer> collectorStateList, Pageable pageable) {
        return collectorInformationRepository.findCollectorInformationDOSByCollectorStateIn(collectorStateList, pageable);
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
        return collectorInformationRepository.findCollectorInformationDOSByCollectorStateInAndGmtCollectorLastUploadDataBefore(collectorStateList, gmtCollectorLastUploadDataBefore, pageable);
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
