package wifi4eu.wifi4eu.common.enums;

public enum ApplicationStatus {
    HOLD(0),
    KO(1),
    OK(2);

    private int status;

    ApplicationStatus(int status) {
        this.status = status;
    }

    public int getValue() {
        return this.status;
    }
}