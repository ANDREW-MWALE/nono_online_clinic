package com.example.nono.s_online_clinic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081")  // Remove trailing slash
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")  // Allow all headers if necessary
                .allowCredentials(true);  // If your requests include cookies or credentials
    }
}
