package com.gzyijian.consumer.restcontroller.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zmjiangi
 * @date 2019-6-24
 */
@Configuration
public class RestTemplateConfiguration {

    /**
     * @return
     * @LoadBalanced 使用负载均衡机制
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
