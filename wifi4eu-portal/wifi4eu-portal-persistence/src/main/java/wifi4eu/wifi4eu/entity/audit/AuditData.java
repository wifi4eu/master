package wifi4eu.wifi4eu.entity.audit;

import javax.persistence.*;

@Entity
@Table(name="AUDIT_DATA_T")
public class AuditData {

    @Id
    @SequenceGenerator(name = "audit_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audit_seq")
    @Column(name="AUDIT_DATA_ID")
    Long auditDataId;

    @Column(name="REQUEST_ENDPOINT")
    String requestEndpoint;

    @Column(name="REQUEST_METHOD")
    String requestMethod;

    @Lob
    @Column(name="REQUEST_BODY")
    String requestBody;

    @Lob
    @Column(name="RESPONSE_BODY")
    String responseBody;

    @Column(name = "USER_ID")
    Long userId;

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
