package wifi4eu.jagate.exception;

/**
 * Contains error data (messages, timestamp) to be attached to a thrown PDM (business) exception.
 * Messages can be formatted with dynamic data values.
 */
public class ErrorDTO {
	
	private ErrorCode errorCode;
	private String clientMessage;
	private String logMessage;
	private long timestamp;
	
	// TODO variable argument list
	public ErrorDTO(ErrorCode errorCode, String clientMessage, String logMessage) {
		this.errorCode 		= errorCode;
		this.clientMessage 	= clientMessage;
		this.logMessage 	= logMessage;
		this.timestamp 		= System.currentTimeMillis();
	}
	
	public ErrorDTO(ErrorCode errorCode, String logMessage) {
	    this(errorCode, logMessage, logMessage);
    }
	
	public ErrorDTO(ErrorCode errorCode) {  
		this(errorCode, null, null);
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	public String getClientMessage() {
		return clientMessage;
	}
	
	public String getLogMessage() {
	    if (logMessage == null) {
	        return getErrorCodeInfo();
	    }
		return logMessage;
	}

    private String getErrorCodeInfo() {
        if (errorCode == null) {
            return "ErrorCode not provided";
        } else {
            return errorCode.name();
        }
    }
	
	public long getTimestamp() {
		return timestamp;
	}
}
