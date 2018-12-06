package org.cqu.edu.mrc.realdata.modules.sys.repository;

import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysUserTokenDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vinicolor
 * @date 2018/10/11
 * <p>
 * Description:
 * 系统用户Token
 */
public interface SysUserTokenRepository extends JpaRepository<SysUserTokenDO, Long> {

    /**
     * 通过token查询SysUserTokenDO
     *
     * @param token
     * @return
     */
    SysUserTokenDO findSysUserTokenByToken(String token);
}
