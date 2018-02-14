package wifi4eu.wifi4eu.web.exception;

public class RestException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	public String getErrorMessage() {
		return errorMessage;
	}
	public RestException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public RestException() {
		super();
	}
}