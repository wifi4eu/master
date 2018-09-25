package wifi4eu.wifi4eu.common.service.mail;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import eu.europa.ec.digit.cns.client.service.notification.ContentTranslation.Language;
import wifi4eu.wifi4eu.common.dto.mail.MailData;

@Configuration
@PropertySource("classpath:env.properties")
@Service
public class MailService {
	private final Logger _log = LogManager.getLogger(MailService.class);

	public static final String FROM_ADDRESS = "no-reply@wifi4eu.eu";
	public static final String NO_ACTION = "NO ACTION LOGGED";

	/** Default language for the mail. */
	public static final Language DEFAULT_LANGUAGE = Language.EN;

	@Value("${mail.serv.enable}")
	private boolean enableMail;

	@Value("${mail.serv.using.smtp}")
	private boolean useSMTP;

	@Value("${mail.serv.using.cns}")
	private boolean useCNS;

	@Autowired
	ApplicationContext context;

	/** Task executor for async tasks. */
	@Autowired
	TaskExecutor taskExecutor;

	/** Task executor for sync tasks. */
	@Autowired
	SyncTaskExecutor syncTaskExecutor;

	/**
	 * Send email using the configured method (SMTP or CNS) and register a log
	 * entry. By default this mail is sent synchronously.
	 * 
	 * @param toAddress
	 *            Destination address
	 * @param fromAddress
	 *            Origin address
	 * @param subject
	 *            Subject of the email
	 * @param msgBody
	 *            Body of the email
	 * @param locale
	 *            Locale of the mail content
	 * @param municipalityId
	 *            Related municipality id
	 * @param action
	 *            Action executed
	 * 
	 */
	public void sendEmailWithLog(String toAddress, String fromAddress, String subject, String msgBody, Locale locale,
			int municipalityId, String action) {
		sendEmailWithLog(toAddress, fromAddress, subject, msgBody, locale, false, municipalityId, action);
	}

	/**
	 * Send email using the configured method (SMTP or CNS) and register a log
	 * entry.
	 * 
	 * @param toAddress
	 *            Destination address
	 * @param fromAddress
	 *            Origin address
	 * @param subject
	 *            Subject of the email
	 * @param msgBody
	 *            Body of the email
	 * @param locale
	 *            Locale of the mail content
	 * @param async
	 *            Send the mail asynchronously if true, synchronously otherwise.
	 * @param municipalityId
	 *            Related municipality id
	 * @param action
	 *            Action executed
	 * 
	 */
	public void sendEmailWithLog(String toAddress, String fromAddress, String subject, String msgBody, Locale locale,
			boolean async, int municipalityId, String action) {
		MailData mailData = new MailData(toAddress, fromAddress, subject, msgBody, locale, municipalityId, action,
				true);
		sendMail(mailData, async);
	}

	/**
	 * Send email using the configured method (SMTP or CNS). By default this mail is
	 * sent synchronously.
	 * 
	 * @param toAddress
	 *            Destination address
	 * @param fromAddress
	 *            Origin address
	 * @param subject
	 *            Subject of the email
	 * @param msgBody
	 *            Body of the email
	 */
	public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
		sendEmail(toAddress, fromAddress, subject, msgBody, false);
	}

	/**
	 * Send email using the configured method (SMTP or CNS).
	 * 
	 * @param toAddress
	 *            Destination address
	 * @param fromAddress
	 *            Origin address
	 * @param subject
	 *            Subject of the email
	 * @param msgBody
	 *            Body of the email
	 * @param async
	 *            Send the mail asynchronously if true, synchronously otherwise.
	 */
	public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody, boolean async) {
		MailData mailData = new MailData(toAddress, fromAddress, subject, msgBody);
		sendMail(mailData, async);
	}

	/**
	 * Send mail asynchronously
	 * 
	 * @param mailData
	 *            Mail data
	 * @param async
	 *            Send the mail asynchronously if true, synchronously otherwise.
	 */
	public void sendMail(MailData mailData, boolean async) {
		if (_log.isDebugEnabled()) {
			_log.debug("Sending mail from[{}] with subject [{}] - async? {}", mailData.getFromAddress(),
					mailData.getSubject(), async);
			_log.debug("Content of the mail: {}", mailData.getBody());
		}

		if (enableMail) {
			// Let the proper task executor manage the execution of the task to send the
			// mail
			if (async) {
				taskExecutor.execute(getMailTaskRunnable(mailData));
			} else {
				syncTaskExecutor.execute(getMailTaskRunnable(mailData));
			}
		} else {
			_log.warn("Mail is no enabled, no emails were sent");
		}
	}

	private Runnable getMailTaskRunnable(MailData mailData) {
		if (useSMTP) {
			return context.getBean(SendMailBySMTPTask.class, mailData);
		} else if (useCNS) {
			return context.getBean(SendMailByCNSTask.class, mailData);
		}

		_log.warn("The system to send mails was not defined but the mailing is enabled. Using SMTP by default");
		return context.getBean(SendMailBySMTPTask.class, mailData);
	}

}
