package com.gzyijian.amqp.service;

import com.gzyijian.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author zmjiangi
 * @date 2019-6-
 */
@Service
public class BookService {

    @RabbitListener(queues = "gzyijian.news")
    public void receive(Book book) {
        System.out.println("收到消息：" + book);
    }

    @RabbitListener(queues = "gzyijian")
    public void receive02(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }

}
