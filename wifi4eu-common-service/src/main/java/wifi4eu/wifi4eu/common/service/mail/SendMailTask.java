package wifi4eu.wifi4eu.common.service.mail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;
import wifi4eu.wifi4eu.repository.logEmails.LogEmailRepository;

@Component
@Scope("prototype")
public abstract class SendMailTask implements Runnable {
	private final Logger _log = LogManager.getLogger(SendMailTask.class);

	public static final String NO_ACTION = "NO ACTION LOGGED";

	@Autowired
	protected LogEmailRepository logEmailRepository;

	protected MailData mailData;

	public SendMailTask(MailData mailData) {
		super();
		this.mailData = mailData;
	}

	/**
	 * Send the email.
	 * 
	 * @param mailData
	 */
	public abstract void sendMail();

	/**
	 * Logs the email in the database associated to a municipality with the executed
	 * action detail.
	 * 
	 */
	protected void logEmail() {
		_log.debug("Logging email");

		String toAddress = mailData.getToAddress();
		String fromAddress = mailData.getFromAddress();
		String action = mailData.getAction();
		String subject = mailData.getSubject();
		String body = mailData.getBody();
		int munId = mailData.getMunicipalityId();

		if (toAddress == null || toAddress.isEmpty()) {
			_log.warn("Mail not registered. No address was specified.");
		} else if (munId == 0) {
			_log.warn("Mail not registered. MunicipalityId was not defined.");
		} else {
			String setAction = NO_ACTION;
			if (action != null && !action.isEmpty()) {
				setAction = action;
			}
			LogEmail logEmail = new LogEmail(toAddress, fromAddress, subject, body, munId, setAction);
			logEmailRepository.save(logEmail);
		}
	}

	@Override
	public void run() {
		_log.debug("Sending asynchronous mail");
		try {
			if (mailData == null) {
				throw new RuntimeException("MailData was not defined");
			}

			// Send message
			sendMail();
			_log.debug("Email sent to {}", mailData.getToAddress());

			if (mailData.isLogEmail()) {
				// Log email in database
				logEmail();
				_log.debug("Email logged");
			}
		} catch (Exception ex) {
			_log.error("Error processing the mail", ex.getMessage());
		}
	}
}
