package wifi4eu.wifi4eu.common.enums;

public enum SelectionStatus {
    MAIN_LIST(0),
    RESERVE_LIST(1),
    REJECTED(2),
    SELECTED(3);

    private int status;

    SelectionStatus(int status) {
        this.status = status;
    }

    public int getValue() {
        return this.status;
    }
}