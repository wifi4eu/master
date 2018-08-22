package wifi4eu.wifi4eu.common.cns;

import eu.europa.ec.digit.cns.client.service.CnsServiceGateway;
import eu.europa.ec.digit.cns.client.service.notification.ContentTranslation;
import eu.europa.ec.digit.cns.client.service.notification.Link;
import eu.europa.ec.digit.cns.client.service.notification.Notification;
import eu.europa.ec.digit.cns.client.service.notification.Recipient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static eu.europa.ec.digit.cns.client.service.notification.ContentTranslation.Language.EN;
import static eu.europa.ec.digit.cns.client.service.notification.ContentTranslation.Language.FR;
import static eu.europa.ec.digit.cns.client.service.notification.ContentTranslation.Language.DE;
import static eu.europa.ec.digit.cns.client.service.notification.Recipient.Type.CC;
import static eu.europa.ec.digit.cns.client.service.notification.Recipient.Type.TO;
import static java.util.concurrent.TimeUnit.MICROSECONDS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Component
@PropertySource({"classpath:cns-client.properties"})
public class CNSManager {

    private static final Logger logger = LoggerFactory.getLogger(CNSManager.class);

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(20);

    @Value("${cns.notification.group.code}")
    private String notificationGroupCode;

    //-- https://webgate.ec.europa.eu/CITnet/confluence/display/EUWIFIOPS/3b.+Email+from+system+to+Beneficiary+to+notify+7+days+of+inoperation+after+Installation+confirmation
    @Value("${cns.message.inoperation.installation.subject}")
    private String cnsMessageInoperationInstallationSubject;
    @Value("${cns.message.inoperation.installation.body}")
    private String cnsMessageInoperationInstallationBody;
    @Value("${cns.message.inoperation.installation.summary}")
    private String cnsMessageInoperationInstallationSummary;


    //-- https://webgate.ec.europa.eu/CITnet/confluence/pages/viewpage.action?pageId=776245984
    @Value("${cns.message.inoperation.subject}")
    private String cnsMessageInoperationSubject;
    @Value("${cns.message.inoperation.body}")
    private String cnsMessagInoperationBbody;
    @Value("${cns.message.inoperation.summary}")
    private String cnsMessageInoperationSummary;

    @Value("${cns.message.inoperation.last.warning.subject}")
    private String cnsMessageInoperationLastWarningSubject;
    @Value("${cns.message.inoperation.last.warning.body}")
    private String cnsMessageInoperationLastWarningBody;
    @Value("${cns.message.inoperation.last.warning.summary}")
    private String cnsMessageInoperationLastWarningSummary;

    @Value("${cns.message.installation.confirmation.subject}")
    private String cnsMessageInstallationConfirmationSubject;
    @Value("${cns.message.installation.confirmation.body}")
    private String cnsMessageInstallationConfirmationBody;
    @Value("${cns.message.installation.confirmation.summary}")
    private String cnsMessageInstallationConfirmationSummary;

    @Value("${cns.message.installation.confirmationBeneficiary.subject}")
    private String cnsMessageInstallationConfirmationBeneficiarySubject;
    @Value("${cns.message.installation.confirmationBeneficiary.body}")
    private String cnsMessageInstallationConfirmationBeneficiaryBody;
    @Value("${cns.message.installation.confirmationBeneficiary.summary}")
    private String cnsMessageInstallationConfirmationBeneficiarySummary;

    @Value("${cns.message.installation.rejectionBeneficiary.subject}")
    private String cnsMessageInstallationRejectionBeneficiarySubject;
    @Value("${cns.message.installation.rejectionBeneficiary.body}")
    private String cnsMessageInstallationRejectionBeneficiaryBody;
    @Value("${cns.message.installation.rejectionBeneficiary.summary}")
    private String cnsMessageInstallationRejectionBeneficiarySummary;

    private CnsServiceGateway serviceGateway;
    Notification notification;

    public CNSManager() {
    }

    @PostConstruct
    public void init() {
        this.serviceGateway = new CnsServiceGateway();
    }


    public void sendInoperationNotificationAfterInstallationConfirmation(String email, String name, Locale locale) {
        logger.info("[I] sendInoperationNotificationAfterInstallationConfirmation");

        sendMessage(
                email,
                name,
                this.cnsMessageInoperationInstallationSubject,
                this.cnsMessageInoperationInstallationBody,
                this.cnsMessageInoperationInstallationSummary);

        logger.info("[F] sendInoperationNotificationAfterInstallationConfirmation");
    }

    public void sendInoperationNotification(String email, String name, int numberOfDays, Locale locale) {
        logger.info("[I] sendInoperationNotification");
        logger.info("EMAIL SEND => " + email);
        logger.info("NAME SEND => " + name);
        logger.info("NUMBER OF DAYS SEND => " + numberOfDays);
        if (!email.isEmpty() && !name.isEmpty() && numberOfDays != 0) {
            sendMessage(
                    email,
                    name,
                    this.cnsMessageInoperationSubject,
                    String.format(this.cnsMessagInoperationBbody, numberOfDays),
                    this.cnsMessageInoperationSummary);
        } else {
            logger.info("something empty!");
        }

        logger.info("[F] sendInoperationNotification");
    }

    public void sendLastCallInoperationNotification(String email, String name) {
        logger.info("[I] sendLastCallInoperationNotification");

        sendMessage(
                email,
                name,
                this.cnsMessageInoperationLastWarningSubject,
                String.format(this.cnsMessageInoperationLastWarningBody, 56),
                this.cnsMessageInoperationLastWarningSummary);

        logger.info("[F] sendLastCallInoperationNotification");
    }


    public void sendInstallationConfirmationNotification(String email, String name, Locale locale) {
        logger.info("[I] sendInstallationConfirmationNotification");

        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.submission.subject");
        String msgBody = bundle.getString("mail.submission.body");
        sendMessage(
                email,
                name,
                subject,
                msgBody,
                subject);

        logger.info("[F] sendInstallationConfirmationNotification");
    }


    public void sendInstallationConfirmationFromBeneficiary(String email, String name, String beneficiaryName, Locale locale) {
        logger.info("[I] sendInstallationConfirmationFromBeneficiary");

        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.confirmation.subject");
        String msgBody = bundle.getString("mail.confirmation.body");
        sendMessage(
                email,
                name,
                subject + beneficiaryName,
                msgBody,
                subject);

        logger.info("[F] sendInstallationConfirmationFromBeneficiary");
    }


    public void sendInstallationRejectionFromBeneficiary(String email, String name, String beneficiaryName, String ccEmail, String ccName, Locale locale) {
        logger.info("[I] sendInstallationRejectionFromBeneficiary");

        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.revision.subject");
        String msgBody = bundle.getString("mail.revision.body");
        sendMessage(
                email,
                name,
                subject + beneficiaryName,
                msgBody,
                subject);

        sendMessage(
                ccEmail,
                ccName,
                subject + beneficiaryName,
                msgBody,
                subject);

        logger.info("[F] sendInstallationRejectionFromBeneficiary");
    }

    private void sendMessage(String email, String name, String subject, String body, String summary) {
        logger.info("[I] sendMessage");

        Recipient recipient = new Recipient(TO, email).setName(name);
        ContentTranslation contentTranslation = new ContentTranslation(EN, subject, body).setSummary(summary);
        notification = new Notification(this.notificationGroupCode, recipient, contentTranslation);

        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                logger.info("Sending message to CNS");
                long notificationId = serviceGateway.getNotificationService().submit(notification);
                logger.info("Message delivered with id: " + notificationId);
            }
        }, 0, MICROSECONDS);

        logger.info("[F] sendMessage");
    }

    public void sendTestMessage() {
        logger.info("[I] sendMessage");

        Notification helloWorldMessage = new Notification(
                "WiFi4EU_OP",
                new Recipient(TO,
                        "jordi.magrina.cortes@everis.com").setName("CORTES Jordi"),
                new ContentTranslation(EN, "Hello World", "" +
                        "Because <b>Hello World</b> is typically one of the simplest programs, " +
                        "it is by tradition often used to illustrate the basic syntax of a programming language")
                        .addLink(new Link("Search via Google",
                                "http://www.google.com?q=Hello+World"))
                        .addLink(new Link("Consult Wikipedia", "http://en.wikipedia.org/wiki/%22Hello,_world!%22_program"))
                        .setSummary("<b>Hello World</b> is one of the simplest programs")
        );

        logger.info("ready to deliver message...");
        long helloWorldMessageId = serviceGateway.getNotificationService().submit(helloWorldMessage);
        logger.error("CNS Message sent with ID: " + helloWorldMessageId);

        logger.info("[F] sendMessage");
    }

    public void sendReportingSystemCallOpen(String email, String name, String url, Locale locale){
        logger.info("[I] sendMessageReportingSystem");

        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.reporting.subject");
        String msgBody = bundle.getString("mail.reporting.body");
        String msgBody2 = bundle.getString("mail.reporting.body2");
        String summary = bundle.getString("mail.reporting.summary");

        Recipient recipient = new Recipient(TO, email).setName(name);
        ContentTranslation contentTranslation = new ContentTranslation(EN, subject, msgBody+"<br>"+url+"<br>"+msgBody2).setSummary(summary);
        Notification notification = new Notification(this.notificationGroupCode, recipient, contentTranslation);

        logger.info("Sending message to CNS");
        long notificationId = serviceGateway.getNotificationService().submit(notification);
        logger.info("Message delivered with id: " + notificationId);

        logger.info("[F] sendMessageReportingSystem");
    }

}
