package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.exception.SaveException;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AbstractInfoService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudUtils;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.info.AfterOperationInfoRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.info.AfterOperationInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:54
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class AfterOperationInfoServiceImpl extends AbstractInfoService<AfterOperationInfo, Integer> implements AfterOperationInfoService {

    private final AfterOperationInfoRepository afterOperationInfoRepository;

    public AfterOperationInfoServiceImpl(AfterOperationInfoRepository afterOperationInfoRepository) {
        this.afterOperationInfoRepository = afterOperationInfoRepository;
    }

    @Override
    public JpaRepository<AfterOperationInfo, Integer> getJpaRepository() {
        return afterOperationInfoRepository;
    }

    @Override
    protected Integer getId(AfterOperationInfo afterOperationInfo) {
        return afterOperationInfo.getId();
    }

}
