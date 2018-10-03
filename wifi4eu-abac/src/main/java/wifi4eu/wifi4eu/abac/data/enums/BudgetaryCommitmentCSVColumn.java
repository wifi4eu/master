package wifi4eu.wifi4eu.abac.data.enums;

public enum BudgetaryCommitmentCSVColumn {

	MUNICIPALITY_PORTAL_ID("mun_id"),
	ABAC_GLOBAL_COMMITMENT_LEVEL1_POSITION_KEY("abac_globalCommitmentLevel1PositionKey"),
	ABAC_COMMITMENT_LEVEL2_POSITION("abac_commitmentLevel2Position"),
	ABAC_COMMITMENT_LEVEL2_POSITION_AMOUNT("abac_commitmentLevel2PositionAmount"),
	ABAC_STATUS("bc_abacStatus"),
	ABAC_MESSAGE("abac_message"),
	ABAC_COMMITMENT_LEVEL2_KEY("abac_commitmentLevel2Key"),
	DATE_EXPORTED("bc_lastDateExported"),
	USER_EXPORTED("bc_lastUserExported"),
	BATCH_REFERENCE("bc_importBatchReference");

	private String value;

	private BudgetaryCommitmentCSVColumn(String value) {
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
