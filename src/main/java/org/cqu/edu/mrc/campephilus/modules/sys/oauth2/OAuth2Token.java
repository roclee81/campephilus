package org.cqu.edu.mrc.campephilus.modules.sys.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author Vinicolor
 * @date 2018/10/11
 * <p>
 * Description:
 */
public class OAuth2Token implements AuthenticationToken {

    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
