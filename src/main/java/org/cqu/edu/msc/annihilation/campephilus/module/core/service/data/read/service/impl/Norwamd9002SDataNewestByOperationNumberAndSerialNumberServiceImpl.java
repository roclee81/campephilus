package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.dto.data.Norwamd9002sDataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data.Norwamd9002sDataRepository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataNewestByOperationNumberAndSerialNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/10
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class Norwamd9002SDataNewestByOperationNumberAndSerialNumberServiceImpl implements DataNewestByOperationNumberAndSerialNumberService {

    @Autowired
    private Norwamd9002sDataRepository norwamd9002sDataRepository;

    @Override
    public Object getNewestOperationNumberAndSerialNumber(int operationNumber, String serialNumber) {
        return Norwamd9002sDataDTO.structureNorwamd9002sDataDTO(norwamd9002sDataRepository
                .findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(
                        operationNumber, serialNumber));
    }
}