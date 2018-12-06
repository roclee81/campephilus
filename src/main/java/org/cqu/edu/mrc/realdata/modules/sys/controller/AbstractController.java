package org.cqu.edu.mrc.realdata.modules.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.cqu.edu.mrc.realdata.modules.sys.dataobject.SysUserDO;

/**
 * @author Vinicolor
 * @date 2018/10/12
 * <p>
 * Description:
 */
public abstract class AbstractController {
    protected SysUserDO getUser() {
        return (SysUserDO) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }
}
