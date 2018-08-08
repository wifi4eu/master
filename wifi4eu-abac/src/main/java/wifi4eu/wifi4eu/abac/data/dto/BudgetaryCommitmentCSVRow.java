package wifi4eu.wifi4eu.abac.data.dto;

import wifi4eu.wifi4eu.abac.data.enums.DocumentType;

import java.math.BigDecimal;
import java.util.Date;

public class BudgetaryCommitmentCSVRow {

	private Long municipalityPortalId;
	private String abac_globalCommitmentKey;
	private Integer abacGlobalCommitmentPosition;
	private BigDecimal abacGlobalCommitmentPositionAmount;
	private BigDecimal abacBugetaryCommitmentAmount;

	public Long getMunicipalityPortalId() {
		return municipalityPortalId;
	}

	public void setMunicipalityPortalId(Long municipalityPortalId) {
		this.municipalityPortalId = municipalityPortalId;
	}

	public String getAbac_globalCommitmentKey() {
		return abac_globalCommitmentKey;
	}

	public void setAbac_globalCommitmentKey(String abac_globalCommitmentKey) {
		this.abac_globalCommitmentKey = abac_globalCommitmentKey;
	}

	public Integer getAbacGlobalCommitmentPosition() {
		return abacGlobalCommitmentPosition;
	}

	public void setAbacGlobalCommitmentPosition(Integer abacGlobalCommitmentPosition) {
		this.abacGlobalCommitmentPosition = abacGlobalCommitmentPosition;
	}

	public BigDecimal getAbacGlobalCommitmentPositionAmmount() {
		return abacGlobalCommitmentPositionAmount;
	}

	public void setAbacGlobalCommitmentPositionAmount(BigDecimal abacGlobalCommitmentPositionAmount) {
		this.abacGlobalCommitmentPositionAmount = abacGlobalCommitmentPositionAmount;
	}

	public BigDecimal getAbacBugetaryCommitmentAmount() {
		return abacBugetaryCommitmentAmount;
	}

	public void setAbacBugetaryCommitmentAmount(BigDecimal abacBugetaryCommitmentAmount) {
		this.abacBugetaryCommitmentAmount = abacBugetaryCommitmentAmount;
	}
}
