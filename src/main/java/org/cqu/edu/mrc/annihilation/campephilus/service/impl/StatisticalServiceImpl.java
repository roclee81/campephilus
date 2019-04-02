package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.DeviceCommon;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.OperationInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.StatisticalDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.exception.SaveException;
import org.cqu.edu.mrc.annihilation.campephilus.repository.StatisticalRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.StatisticalService;
import org.cqu.edu.mrc.annihilation.campephilus.utils.ParseJsonUtil;
import org.cqu.edu.mrc.annihilation.campephilus.value.StatisticalValue;
import org.cqu.edu.mrc.annihilation.common.constant.DataBaseConstant;
import org.cqu.edu.mrc.annihilation.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

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
    private final StatisticalValue statisticalValue;

    @Autowired
    public StatisticalServiceImpl(StatisticalRepository statisticalRepository, StatisticalValue statisticalValue) {
        this.statisticalRepository = statisticalRepository;
        this.statisticalValue = statisticalValue;
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
        OperationInformationDO parseResult = ParseJsonUtil.parseJsonString(parseDataDTO, OperationInformationDO.class);
        StatisticalDO searchResult = getStatisticalDOByStatisticalDate(DateUtil.getCurrentDateString());
        if (null == searchResult) {
            searchResult = StatisticalDO.getStatisticalDOInstance();
        }
        searchResult.getDeviceList().add(parseResult.getDevice());
        searchResult.getHospitalList().add(parseResult.getOperationHospitalCode());
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
            statisticalDataDTO.setOperationDevice(getDeviceStatisticalRemoveDuplicates(searchResult.getDeviceList()));
            statisticalDataDTO.setOperationHospital(searchResult.getHospitalList().size());
        }
        statisticalDataDTO.setCollectorUploadTotal(statisticalValue.getCollectorUploadTotal());
        statisticalDataDTO.setOperationTotal(statisticalValue.getOperationTotal());
        statisticalDataDTO.setOperationDeviceTotal(statisticalValue.getDeviceNumber().size());
        statisticalDataDTO.setOperationHospitalTotal(statisticalValue.getHospitalNumber().size());

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

                statisticalValue.setCollectorUploadTotal(
                        statisticalValue.getCollectorUploadTotal() + statisticalDO.getCollectorUpload());

                statisticalValue.getCollectorUploadList().add(statisticalDO.getCollectorUpload());

                statisticalValue.getOperationNumberList().add(statisticalDO.getOperationNumberList().size());

                statisticalValue.setOperationTotal(statisticalValue.getOperationTotal() + statisticalDO.getOperationNumberList().size());

//                statisticalDO.getDeviceList().forEach(deviceCommons -> {
//                    statisticalValue.getDeviceNumber().add(deviceCommons);
//                });
                // TODO

                statisticalValue.getHospitalNumber().addAll(statisticalDO.getHospitalList());
            });
        }
    }

    private int getDeviceStatisticalRemoveDuplicates(List<List<DeviceCommon>> operationDeviceList) {
        HashSet<String> hashSet = new HashSet<>();
        for (List<DeviceCommon> operationDeviceOnce : operationDeviceList) {
            for (DeviceCommon deviceCommon : operationDeviceOnce) {
                hashSet.add(deviceCommon.getSerialNumber());
            }
        }
        return hashSet.size();
    }
}
