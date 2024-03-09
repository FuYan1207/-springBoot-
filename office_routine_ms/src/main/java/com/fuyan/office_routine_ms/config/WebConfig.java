package com.fuyan.office_routine_ms.config;

import com.fuyan.office_routine_ms.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 用户验证拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登入接口和注册接口不拦截
        registry.addInterceptor(loginInterceptor).excludePathPatterns(
                "/user/login",
                "/user/register"
        );
    }
}
