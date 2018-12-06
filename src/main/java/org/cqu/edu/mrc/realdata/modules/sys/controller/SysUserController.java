package org.cqu.edu.mrc.realdata.modules.sys.controller;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.cqu.edu.mrc.realdata.common.utils.R;
import org.cqu.edu.mrc.realdata.common.validator.Assert;
import org.cqu.edu.mrc.realdata.common.validator.ValidatorUtils;
import org.cqu.edu.mrc.realdata.common.validator.group.AddGroup;
import org.cqu.edu.mrc.realdata.common.validator.group.UpdateGroup;
import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysUserDO;
import org.cqu.edu.mrc.realdata.modules.sys.service.SysUserRoleService;
import org.cqu.edu.mrc.realdata.modules.sys.form.PasswordForm;
import org.cqu.edu.mrc.realdata.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Vinicolor
 * @date 2018/10/17 9:35
 * <p>
 * Description:
 * 系统用户
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {

    private final SysUserService sysUserService;

    private final SysUserRoleService sysUserRoleService;

    @Autowired
    public SysUserController(SysUserService sysUserService, SysUserRoleService sysUserRoleService) {
        this.sysUserService = sysUserService;
        this.sysUserRoleService = sysUserRoleService;
    }

    /**
     * 获取登录的用户信息
     */
    @GetMapping("/info")
    public R info() {
        return R.success().put("user", getUser());
    }

    /**
     * 修改登录用户密码
     */
//    @SysLog("修改密码")
    @PostMapping("/password")
    public R password(@RequestBody PasswordForm form) {
        Assert.isBlank(form.getNewPassword(), "新密码不为能空");

        //sha256加密
        String password = new Sha256Hash(form.getPassword(), getUser().getSalt()).toHex();
        //sha256加密
        String newPassword = new Sha256Hash(form.getNewPassword(), getUser().getSalt()).toHex();

        //更新密码
        boolean flag = sysUserService.updatePassword(getUserId(), password, newPassword);
        if (!flag) {
            return R.error("原密码不正确");
        }

        return R.success();
    }

    /**
     * 用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/info/{userId}")
    @RequiresPermissions("sys:user:info")
    public R info(@PathVariable("userId") Long userId) {
        SysUserDO user = sysUserService.getSysUserByUserId(userId);

        //获取用户所属的角色列表
        List<Long> roleIdList = sysUserRoleService.listRoleIdsByUserId(userId);
        user.setRoleIdList(roleIdList);

        return R.success().put("user", user);
    }

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
//    @SysLog("保存用户")
    @PostMapping("/save")
    @RequiresPermissions("sys:user:save")
    public R save(@RequestBody SysUserDO user) {
        ValidatorUtils.validateEntity(user, AddGroup.class);

        user.setCreateUserId(getUserId());
        sysUserService.save(user);

        return R.success();
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
//    @SysLog("修改用户")
    @PostMapping("/update")
    @RequiresPermissions("sys:user:update")
    public R update(@RequestBody SysUserDO user) {
        ValidatorUtils.validateEntity(user, UpdateGroup.class);

        user.setCreateUserId(getUserId());
        sysUserService.update(user);

        return R.success();
    }

    /**
     * 删除用户
     *
     * @param userIds
     * @return
     */
//    @SysLog("删除用户")
    @PostMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public R delete(@RequestBody Long[] userIds) {
        if (ArrayUtils.contains(userIds, 1L)) {
            return R.error("系统管理员不能删除");
        }

        if (ArrayUtils.contains(userIds, getUserId())) {
            return R.error("当前用户不能删除");
        }

        sysUserService.deleteSysUsersByUserIdIn(userIds);

        return R.success();
    }

}
