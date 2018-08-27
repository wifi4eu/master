package wifi4eu.wifi4eu.common.service.mail;

import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.service.encryption.EncrypterService;

@Configuration
@PropertySource("classpath:env.properties")
@Component
@Scope("prototype")
public class SendMailBySMTPTask extends SendMailTask {

	private final Logger _log = LogManager.getLogger(SendMailBySMTPTask.class);

	@Value("${mail.smtp.password}")
	private String passwordEncrypted;

	@Autowired
	private EncrypterService encrypterService;

	@Autowired
	private JavaMailSender mailSender;

	public SendMailBySMTPTask(MailData mailData) {
		super(mailData);
	}

	@PostConstruct
	public void init() {
		if (mailSender != null) {
			String dPassword = encrypterService.getDecodedValue(passwordEncrypted);
			((JavaMailSenderImpl) mailSender).setPassword(dPassword);
		}
	}

	@Override
	public void sendMail() {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			message.setSubject(mailData.getSubject(), StandardCharsets.UTF_8.toString());
			MimeMessageHelper helper = new MimeMessageHelper(message);
			String encodingOptions = "text/html; charset=UTF-8";

			byte[] mgsBody64 = mailData.getBody().getBytes(StandardCharsets.UTF_8);
			message.setHeader("Content-Type", encodingOptions);
			message.setHeader("Content-Type", "multipart/mixed");

			MimeBodyPart bodyPart = new MimeBodyPart();
			bodyPart.setHeader("Content-Type", "text/html; charset=utf-8");
			bodyPart.setContent(new String(mgsBody64, StandardCharsets.UTF_8), "text/html; charset=utf-8");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(bodyPart);

			message.setContent(multipart);
			helper.setSubject(mailData.getSubject());
			helper.setTo(mailData.getToAddress());
			helper.setFrom(mailData.getFromAddress());
			mailSender.send(message);
		} catch (MessagingException ex) {
			_log.error("Cannot send the message an error ocurred", ex);
		}
	}
}
