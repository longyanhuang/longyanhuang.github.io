package com.hzj.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMVCConfig  implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //配置跨域访问
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }
}
