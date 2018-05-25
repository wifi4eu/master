package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;

public class HelpdeskIssueValidator {

    private static final String MEMBER_STATE = "Member State";
    private static final String WIFI4EU = "WiFi4EU";

    public static void validateHelpdeskIssue(HelpdeskIssueDTO helpdeskIssue) throws Exception {

        if(!helpdeskIssue.getAssignedTo().equals(MEMBER_STATE)){
            throw new Exception("Invalid assigned to Issue");
        }
        if(!helpdeskIssue.getSummary().contains(MEMBER_STATE)){
            throw new Exception("Invalid summary Issue");
        }

    }
}
