package com.gzyijian.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;


/**
 * @author zmjiangi
 * @date 2019-6-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开会");

        message.setTo("zmjiangi_xpzs@qq.com");
        message.setFrom("zmjiangi@qq.com");

        javaMailSender.send(message);
    }

    @Test
    public void test02() throws Exception {

        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        // 邮件设置
        mimeMessageHelper.setSubject("通知-今晚开会");
        mimeMessageHelper.setText("<b style='color:red'>今天 7:30 开会</b>", true);

        mimeMessageHelper.setFrom("zmjiangi@qq.com");
        mimeMessageHelper.setTo("zmjiangi_xpzs@qq.com");

        //上传文件
        mimeMessageHelper.addAttachment(
                "cat.jpg",
                () -> Thread.currentThread().getContextClassLoader().getResourceAsStream("images/cat.jpg")
        );

        mimeMessageHelper.addAttachment(
                "dog.jpg",
                () -> Thread.currentThread().getContextClassLoader().getResourceAsStream("images/dog.jpg")
        );

        javaMailSender.send(mimeMessage);
    }

}
