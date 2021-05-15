package com.wong.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 擴展springmvc
@Configuration
public class MyMVCConfig implements WebMvcConfigurer{
//	@Bean //放到bean中
//	public ViewResolver myViewResolver(){
//	    return new MyViewResolver();
//	}
//
//	// 自定義了一個視圖解析器
//	// 我們寫一個靜態內部類，視圖解析器就需要實現ViewResolver接口
//	private static class MyViewResolver implements ViewResolver{@Override
//	    public View resolveViewName(String s, Locale locale) throws Exception {
//	        return null;
//	    }
//	}
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 瀏覽器發送/test ， 就會跳轉到test頁面；
        registry.addViewController("/wong").setViewName("test");
    }
}
