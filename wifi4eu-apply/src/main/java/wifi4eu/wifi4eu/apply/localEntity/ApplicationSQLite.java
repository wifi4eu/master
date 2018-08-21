package wifi4eu.wifi4eu.apply.localEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="applications")
public class ApplicationSQLite {

	@Id
	@Column(name="redis_id")
	public String id;
	
	@Column(name="call_id")
	public Long callId;
	
	@Column(name="r")
	public String registrationId;
	
	@Column(name="u")
	public String userId;
	
	@Column(name="m")
	public String municipalityId;
	
	@Column
	public String ip;
	
	@Column
	public String data;
	
	public ApplicationSQLite() {
	}
	
	public ApplicationSQLite(String id, Long callId, String registrationId) {
		this.id = id;
		this.callId = callId;
		this.registrationId = registrationId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCallId() {
		return callId;
	}

	public void setCallId(Long callId) {
		this.callId = callId;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMunicipalityId() {
		return municipalityId;
	}

	public void setMunicipalityId(String municipalityId) {
		this.municipalityId = municipalityId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
