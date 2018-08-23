package wifi4eu.wifi4eu.abac.data.entity;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "WIF_BUDGETARY_COMMITMENT")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "CREATE_BC_IN_ABAC",
				procedureName = "CREATE_BC_IN_ABAC",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "LEGALENTITYID", type = Long.class)
				}),
		@NamedStoredProcedureQuery(name = "UPDATE_BC_STATUS_FROM_ABAC",
				procedureName = "UPDATE_BC_STATUS_FROM_ABAC")
})
public class BudgetaryCommitment {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bcIDGenerator")
	@SequenceGenerator(name = "bcIDGenerator", sequenceName = "SEQ_BUDGETARY_COMMITMENT", allocationSize = 1)
	private Long id;

	@Column(name = "wf_status")
	@Enumerated(EnumType.STRING)
	private AbacWorkflowStatus wfStatus;

	@Column(name = "date_created")
	private Date dateCreated;

	@Column(name = "date_updated")
	private Date dateUpdated;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEGAL_ENTITY_ID")
	private LegalEntity legalEntity;

	@OneToMany(mappedBy = "budgetaryCommitment", fetch = FetchType.LAZY)
	private List<BudgetaryCommitmentPosition> positions;

	@OneToMany(mappedBy = "budgetaryCommitment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OrderBy("submitDate DESC")
	private List<BudgetaryCommitmentAbacRequest> abacRequests = new ArrayList<BudgetaryCommitmentAbacRequest>();

	@Column(name = "COMMITMENT_L2_KEY")
	private String commitmentLevel2Key;

	@Column(name = "BATCH_REF", length = 50)
	private String batchRef;

	@PrePersist
	protected void onCreate() {
		this.dateCreated = Calendar.getInstance().getTime();
		this.wfStatus = AbacWorkflowStatus.READY_FOR_ABAC;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AbacWorkflowStatus getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(AbacWorkflowStatus wfStatus) {
		this.wfStatus = wfStatus;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public List<BudgetaryCommitmentPosition> getPositions() {
		return positions;
	}

	public void setPositions(List<BudgetaryCommitmentPosition> positions) {
		this.positions = positions;
	}

	public List<BudgetaryCommitmentAbacRequest> getAbacRequests() {
		return abacRequests;
	}

	public void setAbacRequests(List<BudgetaryCommitmentAbacRequest> abacRequests) {
		this.abacRequests = abacRequests;
	}

	public String getAbacErrorMessage(){
		return !abacRequests.isEmpty() ? abacRequests.get(0).getErrorMessage() : null;
	}

	public String getCommitmentLevel2Key() {return commitmentLevel2Key;	}

	public void setCommitmentLevel2Key(String commitmentLevel2Key) {this.commitmentLevel2Key = commitmentLevel2Key;	}

	public String getBatchRef() {
		return batchRef;
	}

	public void setBatchRef(String batchRef) {
		this.batchRef = batchRef;
	}
}