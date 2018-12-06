package org.cqu.edu.mrc.realdata.modules.sys.service;

import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysMenuDO;

import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/15
 * <p>
 * Description:
 */
public interface SysMenuService {

    /**
     * @param sysMenuDO
     */
    void save(SysMenuDO sysMenuDO);

    /**
     * 通过menuId查询SysMenuDO
     *
     * @param menuId
     * @return
     */
    SysMenuDO getSysMenuByMenuId(Long menuId);

    /**
     * 通过一个或多个sysMenu列表得到SysMenuDO
     *
     * @param sysMenuList
     * @return
     */
    List<SysMenuDO> listSysMenusByMenuIdIn(List<Long> sysMenuList);

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId 父菜单ID
     * @return
     */
    List<SysMenuDO> listSysMenusByParentId(Long parentId);

    /**
     * 查询所有的SysMenuDO
     *
     * @return
     */
    List<SysMenuDO> listSysMenus();

    /**
     * 获取不包含按钮的菜单列表
     *
     * @return
     */
    List<SysMenuDO> queryNotButtonList();

    /**
     * 通过menuId删除SysMenuDO
     *
     * @param menuId
     */
    void deleteSysMenuByMenuId(Long menuId);


    /**
     * 通过用户ID，得到该用户对应的SysMenu，
     * 首先需要先查询用户所拥有的角色，
     * 然后查询角色拥有的菜单ID，最后通过菜单ID得到菜单
     *
     * @param userId
     * @return
     */
    List<SysMenuDO> listSysMenuByUserId(Long userId);

}
