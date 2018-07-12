package wifi4eu.wifi4eu.common.enums;

public enum SupplierUserType {

    INVITED(0),
    MAIN(1);

    int type;

    SupplierUserType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
