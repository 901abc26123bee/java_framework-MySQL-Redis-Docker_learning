package com.wong.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    // 解析請求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 獲取請求中的語言參數
        String language = request.getParameter("l");
//    	Locale localelanguage = request.getLocale();
//        String language = localelanguage.toString();

        System.out.println("params: "+language);
        //如果沒有就使用默認的
        Locale locale = Locale.getDefault();
        System.out.println("default: "+language);
        
        //如果請求的鏈接攜帶了地區化的參數
        if (!StringUtils.isEmpty(language)) {
            //zh_CN
            String[] split = language.split("_");
            //國家.地區
            locale = new Locale(split[0], split[1]);
        }
        System.out.println("final === " + locale.toString());
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}