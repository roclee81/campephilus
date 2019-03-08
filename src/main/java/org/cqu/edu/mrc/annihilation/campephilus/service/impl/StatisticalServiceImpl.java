package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.StatisticalDO;
import org.cqu.edu.mrc.annihilation.campephilus.repository.StatisticalRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public StatisticalDO getFirstByOrderByIdDesc() {
        return statisticalRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Page<StatisticalDO> listAllByIdNotNull(Pageable pageable) {
        return statisticalRepository.findAllByIdNotNull(pageable);
    }

    @Override
    public StatisticalDO saveStatisticalDO(StatisticalDO statisticalDO) {
        return statisticalRepository.save(statisticalDO);
    }

    @Override
    public StatisticalDO updateStatisticalDO(StatisticalDO statisticalDO) {
        return null;
    }
}
