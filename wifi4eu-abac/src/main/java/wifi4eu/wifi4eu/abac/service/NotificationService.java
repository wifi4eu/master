package wifi4eu.wifi4eu.abac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.entity.Notification;
import wifi4eu.wifi4eu.abac.data.enums.NotificationStatus;
import wifi4eu.wifi4eu.abac.data.enums.NotificationType;
import wifi4eu.wifi4eu.abac.data.repository.NotificationRepository;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

@Service
public class NotificationService {

    private final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @Value("${notifications.default.recipients}")
    private String defaultRecipients;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private LegalEntityService legalEntityService;

    @Transactional
    public void createLegalEntityProcessPendingNotification(String batchRef){
        Notification notification = new Notification();
        notification.setBatchRef(batchRef);
        notification.setNotificationStatus(NotificationStatus.PENDING);
        notification.setNotificationType(NotificationType.LEF_CREATION);
        notification.setSendTo(defaultRecipients);

        notificationRepository.save(notification);
    }

    @Transactional
    public void notifyLegalEntityProcessFinished(){
        List<Notification> notificationsPending = notificationRepository.findAllByNotificationStatusEquals(NotificationStatus.PENDING);

        for(Notification notification:notificationsPending){
            if(legalEntityService.isBatchProcessed(notification.getBatchRef())){
                log.info("BATCH Processing finished for BatchRef {}", notification.getBatchRef());
                //send email
                sendEmailNotification(defaultRecipients, "\"BATCH Processing finished for BatchRef - " + notification.getBatchRef(), "Please check the application Monitoring page for more details!");

                //update notification status
                notification.setNotificationStatus(NotificationStatus.SENT);
                notificationRepository.save(notification);
            }
        }

    }


    private void sendEmailNotification(String recipients, String subject, String body){
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("Alexandru.ANDREI@ext.ec.europa.eu", "ANDREI Alexandru"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress("Alexandru.ANDREI@ext.ec.europa.eu", "ANDREi Alexandru"));
            msg.setSubject("Your Example.com account has been activated");
            msg.setText("This is a test");
            Transport.send(msg);
        } catch (AddressException e) {
            log.error("ERROR sending email",e);
        } catch (MessagingException e) {
            log.error("ERROR sending email",e);
        } catch (UnsupportedEncodingException e) {
            log.error("ERROR sending email",e);
        }
    }
}
