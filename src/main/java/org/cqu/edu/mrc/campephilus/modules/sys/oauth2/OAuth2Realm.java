package org.cqu.edu.mrc.campephilus.modules.sys.oauth2;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysUserDO;
import org.cqu.edu.mrc.campephilus.modules.sys.dataobject.SysUserTokenDO;
import org.cqu.edu.mrc.campephilus.modules.sys.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author Vinicolor
 * @date 2018/10/11
 * <p>
 * Description:
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {

    private final ShiroService shiroService;

    @Autowired
    public OAuth2Realm(ShiroService shiroService) {
        this.shiroService = shiroService;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * ��Ȩ(��֤Ȩ��ʱ����)
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUserDO user = (SysUserDO) principals.getPrimaryPrincipal();
        Long userId = user.getUserId();

        //�û�Ȩ���б�
        Set<String> permsSet = shiroService.getUserPermissionsByUserId(userId);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * ��֤(��¼ʱ����)
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        //����accessToken����ѯ�û���Ϣ
        SysUserTokenDO tokenEntity = shiroService.getSysUserTokenByToken(accessToken);
        //tokenʧЧ
        if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new IncorrectCredentialsException("tokenʧЧ�������µ�¼");
        }

        //��ѯ�û���Ϣ
        SysUserDO user = shiroService.getSysUserByUserId(tokenEntity.getUserId());
        //�˺�����
        if (user.getStatus() == 0) {
            throw new LockedAccountException("�˺��ѱ�����,����ϵ����Ա");
        }

        return new SimpleAuthenticationInfo(user, accessToken, getName());
    }
}
