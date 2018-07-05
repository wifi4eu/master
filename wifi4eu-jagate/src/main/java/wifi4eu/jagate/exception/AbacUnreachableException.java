package eu.europa.ec.jagate.financiallegalentity.exception;


public class AbacUnreachableException extends BusinessException {

	private static final long serialVersionUID = -7648047283135273624L;

	public AbacUnreachableException(Throwable cause) {
		super(new ErrorDTO(ErrorCode.SERVICE_ABAC_REMOTE, cause.getMessage()), cause);
	}

}
