package org.cqu.edu.mrc.campephilus.modules.sys.service;

import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysUserDO;
import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysUserTokenDO;

import java.util.Set;

/**
 * @author Vinicolor
 * @date 2018/10/16 15:01
 * <p>
 * Description:
 * shiro相关接口
 */
public interface ShiroService {

    /**
     * 获取用户权限列表
     *
     * @param userId
     * @return
     */
    Set<String> getUserPermissionsByUserId(long userId);

    /**
     * 根据token，查询SysUserTokenDO
     *
     * @param token
     * @return
     */
    SysUserTokenDO getSysUserTokenByToken(String token);

    /**
     * 根据用户ID，查询用户
     *
     * @param userId
     * @return
     */
    SysUserDO getSysUserByUserId(Long userId);
}
