package org.cqu.edu.mrc.realdata.modules.sys.repository;

import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysRoleDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/11
 * <p>
 * Description:
 */
public interface SysRoleRepository extends JpaRepository<SysRoleDO, Long> {

    /**
     * 查询用户创建的角色ID列表
     *
     * @param createUserId
     * @return
     */
    List<SysRoleDO> findSysRoleDOSByCreateUserId(Long createUserId);

    /**
     * 通过多个roleId查询SysRole
     *
     * @param roleIds
     * @return
     */
    List<SysRoleDO> findSysRoleDOSByRoleIdIn(Long[] roleIds);

    /**
     * @param roleId
     * @return
     */
    SysRoleDO findSysRoleDOByRoleId(Long roleId);

    /**
     * 通过roleId删除一个或多个SysRole
     *
     * @param roleIds
     */
    void deleteSysRoleByRoleIdIn(Long[] roleIds);

}
