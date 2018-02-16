package wifi4eu.wifi4eu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created by rgarcita on 11/02/2017.
 */

@Service
public class MailService {

    public final static String FROM_ADDRESS = "no-reply@wifi4eu.eu";

    @Autowired
    private MailSender mailSender;

    public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties properties = new Properties();
        properties.setProperty("mail.mime.charset", "utf-8");
        properties.setProperty("mail.smtp.allow8bitmime", "true");
        properties.setProperty("mail.smtps.allow8bitmime", "true");
        properties.setProperty("mail.smtp.port", 587)
        mailSender.setJavaMailProperties(properties);
        mailSender.setDefaultEncoding("UTF-8");
        SimpleMailMessage mailMsg = new SimpleMailMessage();
        mailMsg.setFrom(fromAddress);
        mailMsg.setTo(toAddress);
        mailMsg.setSubject(subject);
        mailMsg.setText(msgBody);
        mailSender.send(mailMsg);
    }

}
