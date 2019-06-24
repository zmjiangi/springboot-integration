package com.gzyijian.provider.restcontroller;

import com.gzyijian.provider.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zmjiangi
 * @date 2019-6-24
 */
@RestController
public class GreetingRestController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/svc/greeting/sayHello")
    public String sayHello(@RequestParam(value = "name", required = false) String name) {
        return greetingService.sayHello(name);
    }

}
