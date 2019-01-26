package org.cqu.edu.mrc.campephilus.modules.sys.service;

import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysRoleDO;

import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/15
 * <p>
 * Description:
 */
public interface SysRoleService {

    /**
     * 通过userId查询所拥有的角色信息，对于超级管理员拥有所有角色
     *
     * @param userId 用户ID
     * @return
     */
    List<SysRoleDO> listSysRolesByUserId(Long userId);

    /**
     * 通过角色Id查询系统权限
     *
     * @param roleId 角色ID
     * @return
     */
    SysRoleDO getSysRoleByRoleId(Long roleId);

    /**
     * 查询用户创建的角色ID列表
     *
     * @param createUserId
     * @return
     */
    List<SysRoleDO> listRoleIdsByCreateUserId(Long createUserId);

    /**
     * 保存系统角色
     *
     * @param sysRoleDO 系统角色实体
     */
    void save(SysRoleDO sysRoleDO);

    /**
     * 通过一个或多个roleId删除系统角色
     *
     * @param roleIds
     */
    void deleteSysRolesByRoleIdIn(Long[] roleIds);

}
