package wifi4eu.wifi4eu.entity.audit;

import javax.persistence.*;

@Entity
@Table(name = "AUDIT_DATA_T")
public class AuditData {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "REQUEST_ENDPOINT")
    private String requestEndpoint;

    @Column(name = "REQUEST_METHOD")
    private String requestMethod;

    @Lob
    @Column(name = "REQUEST_BODY")
    private String requestBody;

    @Lob
    @Column(name = "RESPONSE_BODY")
    private String responseBody;

    @Column(name = "USER_ID")
    private Long userId;

    public AuditData() {
    }

    public AuditData(Integer id, String requestEndpoint, String requestMethod, String requestBody, String responseBody, Long userId) {
        this.id = id;
        this.requestEndpoint = requestEndpoint;
        this.requestMethod = requestMethod;
        this.requestBody = requestBody;
        this.responseBody = responseBody;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
