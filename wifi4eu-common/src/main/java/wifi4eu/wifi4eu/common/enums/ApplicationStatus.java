package wifi4eu.wifi4eu.common.enums;

public enum ApplicationStatus {
    HOLD(0),
    KO(1),
    OK(2),
    PENDING_FOLLOWUP(3),
    SELECTED(4),
    SIGNED(5),
    COUNTERSIGNED(6),
    CANCELLED(7);

    private int status;

    ApplicationStatus(int status) {
        this.status = status;
    }

    public int getValue() {
        return this.status;
    }
}