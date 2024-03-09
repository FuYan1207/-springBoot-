package com.fuyan.office_routine_ms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 处理跨域
 */
@Configuration
public class CrossConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                                        //所有的URL路径（/**表示所有路径）都将被此CORS配置所覆盖
                .allowedOriginPatterns("*")                                         //允许任何来源的域名进行跨域请求
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","PATCH")      //允许的HTTP方法
                .allowCredentials(true)                                             //允许发送凭证（如cookies、HTTP认证或客户端SSL证明等）
                .maxAge(3600)                                                       //预检请求的缓存时间
                .allowedHeaders("*");                                               //允许任何HTTP头进行跨域请求
    }
}
