package com.gzyijian.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zmjiangi
 * @date 2019-6-22
 * @EnableAsync 开启异步注解功能
 * @EnableScheduling 开启基于注解的定时任务
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringbootTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTaskApplication.class, args);
    }

}
