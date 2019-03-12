package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
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
}
