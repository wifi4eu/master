package wifi4eu.wifi4eu.common.dto.rest;

/**
 * Created by rgarcita on 21/02/2017.
 */
public class ErrorDTO{

    private long code;
    private String message;

    public ErrorDTO(){}

    public ErrorDTO(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
