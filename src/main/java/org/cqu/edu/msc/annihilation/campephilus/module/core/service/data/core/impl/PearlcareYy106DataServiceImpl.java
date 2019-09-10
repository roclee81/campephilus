package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.core.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.PearlcareYy106Data;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data.PearlcareYy106DataRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.core.AbstractDataService;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.core.PearlcareYy106DataService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 21:28
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class PearlcareYy106DataServiceImpl extends AbstractDataService<PearlcareYy106Data, Integer> implements PearlcareYy106DataService {

    private final PearlcareYy106DataRepository pearlcareYy106DataRepository;

    public PearlcareYy106DataServiceImpl(PearlcareYy106DataRepository pearlcareYy106DataRepository) {
        this.pearlcareYy106DataRepository = pearlcareYy106DataRepository;
    }

    @Override
    public JpaRepository<PearlcareYy106Data, Integer> getJpaRepository() {
        return pearlcareYy106DataRepository;
    }

    @Override
    protected Integer getId(PearlcareYy106Data pearlcareYy106Data) {
        return pearlcareYy106Data.getId();
    }
}