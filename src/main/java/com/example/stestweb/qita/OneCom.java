package com.example.stestweb.qita;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OneCom {

//    @Scope("singleton")
    @Bean(initMethod="init")
    TestBean getTestBean()
    {
        return new TestBean("shuanshuan","123456");
    }

    @Bean
    InitTestBean getInitTestBean()
    {
        return new InitTestBean();
    }
}
