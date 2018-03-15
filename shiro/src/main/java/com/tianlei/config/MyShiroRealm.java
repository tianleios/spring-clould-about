package com.tianlei.config;

import com.tianlei.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyShiroRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();


//        for (int i = 0; i < 5; i++) {
//
//            //把用户所有的权限加进去
//            simpleAuthorizationInfo.addStringPermission("");
//        }
        //把当前用户的所有权限查询出来
        simpleAuthorizationInfo.addRole("admin");

        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取用户名
        String name = authenticationToken.getPrincipal().toString();
        if (name == null) {
            return null;
        }

        if (!name.equals("tianlei")) {
            return null;
        }

        //获取用户
        User user = new User();
        user.setId(1L);
        user.setName(name);
        user.setPassword(new String((char[]) authenticationToken.getCredentials()));
        if (user == null) {
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword(), getName());
        return simpleAuthenticationInfo;

    }
}
