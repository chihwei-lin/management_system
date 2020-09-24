package com.example.user_management_system.config;

import com.example.user_management_system.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**") // 拦截任意多层路径底下的任意请求
                .excludePathPatterns("/login",
                                    "/**/*.html",            //html静态资源
                                    "/**/*.js",              //js静态资源
                                    "/**/*.css");
    }

    //静态文件
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态文件
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        //webjar文件
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
