package com.wong.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// AOP:攔截器
@EnableWebSecurity // 開啟WebSecurity模式
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// 鍊式編程
	// 授權
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 首頁所有人都可以訪問，功能也只有對應有權限的人才能訪問到
		// 請求授權的規則
		http.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/level1/**").hasRole("vip1")
				.antMatchers("/level2/**").hasRole("vip2")
				.antMatchers("/level3/**").hasRole("vip3");

		// 開啟自動配置的登錄功能
	    // /login 請求來到登錄頁
	    // /login?error 重定向到這裡表示登錄失敗
	    http.formLogin();
		
	    // 沒有權限默認會到登錄頁面,需要開啟登錄的頁面
		// /login頁面
		http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/toLogin")
				.loginProcessingUrl("/login");

		// 註銷,開啟了註銷功能,跳到首頁
		http.logout().logoutSuccessUrl("/");

		// 防止網站工具：get，post
		http.csrf().disable();// 關閉csrf功能，登錄失敗肯定存在的原因

		// 開啟記住我功能: cookie,默認保存兩週,自定義接收前端的參數
		http.rememberMe().rememberMeParameter("remember");

	}

	// 認證，springboot 2.1.x 可以直接使用
	// 密碼編碼： PasswordEncoder
	// 在spring Secutiry 5.0+ 新增了很多加密方法
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// 這些數據正常應該中數據庫中讀
		auth.inMemoryAuthentication()
			.passwordEncoder(new BCryptPasswordEncoder())
			.withUser("wong").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2", "vip3")
			.and()
			.withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2", "vip3")
			.and()
			.withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2");
	}

}