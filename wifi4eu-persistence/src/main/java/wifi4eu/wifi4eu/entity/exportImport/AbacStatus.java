package wifi4eu.wifi4eu.entity.exportImport;

public enum AbacStatus {

    ABAC_VALID("ABAC_VALID"),

    REJECTED("REJECTED"),

    ABAC_ERROR("ABAC_ERROR"),

    IMPORTED("IMPORTED"),

    UNKNOWN("UNKNOWN");

    private String value;

    AbacStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AbacStatus fromValue(final String value) {
        AbacStatus parsedStatus = UNKNOWN;
        if (value != null) {
            for (AbacStatus checkedValue : values()) {
                if (value.equalsIgnoreCase(checkedValue.value)) {
                    parsedStatus = checkedValue;
                    break;
                }
            }
        }
        return parsedStatus;
    }

}
