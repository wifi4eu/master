package wifi4eu.wifi4eu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 * Created by rgarcita on 11/02/2017.
 */

@Service
public class MailService {

    public final static String FROM_ADDRESS = "no-reply@wifi4eu.eu";

    @Autowired
    private JavaMailSender mailSender;

    private final Logger _log = LoggerFactory.getLogger(MailService.class);

    public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            message.setSubject(subject, "UTF-8");
            MimeMessageHelper helper = new MimeMessageHelper(message);
            String encodingOptions = "text/html; charset=UTF-8";
            String font = "'Open Sans', sans-serif";


            byte[] mgsBody64 = msgBody.getBytes("UTF-8");
            byte[] subject64 = subject.getBytes("UTF-8");

//            Base64.encode(subject64);


            message.setHeader("Content-Type", encodingOptions);
            message.setHeader("Content-Type", "multipart/mixed");
            message.setHeader("font-family", font);


            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setHeader("Content-Type", "text/html; charset=utf-8");
            bodyPart.setContent(new String(mgsBody64, "UTF-8"), "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodyPart);

            message.setContent(multipart);
            helper.setSubject();
            helper.setTo(toAddress);
            helper.setFrom(fromAddress);


            mailSender.send(message);
        } catch (Exception ex) {
            _log.error(ex.getMessage());
        }

    }

}
