package wifi4eu.wifi4eu.apply.masterEntity;

public class ApplicationSQLServer {

	public long callId;

	public long registrationId;

	public long date;

	public long order;

	public ApplicationSQLServer() {
	}

	public ApplicationSQLServer(long callId, long registrationId, long date, long order) {
		this.callId = callId;
		this.registrationId = registrationId;
		this.date = date;
		this.order = order;
	}

	public long getOrder() {
		return order;
	}

	public void setOrder(long order) {
		this.order = order;
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

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}
}