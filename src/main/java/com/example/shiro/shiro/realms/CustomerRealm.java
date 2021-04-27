package com.example.shiro.shiro.realms;

import com.example.shiro.entity.Perms;
import com.example.shiro.entity.User;
import com.example.shiro.service.UserService;
import com.example.shiro.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;


/**
 * 自定义realm
 * CollectionUtils.isEmpty(list) 判断list是否为空和null,是则返回true.
 *     否则返回false
 *
 */
public class CustomerRealm extends AuthorizingRealm {
    /**
     * 处理授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //获取身份信息
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        System.out.println("调用授权验证："+primaryPrincipal);
        //根据主身份信息获取角色 和 权限信息
//        if ("xiaobai123".equals(primaryPrincipal)) {
//            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//
//            simpleAuthorizationInfo.addRole("user");
//            simpleAuthorizationInfo.addRole("admin");
//
//            simpleAuthorizationInfo.addStringPermission("user:*:*");
//
//            return simpleAuthorizationInfo;
//        }

        UserService userServcie = (UserService) ApplicationContextUtils.getBean("userService");
        User user= userServcie.findRolesByUserName(primaryPrincipal);
        //遍历list,获取角色信息----->授权角色信息
        if (!CollectionUtils.isEmpty(user.getRoles())) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            user.getRoles().forEach(role->{

                simpleAuthorizationInfo.addRole(role.getName());

                //权限信息
                List<Perms> perms = userServcie.findPermsByRoleId(role.getId());
                if (!CollectionUtils.isEmpty(perms)) {
                    perms.forEach(perm->{
                        simpleAuthorizationInfo.addStringPermission(perm.getName());
                    });
                    
                }
            });

            return simpleAuthorizationInfo;
        }
        return null;

    }

    /**
     * 处理认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.err.println("66666666666666666666666666666");
        //根据身份信息
        String principal = (String) token.getPrincipal();
        //在工厂中获取service对象
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");

        User user = userService.findByUserName(principal);
        if (!ObjectUtils.isEmpty(user)) {
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        }

        return null;
    }
}
