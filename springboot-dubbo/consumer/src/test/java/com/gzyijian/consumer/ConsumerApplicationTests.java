package com.gzyijian.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gzyijian.api.GreetingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zmjiangi
 * @date 2019-6-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTests {

    @Reference
    private GreetingService greetingService;

    @Test
    public void contextLoads() {
        String result = greetingService.sayHello("dubbo");
        System.out.println("result = " + result);
    }

}
