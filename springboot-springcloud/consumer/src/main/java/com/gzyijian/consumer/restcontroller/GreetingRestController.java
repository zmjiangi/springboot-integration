package com.gzyijian.consumer.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zmjiangi
 * @date 2019-6-24
 */
@RestController
public class GreetingRestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/api/greeting/sayHello")
    public String sayHello(String name) {
        return restTemplate.getForObject(
                "http://PROVIDER/svc/greeting/sayHello?name=" + name,
                String.class
        );
    }

}
