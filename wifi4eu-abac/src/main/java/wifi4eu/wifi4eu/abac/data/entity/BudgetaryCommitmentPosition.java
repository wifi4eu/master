package wifi4eu.wifi4eu.abac.data.entity;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "WIF_BC_LEVEL2_POSITION")
public class BudgetaryCommitmentPosition {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bcposIDGenerator")
	@SequenceGenerator(name = "bcposIDGenerator", sequenceName = "SEQ_BC_LEVEL2_POSITION", allocationSize = 1)
	private Long id;

	@Column(name = "GLOBAL_COMMITMENT_L1_POS_KEY")
	private String globalCommitmentLevel1PositionKey;

	@Column(name = "COMMITMENT_L2_POSITION")
	private Integer commitmentLevel2Position;

	@Column(name = "COMMITMENT_L2_AMOUNT")
	private BigDecimal commitmentLevel2Amount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BUDGETARY_COMMITMENT_ID")
	private BudgetaryCommitment budgetaryCommitment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BudgetaryCommitment getBudgetaryCommitment() {
		return budgetaryCommitment;
	}

	public void setBudgetaryCommitment(BudgetaryCommitment budgetaryCommitment) {
		this.budgetaryCommitment = budgetaryCommitment;
	}
}