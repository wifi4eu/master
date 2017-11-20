package wifi4eu.wifi4eu.entity.audit;

import javax.persistence.*;

@Entity
@Table(name="AUDIT_DATA_T")
public class AuditData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AUDIT_DATA_ID")
    private Long auditDataId;

    @Column(name="REQUEST_ENDPOINT")
    private String requestEndpoint;

    @Column(name="REQUEST_METHOD")
    private String requestMethod;

    @Lob
    @Column(name="REQUEST_BODY")
    private String requestBody;

    @Lob
    @Column(name="RESPONSE_BODY")
    private String responseBody;

    @Column(name = "USER_ID")
    private Long userId;

    public AuditData(){}

    public AuditData(Long auditDataId, String requestEndpoint, String requestMethod, String requestBody, String responseBody, Long userId) {
        this.auditDataId = auditDataId;
        this.requestEndpoint = requestEndpoint;
        this.requestMethod = requestMethod;
        this.requestBody = requestBody;
        this.responseBody = responseBody;
        this.userId = userId;
    }

    public Long getAuditDataId() {
        return auditDataId;
    }

    public void setAuditDataId(Long auditDataId) {
        this.auditDataId = auditDataId;
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
