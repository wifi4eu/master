package wifi4eu.wifi4eu.common.utils;

import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;

import java.util.List;

public class HelpdeskIssueValidator {

    private static final String MEMBER_STATE = "Member State";
    private static final String WIFI4EU = "WiFi4EU";

    public static void validateHelpdeskIssue(HelpdeskIssueDTO helpdeskIssue, List<NutsDTO> nutsList) throws Exception {

        if(!helpdeskIssue.getAssignedTo().equals(MEMBER_STATE)){
            throw new Exception("Invalid assigned to Issue");
        }
        if(!helpdeskIssue.getSummary().contains(WIFI4EU)){
            throw new Exception("Invalid summary Issue");
        }
        if(helpdeskIssue.getStatus() != 0){
            throw new Exception("Invalid helpdesk Status");
        }
        Boolean nutsValidation = false;
        for(NutsDTO nuts : nutsList) {
            if (helpdeskIssue.getMemberState().equals(nuts.getLabel())) {
                nutsValidation = true;
                break;
            }
        }
        if(!nutsValidation) {
            throw new Exception("Invalid member state. Not found in nuts list");
        }

    }
}
