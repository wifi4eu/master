package wifi4eu.jagate.exception;


public class AbacProtocolBreachException extends BusinessException {

	private static final long serialVersionUID = -7648047283135273624L;

	public AbacProtocolBreachException(String msg) {
		super(new ErrorDTO(ErrorCode.SERVICE_ABAC_REMOTE, msg));
	}

}
