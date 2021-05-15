package com.wong.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig {

    //shiroFilterFactoryBean

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 設置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        // 添加shiro的內置過濾器
        /*
            anon： 無需認證就可以訪問
            authc： 必須認證了才能訪問
            user： 必須擁有記住我功能才能用
            perms： 擁有對某個資源的權限才能訪問
            role： 擁有某個角色權限
         */

        //攔截
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");
//      filterMap.put("/user/*","authc"); // 同上兩個功能，支持通配符

        //授權，正常情況下，沒有授權會跳轉到為授權頁面
        filterMap.put("/user/add","perms[user:add]"); //cannot visit add
        filterMap.put("/user/update","perms[user:update]"); //cannot visit update



        bean.setFilterChainDefinitionMap(filterMap);

        //設置登錄的請求
        bean.setLoginUrl("/toLogin");

        //未授權頁面
        bean.setUnauthorizedUrl("/noauto");

      return bean;
    }

    //DefaultWebSecurityManager

    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        // 關聯userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //創建realm對象，需要自定義類

    // @Bean(name = "userRealm") or
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    // 整合ShiroDialect： 用來整合 Shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}