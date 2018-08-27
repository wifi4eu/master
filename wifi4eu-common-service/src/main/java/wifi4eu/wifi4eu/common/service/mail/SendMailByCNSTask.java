package wifi4eu.wifi4eu.common.service.mail;

import static eu.europa.ec.digit.cns.client.service.notification.Recipient.Type.TO;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.europa.ec.digit.cns.client.service.CnsServiceGateway;
import eu.europa.ec.digit.cns.client.service.notification.ContentTranslation;
import eu.europa.ec.digit.cns.client.service.notification.ContentTranslation.Language;
import eu.europa.ec.digit.cns.client.service.notification.Notification;
import eu.europa.ec.digit.cns.client.service.notification.Recipient;
import wifi4eu.wifi4eu.common.dto.mail.MailData;

@Configuration
@PropertySource("classpath:env.properties")
@Component
@Scope("prototype")
public class SendMailByCNSTask extends SendMailTask {

	private static final Logger _log = LogManager.getLogger(SendMailByCNSTask.class);

	@Value("${cns.notification.group.code}")
	private String notificationGroupCode;

	private CnsServiceGateway serviceGateway;

	public SendMailByCNSTask(MailData mailData) {
		super(mailData);
	}

	@PostConstruct
	public void init() {
		this.serviceGateway = new CnsServiceGateway();
	}

	/**
	 * Prepares the recipient of the mail.
	 * 
	 * @return Recipient object
	 */
	private static Recipient prepareRecipient(String toAddress, String toName) {
		Recipient recipient = new Recipient(TO, toAddress);
		if (toName != null && !toName.isEmpty()) {
			recipient.setName(toName);
		}

		return recipient;
	}

	/**
	 * Prepares the language of the mail.
	 * 
	 * @return Language object
	 */
	private static Language prepareLanguage(Locale locale) {
		Language language;
		if (locale != null) {
			try {
				language = Language.valueOf(locale.getLanguage().toUpperCase());
			} catch (IllegalArgumentException e) {
				// Set default value
				language = MailService.DEFAULT_LANGUAGE;
				_log.warn("Error, language [" + locale.getLanguage() + "] not found, setting default language ["
						+ language.name() + "]");
			}
		} else {
			// Set default value
			language = MailService.DEFAULT_LANGUAGE;
			_log.warn("Error, language not defined, setting default language [" + language.name() + "]");
		}

		return language;
	}

	/**
	 * Prepares the content of the mail.
	 * 
	 * @return ContentTranslation object
	 */
	private static ContentTranslation prepareContentTranslation(Language language, String subject, String body,
			String summary) {
		ContentTranslation contentTranslation = new ContentTranslation(language, subject, body);
		if (summary != null && !summary.isEmpty()) {
			contentTranslation.setSummary(summary);
		}

		return contentTranslation;
	}

	@Override
	public void sendMail() {
		// Prepare data
		Recipient recipient = prepareRecipient(mailData.getToAddress(), mailData.getToName());
		Language language = prepareLanguage(mailData.getLocale());
		ContentTranslation contentTranslation = prepareContentTranslation(language, mailData.getSubject(),
				mailData.getBody(), mailData.getSummary());

		// Create notification and submit
		Notification notification = new Notification(notificationGroupCode, recipient, contentTranslation);
		_log.info("Sending message to CNS");
		long notificationId = serviceGateway.getNotificationService().submit(notification);
		_log.info("Message delivered with id: " + notificationId);

	}
}
