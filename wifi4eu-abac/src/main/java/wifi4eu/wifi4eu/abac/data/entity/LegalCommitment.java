package wifi4eu.wifi4eu.abac.data.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;
import javax.print.Doc;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.LegalCommitmentWorkflowStatus;

@Entity
@Table(name = "WIF_LEGAL_COMMITMENT")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "CREATE_LC_IN_ABAC",
		procedureName = "CREATE_LC_IN_ABAC",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "LEGAL_COMMITMENT_ID", type = Long.class)
		}),
	@NamedStoredProcedureQuery(name = "UPDATE_LC_STATUS_FROM_ABAC",
		procedureName = "UPDATE_LC_STATUS_FROM_ABAC")
})
public class LegalCommitment {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lcIDGenerator")
	@SequenceGenerator(name = "lcIDGenerator", sequenceName = "SEQ_LEGAL_COMMITMENT", allocationSize = 1)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEGAL_ENTITY_ID")
	private LegalEntity legalEntity;
	
	@Column(name = "abac_id")
	private Long abacId;
	
	@Column(name = "wf_status")
	@Enumerated(EnumType.STRING)
	private LegalCommitmentWorkflowStatus wfStatus;

	@Column(name = "date_created", length = 20)
	private Date dateCreated;
	
	@Column(name = "date_updated", length = 20)
	private Date dateUpdated;

	@OneToOne
	@JoinColumn(name="GRANT_AGREEMENT_DOC_ID")
	private Document grantAgreementDocument;

	@OneToOne
	@JoinColumn(name="COUNTERSIGNED_GRANT_AGR_DOC_ID")
	private Document counterSignedGrantAgreementDocument;

	@Column(name="GRANT_AGREEMENT_SIGNATURE_DATE")
	private Date grantAgreementSignatureDate;

	@Column(name="GRANT_AGREEMENT_CNTRSIGN_DATE")
	private Date grantAgreementCounterSignatureDate;

	public LegalCommitment() {
	}

	public LegalCommitment(Long id, LegalEntity legalEntity, Long abacId, LegalCommitmentWorkflowStatus wfStatus,
			String userImported, Date dateCreated, Date dateUpdated, Date countersignatureDate,
			Long idCountersignatureFile, String userCountersignatured) {
		super();
		this.id = id;
		this.legalEntity = legalEntity;
		this.abacId = abacId;
		this.wfStatus = wfStatus;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	@PrePersist
	protected void onCreate() {
		this.dateCreated = Calendar.getInstance().getTime();
		this.wfStatus = LegalCommitmentWorkflowStatus.READY_TO_BE_COUNTERSIGNED;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	public Long getAbacId() {
		return abacId;
	}

	public void setAbacId(Long abacId) {
		this.abacId = abacId;
	}

	public LegalCommitmentWorkflowStatus getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(LegalCommitmentWorkflowStatus wfStatus) {
		this.wfStatus = wfStatus;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Document getGrantAgreementDocument() {
		return grantAgreementDocument;
	}

	public void setGrantAgreementDocument(Document grantAgreementDocument) {
		this.grantAgreementDocument = grantAgreementDocument;
	}

	public Document getCounterSignedGrantAgreementDocument() {
		return counterSignedGrantAgreementDocument;
	}

	public void setCounterSignedGrantAgreementDocument(Document counterSignedGrantAgreementDocument) {
		this.counterSignedGrantAgreementDocument = counterSignedGrantAgreementDocument;
	}

	public Date getGrantAgreementSignatureDate() {
		return grantAgreementSignatureDate;
	}

	public void setGrantAgreementSignatureDate(Date grantAgreementSignatureDate) {
		this.grantAgreementSignatureDate = grantAgreementSignatureDate;
	}

	public Date getGrantAgreementCounterSignatureDate() {
		return grantAgreementCounterSignatureDate;
	}

	public void setGrantAgreementCounterSignatureDate(Date grantAgreementCounterSignatureDate) {
		this.grantAgreementCounterSignatureDate = grantAgreementCounterSignatureDate;
	}

	@Override
	public String toString() {
		return "LegalCommitment [id=" + id + ", legalEntity=" + legalEntity + ", abacId=" + abacId + ", wfStatus="
				+ wfStatus + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}
}