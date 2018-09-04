package wifi4eu.wifi4eu.common.dto.mail;

import java.util.Locale;

public class MailData {

	private String toAddress;
	private String toName;
	private String fromAddress;
	private String subject;
	private String body;
	private String summary;
	private Locale locale = Locale.ENGLISH;
	private int municipalityId = 0;
	private String action;
	private boolean logEmail = false;

	public MailData() {

	}

	public MailData(String toAddress, String fromAddress, String subject, String body) {
		super();
		this.toAddress = toAddress;
		this.fromAddress = fromAddress;
		this.subject = subject;
		this.body = body;
	}

	public MailData(String toAddress, String toName, String subject, String body, Locale locale) {
		super();
		this.toAddress = toAddress;
		this.toName = toName;
		this.subject = subject;
		this.body = body;
		this.locale = locale;
	}

	public MailData(String toAddress, String fromAddress, String subject, String body, Locale locale,
			int municipalityId, String action, boolean logEmail) {
		super();
		this.toAddress = toAddress;
		this.fromAddress = fromAddress;
		this.subject = subject;
		this.body = body;
		this.locale = locale;
		this.municipalityId = municipalityId;
		this.action = action;
		this.logEmail = logEmail;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public int getMunicipalityId() {
		return municipalityId;
	}

	public void setMunicipalityId(int municipalityId) {
		this.municipalityId = municipalityId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean isLogEmail() {
		return logEmail;
	}

	public void setLogEmail(boolean logEmail) {
		this.logEmail = logEmail;
	}

}
