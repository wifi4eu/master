package wifi4eu.wifi4eu.common.enums;

public enum SupplierContactStatus {

    DEACTIVATED(-1);

    int status;

    SupplierContactStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
