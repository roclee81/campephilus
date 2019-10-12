package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.dto.data.Norwamd9002sDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data.Norwamd9002sRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataListByOperationNumberAndSerialNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class Norwamd9002sDataListByOperationNumberAndSerialNumberServiceImpl implements DataListByOperationNumberAndSerialNumberService {

    @Autowired
    private Norwamd9002sRepository norwamd9002SRepository;

    @Override
    public Object listByOperationNumberAndSerialNumber(
            int page, int size, int operationNumber, String serialNumber) {
        return Norwamd9002sDataDTO.structureNorwamd9002sDataDTOList(
                norwamd9002SRepository.findByOperationNumberAndSerialNumber(
                        operationNumber, serialNumber, PageRequest.of(page, size)));
    }
}