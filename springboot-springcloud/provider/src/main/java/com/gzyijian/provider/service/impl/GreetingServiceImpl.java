package com.gzyijian.provider.service.impl;

import com.gzyijian.provider.service.GreetingService;
import org.springframework.stereotype.Service;

/**
 * @author zmjiangi
 * @date 2019-6-24
 */
@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

}
