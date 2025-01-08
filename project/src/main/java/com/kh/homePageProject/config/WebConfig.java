package com.kh.homePageProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//React 애플리케이션은 기본적으로 http://localhost:3000에서 실행되고,
//Spring Boot는 http://localhost:8080에서 실행되므로, 
//두 서버 간의 통신 시 CORS(Cross-Origin Resource Sharing) 
//설정이 필요합니다.
	
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")  // React 앱의 포트
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}