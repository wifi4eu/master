package wifi4eu.wifi4eu.service.exportImport.messageCall;

import java.io.Serializable;

public class SoaMessageCall implements Serializable {
	private String messageCorrelation = "";
	private String databaseName = "";
	private String appVersion = "";
	private String invMethod ="";
	private String errorMessage = "";
	private boolean successfullInvocation = false;
	private String status = "";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isSuccessfullInvocation() {
		return successfullInvocation;
	}

	public void setSuccessfullInvocation(boolean successfullInvocation) {
		this.successfullInvocation = successfullInvocation;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public SoaMessageCall() {
	}

	public String getMessageCorrelation() {
		return messageCorrelation;
	}

	public void setMessageCorrelation(String messageCorrelation) {
		this.messageCorrelation = messageCorrelation;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getInvMethod() {
		return invMethod;
	}

	public void setInvMethod(String invMethod) {
		this.invMethod = invMethod;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String dbName) {
		this.databaseName = dbName;
	}

}