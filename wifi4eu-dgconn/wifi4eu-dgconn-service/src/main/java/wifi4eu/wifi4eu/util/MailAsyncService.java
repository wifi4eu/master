package wifi4eu.wifi4eu.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.BeanUtil;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;
import wifi4eu.wifi4eu.repository.logEmails.LogEmailRepository;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 * Created by rgarcita on 11/02/2017.
 */

public class MailAsyncService implements Runnable {

    private UserService userService;

    private LogEmailRepository logEmailRepository;

    public final static String FROM_ADDRESS = "no-reply@wifi4eu.eu";
    public final static String NO_ACTION = "NO ACTION LOGGED";

    private final Logger _log = LogManager.getLogger(MailAsyncService.class);

    private String toAddress = null;
    private String fromAddress = null;
    private String subject = null;
    private String msgBody = null;
    private JavaMailSender mailSender = null;
    private Integer municipalityId = 0;
    private String action = NO_ACTION;

    public MailAsyncService(String toAddress, String fromAddress, String subject, String msgBody, JavaMailSender mailSender, int municipalityId, String action) {
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.subject = subject;
        this.msgBody = msgBody;
        this.mailSender = mailSender;
        this.municipalityId = municipalityId;
        this.action = action;
        this.logEmailRepository = BeanUtil.getBean(LogEmailRepository.class);
        this.userService = BeanUtil.getBean(UserService.class);
    }

    @Override
    public void run() {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Sending asynchronous mail: " + fromAddress + " " + subject + " " + msgBody);
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
            logEmail();

            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Email sent to " + toAddress);
        } catch (Exception ex) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot send the message", ex.getMessage());
        }
    }

    private void logEmail() throws Exception {
        if (this.toAddress != null && this.toAddress.length() > 0 && this.municipalityId > 0) {
            String setAction = NO_ACTION;
            if (this.action != null && this.action.length() > 0) {
                setAction = this.action;
            }
            LogEmail logEmail = new LogEmail(this.toAddress, this.fromAddress, this.subject, this.msgBody, this.municipalityId, setAction);
            logEmailRepository.save(logEmail);
        }
    }
}
