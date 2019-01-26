package org.cqu.edu.mrc.campephilus.modules.sys.form;

import lombok.Data;

/**
 * @author Vinicolor
 * @date 2018/10/12
 * <p>
 * Description:
 */
@Data
public class PasswordForm {

    /**
     * 原密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;

}
