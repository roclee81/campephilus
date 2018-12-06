package org.cqu.edu.mrc.realdata.modules.sys.service.impl;

import org.apache.commons.lang.StringUtils;
import org.cqu.edu.mrc.realdata.modules.sys.repository.SysMenuRepository;
import org.cqu.edu.mrc.realdata.modules.sys.repository.SysUserRepository;
import org.cqu.edu.mrc.realdata.common.constant.SysConstant;
import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysMenuDO;
import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysUserDO;
import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysUserTokenDO;
import org.cqu.edu.mrc.realdata.modules.sys.repository.SysUserTokenRepository;
import org.cqu.edu.mrc.realdata.modules.sys.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Vinicolor
 * @date 2018/10/16 15:02
 * <p>
 * Description:
 */
@Service
public class ShiroServiceImpl implements ShiroService {

    private final SysMenuRepository sysMenuRepository;

    private final SysUserTokenRepository sysUserTokenRepository;

    private final SysUserRepository sysUserRepository;

    @Autowired
    public ShiroServiceImpl(SysMenuRepository sysMenuRepository, SysUserTokenRepository sysUserTokenRepository, SysUserRepository sysUserRepository) {
        this.sysMenuRepository = sysMenuRepository;
        this.sysUserTokenRepository = sysUserTokenRepository;
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    public Set<String> getUserPermissionsByUserId(long userId) {
        List<String> permsList;
        // 系统管理员，拥有最高权限
        if (userId == SysConstant.SUPER_ADMIN) {
            List<SysMenuDO> sysMenuDOList = sysMenuRepository.findAll();
            permsList = new ArrayList<>(sysMenuDOList.size());
            for (SysMenuDO menuEntity : sysMenuDOList) {
                permsList.add(menuEntity.getPerms());
            }
        } else {
            permsList = sysUserRepository.listPermissionsByUserId(userId);
        }
        Set<String> permsSet = new HashSet<>();
        for (String perms : permsList) {
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserTokenDO getSysUserTokenByToken(String token) {
        return sysUserTokenRepository.findSysUserTokenByToken(token);
    }

    @Override
    public SysUserDO getSysUserByUserId(Long userId) {
        return sysUserRepository.findById(userId).orElse(null);
    }
}
