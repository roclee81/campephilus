package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.save.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.Norwamd9002s;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data.Norwamd9002sRepository;
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
public class Norwamd9002sDataSaveServiceImpl implements DataSaveService {

    @Autowired
    private Norwamd9002sRepository norwamd9002SRepository;

    @Override
    public ResultDTO save(Object object) {
        Norwamd9002s NORWAMD9002S = ParseJsonUtil.getTObject(Norwamd9002s.class, (String) object);
        return ServiceCrudCheckUtils.saveObjectAndCheck(norwamd9002SRepository, NORWAMD9002S);
    }
}