package com.wong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }
    // 自定義的國際化組件就生效了
    // 一定要是localeResolver方法名，不能改否則失效
    // Bean註解註冊組件時，組件的默認名字就是方法名字。
    // 如果名字不是localeResolver，SpringBoot也就找不到localeResolver這樣一個bean，相當於白註冊了。
    // @Bean("localeResolver")
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
    
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/css/**","/js/**","/img/**");
    }
}
