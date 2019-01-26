package org.cqu.edu.mrc.campephilus.modules.sys.form;

import lombok.Data;

/**
 * @author Vinicolor
 * @date 2018/10/11
 * <p>
 * Description:
 * 登录表单
 */
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String uuid;
    private String captcha;
}
