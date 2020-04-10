package guofucheng.sms.service;

import javafx.application.Application;
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

@RunWith(SpringRunner.class) //14.版本之前用的是SpringJUnit4ClassRunner.class
@SpringBootTest(classes = Application.class) //1.4版本之前用的是//@SpringApplicationConfiguration(classes = Application.class)
public class EmailApplicationTest {
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void testMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //发件人
        helper.setFrom("13891037913@163.com");
        //收件人
        helper.setTo("627355704@qq.com");
        //标题
        helper.setSubject("标题");
        //文本
        helper.setText("正文文本内容");
        //附件
        helper.addAttachment("EmailApplicationTest",new File("H:/project/spring-boot-demo/project-email/src/main/java/com/pers/guofucheng/email/service/EmailApplicationTest.java"));
        mailSender.send(mimeMessage);
    }

}
