package wifi4eu.wifi4eu.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.EncrypterService;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;
import wifi4eu.wifi4eu.repository.logEmails.LogEmailRepository;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.annotation.PostConstruct;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.nio.charset.StandardCharsets;


/**
 * Created by rgarcita on 11/02/2017.
 */

@Configuration
@PropertySource("classpath:env.properties")
@Service
public class MailService {

    public final static String FROM_ADDRESS = "no-reply@wifi4eu.eu";

    @Value("${mail.serv.enable}")
    private boolean enableMail;

    @Value("${mail.smtp.password}")
    private String passwordEncrypted;

    @Autowired
    private EncrypterService encrypterService;

    @Autowired
    private JavaMailSender mailSender;

    private final Logger _log = LogManager.getLogger(MailService.class);

    @PostConstruct
    public void init() throws Exception{
        if(mailSender != null){
            String dPassword = encrypterService.decrypt(passwordEncrypted.getBytes(StandardCharsets.UTF_8));
            ((JavaMailSenderImpl) mailSender).setPassword(dPassword);
        }
    }

    public void sendEmailAsync(String toAddress, String fromAddress, String subject, String msgBody, int municipalityId, String action) {
        if (enableMail) {
            MailAsyncService asyncService = new MailAsyncService(toAddress, fromAddress, subject, msgBody, this.mailSender, municipalityId, action);
            Thread thread = new Thread(asyncService);
            thread.start();
        }
    }
}
