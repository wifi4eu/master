package wifi4eu.wifi4eu.common.enums;

public enum RegistrationStatus {
    HOLD(0),
    KO(1),
    OK(2);

    private int status;

    RegistrationStatus(int status) {
        this.status = status;
    }

    public int getValue() {
        return this.status;
    }
}
