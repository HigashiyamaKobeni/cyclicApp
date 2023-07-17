package com.ft1.cycleApp.config;

import com.ft1.cycleApp.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.ArrayList;

/** handle registration of interceptor */
@Configuration // load current interceptor and register it
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    /** configuration interceptor */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // create customized interceptor object
        HandlerInterceptor interceptor = new LoginInterceptor();

        // configure white list: save to a List set
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");


        // interceptor registration
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);//  url intercept

    }
}
