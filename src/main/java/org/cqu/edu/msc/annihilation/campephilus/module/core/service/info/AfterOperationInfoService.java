package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/15 16:50
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface AfterOperationInfoService {

    /**
     * 保存
     *
     * @param afterOperationInfo
     */
    AfterOperationInfo save(AfterOperationInfo afterOperationInfo);

    /**
     * 更新
     *
     * @param afterOperationInfo
     */
    void update(AfterOperationInfo afterOperationInfo);

    List<AfterOperationInfo> listById(Object id);

    /**
     * 列出所有的数据，根据分页信息
     *
     * @param page
     * @param size
     * @return
     */
    List<AfterOperationInfo> listAll(int page, int size);

    /**
     * 删除
     *
     * @param afterOperationInfo
     */
    void delete(AfterOperationInfo afterOperationInfo);

    long countAll();
}
