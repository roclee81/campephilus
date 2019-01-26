package org.cqu.edu.mrc.campephilus.modules.sys.service.impl;

import org.cqu.edu.mrc.campephilus.common.constant.SysConstant;
import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysMenuDO;
import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysRoleDO;
import org.cqu.edu.mrc.campephilus.modules.sys.repository.SysMenuRepository;
import org.cqu.edu.mrc.campephilus.modules.sys.repository.SysRoleMenuRepository;
import org.cqu.edu.mrc.campephilus.modules.sys.service.SysRoleService;
import org.cqu.edu.mrc.campephilus.modules.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/15
 * <p>
 * Description:
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    private final SysMenuRepository sysMenuRepository;

    private final SysRoleService sysRoleService;

    private final SysRoleMenuRepository sysRoleMenuRepository;

    @Autowired
    public SysMenuServiceImpl(SysMenuRepository sysMenuRepository, SysRoleService sysRoleService, SysRoleMenuRepository sysRoleMenuRepository) {
        this.sysMenuRepository = sysMenuRepository;
        this.sysRoleService = sysRoleService;
        this.sysRoleMenuRepository = sysRoleMenuRepository;
    }

    @Override
    public void save(SysMenuDO sysMenuDO) {
        sysMenuRepository.save(sysMenuDO);
    }

    @Override
    public SysMenuDO getSysMenuByMenuId(Long menuId) {
        return sysMenuRepository.findById(menuId).orElse(null);
    }

    @Override
    public List<SysMenuDO> listSysMenusByMenuIdIn(List<Long> sysMenuList) {
        return sysMenuRepository.findSysMenuDOSByMenuIdIn(sysMenuList);
    }

    @Override
    public List<SysMenuDO> listSysMenusByParentId(Long parentId) {
        return sysMenuRepository.listSysMenuDOByParentId(parentId);
    }

    @Override
    public List<SysMenuDO> listSysMenus() {
        return sysMenuRepository.findAll();
    }

    @Override
    public List<SysMenuDO> queryNotButtonList() {
        return sysMenuRepository.queryNotButtonList();
    }

    @Override
    public void deleteSysMenuByMenuId(Long menuId) {
        sysMenuRepository.deleteById(menuId);
    }

    @Override
    public List<SysMenuDO> listSysMenuByUserId(Long userId) {
        // 超级管理员，查询所有拥有的菜单
        if (userId == SysConstant.SUPER_ADMIN) {
            return sysMenuRepository.findAll();
        }

        // 由于用户可能拥有的多个角色，而多个角色可能相同的菜单，这样得到的菜单重复部分需要去重
        // 1.通过userID，用户所拥有的角色
        List<SysRoleDO> sysRoleDOList = sysRoleService.listSysRolesByUserId(userId);
        // 2.查询角色拥有的菜单ID，在此步进行去重，通过HashSet
        HashSet<Long> longHashSet = new HashSet<>(16);

        sysRoleDOList.forEach(sysRoleDO -> {
            Long[] sysMenuIdList = sysRoleMenuRepository.listMenuIdsByRoleId(sysRoleDO.getRoleId());
            longHashSet.addAll(Arrays.asList(sysMenuIdList));
        });

        List<Long> sysMenuIdList = new ArrayList<>(longHashSet);

        // 3.通过菜单ID列表得到菜单
        return sysMenuRepository.findSysMenuDOSByMenuIdIn(sysMenuIdList);
    }

}
