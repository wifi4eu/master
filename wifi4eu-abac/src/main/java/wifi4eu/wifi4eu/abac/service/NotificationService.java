package wifi4eu.wifi4eu.abac.service;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
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
import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

@Service
public class NotificationService {

	private static final String LEF_FINISHED_BATCH_EMAIL_SUBJECT = "[WIFI4EU] %s LEFs finished processing for BatchRef %s";
	private static final String BC_FINISHED_BATCH_EMAIL_SUBJECT = "[WIFI4EU] %s BCs finished processing for BatchRef %s";
	private static final String LC_FINISHED_BATCH_EMAIL_SUBJECT = "[WIFI4EU] %s LCs finished processing for BatchRef %s";

	private static final String LEF_MAIL_TEMPLATE = "templates/LEF_MAIL_REPORT_TEMPLATE.html";
	private static final String BC_MAIL_TEMPLATE = "templates/BC_MAIL_REPORT_TEMPLATE.html";
	private static final String LC_MAIL_TEMPLATE = "templates/LC_MAIL_REPORT_TEMPLATE.html";

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

    public void createValidationProcessPendingNotification(String batchRef, NotificationType notificationType, String recipient){
        Notification notification = new Notification();
        notification.setBatchRef(batchRef);
        notification.setNotificationStatus(NotificationStatus.PENDING);
        notification.setNotificationType(notificationType);
        notification.setSendTo(recipient);
        notificationRepository.save(notification);
    }

	@Transactional
	public void notifyBatchProcessFinished(){
		List<Notification> notificationsPending = notificationRepository.findAllByNotificationStatusEquals(NotificationStatus.PENDING);

		for(Notification notification:notificationsPending){

			Boolean batchIsFinished = Boolean.FALSE;
			switch (notification.getNotificationType()) {
				case LEF_CREATION:
					batchIsFinished = notifyLegalEntityProcessFinished(notification.getBatchRef(), notification.getSendTo());
					break;
				case BC_CREATION:
					batchIsFinished = notifyBudgetaryCommitmentProcessFinished(notification.getBatchRef(), notification.getSendTo());
					break;
				case LC_CREATION:
					batchIsFinished = notifyLegalCommitmentProcessFinished(notification.getBatchRef(), notification.getSendTo());
					break;
			}
			if(batchIsFinished) {
				//update notification status
				notification.setNotificationStatus(NotificationStatus.SENT);
				notificationRepository.save(notification);
			}
		}
	}

	private Boolean notifyLegalEntityProcessFinished(String batchRef, String recipient){
    	Boolean batchIsFinished = legalEntityService.isBatchProcessed(batchRef);
		if(batchIsFinished){
			List<LegalEntity> legalEntities = legalEntityService.getAllByBatchRef(batchRef);

			Integer legalEntitiesCount = legalEntities.size();
			Long legalEntitiesValidCount = legalEntities.stream().filter(le -> le.getWfStatus().equals(AbacWorkflowStatus.ABAC_VALID)).count();
			Long legalEntitiesRejectedCount = legalEntities.stream().filter(le -> le.getWfStatus().equals(AbacWorkflowStatus.ABAC_REJECTED)).count();
			Long legalEntitiesErrorCount = legalEntities.stream().filter(le -> le.getWfStatus().equals(AbacWorkflowStatus.ABAC_ERROR)).count();

			if (legalEntitiesCount > 0) {
				String subject = String.format(LEF_FINISHED_BATCH_EMAIL_SUBJECT, legalEntitiesCount, batchRef);
				String message = buildNotificationFinishedMessage(LEF_MAIL_TEMPLATE, batchRef, legalEntitiesCount, legalEntitiesValidCount, legalEntitiesRejectedCount, legalEntitiesErrorCount);
				sendEmailNotification(recipient, subject, message);
				log.info(subject);
			}
		}
		return batchIsFinished;
    }

	private Boolean notifyBudgetaryCommitmentProcessFinished(String batchRef, String recipient){
		Boolean batchIsFinished = budgetaryCommitmentService.isBatchProcessed(batchRef);
		if(batchIsFinished) {
			List<BudgetaryCommitment> budgetaryCommitments = budgetaryCommitmentService.getAllByBatchRef(batchRef);

			Integer entitiesCount = budgetaryCommitments.size();
			Long entitiesValidCount = budgetaryCommitments.stream().filter(bc -> bc.getWfStatus().equals(AbacWorkflowStatus.ABAC_VALID)).count();
			Long entitiesRejectedCount = budgetaryCommitments.stream().filter(bc -> bc.getWfStatus().equals(AbacWorkflowStatus.ABAC_REJECTED)).count();
			Long entitiesErrorCount = budgetaryCommitments.stream().filter(bc -> bc.getWfStatus().equals(AbacWorkflowStatus.ABAC_ERROR)).count();

			if (entitiesCount > 0) {
				String subject = String.format(BC_FINISHED_BATCH_EMAIL_SUBJECT, entitiesCount, batchRef);
				String message = buildNotificationFinishedMessage(BC_MAIL_TEMPLATE, batchRef, entitiesCount, entitiesValidCount, entitiesRejectedCount, entitiesErrorCount);
				sendEmailNotification(recipient, subject, message);
				log.info(subject);
			}
        }
		return batchIsFinished;
    }

    private Boolean notifyLegalCommitmentProcessFinished(String batchRef, String recipient){
		Boolean batchIsFinished = legalCommitmentService.isBatchProcessed(batchRef);
		if(batchIsFinished) {
			List<LegalCommitment> legalCommitments = legalCommitmentService.getAllByBatchRef(batchRef);

			Integer entitiesCount = legalCommitments.size();
			Long entitiesValidCount = legalCommitments.stream().filter(lc -> lc.getWfStatus().equals(LegalCommitmentWorkflowStatus.ABAC_VALID)).count();
			Long entitiesRejectedCount = legalCommitments.stream().filter(lc -> lc.getWfStatus().equals(LegalCommitmentWorkflowStatus.ABAC_REJECTED)).count();
			Long entitiesErrorCount = legalCommitments.stream().filter(lc -> lc.getWfStatus().equals(LegalCommitmentWorkflowStatus.ABAC_ERROR)).count();

			if (entitiesCount > 0) {
				String subject = String.format(LC_FINISHED_BATCH_EMAIL_SUBJECT, entitiesCount, batchRef);
				String message = buildNotificationFinishedMessage(LC_MAIL_TEMPLATE, batchRef, entitiesCount, entitiesValidCount, entitiesRejectedCount, entitiesErrorCount);
				sendEmailNotification(recipient, subject, message);
				log.info(subject);
			}
		}
		return batchIsFinished;
    }

    private String buildNotificationFinishedMessage(String templateName, String batchRef, Integer legalEntitiesCount, Long legalEntitiesValidCount, Long legalEntitiesRejectedCount, Long legalEntitiesErrorCount){
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("monitoringTableURL", monitoringTableUrl);
        velocityContext.put("entitiesCount", legalEntitiesCount);
        velocityContext.put("entitiesValidCount", legalEntitiesValidCount);
        velocityContext.put("entitiesRejectedCount", legalEntitiesRejectedCount);
        velocityContext.put("entitiesErrorCount", legalEntitiesErrorCount);
        velocityContext.put("reportDate", Calendar.getInstance().getTime().toString());

        StringWriter stringWriter = new StringWriter();
        velocityEngine.mergeTemplate(templateName, "UTF-8", velocityContext, stringWriter);

        return stringWriter.toString();
    }

    private void sendEmailNotification(String recipient, String subject, String body){
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            MimeMessage  msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(defaultSender));

			if (StringUtils.isEmpty(recipient)) {
				recipient = defaultRecipients;
			}

            for(String recipientSplited: recipient.split(",")) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientSplited));
			}

            for(String defaultRecipient: defaultRecipients.split(",")) {
                msg.addRecipient(Message.RecipientType.CC, new InternetAddress(defaultRecipient));
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
