package wifi4eu.wifi4eu.abac.data.dto;

import java.math.BigDecimal;

public class BudgetaryCommitmentCSVRow {

	private Long municipalityPortalId;
	private String abacGlobalCommitmentLevel1PositionKey;
	private Integer abacCommitmentLevel2Position;
	private BigDecimal abacCommitmentLevel2PositionAmount;

	public Long getMunicipalityPortalId() {
		return municipalityPortalId;
	}

	public void setMunicipalityPortalId(Long municipalityPortalId) {
		this.municipalityPortalId = municipalityPortalId;
	}

	public String getAbacGlobalCommitmentLevel1PositionKey() {
		return abacGlobalCommitmentLevel1PositionKey;
	}

	public void setAbacGlobalCommitmentLevel1PositionKey(String abacGlobalCommitmentLevel1PositionKey) {
		this.abacGlobalCommitmentLevel1PositionKey = abacGlobalCommitmentLevel1PositionKey;
	}

	public Integer getAbacCommitmentLevel2Position() {
		return abacCommitmentLevel2Position;
	}

	public void setAbacCommitmentLevel2Position(Integer abacCommitmentLevel2Position) {
		this.abacCommitmentLevel2Position = abacCommitmentLevel2Position;
	}

	public BigDecimal getAbacGlobalCommitmentPositionAmmount() {
		return abacCommitmentLevel2PositionAmount;
	}

	public void setAbacCommitmentLevel2PositionAmount(BigDecimal abacCommitmentLevel2PositionAmount) {
		this.abacCommitmentLevel2PositionAmount = abacCommitmentLevel2PositionAmount;
	}
}
