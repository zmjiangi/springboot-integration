package com.gzyijian.task.restcontroller.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zmjiangi
 * @date 2019-6-22
 */
@Service
public class AsyncService {

    /**
     * 告诉Spring这是一个异步方法
     * @return
     */
    @Async
    public void get() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据处理中");
    }

}
