package com.cc.sys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 添加一个session 是否登录拦截器
 */
@Configuration
public class SessionConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置不拦截的请求，以及静态资源
        String[] exclude = {"/login","/static/**","/templates/**","/**/*.css",
                "/**/*.js"};
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(exclude);
    }
}
