package com.learning.concept.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    MyCustomInterceptor customInterceptor1;

    @Autowired
    MyCustomInterceptor2 customInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(customInterceptor1)
//                .addPathPatterns("/api/*");
//
//        registry.addInterceptor(customInterceptor2)
//                .addPathPatterns("/api/*");
    }

    @Bean
    public FilterRegistrationBean<MyCustomFilter1> filter1() {
        FilterRegistrationBean<MyCustomFilter1> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyCustomFilter1());
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyCustomFilter2> filter2() {
        FilterRegistrationBean<MyCustomFilter2> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyCustomFilter2());
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }
}
