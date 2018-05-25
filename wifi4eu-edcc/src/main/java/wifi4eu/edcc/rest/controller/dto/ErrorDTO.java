package wifi4eu.edcc.rest.controller.dto;

/**
 * Created by rgarcita on 21/02/2017.
 */
public class ErrorDTO{

    private long errorCode;
    private String errorMessage;

    public ErrorDTO(){}

    public ErrorDTO(long errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
