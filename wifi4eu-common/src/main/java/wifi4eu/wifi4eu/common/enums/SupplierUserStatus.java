package wifi4eu.wifi4eu.common.enums;

public enum SupplierUserStatus {
    NOT_REGISTERED(0),
    ALREADY_REGISTERED(1),
    DEACTIVATED(2),
    DELETED(3);

    int status;

    SupplierUserStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
