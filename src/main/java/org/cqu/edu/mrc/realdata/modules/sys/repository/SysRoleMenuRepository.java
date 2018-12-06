package org.cqu.edu.mrc.realdata.modules.sys.repository;


import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysRoleMenuDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Vinicolor
 * @date 2018/10/15 13:49
 * <p>
 * Description:
 */
public interface SysRoleMenuRepository extends JpaRepository<SysRoleMenuDO, String> {

    /**
     * 通过RoleId查询菜单Id
     *
     * @param roleId
     * @return Long[]，如果获得List<Long>的时候，返回的是List<BigInteger>
     */
    //TODO 为什么将其返回值设置为List<Long>的时候，结果中List会出现为BigInteger
    @Query(value = "select menu_id from sys_role_menu where role_id = ?1", nativeQuery = true)
    Long[] listMenuIdsByRoleId(Long roleId);

    /**
     * 通过
     *
     * @param roleIds
     */
    void deleteSysRoleMenuDOSByRoleIdIn(Long[] roleIds);

}
