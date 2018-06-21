package wifi4eu.wifi4eu.web.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import wifi4eu.wifi4eu.common.exception.AppException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private static final Logger logger = LogManager.getLogger(ExceptionControllerAdvice.class);
 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> exceptionHandler(Exception ex) {
		HttpStatus responseCode = HttpStatus.INTERNAL_SERVER_ERROR;
		String responseMessage = "Application error : contact your administrator";

		ExceptionResponse error = new ExceptionResponse();
		if (ex instanceof AppException) {
			AppException appException = (AppException) ex;

			responseCode = HttpStatus.valueOf(appException.getResponseCode()) ;
			responseMessage = appException.getUserMessage();
		}

		error.setErrorCode(responseCode.value());
		error.setMessage(responseMessage);

		logger.error(error.getMessage(), ex);
		return new ResponseEntity<ExceptionResponse>(error, responseCode);
	}
}