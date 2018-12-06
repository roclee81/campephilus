package org.cqu.edu.mrc.realdata.modules.sys.repository;

import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysUserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/11
 * <p>
 * Description:
 */
public interface SysUserRepository extends JpaRepository<SysUserDO, Long> {

    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     * @return
     */
    @Query(value = "select m.perms from sys_user_role LEFT JOIN sys_role_menu rm on sys_user_role.role_id = rm.role_id LEFT JOIN sys_menu m on rm.menu_id = m.menu_id where sys_user_role.user_id = ?1", nativeQuery = true)
    List<String> listPermissionsByUserId(Long userId);

    /**
     * 查询用户的所有菜单ID
     *
     * @param userId
     * @return
     */
    @Query(value = "select distinct rm.menu_id from sys_user_role LEFT JOIN sys_role_menu rm on sys_user_role.role_id = rm.role_id where sys_user_role.user_id = ?1", nativeQuery = true)
    Long[] listMenuIdsByUserId(Long userId);

    /**
     * 根据用户名，查询系统用户
     *
     * @param username
     * @return
     */
    SysUserDO findSysUserDOByUsername(String username);

    /**
     * 通过一个或多个UserId删除一个或多个SysUser实体
     *
     * @param userIds 用户ID
     */
    void deleteSysUserDOSByUserIdIn(Long[] userIds);
}
