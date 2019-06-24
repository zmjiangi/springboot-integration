package com.gzyijian.provider.service.impl.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.gzyijian.api.GreetingService;
import org.springframework.stereotype.Component;

/**
 * @author zmjiangi
 * @date 2019-6-24
 * @Service 将服务发布出去
 */
@Component
@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

}
