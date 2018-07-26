package wifi4eu.wifi4eu.common.enums;

public enum UserHistoryActionList {

    SUPPORTING_DOCUMENTS_UPLOADED("benefPortal.myHistory.actionPerformed.supportingDocumentsUploaded"),
    APPLICATION_SUBMITTED("benefPortal.myHistory.actionPerformed.applicationSubmitted");

    private String actionPerformed;

    UserHistoryActionList(String actionPerformed) {
        this.actionPerformed = actionPerformed;
    }

    public String getActionPerformed() {
        return actionPerformed;
    }
}