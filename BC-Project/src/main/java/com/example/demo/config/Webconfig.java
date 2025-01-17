package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {

    /**
     * CORS(리소스 공유)는 Method 허용도 필수입니다.
     * 허용해주지 않으면, Client는 API Server에 접근할 수 없어요.
     * 관련 설정 'ALLOWED_METHOD_NAMES' 을 추가하여 API 호출이 되지 않던 axios 오류 해결했습니다!
     */
    public static final String ALLOWED_METHOD_NAMES = "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH";
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry
            .addMapping("/**")
            .allowedOrigins("http://192.168.1.18:19006")
            .allowedOriginPatterns("*")
            .allowCredentials(true)
            .allowedMethods(ALLOWED_METHOD_NAMES.split(","));
    }
}

