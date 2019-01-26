package org.cqu.edu.mrc.campephilus.modules.sys.service.impl;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.cqu.edu.mrc.campephilus.common.constant.SysConstant;
import org.cqu.edu.mrc.campephilus.common.exception.OAuthException;
import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysRoleDO;
import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysUserDO;
import org.cqu.edu.mrc.campephilus.modules.sys.repository.SysUserRepository;
import org.cqu.edu.mrc.campephilus.modules.sys.service.SysRoleService;
import org.cqu.edu.mrc.campephilus.modules.sys.service.SysUserRoleService;
import org.cqu.edu.mrc.campephilus.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/15
 * <p>
 * Description:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private final SysUserRepository sysUserRepository;

    private final SysUserRoleService sysUserRoleService;

    private final SysRoleService sysRoleService;


    @Autowired
    public SysUserServiceImpl(SysUserRepository sysUserRepository, SysUserRoleService sysUserRoleService, SysRoleService sysRoleService) {
        this.sysUserRepository = sysUserRepository;
        this.sysUserRoleService = sysUserRoleService;
        this.sysRoleService = sysRoleService;
    }


    @Override
    public SysUserDO getSysUserByUserId(Long userId) {
        return sysUserRepository.findById(userId).orElse(null);
    }

    @Override
    public SysUserDO getSysUserByUsername(String username) {
        return sysUserRepository.findSysUserDOByUsername(username);
    }

    @Override
    public List<String> listPermissionsByUserId(Long userId) {
        return sysUserRepository.listPermissionsByUserId(userId);
    }

    @Override
    public List<Long> listMenuIdsByUserId(Long userId) {
        return Arrays.asList(sysUserRepository.listMenuIdsByUserId(userId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserDO user) {

        //TODO 未实现回滚

        user.setCreateTime(new Date());
        // SHA256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
        user.setSalt(salt);
        sysUserRepository.save(user);

        // 检查角色是否越权
        checkRole(user);

        // 保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysUserDO user) {
        if (StringUtils.isBlank(user.getPassword())) {
            user.setPassword(null);
        } else {
            user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
        }
        sysUserRepository.save(user);

        // 检查角色是否越权
        checkRole(user);

        // 保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());

    }

    @Override
    public void deleteSysUsersByUserIdIn(Long[] userIds) {
        sysUserRepository.deleteSysUserDOSByUserIdIn(userIds);
    }

    @Override
    public boolean updatePassword(Long userId, String password, String newPassword) {
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setPassword(newPassword);
        //TODO 这里应该判断是否更新成功
        return false;
    }


    private void checkRole(SysUserDO user) {
        if (user.getRoleIdList() == null || user.getRoleIdList().size() == 0) {
            return;
        }
        // 如果不是超级管理员，则需要判断用户的角色是否自己创建
        if (user.getCreateUserId() == SysConstant.SUPER_ADMIN) {
            return;
        }

        // 查询用户创建的角色列表
        List<SysRoleDO> roleIdList = sysRoleService.listRoleIdsByCreateUserId(user.getCreateUserId());

        // 判断是否越权
        if (!roleIdList.containsAll(user.getRoleIdList())) {
            throw new OAuthException("新增用户所选角色，不是本人创建");
        }
    }
}
