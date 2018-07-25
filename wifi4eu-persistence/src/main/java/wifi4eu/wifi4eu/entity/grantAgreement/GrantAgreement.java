package wifi4eu.wifi4eu.entity.grantAgreement;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "grant_agreement")
public class GrantAgreement {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "signature_id")
    private String signatureId;

    @Column(name = "counter_signature_id")
    private String counterSignatureId;

    @Column(name = "signature_proof")
    private String signatureProof;

    @Column(name = "application_id")
    private Integer applicationId;

    @Column(name = "date_signature")
    private Date dateSignature;

    @Column(name = "date_counter_signature")
    private Date dateCounterSignature;

    @Column(name = "document_location")
    private String document_location;

    public GrantAgreement() {
    }

    public GrantAgreement(Integer id, String signatureId, String counterSignatureId, String signatureProof, Integer applicationId, Date dateSignature, Date dateCounterSignature, String document_location) {
        this.id = id;
        this.signatureId = signatureId;
        this.counterSignatureId = counterSignatureId;
        this.signatureProof = signatureProof;
        this.applicationId = applicationId;
        this.dateSignature = dateSignature;
        this.dateCounterSignature = dateCounterSignature;
        this.document_location = document_location;
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

    public String getDocument_location() {
        return document_location;
    }

    public void setDocument_location(String document_location) {
        this.document_location = document_location;
    }
}
