package com.wong.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    // 後台監控:web.xml, ServletRegistrationBean
    // 因為SpringBoot 內置了 servlet容器，所以沒有web.xml，替代方法ServletRegistrationBean
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //後台需要有人登陸，賬號密碼
        Map<String, String> initParameters = new HashMap<>();
        //增加配置
        initParameters.put("loginUsername", "root");//登陸key 是固定的loginUsername loginPassword
        initParameters.put("loginPassword", "12345678");

        // 允許誰可以訪問
        initParameters.put("allow", "");

        //禁止誰能訪問
        //initParameters.put("kuangshen","192.168.1.2");

        bean.setInitParameters(initParameters);//設置初始化參數

        return bean;
    }

    // filter
    @Bean
    public FilterRegistrationBean<Filter> webStatilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        bean.setFilter(new WebStatFilter());

        //可以過濾那些請求

        Map<String, String> initParameters = new HashMap<>();

        //這些東西不進行統計
        initParameters.put("exclusions", "*.js,*.cs,/druid/*");

        bean.setInitParameters(initParameters);

        return bean;

    }
}