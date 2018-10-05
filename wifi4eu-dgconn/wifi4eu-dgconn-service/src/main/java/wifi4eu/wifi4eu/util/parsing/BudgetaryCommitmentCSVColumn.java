package wifi4eu.wifi4eu.util.parsing;

public enum BudgetaryCommitmentCSVColumn {

    MUNICIPALITY_ID("mun_id"),

    GLOBAL_COMMITMENT_ABAC_KEY("abac_globalCommitmentLevel1positionkey"),

    COMMITMENT_LEVEL2_POSITION("abac_commitmentLevel2Position"),

    COMMITMENT_LEVEL2_POSITION_AMOUNT("abac_commitmentLevel2PositionAmount"),

    ABAC_STATUS("bc_abacStatus"),

    ABAC_MESSAGE("abac_Message"),

    COMMITMENT_LEVEL2_ABAC_KEY("abac_commitmentLevel2Key"),

    LAST_DAY_EXPORTED("bc_lastDateExported"),

    LAST_USER_EXPORTED("bc_lastUserExported");


    private String value;

    BudgetaryCommitmentCSVColumn(String value) {
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
