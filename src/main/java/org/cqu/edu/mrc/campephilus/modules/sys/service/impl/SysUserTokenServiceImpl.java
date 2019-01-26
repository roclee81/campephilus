package org.cqu.edu.mrc.campephilus.modules.sys.service.impl;

import org.cqu.edu.mrc.campephilus.common.utils.R;
import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysUserTokenDO;
import org.cqu.edu.mrc.campephilus.modules.sys.repository.SysUserTokenRepository;
import org.cqu.edu.mrc.campephilus.modules.sys.service.SysUserTokenService;
import org.cqu.edu.mrc.campephilus.modules.sys.oauth2.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Vinicolor
 * @date 2018/10/12
 * <p>
 * Description:
 */
@Service
public class SysUserTokenServiceImpl implements SysUserTokenService {

    /**
     * 12小时后过期
     */
    private final static int EXPIRE = 3600 * 12;

    private final SysUserTokenRepository sysUserTokenRepository;

    @Autowired
    public SysUserTokenServiceImpl(SysUserTokenRepository sysUserTokenRepository) {
        this.sysUserTokenRepository = sysUserTokenRepository;
    }

    @Override
    public R createToken(long userId) {
        // 生成一个token
        String token = TokenGenerator.generateValue();

        // 当前时间
        Date now = new Date();
        // 过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        Optional<SysUserTokenDO> optionalSysUserTokenEntity = sysUserTokenRepository.findById(userId);
        SysUserTokenDO tokenEntity;
        if (optionalSysUserTokenEntity.isPresent()) {
            tokenEntity = optionalSysUserTokenEntity.get();
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
        } else {
            tokenEntity = new SysUserTokenDO(userId, token, now, expireTime);
        }
        sysUserTokenRepository.save(tokenEntity);
        return Objects.requireNonNull(R.success().put("token", token)).put("expire", EXPIRE);
    }

    @Override
    public void logout(long userId) {
        // 生成一个token
        String token = TokenGenerator.generateValue();

        //修改token
        SysUserTokenDO tokenEntity = new SysUserTokenDO();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        sysUserTokenRepository.save(tokenEntity);
    }
}
