package wifi4eu.wifi4eu.common.enums;

public enum VoucherAssignmentStatus {
    SIMULATION(1),
    PRE_LIST(2),
    FREEZE_LIST(3);

    private int status;

    VoucherAssignmentStatus(int status) {
        this.status = status;
    }

    public int getValue() {
        return this.status;
    }
}