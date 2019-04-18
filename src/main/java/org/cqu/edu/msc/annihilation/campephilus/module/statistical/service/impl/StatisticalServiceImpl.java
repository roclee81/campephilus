package org.cqu.edu.msc.annihilation.campephilus.module.statistical.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.info.OperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.ParseDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.app.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.module.app.utils.RemoveDuplicatesUtil;
import org.cqu.edu.msc.annihilation.campephilus.module.statistical.cache.StatisticalCache;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.StatisticalDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.repository.StatisticalRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.statistical.service.StatisticalService;
import org.cqu.edu.msc.annihilation.common.constant.DataBaseConstant;
import org.cqu.edu.msc.annihilation.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final StatisticalCache statisticalCache;

    @Autowired
    public StatisticalServiceImpl(StatisticalRepository statisticalRepository, StatisticalCache statisticalCache) {
        this.statisticalRepository = statisticalRepository;
        this.statisticalCache = statisticalCache;
    }

    @Override
    public StatisticalDO getStatisticalDOByStatisticalDate(String statisticalDate) {
        return statisticalRepository.findStatisticalDOByDate(statisticalDate);
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
        searchResult.getPerHourCollectorUploadList().addAll(statisticalDO.getPerHourCollectorUploadList());
        searchResult.getPerHourCollectorValidUploadList().addAll(statisticalDO.getPerHourCollectorValidUploadList());
        searchResult.setCollectorUpload(searchResult.getCollectorUpload() + statisticalDO.getCollectorUpload());
        searchResult.setCollectorValidUpload(searchResult.getCollectorValidUpload() + statisticalDO.getCollectorValidUpload());
        searchResult.getPerHourCollectorUploadList().addAll(statisticalDO.getPerHourCollectorUploadList());
        searchResult.getPerHourCollectorValidUploadList().addAll(statisticalDO.getPerHourCollectorValidUploadList());
        searchResult.setRequest(searchResult.getRequest() + statisticalDO.getRequest());
        searchResult.setCollectorValidUpload(searchResult.getCollectorValidUpload() + statisticalDO.getCollectorValidUpload());
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
        OperationInfo parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, OperationInfo.class);
        StatisticalDO searchResult = getStatisticalDOByStatisticalDate(DateUtil.getCurrentDateString());
        if (null == searchResult) {
            searchResult = StatisticalDO.getStatisticalDOInstance();
        }
        searchResult.getDeviceList().add(parseResult.getDevice());
        searchResult.getHospitalCodeList().add(parseResult.getOperationHospitalCode());
        searchResult.getOperationNumberList().add(parseResult.getOperationNumber());
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
            statisticalDataDTO.setCollectorUpload(null);
            statisticalDataDTO.setOperation(null);
            statisticalDataDTO.setOperationDevice(null);
            statisticalDataDTO.setOperationHospital(null);
        } else {
            statisticalDataDTO.setCollectorUpload(searchResult.getCollectorUpload());
            statisticalDataDTO.setOperation(searchResult.getOperationNumberList().size());
            statisticalDataDTO.setOperationDevice(RemoveDuplicatesUtil.getDeviceSetRemoveDuplicates(searchResult.getDeviceList()).size());
            statisticalDataDTO.setOperationHospital(searchResult.getHospitalCodeList().size());
        }
        statisticalDataDTO.setCollectorUploadTotal(statisticalCache.getCollectorUploadTotal());
        statisticalDataDTO.setOperationTotal(statisticalCache.getOperationTotal());
        statisticalDataDTO.setOperationDeviceTotal(statisticalCache.getDeviceNumber().size());
        statisticalDataDTO.setOperationHospitalTotal(statisticalCache.getHospitalCode().size());

        return statisticalDataDTO;
    }

    /**
     * 初始化StatisticalValue
     * 需要查询遍历数据库表来形成值
     */
    private void initStatisticalValue() {
        int totalStatistical = statisticalRepository.countStatisticalDOSByIdNotNull();
        // 查询数据库得到StatisticalDataDTO中的字段
        // 分页查询，得到需要查询多少页
        int totalPage = totalStatistical / 20;
        for (int page = 0; page <= totalPage; page++) {
            Page<StatisticalDO> statisticalDOPage =
                    statisticalRepository.findAllByIdNotNull(PageRequest.of(page, DataBaseConstant.I_PAGE_SIZE));
            statisticalDOPage.stream().forEach(statisticalDO -> {

                statisticalCache.setCollectorUploadTotal(
                        statisticalCache.getCollectorUploadTotal() + statisticalDO.getCollectorUpload());

                statisticalCache.getCollectorUploadList().add(statisticalDO.getCollectorUpload());

                statisticalCache.getOperationNumberList().add(statisticalDO.getOperationNumberList().size());

                statisticalCache.setOperationTotal(statisticalCache.getOperationTotal() + statisticalDO.getOperationNumberList().size());

//                statisticalDO.getDeviceList().forEach(deviceCommons -> {
//                    statisticalValue.getDeviceNumber().add(deviceCommons);
//                });
                // TODO

                statisticalCache.getHospitalCode().addAll(statisticalDO.getHospitalCodeList());
            });
        }
    }
}
