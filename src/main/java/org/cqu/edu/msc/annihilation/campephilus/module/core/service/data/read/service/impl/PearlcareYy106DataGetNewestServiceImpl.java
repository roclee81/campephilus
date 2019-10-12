package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.module.core.dto.data.PearlcareYy106DataDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.core.repository.data.PearlcareYy106Repository;
import org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.read.service.DataGetNewestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luoxin
 * @version V1.0
 * @date 2019/9/18
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class PearlcareYy106DataGetNewestServiceImpl implements DataGetNewestService {

    @Autowired
    private PearlcareYy106Repository PEARLCAREYY106Repository;

    @Override
    public Object getNewest(int operationNumber, String serialNumber) {
        return PearlcareYy106DataDTO.structurePearlcareYy106DataDTO(PEARLCAREYY106Repository
                .findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(
                        operationNumber, serialNumber));
    }
}