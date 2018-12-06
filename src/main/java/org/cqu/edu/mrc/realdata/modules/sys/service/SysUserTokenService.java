package org.cqu.edu.mrc.realdata.modules.sys.service;

import org.cqu.edu.mrc.realdata.common.utils.R;

/**
 * @author Vinicolor
 * @date 2018/10/12
 * <p>
 * Description:
 */
public interface SysUserTokenService {

    /**
     * 生成token
     *
     * @param userId 用户ID
     * @return
     */
    R createToken(long userId);

    /**
     * 退出，修改token值
     *
     * @param userId 用户ID
     */
    void logout(long userId);
}
