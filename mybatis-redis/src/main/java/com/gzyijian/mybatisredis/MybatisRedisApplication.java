package com.gzyijian.mybatisredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zmjiangi
 * @date 2019-6-18
 */
@SpringBootApplication
@MapperScan("com.gzyijian.mybatisredis.dao")
public class MybatisRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisRedisApplication.class, args);
    }

}
