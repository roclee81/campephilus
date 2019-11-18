package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.PearlcareYy106;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data.PearlcareYy106Repository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.service.DataSaveService;
import org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils.ParseJsonUtil;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.cqu.edu.msc.annihilation.common.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/9
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class PearlcareYy106DataSaveServiceImpl implements DataSaveService {

    @Autowired
    private PearlcareYy106Repository PEARLCAREYY106Repository;

    @Override
    public ResultDTO save(Object object) {
        PearlcareYy106 pearlcareYy106 = ParseJsonUtil.getTObject(PearlcareYy106.class, (String) object);
        return ServiceCrudCheckUtils.saveObjectAndCheck(PEARLCAREYY106Repository, pearlcareYy106);
    }
}