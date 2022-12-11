package com.yangtze.laboratory.oil.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @program: oil
 * @Author 陈欣
 * @description
 * @Date 2022/10/21 14:20
 * @Version 1.0
 **/
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());

        registration.addPathPatterns("/**"); //所有路径都被拦截
        registration.excludePathPatterns(    //添加不拦截路径
                "/login1",                    //登录路径
                "/login",
                           //html静态资源
                "/js/**",                  //js静态资源
                "/css/**",                  //css静态资源
                "/fonts/**",
                "/images/**",
                "/lib/**"
        );
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");
        registry.addViewController("/login").setViewName("/");

        registry.addViewController("/login.html").setViewName("/");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
