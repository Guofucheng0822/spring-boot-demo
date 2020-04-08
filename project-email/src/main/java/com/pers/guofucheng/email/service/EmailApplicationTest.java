package com.pers.guofucheng.email.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailApplicationTest {
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void testMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //发件人
        helper.setFrom("15068610616@163.com");
        //收件人
        helper.setTo("627355704@qq.com");
        //标题
        helper.setSubject("标题");
        //文本
        helper.setText("正文文本内容");
        //附件
        helper.addAttachment("downFile",new File("H:\\project\\spring-boot-demo\\project-email\\src\\main\\java\\com\\pers\\guofucheng\\email\\service\\EmailApplicationTest.javaH:\\project\\spring-boot-demo\\project-email\\src\\main\\java\\com\\pers\\guofucheng\\email\\service\\EmailApplicationTest.java"));
        mailSender.send(mimeMessage);
    }

}
