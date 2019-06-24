package com.gzyijian.consumer.restcontroller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gzyijian.api.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zmjiangi
 * @date 2019-6-24
 */
@RestController
public class GreetingRestController {

    @Reference
    private GreetingService greetingService;

    @GetMapping("/api/greeting/sayHello")
    public String sayHello(String name) {
        return greetingService.sayHello(name);
    }

}
