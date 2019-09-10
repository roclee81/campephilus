package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.core.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.Norwamd9002sData;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data.Norwamd9002sDataRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.core.AbstractDataService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.core.Norwamd9002sDataService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 23:45
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class Norwamd9002sDataServiceImpl extends AbstractDataService<Norwamd9002sData, Integer> implements Norwamd9002sDataService {

    private final Norwamd9002sDataRepository norwamd9002sDataRepository;

    public Norwamd9002sDataServiceImpl(Norwamd9002sDataRepository norwamd9002sDataRepository) {
        this.norwamd9002sDataRepository = norwamd9002sDataRepository;
    }

    @Override
    protected JpaRepository<Norwamd9002sData, Integer> getJpaRepository() {
        return norwamd9002sDataRepository;
    }

    @Override
    protected Integer getId(Norwamd9002sData norwamd9002sData) {
        return norwamd9002sData.getId();
    }

}
