package wifi4eu.wifi4eu.common.dto.audit;


public class AuditDataDTO {

    private String requestEndpoint;
    private String requestMethod;
    private String requestBody;
    private String responseBody;
    private Long userId;

    public AuditDataDTO(){
    }

    public AuditDataDTO(String requestEndpoint, String requestMethod, String requestBody, String responseBody, Long userId) {
        this.requestEndpoint = requestEndpoint;
        this.requestMethod = requestMethod;
        this.requestBody = requestBody;
        this.responseBody = responseBody;
        this.userId = userId;
    }

    public String getRequestEndpoint() {
        return requestEndpoint;
    }

    public void setRequestEndpoint(String requestEndpoint) {
        this.requestEndpoint = requestEndpoint;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
