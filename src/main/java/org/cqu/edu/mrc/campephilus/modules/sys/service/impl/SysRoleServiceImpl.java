package org.cqu.edu.mrc.campephilus.modules.sys.service.impl;

import org.cqu.edu.mrc.campephilus.common.constant.SysConstant;
import org.cqu.edu.mrc.campephilus.common.exception.OAuthException;
import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysRoleDO;
import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysUserRoleDO;
import org.cqu.edu.mrc.campephilus.modules.sys.repository.SysRoleRepository;
import org.cqu.edu.mrc.campephilus.modules.sys.repository.SysUserRepository;
import org.cqu.edu.mrc.campephilus.modules.sys.repository.SysUserRoleRepository;
import org.cqu.edu.mrc.campephilus.modules.sys.service.SysRoleService;
import org.cqu.edu.mrc.campephilus.modules.sys.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
public class SysRoleServiceImpl implements SysRoleService {

    private final SysUserRepository sysUserRepository;

    private final SysRoleRepository sysRoleRepository;

    private final SysRoleMenuService sysRoleMenuService;

    private final SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    public SysRoleServiceImpl(SysRoleRepository sysRoleRepository, SysRoleMenuService sysRoleMenuService, SysUserRepository sysUserRepository, SysUserRoleRepository sysUserRoleRepository) {
        this.sysRoleRepository = sysRoleRepository;
        this.sysRoleMenuService = sysRoleMenuService;
        this.sysUserRepository = sysUserRepository;
        this.sysUserRoleRepository = sysUserRoleRepository;
    }

    @Override
    public List<SysRoleDO> listSysRolesByUserId(Long userId) {
        // 超级管理员，查询所有拥有的角色列表
        if (userId == SysConstant.SUPER_ADMIN) {
            return sysRoleRepository.findAll();
        }
        // 如果不是超级管理员，则只查询自己所拥有的角色列表
        List<SysUserRoleDO> sysUserRoleDOList = sysUserRoleRepository.findSysUserRoleDOSByUserId(userId);
        List<SysRoleDO> sysRoleDOList = new ArrayList<>(16);
        for (SysUserRoleDO sysUserRoleDO : sysUserRoleDOList) {
            sysRoleDOList.add(sysRoleRepository.findSysRoleDOByRoleId(sysUserRoleDO.getRoleId()));
        }
        return sysRoleDOList;
    }

    @Override
    public SysRoleDO getSysRoleByRoleId(Long roleId) {
        return sysRoleRepository.findById(roleId).orElse(null);
    }

    @Override
    public List<SysRoleDO> listRoleIdsByCreateUserId(Long createUserId) {
        return sysRoleRepository.findSysRoleDOSByCreateUserId(createUserId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysRoleDO sysRoleDO) {

        //TODO 未实现回滚

        sysRoleDO.setCreateTime(new Date());
        sysRoleRepository.save(sysRoleDO);

        // 检查权限是否越权
        checkPermissions(sysRoleDO);

        // 保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(sysRoleDO.getRoleId(), sysRoleDO.getMenuIdList());
    }

    @Override
    public void deleteSysRolesByRoleIdIn(Long[] roleIds) {
        sysRoleRepository.deleteSysRoleByRoleIdIn(roleIds);
    }

    /**
     * 检查权限是否越权
     *
     * @param sysRoleDO
     */
    private void checkPermissions(SysRoleDO sysRoleDO) {
        // 如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
        if (sysRoleDO.getCreateUserId() == SysConstant.SUPER_ADMIN) {
            return;
        }

        // 查询用户所拥有的菜单列表
        List<Long> menuIdList = Arrays.asList(sysUserRepository.listMenuIdsByUserId(sysRoleDO.getCreateUserId()));

        // 判断是否越权
        if (!menuIdList.containsAll(sysRoleDO.getMenuIdList())) {
            throw new OAuthException("新增角色的权限，已超出你的权限范围");
        }
    }

}
