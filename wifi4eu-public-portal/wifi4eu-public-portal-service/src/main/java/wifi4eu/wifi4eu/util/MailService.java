package wifi4eu.wifi4eu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    public final static String FROM_ADDRESS =  "azure_efe0541f6fda2f126859caac07925571@azure.com";

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
