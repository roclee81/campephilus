package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.StatisticalDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.exception.SaveException;
import org.cqu.edu.mrc.annihilation.campephilus.repository.StatisticalRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.StatisticalService;
import org.cqu.edu.mrc.annihilation.campephilus.utils.ParseJsonUtil;
import org.cqu.edu.mrc.annihilation.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author lx
 * @version V1.0
 * @date 2019/3/8 18:24
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class StatisticalServiceImpl implements StatisticalService {

    private final StatisticalRepository statisticalRepository;

    @Autowired
    public StatisticalServiceImpl(StatisticalRepository statisticalRepository) {
        this.statisticalRepository = statisticalRepository;
    }

    @Override
    public StatisticalDO getStatisticalDOByStatisticalDate(String statisticalDate) {
        return statisticalRepository.findStatisticalDOByStatisticalDate(statisticalDate);
    }

    @Override
    public StatisticalDO getLastStatisticalDO() {
        return statisticalRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Page<StatisticalDO> listAllByIdNotNull(Pageable pageable) {
        return statisticalRepository.findAllByIdNotNull(pageable);
    }

    @Override
    public boolean saveStatisticalDO(StatisticalDO statisticalDO) {
        // 首先查找有没有该条数据，通过statisticalDate字段去查找
        StatisticalDO searchResult = this.getStatisticalDOByStatisticalDate(DateUtil.getCurrentDateString());
        if (null != searchResult) {
            if (!searchResult.getId().equals(statisticalDO.getId())) {
                return false;
            }
        }
        StatisticalDO result = statisticalRepository.save(statisticalDO);
        SaveException.checkSaveSuccess(result, statisticalDO);
        return true;
    }

    @Override
    public boolean updateStatisticalDO(StatisticalDO statisticalDO) {
        // 查询记录
        // 首先查找有没有该条数据，通过statisticalDate字段去查找
        StatisticalDO searchResult = this.getStatisticalDOByStatisticalDate(DateUtil.getCurrentDateString());
        if (null == searchResult) {
            return this.saveStatisticalDO(statisticalDO);
        }
        // 如果数据库中拥有该表，需要将数据进行叠加
        searchResult.getPerHourRequestNumber().addAll(statisticalDO.getPerHourRequestNumber());
        searchResult.getPerHourValidRequestNumber().addAll(statisticalDO.getPerHourValidRequestNumber());
        searchResult.setCollectorRequestNumber(searchResult.getCollectorRequestNumber() + statisticalDO.getCollectorRequestNumber());
        searchResult.setCollectorValidRequestNumber(searchResult.getCollectorValidRequestNumber() + statisticalDO.getCollectorValidRequestNumber());
        searchResult.getCollectorPerHourRequestNumber().addAll(statisticalDO.getCollectorPerHourRequestNumber());
        searchResult.getCollectorPerHourValidRequestNumber().addAll(statisticalDO.getCollectorPerHourValidRequestNumber());
        searchResult.setTotalRequestNumber(searchResult.getTotalRequestNumber() + statisticalDO.getTotalRequestNumber());
        searchResult.setTotalValidRequestNumber(searchResult.getTotalValidRequestNumber() + statisticalDO.getTotalValidRequestNumber());
        searchResult.setGmtModified(new Date());
        return this.saveStatisticalDO(searchResult);
    }

    @Override
    public Page<StatisticalDO> listStatisticalDOByGmtCreateBetween(Date gmtCreateBefore, Date gmtCreateAfter, Pageable pageable) {
        return statisticalRepository.findStatisticalDOByGmtCreateBetween(gmtCreateBefore, gmtCreateAfter, pageable);
    }

    @Override
    public Page<StatisticalDO> listStatisticalDOByGmtModifiedBetween(Date gmtModifiedBefore, Date gmtModifiedAfter, Pageable pageable) {
        return statisticalRepository.findStatisticalDOByGmtModifiedBetween(gmtModifiedBefore, gmtModifiedAfter, pageable);
    }

    @Override
    public boolean updateStatisticalDOOperationInformationWhenUpdateSuccess(ParseDataDTO parseDataDTO) {
        OperationInformationDO parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, OperationInformationDO.class);
        StatisticalDO searchResult = getStatisticalDOByStatisticalDate(DateUtil.getCurrentDateString());
        if (null == searchResult) {
            searchResult = StatisticalDO.getStatisticalDOInstance();
        }
        searchResult.getOperationDevice().add(parseResult.getDeviceInformation());
        searchResult.getOperationHospital().add(parseResult.getOperationHospitalCode());
        searchResult.getOperationList().add(parseResult.getOperationNumber());
        return this.saveStatisticalDO(searchResult);
    }

    @Override
    public StatisticalDataDTO getStatisticsDataDTO() {
        // 首先查询数据库中是否有数据，如果没有数据，将直接返回null
        int totalStatistical = statisticalRepository.countStatisticalDOSByIdNotNull();
        if (totalStatistical == 0) {
            return null;
        }
        StatisticalDataDTO statisticalDataDTO = new StatisticalDataDTO();
        //首先得到当天的
        StatisticalDO searchResult = getStatisticalDOByStatisticalDate(DateUtil.getCurrentDateString());
        if (null == searchResult) {
            statisticalDataDTO.setCollectorUploadStatisticalDay(null);
            statisticalDataDTO.setOperationStatisticalDay(null);
            statisticalDataDTO.setOperationDeviceStatisticalDay(null);
            statisticalDataDTO.setOperationHospitalStatistical(null);
        } else {
            statisticalDataDTO.setCollectorUploadStatisticalDay(searchResult.getCollectorRequestNumber());
            statisticalDataDTO.setOperationStatisticalDay(searchResult.getOperationList().size());
            statisticalDataDTO.setOperationDeviceStatisticalDay(getDeviceStatisticalRemoveDuplicates(searchResult.getOperationDevice()));
            statisticalDataDTO.setOperationHospitalStatistical(searchResult.getOperationHospital().size());
        }

        // 查询数据库得到StatisticalDataDTO中的字段
        // 分页查询，得到需要查询多少页
        int page = totalStatistical / 20;
        //statisticalRepository.findAllByIdNotNull();

        return null;
    }

    private int getDeviceStatisticalRemoveDuplicates(List<List<Map<String, Object>>> operationDeviceList) {
        HashSet<String> hashSet = new HashSet<>();
        for (List<Map<String, Object>> operationDeviceOnce : operationDeviceList) {
            for (Map<String, Object> operationDevice : operationDeviceOnce) {
                hashSet.add(String.valueOf(operationDevice.get("serialNumber")));
            }
        }
        return hashSet.size();
    }
}
