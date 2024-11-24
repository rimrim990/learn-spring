package org.study.learnspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.study.learnspring.mvc.CustomLoggerInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public CustomLoggerInterceptor customLoggerInterceptor() {
        return new CustomLoggerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customLoggerInterceptor())
            .excludePathPatterns("/css/**", "/images/**", "/js/**");
    }
}
