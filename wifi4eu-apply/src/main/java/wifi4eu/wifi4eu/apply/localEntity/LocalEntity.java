package wifi4eu.wifi4eu.apply.localEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LocalEntity {

	@Id
	public long id;
	
	@Column
	public long callId;
	
	@Column
	public long registrationId;
	
	@Column
	public Date date;
	
	public LocalEntity() {
		
	}
	
	public LocalEntity(long id, long callId, long registrationId, Date date) {
		this.id = id;
		this.callId = callId;
		this.registrationId = registrationId;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
