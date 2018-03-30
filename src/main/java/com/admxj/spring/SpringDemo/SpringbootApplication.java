package com.admxj.spring.SpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication

//开启定时任务
@EnableScheduling

//开启异步执行
@EnableAsync
public class SpringbootApplication{

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
