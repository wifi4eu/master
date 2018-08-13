package wifi4eu.wifi4eu.abac.data.entity;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

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

	@Column(name = "GLOBAL_COMMITMENT_L1_POS_KEY")
	private String globalCommitmentLevel1PositionKey;

	@Column(name = "COMMITMENT_L2_POSITION")
	private Integer commitmentLevel2Position;

	@Column(name = "COMMITMENT_L2_AMOUNT")
	private BigDecimal commitmentLevel2Amount;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEGAL_ENTITY_ID")
	private LegalEntity legalEntity;

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

	public String getGlobalCommitmentLevel1PositionKey() {
		return globalCommitmentLevel1PositionKey;
	}

	public void setGlobalCommitmentLevel1PositionKey(String globalCommitmentLevel1PositionKey) {
		this.globalCommitmentLevel1PositionKey = globalCommitmentLevel1PositionKey;
	}

	public Integer getCommitmentLevel2Position() {
		return commitmentLevel2Position;
	}

	public void setCommitmentLevel2Position(Integer commitmentLevel2Position) {
		this.commitmentLevel2Position = commitmentLevel2Position;
	}

	public BigDecimal getCommitmentLevel2Amount() {
		return commitmentLevel2Amount;
	}

	public void setCommitmentLevel2Amount(BigDecimal commitmentLevel2Amount) {
		this.commitmentLevel2Amount = commitmentLevel2Amount;
	}

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}
}