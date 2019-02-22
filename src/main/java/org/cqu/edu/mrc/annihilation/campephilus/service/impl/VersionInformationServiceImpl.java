package org.cqu.edu.mrc.annihilation.campephilus.service.impl;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.VersionInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.repository.VersionInformationRepository;
import org.cqu.edu.mrc.annihilation.campephilus.service.VersionInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 13:43
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Service
public class VersionInformationServiceImpl implements VersionInformationService {

    private final VersionInformationRepository versionInformationRepository;

    @Autowired
    public VersionInformationServiceImpl(VersionInformationRepository versionInformationRepository) {
        this.versionInformationRepository = versionInformationRepository;
    }

    @Override
    public VersionInformationDO saveVersionInformation(VersionInformationDO versionInformationDO) {
        return versionInformationRepository.save(versionInformationDO);
    }

    @Override
    public VersionInformationDO getFirstByOrderByIdDesc() {
        return versionInformationRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Page<VersionInformationDO> listAllByIdNotNull(Pageable pageable) {
        return versionInformationRepository.findAllByIdNotNull(pageable);
    }

}
