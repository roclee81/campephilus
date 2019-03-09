package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.cqu.edu.mrc.annihilation.campephilus.dto.ParseDataDTO;
import org.cqu.edu.mrc.annihilation.campephilus.enums.RequestEnum;
import org.cqu.edu.mrc.annihilation.campephilus.repository.StatisticalRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.StatisticalService;
import org.cqu.edu.mrc.annihilation.common.utils.DateUtil;
import org.springframework.beans.BeanUtils;
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
    public StatisticalDO saveStatisticalDO(StatisticalDO statisticalDO) {
        // 首先查找有没有该条数据，通过statisticalDate字段去查找
        StatisticalDO result = this.getStatisticalDOByStatisticalDate(DateUtil.getCurrentDateString());
        if (null != result) {
            return null;
        }
        return statisticalRepository.save(statisticalDO);
    }

    @Override
    public StatisticalDO updateStatisticalDO(StatisticalDO statisticalDO) {
        // 查询记录
        // 首先查找有没有该条数据，通过statisticalDate字段去查找
        StatisticalDO result = this.getStatisticalDOByStatisticalDate(DateUtil.getCurrentDateString());
        StatisticalDO lastStatisticalDO = this.getLastStatisticalDO();
        // 首先将通过日期查询数据是否有改字段，在查询时还将通过<code>getLastStatisticalDO()</code>方法去查询
        // 查询是否statisticalDate字段相同，如果不同，则将直接保存statisticalDO对象
        boolean statisticalDateIsSame = null == result || !result.getStatisticalDate().equals(lastStatisticalDO.getStatisticalDate());
        if (statisticalDateIsSame) {
            return this.saveStatisticalDO(statisticalDO);
        }
        // 如果数据库中拥有该表，需要将数据进行叠加
        result.getOperationList().addAll(statisticalDO.getOperationList());
        result.getOperationDevice().addAll(statisticalDO.getOperationDevice());
        result.getOperationHospital().addAll(statisticalDO.getOperationHospital());
        result.getPerHourRequestNumber().addAll(statisticalDO.getPerHourRequestNumber());
        result.getPerHourValidRequestNumber().addAll(statisticalDO.getPerHourValidRequestNumber());
        result.setCollectorRequestNumber(result.getCollectorRequestNumber() + statisticalDO.getCollectorRequestNumber());
        result.setCollectorValidRequestNumber(result.getCollectorValidRequestNumber() + statisticalDO.getCollectorValidRequestNumber());
        result.getCollectorPerHourRequestNumber().addAll(statisticalDO.getCollectorPerHourRequestNumber());
        result.getCollectorPerHourValidRequestNumber().addAll(statisticalDO.getCollectorPerHourValidRequestNumber());
        result.setTotalRequestNumber(result.getTotalRequestNumber() + statisticalDO.getTotalRequestNumber());
        result.setTotalValidRequestNumber(result.getTotalValidRequestNumber() + statisticalDO.getTotalValidRequestNumber());
        result.setGmtModified(new Date());
        return this.saveStatisticalDO(result);
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
    public StatisticalDO updateStatisticalDO(ParseDataDTO parseDataDTO) {
        if (RequestEnum.OPERATION_READY.getCode().equals(parseDataDTO.getCode())) {
            //TODO 未实现
        }
        return null;
    }
}
