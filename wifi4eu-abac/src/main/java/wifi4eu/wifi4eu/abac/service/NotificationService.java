package wifi4eu.wifi4eu.abac.service;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.entity.LegalCommitment;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.entity.Notification;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.LegalCommitmentWorkflowStatus;
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
import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

@Service
public class NotificationService {

    private final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @Value("${notifications.default.recipients}")
    private String defaultRecipients;

    @Value("${notifications.default.sender}")
    private String defaultSender;

    @Value("${application.url.monitoring}")
    private String monitoringTableUrl;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private LegalEntityService legalEntityService;

    @Autowired
    private BudgetaryCommitmentService budgetaryCommitmentService;

    @Autowired
    private LegalCommitmentService legalCommitmentService;

    @Autowired
    private VelocityEngine velocityEngine;

    @Transactional
    public void createValidationProcessPendingNotification(String batchRef, NotificationType notificationType){
        Notification notification = new Notification();
        notification.setBatchRef(batchRef);
        notification.setNotificationStatus(NotificationStatus.PENDING);
        notification.setNotificationType(notificationType);
        notification.setSendTo(defaultRecipients);

        notificationRepository.save(notification);
    }


    @Transactional
    public void notifyLegalEntityProcessFinished(){
        List<Notification> notificationsPending = notificationRepository.findAllByNotificationStatusEqualsAndNotificationTypeEquals(NotificationStatus.PENDING, NotificationType.LEF_CREATION);

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

    @Transactional
    public void notifyBudgetaryCommitmentProcessFinished(){
        List<Notification> notificationsPending = notificationRepository.findAllByNotificationStatusEqualsAndNotificationTypeEquals(NotificationStatus.PENDING, NotificationType.BC_CREATION);

        for(Notification notification:notificationsPending){
            if(budgetaryCommitmentService.isBatchProcessed(notification.getBatchRef())){
                log.info("BC BATCH Processing finished for BatchRef {}", notification.getBatchRef());
                //send email
                sendEmailNotification(defaultRecipients, "BC BATCH Processing finished for BatchRef <" + notification.getBatchRef() + ">", buildBudgetaryCommitmentNotificationFinishedMessage(notification.getBatchRef()));

                //update notification status
                notification.setNotificationStatus(NotificationStatus.SENT);
                notificationRepository.save(notification);
            }
        }

    }


    @Transactional
    public void notifyLegalCommitmentProcessFinished(){
        List<Notification> notificationsPending = notificationRepository.findAllByNotificationStatusEqualsAndNotificationTypeEquals(NotificationStatus.PENDING, NotificationType.LC_CREATION);

        for(Notification notification:notificationsPending){
            if(legalCommitmentService.isBatchProcessed(notification.getBatchRef())){
                log.info("LC BATCH Processing finished for BatchRef {}", notification.getBatchRef());
                //send email
                sendEmailNotification(defaultRecipients, "LC BATCH Processing finished for BatchRef <" + notification.getBatchRef() + ">", buildLegalCommitmentNotificationFinishedMessage(notification.getBatchRef()));

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
        velocityContext.put("monitoringTableURL", monitoringTableUrl);
        velocityContext.put("entitiesCount", legalEntitiesCount);
        velocityContext.put("entitiesValidCount", legalEntitiesValidCount);
        velocityContext.put("entitiesRejectedCount", legalEntitiesRejectedCount);
        velocityContext.put("entitiesErrorCount", legalEntitiesErrorCount);
        velocityContext.put("reportDate", Calendar.getInstance().getTime().toString());

        StringWriter stringWriter = new StringWriter();
        velocityEngine.mergeTemplate("templates/LEF_MAIL_REPORT_TEMPLATE.html", "UTF-8", velocityContext, stringWriter);

        return stringWriter.toString();
    }

    private String buildBudgetaryCommitmentNotificationFinishedMessage(String batchRef){
        List<BudgetaryCommitment> budgetaryCommitments = budgetaryCommitmentService.getAllByBatchRef(batchRef);

        Integer entitiesCount = budgetaryCommitments.size();
        Long entitiesValidCount = budgetaryCommitments.stream().filter(le -> le.getWfStatus().equals(AbacWorkflowStatus.ABAC_VALID)).count();
        Long entitiesRejectedCount = budgetaryCommitments.stream().filter(le -> le.getWfStatus().equals(AbacWorkflowStatus.ABAC_REJECTED)).count();
        Long entitiesErrorCount = budgetaryCommitments.stream().filter(le -> le.getWfStatus().equals(AbacWorkflowStatus.ABAC_ERROR)).count();

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("monitoringTableURL", monitoringTableUrl);
        velocityContext.put("entitiesCount", entitiesCount);
        velocityContext.put("entitiesValidCount", entitiesValidCount);
        velocityContext.put("entitiesRejectedCount", entitiesRejectedCount);
        velocityContext.put("entitiesErrorCount", entitiesErrorCount);
        velocityContext.put("reportDate", Calendar.getInstance().getTime().toString());

        StringWriter stringWriter = new StringWriter();
        velocityEngine.mergeTemplate("templates/BC_MAIL_REPORT_TEMPLATE.html", "UTF-8", velocityContext, stringWriter);

        return stringWriter.toString();
    }

    private String buildLegalCommitmentNotificationFinishedMessage(String batchRef){
        List<LegalCommitment> legalCommitments = legalCommitmentService.getAllByBatchRef(batchRef);

        Integer entitiesCount = legalCommitments.size();
        Long entitiesValidCount = legalCommitments.stream().filter(le -> le.getWfStatus().equals(LegalCommitmentWorkflowStatus.ABAC_VALID)).count();
        Long entitiesRejectedCount = legalCommitments.stream().filter(le -> le.getWfStatus().equals(LegalCommitmentWorkflowStatus.ABAC_REJECTED)).count();
        Long entitiesErrorCount = legalCommitments.stream().filter(le -> le.getWfStatus().equals(LegalCommitmentWorkflowStatus.ABAC_ERROR)).count();

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("monitoringTableURL", monitoringTableUrl);
        velocityContext.put("entitiesCount", entitiesCount);
        velocityContext.put("entitiesValidCount", entitiesValidCount);
        velocityContext.put("entitiesRejectedCount", entitiesRejectedCount);
        velocityContext.put("entitiesErrorCount", entitiesErrorCount);
        velocityContext.put("reportDate", Calendar.getInstance().getTime().toString());

        StringWriter stringWriter = new StringWriter();
        velocityEngine.mergeTemplate("templates/LC_MAIL_REPORT_TEMPLATE.html", "UTF-8", velocityContext, stringWriter);

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
