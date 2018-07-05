package wifi4eu.jagate.exception;


public class BusinessException extends BaseException {
    private static final long serialVersionUID = -7214002954289074335L;

    public BusinessException(ErrorDTO errorData) {
		super(errorData);
	}

	public BusinessException(ErrorDTO errorData, Throwable cause) {
		super(errorData, cause);
	}

	public BusinessException(String msg) {
		super(msg);
	}
}
