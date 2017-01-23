package wifi4eu.wifi4eu.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
 
@ControllerAdvice
public class ExceptionControllerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> exceptionHandler(Exception ex) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("Application error : contact your administrator");
		logger.error(error.getMessage(),ex);
		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}