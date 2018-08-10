package wifi4eu.wifi4eu.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.task.TaskExecutor;
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
    public final static String NO_ACTION = "NO ACTION LOGGED";

    @Value("${mail.serv.enable}")
    private boolean enableMail;

    @Value("${mail.smtp.password}")
    private String passwordEncrypted;

    @Autowired
    private EncrypterService encrypterService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private LogEmailRepository logEmailRepository;

    @Autowired
    private UserService userService;

    @Autowired
    ApplicationContext context;    

    @Autowired
    TaskExecutor taskExecutor;    

    private final Logger _log = LogManager.getLogger(MailService.class);

    @PostConstruct
    public void init() throws Exception{
        if(mailSender != null){
            String dPassword = encrypterService.decrypt(passwordEncrypted.getBytes(StandardCharsets.UTF_8));
            ((JavaMailSenderImpl) mailSender).setPassword(dPassword);
        }
    }

    public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
        sendEmail(toAddress, fromAddress, subject, msgBody, 0, NO_ACTION);
    }

    public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody, int municipalityId, String action) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Sending synchronous mail: " + fromAddress + " " + subject + " " + msgBody);
        if (enableMail) {
            try {
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

                //-- Log email
                logEmail(toAddress, fromAddress, subject, msgBody, municipalityId, action);
                _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Email sent to " + toAddress);
            } catch (Exception ex) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot send the message", ex);
            }
        } else {
        	_log.warn("Mail is no enabled, no emails were sent");
        }
    }

    public void sendEmailAsync(String toAddress, String fromAddress, String subject, String msgBody) {
        sendEmailAsync(toAddress, fromAddress, subject, msgBody, 0, NO_ACTION);
    }

    public void sendEmailAsync(String toAddress, String fromAddress, String subject, String msgBody, int municipalityId, String action) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Sending asynchronous mail: " + fromAddress + " " + subject + " " + msgBody);
    	
        if (enableMail) {
        	_log.info("Launching send mail thread...");        
            // Let the task executor manage the execution of the new thread to send the mails
        	taskExecutor.execute(context.getBean(MailAsyncService.class, toAddress, fromAddress, subject, msgBody, this.mailSender, municipalityId, action));
        } else {
        	_log.warn("Mail is no enabled, no emails were sent");
        }
    }

    private void logEmail(String toAddress, String fromAddress, String subject, String msgBody, int municipalityId, String action) throws Exception {
        if (toAddress != null && toAddress.length() > 0 && municipalityId > 0) {
            String setAction = NO_ACTION;
            if (action != null && action.length() > 0) {
                setAction = action;
            }
            LogEmail logEmail = new LogEmail(toAddress, fromAddress, subject, msgBody, municipalityId, setAction);
            logEmailRepository.save(logEmail);
        }
    }
}
