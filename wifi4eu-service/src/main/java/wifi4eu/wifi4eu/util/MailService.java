package wifi4eu.wifi4eu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by rgarcita on 11/02/2017.
 */

@Service
public class MailService {

    public final static String FROM_ADDRESS =  "portales.everis@gmail.com";

    @Autowired
    private MailSender mailSender;

    public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {

        SimpleMailMessage mailMsg = new SimpleMailMessage();
        mailMsg.setFrom(fromAddress);
        mailMsg.setTo(toAddress);
        mailMsg.setSubject(subject);
        mailMsg.setText(msgBody);
        mailSender.send(mailMsg);
    }

}
