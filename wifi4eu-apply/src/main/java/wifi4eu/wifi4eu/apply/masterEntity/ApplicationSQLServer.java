package wifi4eu.wifi4eu.apply.masterEntity;

import java.util.Date;

public class ApplicationSQLServer {

	public long callId;

	public long registrationId;

	public Date date;

	public ApplicationSQLServer() {
	}

	public ApplicationSQLServer(long callId, long registrationId, Date date) {
		this.callId = callId;
		this.registrationId = registrationId;
		this.date = date;
	}

	public long getCallId() {
		return callId;
	}

	public void setCallId(long callId) {
		this.callId = callId;
	}

	public long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}