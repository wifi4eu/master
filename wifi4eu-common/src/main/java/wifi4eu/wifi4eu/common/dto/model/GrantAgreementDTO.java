package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.Date;

public class GrantAgreementDTO implements Serializable {
    private Integer id;
    private String signatureId;
    private String counterSignatureId;
    private String signatureProof;
    private Integer applicationId;
    private Date dateSignature;
    private Date dateCounterSignature;
    private String documentLocation;
    private String documentLocationCounterSigned;
    private String documentLanguage;

    public GrantAgreementDTO() {
    }

    public GrantAgreementDTO(Integer id, String signatureId, String counterSignatureId, String signatureProof, Integer applicationId, Date dateSignature, Date dateCounterSignature, String documentLocation, String documentLocationCounterSigned, String documentLanguage) {
        this.id = id;
        this.signatureId = signatureId;
        this.counterSignatureId = counterSignatureId;
        this.signatureProof = signatureProof;
        this.applicationId = applicationId;
        this.dateSignature = dateSignature;
        this.dateCounterSignature = dateCounterSignature;
        this.documentLocation = documentLocation;
        this.documentLocationCounterSigned = documentLocationCounterSigned;
        this.documentLanguage = documentLanguage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSignatureId() {
        return signatureId;
    }

    public void setSignatureId(String signatureId) {
        this.signatureId = signatureId;
    }

    public String getCounterSignatureId() {
        return counterSignatureId;
    }

    public void setCounterSignatureId(String counterSignatureId) {
        this.counterSignatureId = counterSignatureId;
    }

    public String getSignatureProof() {
        return signatureProof;
    }

    public void setSignatureProof(String signatureProof) {
        this.signatureProof = signatureProof;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }

    public Date getDateCounterSignature() {
        return dateCounterSignature;
    }

    public void setDateCounterSignature(Date dateCounterSignature) {
        this.dateCounterSignature = dateCounterSignature;
    }

    public String getDocumentLocation() {
        return documentLocation;
    }

    public void setDocumentLocation(String documentLocation) {
        this.documentLocation = documentLocation;
    }

    public String getDocumentLanguage() {
        return documentLanguage;
    }

    public void setDocumentLanguage(String documentLanguage) {
        this.documentLanguage = documentLanguage;
    }

    public String getDocumentLocationCounterSigned() {
        return documentLocationCounterSigned;
    }

    public void setDocumentLocationCounterSigned(String documentLocationCounterSigned) {
        this.documentLocationCounterSigned = documentLocationCounterSigned;
    }
}
