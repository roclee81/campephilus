package org.cqu.edu.mrc.realdata.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.cqu.edu.mrc.realdata.common.utils.R;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Vinicolor
 * @date 2018/10/18 11:01
 * <p>
 * Description:
 * 异常处理器
 */
@RestControllerAdvice
@Slf4j
public class OAuthExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(OAuthException.class)
    public R handleRRException(OAuthException e) {
        R r = new R();
        r.put("code", e.getCode());
        r.put("data", e.getMessage());
        return r;
    }

    @ExceptionHandler(AuthorizationException.class)
    public R handleAuthorizationException(AuthorizationException e) {
        log.error(e.getMessage(), e);
        return R.error("没有权限，请联系管理员授权");
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        log.error(e.getMessage(), e);
        return R.error();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error(e.getMessage(), e);
        return R.error("请求类型不支持");
    }
}
