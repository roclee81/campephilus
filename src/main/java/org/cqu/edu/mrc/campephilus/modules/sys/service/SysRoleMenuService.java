package org.cqu.edu.mrc.campephilus.modules.sys.service;

import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/15
 * <p>
 * Description:
 */
public interface SysRoleMenuService {

    /**
     * 更改。。。。。。。。。
     *
     * @param roleId
     * @param menuIdList
     */
    void saveOrUpdate(Long roleId, List<Long> menuIdList);

    /**
     * 通过roleId查询所有的MenuId
     *
     * @param roleId
     * @return
     */
    List<Long> listMenuIdsByRoleId(Long roleId);

    /**
     * 通过1个或多个角色ID删除系统角色菜单
     *
     * @param roleId 角色ID
     */
    void deleteSysRoleMenusByRoleIdIn(Long[] roleId);

}
