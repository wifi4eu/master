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

public class MailAsyncService implements Runnable {

    public final static String FROM_ADDRESS = "no-reply@wifi4eu.eu";

    private final Logger _log = LoggerFactory.getLogger(MailAsyncService.class);

    private String toAddress = null;
    private String fromAddress = null;
    private String subject = null;
    private String msgBody = null;
    private JavaMailSender mailSender = null;

    public MailAsyncService(String toAddress, String fromAddress, String subject, String msgBody, JavaMailSender mailSender) {
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.subject = subject;
        this.msgBody = msgBody;
        this.mailSender = mailSender;
    }

    @Override
    public void run() {
        try {
            if (_log.isDebugEnabled()) {
                _log.debug("Sending async mail: " + fromAddress + " " + subject + " " + msgBody);
            }

            MimeMessage message = mailSender.createMimeMessage();
            message.setSubject(subject, "UTF-8");
            MimeMessageHelper helper = new MimeMessageHelper(message);
            String encodingOptions = "text/html; charset=UTF-8";

            byte[] mgsBody64 = msgBody.getBytes("UTF-8");

            message.setHeader("Content-Type", encodingOptions);
            message.setHeader("Content-Type", "multipart/mixed");

            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setHeader("Content-Type", "text/html; charset=utf-8");
            bodyPart.setContent(new String(mgsBody64, "UTF-8"), "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodyPart);

            message.setContent(multipart);
            helper.setSubject(subject);
            helper.setTo(toAddress);
            helper.setFrom(fromAddress);

            mailSender.send(message);
        } catch (Exception ex) {
            _log.error(ex.getMessage());
        }
    }
}
