package com.gzyijian.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zmjiangi
 * @date 2019-6-19
 */
@Configuration
public class MyCacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return (Object target, Method method, Object... params)
                ->
                method.getName() + "[" + Arrays.asList(params).toString() + "]";
    }

}
