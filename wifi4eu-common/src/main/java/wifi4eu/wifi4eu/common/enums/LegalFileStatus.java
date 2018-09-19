package wifi4eu.wifi4eu.common.enums;

public enum LegalFileStatus {
    UNTOUCHED(0),
    CORRECTION_REQUESTED(1),
    VALID(2),
    INVALID(3);

    private int status;

    LegalFileStatus(int status) {
        this.status = status;
    }

    public int getValue() {
        return this.status;
    }
}
