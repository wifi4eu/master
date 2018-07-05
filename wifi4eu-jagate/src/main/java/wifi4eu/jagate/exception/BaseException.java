package eu.europa.ec.jagate.financiallegalentity.exception;


public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = 7666852056670592320L;

    private ErrorDTO errorData;

	//
	// Inherited constructors.
	//

    public BaseException() {
    	super();
    }

	public BaseException(Throwable cause) {
		super(cause);
		this.errorData = new ErrorDTO(ErrorCode.UNKNOWN_ERROR);
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
		this.errorData = new ErrorDTO(ErrorCode.UNKNOWN_ERROR);
	}

	public BaseException(String message) {
		super(message);
		this.errorData = new ErrorDTO(ErrorCode.UNKNOWN_ERROR);
	}

	@Override
	public String getMessage() {
	    if ((errorData != null) && (errorData.getErrorCode() != ErrorCode.UNKNOWN_ERROR)) {
	        return errorData.getLogMessage();
	    } else {
	    	return super.getMessage();
	    }
	}
	//
	// User-defined constructors.
	//

	public BaseException(ErrorDTO errorData) {
		this.errorData = errorData;
	}

	public BaseException(ErrorDTO errorData, Throwable cause) {
		super(cause);
		this.errorData = errorData;
	}

	public ErrorDTO getErrorData() {
		return errorData;
	}
}
