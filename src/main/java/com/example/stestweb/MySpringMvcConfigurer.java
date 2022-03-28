package com.example.stestweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MySpringMvcConfigurer{
    /**
     * 描述 TODO：添加一个登陆拦截器到容器里面
     * 创建时间：  2021/6/24 16:59
     * 返回：
     * 参数：
     * 创建人： shuanshuan
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
               // registry.addViewController("/test").setViewName("test");
               // registry.addViewController("/test").setViewName("test");
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //添加映射路径
                registry.addMapping("/**")
                        //是否发送Cookie
                        .allowCredentials(true)
                        //设置放行哪些原始域   SpringBoot2.4.4下低版本使用.allowedOrigins("*")
                        .allowedOriginPatterns("*")
                        //放行哪些请求方式
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        //.allowedMethods("*") //或者放行全部
                        //放行哪些原始请求头部信息
                        .allowedHeaders("*")
                        //暴露哪些原始请求头部信息
                        .exposedHeaders("*");
            }
        };
    }
}