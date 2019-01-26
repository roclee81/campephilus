package org.cqu.edu.mrc.campephilus.modules.sys.controller;


import org.apache.shiro.crypto.hash.Sha256Hash;
import org.cqu.edu.mrc.campephilus.common.utils.R;
import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysUserDO;
import org.cqu.edu.mrc.campephilus.modules.sys.form.SysLoginForm;
import org.cqu.edu.mrc.campephilus.modules.sys.service.SysCaptchaService;
import org.cqu.edu.mrc.campephilus.modules.sys.service.SysUserService;
import org.cqu.edu.mrc.campephilus.modules.sys.service.SysUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * @author Vinicolor
 * @date 2018/10/12
 * <p>
 * Description:
 */
@RestController
public class SysLoginController extends AbstractController {

    private final
    SysUserService sysUserService;

    private final
    SysUserTokenService sysUserTokenService;

    private final
    SysCaptchaService sysCaptchaService;

    @Autowired
    public SysLoginController(SysUserService sysUserService, SysUserTokenService sysUserTokenService, SysCaptchaService sysCaptchaService) {
        this.sysUserService = sysUserService;
        this.sysUserTokenService = sysUserTokenService;
        this.sysCaptchaService = sysCaptchaService;
    }

    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody SysLoginForm form) throws IOException {
//        boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
//        if (!captcha) {
//            return R.error("验证码不正确");
//        }

        // 用户信息
        SysUserDO user = sysUserService.getSysUserByUsername(form.getUsername());

        // 账号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return R.error("账号或密码不正确");
        }

        // 账号锁定
        if (user.getStatus() == 0) {
            return R.error("账号已被锁定,请联系管理员");
        }

        // 生成token，并保存到数据库
        return sysUserTokenService.createToken(user.getUserId());
    }

    @PostMapping("/sys/logout")
    public R logout() {
        sysUserTokenService.logout(getUserId());
        return R.success();
    }

}
