package org.learn.boot.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSpringBootTaskApplicationTests {

	@Autowired
	JavaMailSenderImpl javaMailSender;

	/**
	 * 测试发送邮件
	 */
	@Test
	public void testMail(){
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setSubject("测试-发送邮件");
		mailMessage.setText("21:30开始发送");
		//发送给网易邮箱
		mailMessage.setTo("lin92591061005@163.com");
		//是那个发送的
		mailMessage.setFrom("591061005@qq.com");
		javaMailSender.send(mailMessage);
	}

	/**
	 * 创建复杂的邮件
	 */
	@Test
	public void  test() throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setSubject("通知-测试邮件发送");
		helper.setText("<b style='color:red'> 还有三天就是国庆节好开心</b>",true);
		helper.setTo("lin92591061005@163.com");
		helper.setFrom("591061005@qq.com");
		//还可以上传文件
		helper.addAttachment("1.jpg",new File("C:\\Users\\lin\\Desktop\\1.jpg"));
		javaMailSender.send(mimeMessage);
	}










	@Test
	public void contextLoads() {
	}

}
