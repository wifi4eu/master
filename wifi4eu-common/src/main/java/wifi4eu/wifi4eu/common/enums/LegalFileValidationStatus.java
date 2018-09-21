package wifi4eu.wifi4eu.common.enums;

public enum LegalFileValidationStatus {
    UNTOUCHED(0),
    INVALID(1),
    VALID(2);

    private int status;

    LegalFileValidationStatus(int status) {
        this.status = status;
    }

    public int getValue() {
        return this.status;
    }
}
