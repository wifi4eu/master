package edcchelpdesk.dto;

import java.util.Map;

public class Response {
    private boolean success;
    private Map<String, Boolean> data;
    private Error error;
    private long XTotalCount;

    public Response(boolean success, Map<String, Boolean> data, Error error, long XTotalCount) {
        this.success = success;
        this.data = data;
        this.error = error;
        this.XTotalCount = XTotalCount;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, Boolean> getData() {
        return this.data;
    }

    public void setData(Map<String, Boolean> data) {
        this.data = data;
    }

    public Error getError() {
        return this.error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public long getXTotalCount() {
        return this.XTotalCount;
    }

    public void setXTotalCount(long XTotalCount) {
        this.XTotalCount = XTotalCount;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", data=" + data +
                ", error=" + error +
                ", XTotalCount=" + XTotalCount +
                '}';
    }
}

