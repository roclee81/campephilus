package org.cqu.edu.msc.annihilation.campephilus.module.app.service;

import org.cqu.edu.msc.annihilation.campephilus.module.app.dataobject.VersionInformationDO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.dto.VersionInformationDTO;
import org.cqu.edu.msc.annihilation.campephilus.module.app.form.InformationForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/4/5 11:08
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface VersionInformationService {

    /**
     * 保存VersionInformationDO
     *
     * @param versionInformationDO 需要保存的实体
     * @return 如果保存成功返回VersionInformationDO，如果没有返回null
     */
    VersionInformationDO saveVersionInformation(VersionInformationDO versionInformationDO);

    /**
     * 查询最后一条数据
     *
     * @return VersionInformationDO实体
     */
    VersionInformationDO getFirstByOrderByIdDesc();

    /**
     * 找到ID不为空的所有数据，就是查找所有的数据
     *
     * @param pageable 分页信息
     * @return Page<VersionInformationDO>，查询失败为空的page
     */
    Page<VersionInformationDO> listAll(Pageable pageable);

    /**
     * 得到最新的VersionInformationDTO版本信息
     *
     * @return VersionInformationDTO
     */
    VersionInformationDTO getVersionInformationDTO();

    /**
     * 保存表单信息
     *
     * @param informationForm 表单信息
     * @return 是否保存成功
     */
    boolean saveInformation(InformationForm informationForm);
}
