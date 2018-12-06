package org.cqu.edu.mrc.realdata.modules.sys.service.impl;

import org.cqu.edu.mrc.realdata.modules.sys.repository.SysUserRoleRepository;
import org.cqu.edu.mrc.realdata.modules.sys.service.SysUserRoleService;
import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysUserRoleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/12
 * <p>
 * Description:
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    private final SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    public SysUserRoleServiceImpl(SysUserRoleRepository sysUserRoleRepository) {
        this.sysUserRoleRepository = sysUserRoleRepository;
    }

    @Override
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        // 先删除用户与角色关系
        // TODO
//        this.deleteByMap(new MapUtils().put("user_id", userId));

        if (roleIdList == null || roleIdList.size() == 0) {
            return;
        }

        // 保存用户与角色关系
        List<SysUserRoleDO> sysUserRoleDOArrayList = new ArrayList<>(roleIdList.size());
        for (Long roleId : roleIdList) {
            SysUserRoleDO sysUserRoleDO = new SysUserRoleDO();
            sysUserRoleDO.setUserId(userId);
            sysUserRoleDO.setRoleId(roleId);

            sysUserRoleDOArrayList.add(sysUserRoleDO);
        }
        sysUserRoleRepository.saveAll(sysUserRoleDOArrayList);
    }

    @Override
    public List<Long> listRoleIdsByUserId(Long userId) {
        return Arrays.asList(sysUserRoleRepository.listRoleIdsByUserId(userId));
    }

    @Override
    public void deleteUserRolesByRoleIdIn(Long[] roleIds) {
        //TODO 未实现
        sysUserRoleRepository.deleteSysUserRoleDOSByRoleIdIn(roleIds);
    }

}
