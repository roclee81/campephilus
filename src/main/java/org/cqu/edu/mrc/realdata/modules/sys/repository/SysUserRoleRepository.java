package org.cqu.edu.mrc.realdata.modules.sys.repository;

import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysUserRoleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/11
 * <p>
 * Description:
 */
public interface SysUserRoleRepository extends JpaRepository<SysUserRoleDO, Long> {

    /**
     * 通过userId查询一个或多个RoleId
     *
     * @param userId
     * @return
     */
    @Query(value = "select role_id from sys_user_role where user_id =?1", nativeQuery = true)
    Long[] listRoleIdsByUserId(Long userId);

    /**
     * 通过userId查询一个或多个SysUserRole
     *
     * @param userId
     * @return
     */
    List<SysUserRoleDO> findSysUserRoleDOSByUserId(Long userId);

    /**
     * 通过一个或多个roleId，删除SysUserRoleDO
     *
     * @param roleIds
     */
    void deleteSysUserRoleDOSByRoleIdIn(Long[] roleIds);
}
