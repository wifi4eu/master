package wifi4eu.wifi4eu.abac.rest.vo;

public class ResponseVO {

	private Boolean success = null;
	private String message = null;
	private String batchRef = null;

	public void success(String message) {
		this.success = true;
		this.message = message;
	}

	public void error(String message) {
		this.success = false;
		this.message = message;
	}

	public void error(String message, String batchRef) {
		error(message);
		this.batchRef = batchRef;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBatchRef() {
		return batchRef;
	}

	public void setBatchRef(String batchRef) {
		this.batchRef = batchRef;
	}
}
