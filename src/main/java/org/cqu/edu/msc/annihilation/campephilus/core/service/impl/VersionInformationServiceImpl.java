package org.cqu.edu.msc.annihilation.campephilus.core.service.impl;

import org.cqu.edu.msc.annihilation.campephilus.core.dataobject.VersionInformationDO;
import org.cqu.edu.msc.annihilation.campephilus.core.repository.VersionInformationRepository;
import org.cqu.edu.msc.annihilation.campephilus.core.dto.VersionInformationDTO;
import org.cqu.edu.msc.annihilation.campephilus.core.form.InformationForm;
import org.cqu.edu.msc.annihilation.campephilus.core.service.VersionInformationService;
import org.cqu.edu.msc.annihilation.common.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Override
    public VersionInformationDTO getVersionInformationDTO() {
        VersionInformationDO versionInformationDO = versionInformationRepository.findFirstByOrderByIdDesc();
        return ConvertUtil.convert(versionInformationDO, VersionInformationDTO.class);
    }

    @Override
    public boolean saveInformation(InformationForm informationForm) {
        VersionInformationDO versionInformationDO = new VersionInformationDO();
        versionInformationDO.setGmtModified(new Date());
        versionInformationDO.setGmtCreate(new Date());
        versionInformationDO.setApplicationVersion(informationForm.getApplicationVersion());
        versionInformationDO.setCollectorVersion(informationForm.getCollectorVersion());
        VersionInformationDO result = versionInformationRepository.save(versionInformationDO);
        return result != null;
    }

}
