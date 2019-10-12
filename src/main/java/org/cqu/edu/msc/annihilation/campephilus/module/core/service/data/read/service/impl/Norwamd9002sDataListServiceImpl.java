package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.dto.data.Norwamd9002sDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.core.entity.data.Norwamd9002s;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data.Norwamd9002sRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/9
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class Norwamd9002sDataListServiceImpl implements DataListService {

    @Autowired
    private Norwamd9002sRepository norwamd9002SRepository;

    @Override
    public Object list(int page, int size) {
        Page<Norwamd9002s> norwamd9002sDataList =
                norwamd9002SRepository.findAll(PageRequest.of(page, size));
        return Norwamd9002sDataDTO.structureNorwamd9002sDataDTOList(norwamd9002sDataList.getContent());
    }
}