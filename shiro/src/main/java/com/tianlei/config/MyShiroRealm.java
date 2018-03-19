package com.tianlei.config;

import com.tianlei.domain.User;
import com.tianlei.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

// 相当于数据 DAO ???????
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取用户名
        String name = authenticationToken.getPrincipal().toString();
        if (name == null) {
            return null;
        }

        //获取用户
        User user = this.userService.findUserDetailByUserName(name);
        if (user == null) {
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword(), getName());
        return simpleAuthenticationInfo;

    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        User user = this.userService.findUserDetailByUserName(principalCollection.getPrimaryPrincipal().toString());

        user.getRoles().forEach(role -> {

            simpleAuthorizationInfo.addRole(role.getRoleName());
            role.getPermissions().forEach(permission -> {

                simpleAuthorizationInfo.addStringPermission(permission.getPermissionName());

            });

        });

        return simpleAuthorizationInfo;

    }


}
