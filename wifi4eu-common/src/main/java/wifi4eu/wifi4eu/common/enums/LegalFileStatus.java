package wifi4eu.wifi4eu.common.enums;

public enum LegalFileStatus {
    OLD(0),
    RECENT(1),
    NEW(2);

    private int isNew;

    LegalFileStatus(int isNew) {
        this.isNew = isNew;
    }

    public int getValue() {
        return this.isNew;
    }
}
