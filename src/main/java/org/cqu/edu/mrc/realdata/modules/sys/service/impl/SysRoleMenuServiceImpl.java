package org.cqu.edu.mrc.realdata.modules.sys.service.impl;

import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysRoleMenuDO;
import org.cqu.edu.mrc.realdata.modules.sys.repository.SysRoleMenuRepository;
import org.cqu.edu.mrc.realdata.modules.sys.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/15
 * <p>
 * Description:
 * 角色与菜单对应关系
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    private final
    SysRoleMenuRepository sysRoleMenuRepository;

    @Autowired
    public SysRoleMenuServiceImpl(SysRoleMenuRepository sysRoleMenuRepository) {
        this.sysRoleMenuRepository = sysRoleMenuRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
        // TODO 未实现回滚
        // 先删除角色与菜单关系
        deleteSysRoleMenusByRoleIdIn(new Long[]{roleId});

        if (menuIdList.size() == 0) {
            return;
        }

        //保存角色与菜单关系
        List<SysRoleMenuDO> list = new ArrayList<>(menuIdList.size());
        for (Long menuId : menuIdList) {
            SysRoleMenuDO sysRoleMenuDO = new SysRoleMenuDO();
            sysRoleMenuDO.setMenuId(menuId);
            sysRoleMenuDO.setRoleId(roleId);

            list.add(sysRoleMenuDO);
        }
        sysRoleMenuRepository.saveAll(list);
    }

    @Override
    public List<Long> listMenuIdsByRoleId(Long roleId) {
        return Arrays.asList(sysRoleMenuRepository.listMenuIdsByRoleId(roleId));
    }

    @Override
    public void deleteSysRoleMenusByRoleIdIn(Long[] roleId) {
        sysRoleMenuRepository.deleteSysRoleMenuDOSByRoleIdIn(roleId);
    }
}
