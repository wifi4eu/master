package wifi4eu.wifi4eu.common.service.mail;

import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.entity.logEmails.LogEmail;
import wifi4eu.wifi4eu.repository.logEmails.LogEmailRepository;


@Component
@Scope("prototype")
public class MailAsyncService implements Runnable {

	@Autowired
    private LogEmailRepository logEmailRepository;

    public static final String FROM_ADDRESS = "no-reply@wifi4eu.eu";
    public static final String NO_ACTION = "NO ACTION LOGGED";

    private final Logger _log = LogManager.getLogger(MailAsyncService.class);

    private String toAddress = null;
    private String fromAddress = null;
    private String subject = null;
    private String msgBody = null;
    private JavaMailSender mailSender = null;
    private Integer municipalityId = 0;
    private String action = NO_ACTION;

    public MailAsyncService(String toAddress, String fromAddress, String subject, String msgBody, 
    JavaMailSender mailSender, int municipalityId, String action) {
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
        this.subject = subject;
        this.msgBody = msgBody;
        this.mailSender = mailSender;
        this.municipalityId = municipalityId;
        this.action = action;
    }

    @Override
    public void run() {
        _log.debug("Sending asynchronous mail: " + fromAddress + " " + subject + " " + msgBody);
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

            _log.debug(" - Email sent to " + toAddress);
        } catch (Exception ex) {
            _log.error(" - Cannot send the message", ex.getMessage());
        }
    }

    private void logEmail() throws Exception {
		_log.debug("Logging email");
		if (toAddress == null || toAddress.isEmpty()) {
			_log.warn("The email was not registered in db because no address was specified.");
		} else if (municipalityId == 0) {
			_log.warn("The email was not registered in db because municipalityId was not defined.");
		} else {        
            String setAction = NO_ACTION;
            if (this.action != null && this.action.length() > 0) {
                setAction = this.action;
            }
            LogEmail logEmail = new LogEmail(this.toAddress, this.fromAddress, this.subject, this.msgBody, this.municipalityId, setAction);
            logEmailRepository.save(logEmail);
        }
    }
}
