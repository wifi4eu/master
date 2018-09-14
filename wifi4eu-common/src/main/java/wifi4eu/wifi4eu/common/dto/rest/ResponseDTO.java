package wifi4eu.wifi4eu.common.dto.rest;

/**
 * Created by rgarcita on 21/02/2017.
 */
public class ResponseDTO {

    private boolean success = false;
    private Object data;
    private ErrorDTO error;
    private long XTotalCount;

    public ResponseDTO(){}

    public ResponseDTO(boolean success) {
        this.success = success;
    }

    public ResponseDTO(boolean success, Object data, ErrorDTO error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public ResponseDTO(boolean success, Object data, Long XTotalCount, ErrorDTO error) {
        this.success = success;
        this.data = data;
        this.error = error;
        this.XTotalCount = XTotalCount;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ErrorDTO getError() {
        return error;
    }

    public void setError(ErrorDTO error) {
        this.error = error;
    }

    public long getXTotalCount(){
        return this.XTotalCount;
    }

    public void setXTotalCount(long XTotalCount){
        this.XTotalCount = XTotalCount;
    }
}