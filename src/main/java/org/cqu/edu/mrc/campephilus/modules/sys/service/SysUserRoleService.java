package org.cqu.edu.mrc.campephilus.modules.sys.service;

import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/12
 * <p>
 * Description:
 * 用户与角色对应关系
 */
public interface SysUserRoleService {

    /**
     * @param userId     用户Id
     * @param roleIdList 权限ID列表
     */
    void saveOrUpdate(Long userId, List<Long> roleIdList);

    /**
     * 根据用户ID，获取角色ID列表
     *
     * @param userId 用户ID
     * @return 用户角色列表
     */
    List<Long> listRoleIdsByUserId(Long userId);

    /**
     * 根据角色ID数组，批量删除
     *
     * @param roleIds 角色ID
     */
    void deleteUserRolesByRoleIdIn(Long[] roleIds);
}
