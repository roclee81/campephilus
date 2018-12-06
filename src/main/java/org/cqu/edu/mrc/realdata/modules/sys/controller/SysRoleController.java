package org.cqu.edu.mrc.realdata.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.cqu.edu.mrc.realdata.common.utils.R;
import org.cqu.edu.mrc.realdata.common.validator.ValidatorUtils;
import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysRoleDO;
import org.cqu.edu.mrc.realdata.modules.sys.service.SysRoleMenuService;
import org.cqu.edu.mrc.realdata.modules.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Vinicolor
 * @date 2018/10/18 11:28
 * <p>
 * Description:
 * 角色管理
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {

    private final SysRoleService sysRoleService;
    private final SysRoleMenuService sysRoleMenuService;

    @Autowired
    public SysRoleController(SysRoleService sysRoleService, SysRoleMenuService sysRoleMenuService) {
        this.sysRoleService = sysRoleService;
        this.sysRoleMenuService = sysRoleMenuService;
    }

    /**
     * 得到角色列表
     *
     * @param params
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:role:list")
    public R list(@RequestParam Map<String, Object> params) {
        //TODO 对于此方式是不是需要判断是否为空
        List<SysRoleDO> list = sysRoleService.listSysRolesByUserId(getUserId());
        return R.success().put("list", list);
    }

    /**
     * 得到一个角色信息
     *
     * @param roleId
     * @return
     */
    @GetMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public R info(@PathVariable("roleId") Long roleId) {
        SysRoleDO role = sysRoleService.getSysRoleByRoleId(roleId);

        //查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.listMenuIdsByRoleId(roleId);
        role.setMenuIdList(menuIdList);

        return R.success().put("role", role);
    }

    /**
     * 保存角色
     *
     * @param role
     * @return
     */
//    @SysLog("保存角色")
    @PostMapping("/save")
    @RequiresPermissions("sys:role:save")
    public R save(@RequestBody SysRoleDO role) {
        ValidatorUtils.validateEntity(role);

        role.setCreateUserId(getUserId());
        sysRoleService.save(role);

        return R.success();
    }

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
//    @SysLog("修改角色")
    @PostMapping("/update")
    @RequiresPermissions("sys:role:update")
    public R update(@RequestBody SysRoleDO role) {
        ValidatorUtils.validateEntity(role);

        role.setCreateUserId(getUserId());
        sysRoleService.save(role);

        return R.success();
    }

    /**
     * 删除角色
     *
     * @param roleIds
     * @return
     */
//    @SysLog("删除角色")
    @PostMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public R delete(@RequestBody Long[] roleIds) {
        sysRoleService.deleteSysRolesByRoleIdIn(roleIds);

        return R.success();
    }

}
