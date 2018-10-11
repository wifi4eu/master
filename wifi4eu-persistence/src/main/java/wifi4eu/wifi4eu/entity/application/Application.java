package wifi4eu.wifi4eu.entity.application;

import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.entity.registration.Registration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "call_id")
    private Integer callId;

    @Column(name = "supplier")
    private Integer supplierId;

    @Column(name = "voucher_awarded")
    private boolean voucherAwarded;

    @Column(name = "date")
    private Long date;

    @Column(name = "lef_export")
    private Long lefExport;

    @Column(name = "lef_import")
    private Long lefImport;

    @Column(name = "lef_status")
    private Integer lefStatus;

    @Column(name = "bc_export")
    private Long bcExport;

    @Column(name = "bc_import")
    private Long bcImport;

    @Column(name = "bc_status")
    private Integer bcStatus;

    @Column(name = "lc_export")
    private Long lcExport;

    @Column(name = "lc_import")
    private Long lcImport;

    @Column(name = "lc_status")
    private Integer lcStatus;

    @Column(name = "_status")
    private int status;

    @Column(name = "invalidate_reason")
    private String invalidateReason;

    @Column(name = "cancel_reason")
    private String cancelReason;

    @Column(name = "pre_selected_flag")
    private Boolean preSelectedFlag;

    @Column(name = "rejected")
    private Boolean rejected;

    @Column(name = "authorized_person")
    private Integer authorizedPerson;

    @Column(name = "date_signature")
    private Date dateSignature;

    @Column(name = "date_counter_signature")
    private Date dateCounterSignature;

    @Column(name = "sent_email")
    private boolean sentEmail;

    @Column(name = "sent_email_date")
    private Date sentEmailDate;

    @ManyToOne
    @JoinColumn(name = "registration")
    private Registration registration;

    @Column(name = "registration", insertable = false, updatable = false)
    private Integer registrationId;

    @OneToMany(mappedBy = "application")
    private List<GrantAgreement> grantAgreements;


//    @Column(name = "sent_email_date")
//    private Date sentEmailDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCallId() {
        return callId;
    }

    public void setCallId(Integer callId) {
        this.callId = callId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public boolean isVoucherAwarded() {
        return voucherAwarded;
    }

    public void setVoucherAwarded(boolean voucherAwarded) {
        this.voucherAwarded = voucherAwarded;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getLefExport() {
        return lefExport;
    }

    public void setLefExport(Long lefExport) {
        this.lefExport = lefExport;
    }

    public Long getLefImport() {
        return lefImport;
    }

    public void setLefImport(Long lefImport) {
        this.lefImport = lefImport;
    }

    public Integer getLefStatus() {
        return lefStatus;
    }

    public void setLefStatus(Integer lefStatus) {
        this.lefStatus = lefStatus;
    }

    public Long getBcExport() {
        return bcExport;
    }

    public void setBcExport(Long bcExport) {
        this.bcExport = bcExport;
    }

    public Long getBcImport() {
        return bcImport;
    }

    public void setBcImport(Long bcImport) {
        this.bcImport = bcImport;
    }

    public Integer getBcStatus() {
        return bcStatus;
    }

    public void setBcStatus(Integer bcStatus) {
        this.bcStatus = bcStatus;
    }

    public Long getLcExport() {
        return lcExport;
    }

    public void setLcExport(Long lcExport) {
        this.lcExport = lcExport;
    }

    public Long getLcImport() {
        return lcImport;
    }

    public void setLcImport(Long lcImport) {
        this.lcImport = lcImport;
    }

    public Integer getLcStatus() {
        return lcStatus;
    }

    public void setLcStatus(Integer lcStatus) {
        this.lcStatus = lcStatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInvalidateReason() {
        return invalidateReason;
    }

    public void setInvalidateReason(String invalidateReason) {
        this.invalidateReason = invalidateReason;
    }

    public String getCanceledReason() {
        return cancelReason;
    }

    public void setCanceledReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Boolean getPreSelectedFlag() {
        return preSelectedFlag;
    }

    public void setPreSelectedFlag(Boolean preSelectedFlag) {
        this.preSelectedFlag = preSelectedFlag;
    }

    public Boolean getRejected() {
        return rejected;
    }

    public void setRejected(Boolean rejected) {
        this.rejected = rejected;
    }

    public Integer getAuthorizedPerson() {
        return authorizedPerson;
    }

    public void setAuthorizedPerson(Integer authorizedPerson) {
        this.authorizedPerson = authorizedPerson;
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

    public boolean isSentEmail() {
        return sentEmail;
    }

    public void setSentEmail(boolean sentEmail) {
        this.sentEmail = sentEmail;
    }

    public Date getSentEmailDate() {
        return sentEmailDate;
    }

    public void setSentEmailDate(Date sentEmailDate) {
        this.sentEmailDate = sentEmailDate;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public void setRegistrationId(Integer registrationId){
        this.registrationId = registrationId;
    }
    // @Deprecated
    public Integer getRegistrationId() {
        return registrationId;
    }

    public List<GrantAgreement> getGrantAgreements() {
        if (grantAgreements == null) {
            grantAgreements = new ArrayList<>(0);
        }
        return grantAgreements;
    }

    public void setGrantAgreements(List<GrantAgreement> grantAgreements) {
        this.grantAgreements = grantAgreements;
    }

    public interface ApplicationApplyEmail {
        Integer getId();
        Integer getRegistrationId();
    }

}