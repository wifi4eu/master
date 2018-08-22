package wifi4eu.wifi4eu.abac.service;

import org.apache.commons.io.IOUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.entity.Notification;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
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
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @Value("${notifications.default.recipients}")
    private String defaultRecipients;

    @Value("${notifications.default.sender}")
    private String defaultSender;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private LegalEntityService legalEntityService;

    @Autowired
    private VelocityEngine velocityEngine;

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
                log.info("LEF BATCH Processing finished for BatchRef {}", notification.getBatchRef());
                //send email
                sendEmailNotification(defaultRecipients, "LEF BATCH Processing finished for BatchRef <" + notification.getBatchRef() + ">", buildLegalEntityNotificationFinishedMessage(notification.getBatchRef()));

                //update notification status
                notification.setNotificationStatus(NotificationStatus.SENT);
                notificationRepository.save(notification);
            }
        }

    }

    private String buildLegalEntityNotificationFinishedMessage(String batchRef){
        List<LegalEntity> legalEntities = legalEntityService.getAllByBatchRef(batchRef);

        Integer legalEntitiesCount = legalEntities.size();
        Long legalEntitiesValidCount = legalEntities.stream().filter(le -> le.getWfStatus().equals(AbacWorkflowStatus.ABAC_VALID)).count();
        Long legalEntitiesRejectedCount = legalEntities.stream().filter(le -> le.getWfStatus().equals(AbacWorkflowStatus.ABAC_REJECTED)).count();
        Long legalEntitiesErrorCount = legalEntities.stream().filter(le -> le.getWfStatus().equals(AbacWorkflowStatus.ABAC_ERROR)).count();

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("legalEntitiesCount", legalEntitiesCount);
        velocityContext.put("legalEntitiesValidCount", legalEntitiesValidCount);
        velocityContext.put("legalEntitiesRejectedCount", legalEntitiesRejectedCount);
        velocityContext.put("legalEntitiesErrorCount", legalEntitiesErrorCount);
        velocityContext.put("reportDate", Calendar.getInstance().getTime().toString());

        StringWriter stringWriter = new StringWriter();
        velocityEngine.mergeTemplate("templates/LEF_MAIL_REPORT_TEMPLATE.html", "UTF-8", velocityContext, stringWriter);

        return stringWriter.toString();
    }


    private void sendEmailNotification(String recipients, String subject, String body){
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            MimeMessage  msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(defaultSender));

            for(String recipient: recipients.split(",")) {
                msg.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(recipient));
            }
            msg.setSubject(subject);
            msg.setText(body,"utf-8", "html");
            Transport.send(msg);
        } catch (AddressException e) {
            log.error("ERROR sending email",e);
        } catch (MessagingException e) {
            log.error("ERROR sending email",e);
        } catch (Exception e) {
            log.error("ERROR sending email",e);
        }
    }
}
