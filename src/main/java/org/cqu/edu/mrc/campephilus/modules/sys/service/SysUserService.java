package org.cqu.edu.mrc.campephilus.modules.sys.service;

import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysUserDO;

import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/12
 * <p>
 * Description:
 */
public interface SysUserService {

    /**
     * 根据用户Id，查询系统用户
     *
     * @param userId
     * @return
     */
    SysUserDO getSysUserByUserId(Long userId);

    /**
     * 根据用户名，查询系统用户
     *
     * @param username
     * @return
     */
    SysUserDO getSysUserByUsername(String username);

    /**
     * 查询用户的所有权限
     *
     * @param userId
     * @return
     */
    List<String> listPermissionsByUserId(Long userId);

    /**
     * 查询用户的所有菜单ID
     *
     * @param userId
     * @return
     */
    List<Long> listMenuIdsByUserId(Long userId);

    /**
     * 保存用户
     *
     * @param user
     */
    void save(SysUserDO user);

    /**
     * 修改用户
     *
     * @param user
     */
    void update(SysUserDO user);


    /**
     * 删除用户
     *
     * @param userIds
     */
    void deleteSysUsersByUserIdIn(Long[] userIds);

    /**
     * 修改密码
     *
     * @param userId      用户ID
     * @param password    原密码
     * @param newPassword 新密码
     * @return
     */
    boolean updatePassword(Long userId, String password, String newPassword);

}
