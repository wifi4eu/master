package wifi4eu.wifi4eu.common.exception;

import java.util.UUID;

@SuppressWarnings("serial")
public class AppException extends RuntimeException implements CodedException {
	
	private final UUID uuid;

	private String code;

	public AppException() {
		this(null, null, null);
	}

	public AppException(String message, String code, Throwable cause) {
		super(message, cause);
		this.code = code;

		uuid= UUID.randomUUID();		
	}

	public AppException(String message, Throwable cause) {
		this(message, null, cause);
	}

	public AppException(String message) {
		this(message, null, null);
	}

	public AppException(Throwable cause) {
		this(null, null, cause);
	}


	public String getCode() {
		if (this.code == null) {
			return "app.exception.global";
		} else {
			return this.code;
		}
	}

	public UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append("uuid=")
			.append(getUuid())
			.append(" ")
			.append(super.toString())
			.toString();
	}
}
