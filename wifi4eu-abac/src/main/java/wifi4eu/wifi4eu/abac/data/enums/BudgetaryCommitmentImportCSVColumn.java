package wifi4eu.wifi4eu.abac.data.enums;

public enum BudgetaryCommitmentImportCSVColumn {

	MUNICIPALITY_PORTAL_ID("mun_id"),
	ABAC_GLOBAL_COMMITMENT_KEY("abac_globalCommitmentKey"),
	ABAC_GLOBAL_COMMITMENT_POSITION("abac_globalCommitmentPosition"),
	ABAC_GLOBAL_COMMITMENT_POSITION_AMOUNT("abac_globalCommitmentPositionAmmount"),
	ABAC_BUDGETARY_COMMITMENT_AMOUNT("abac_bugetaryCommitmentAmount");

	private String value;

	private BudgetaryCommitmentImportCSVColumn(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return getValue();
	}
}
