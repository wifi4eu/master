package wifi4eu.wifi4eu.util;

public enum AdminAction {

    PRE_SELECT_LIST("pre_select_list");

    private String value;

    AdminAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}