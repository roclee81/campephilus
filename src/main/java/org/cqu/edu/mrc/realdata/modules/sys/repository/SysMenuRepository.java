package org.cqu.edu.mrc.realdata.modules.sys.repository;

import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysMenuDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/15 13:48
 * <p>
 * Description:
 */
public interface SysMenuRepository extends JpaRepository<SysMenuDO, Long> {

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId 父菜单ID
     * @return
     */
    @Query(value = "select * from sys_menu where parent_id = ?1 order by order_num asc", nativeQuery = true)
    List<SysMenuDO> listSysMenuDOByParentId(Long parentId);

    /**
     *通过一个或多个sysMenu列表得到SysMenuDO
     * @param sysMenuList
     * @return
     */
    List<SysMenuDO> findSysMenuDOSByMenuIdIn(List<Long> sysMenuList);

    /**
     * 获取不包含按钮的菜单列表
     *
     * @return
     */
    @Query(value = "select * from sys_menu where type != 2 order by order_num asc", nativeQuery = true)
    List<SysMenuDO> queryNotButtonList();

    /**
     * 通过父菜单Id得到SysMenuDO
     *
     * @param parentId
     * @return
     */
    SysMenuDO findSysMenuDOByParentId(Long parentId);
}
