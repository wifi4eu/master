package wifi4eu.wifi4eu.abac.data.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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
	
	@Column(name = "abac_key")
	private String abacKey;
	
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

	@Column(name = "BATCH_REF", length = 50)
	private String batchRef;

	@OneToMany(mappedBy = "legalCommitment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OrderBy("submitDate DESC")
	private List<LegalCommitmentAbacRequest> abacRequests = new ArrayList<LegalCommitmentAbacRequest>();

	@Column(name = "GRANT_AGREEMENT_CNTRSIGN_USER")
	private String grantAgreementCounterSignatureUser;

	public LegalCommitment() {
	}

	@PrePersist
	protected void onCreate() {
		this.dateCreated = Calendar.getInstance().getTime();

		if (legalEntity.getBudgetaryCommitment() != null && legalEntity.getBudgetaryCommitment().getWfStatus().equals(AbacWorkflowStatus.ABAC_VALID)) {
			this.wfStatus = LegalCommitmentWorkflowStatus.READY_TO_BE_COUNTERSIGNED;
		} else {
			this.wfStatus = LegalCommitmentWorkflowStatus.IMPORTED;
		}
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

	public String getAbacKey() {
		return abacKey;
	}

	public void setAbacKey(String abacKey) {
		this.abacKey = abacKey;
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

	public String getBatchRef() {
		return batchRef;
	}

	public void setBatchRef(String batchRef) {
		this.batchRef = batchRef;
	}

	public String getAbacErrorMessage() {
		return !abacRequests.isEmpty() ? abacRequests.get(0).getErrorMessage() : null;
	}

	public String getGrantAgreementCounterSignatureUser() {
		return grantAgreementCounterSignatureUser;
	}

	public void setGrantAgreementCounterSignatureUser(String grantAgreementCounterSignatureUser) {
		this.grantAgreementCounterSignatureUser = grantAgreementCounterSignatureUser;
	}

	@Override
	public String toString() {
		return "LegalCommitment [id=" + id + ", legalEntity=" + legalEntity + ", abacKey=" + abacKey + ", wfStatus="
				+ wfStatus + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}
}