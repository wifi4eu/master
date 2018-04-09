package wifi4eu.wifi4eu.common.exception;

import org.apache.http.HttpStatus;

import java.util.UUID;

@SuppressWarnings("serial")
public class AppException extends RuntimeException {
	
	private final UUID uuid;

	private int responseCode;
	private String userMessage;
	private String detailMessage;

	public AppException() {
		this(null, null);
	}

	public AppException(String message) {
		this(message, null);
	}

	public AppException(Throwable cause) {
		this(null, cause);
	}

	public AppException(String message, Throwable cause) {
		this(message, 0, null, cause);
	}

	public AppException(int responseCode, String message, Throwable cause) {
		this(message, responseCode, null, cause);
	}

	public AppException(String detailMessage, String userMessage, Throwable cause) {
		this(detailMessage, 0, userMessage, cause);
	}

	public AppException(int responseCode, String userMessage) {
		this(null, responseCode, userMessage, null);
	}

	public AppException(String detailMessage, int responseCode, String userMessage) {
		this(detailMessage, responseCode, userMessage, null);
	}

	public AppException(String detailMessage, int responseCode, String userMessage, Throwable cause) {
		super(detailMessage, cause);

		uuid = UUID.randomUUID();
		this.responseCode = responseCode == 0 ? HttpStatus.SC_INTERNAL_SERVER_ERROR : responseCode;
		if (userMessage != null && userMessage.length() != 0) {
			this.userMessage = userMessage;
		} else {
			this.userMessage = "Internal server error";
		}

		this.detailMessage = "";
		if (detailMessage != null && detailMessage.length() != 0) {
			this.detailMessage = detailMessage;
		}

		if (cause != null) {
			this.detailMessage = this.detailMessage + ": " + cause.getMessage();
		}
	}

	public String getDetailMessage() {
		if (this.detailMessage == null) {
			return "";
		} else {
			return this.detailMessage;
		}
	}

	public String getUserMessage() {
		if (this.userMessage == null) {
			return "app.exception.global";
		} else {
			return this.userMessage;
		}
	}

	public int getResponseCode() {
		return responseCode;
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
			.append("responseCode=")
			.append(this.responseCode)
			.append(" ")
			.append(this.responseCode == HttpStatus.SC_INTERNAL_SERVER_ERROR || this.responseCode == 0 ? super.toString() : "")
			.toString();
	}
}
