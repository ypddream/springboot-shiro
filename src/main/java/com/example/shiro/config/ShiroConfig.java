package com.example.shiro.config;

import com.example.shiro.shiro.realms.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * ClassName:ShiroConfig
 * Package:com.example.shiro.config
 * Description:整合shiro框架的相关依赖
 *
 * @Date:2021/4/26 0026 下午 12:42
 * @author:ypd
 */
@Configuration
public class ShiroConfig {

    /**
     *  1.创建ShiroFilter  负责拦截所有请求
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //配置系统的受限资源
        //配置系统的公共资源
        HashMap<String, String> map = new HashMap<>();
        map.put("/user/login","anon");//anon设置为公共资源, 放行资源放在下面
        map.put("/user/register","anon");//anon设置为公共资源
        map.put("/register.jsp","anon");
        //authc这个资源请求需要认证和授权, authc代表shiro中一个filter的别名，详细的看文档 。/**代表项目中的一切资源
        map.put("/**","authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //默认认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");

        return  shiroFilterFactoryBean;

    }

    /**
     *  2.创建安全管理器
     * @return
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm) {
        //创建web安全管理器
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;

     }

    /**
     *  3.创建自定义的realm
     * @return
     */
    @Bean
    public Realm getRealm() {
        CustomerRealm customerRealm = new CustomerRealm();
        //修改凭证校验匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法为md5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置散列次数
        credentialsMatcher.setHashIterations(1024);//与注册时的散列次数相同
        customerRealm.setCredentialsMatcher(credentialsMatcher);
        return customerRealm;
    }
}
