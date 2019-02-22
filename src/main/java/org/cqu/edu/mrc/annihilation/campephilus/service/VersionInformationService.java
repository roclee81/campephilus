package org.cqu.edu.mrc.annihilation.campephilus.service;

import org.cqu.edu.mrc.annihilation.campephilus.dataobject.FeedbackInformationDO;
import org.cqu.edu.mrc.annihilation.campephilus.dataobject.VersionInformationDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author lx
 * @version V1.0
 * @date 2019/2/22 13:40
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
    Page<VersionInformationDO> listAllByIdNotNull(Pageable pageable);
}
