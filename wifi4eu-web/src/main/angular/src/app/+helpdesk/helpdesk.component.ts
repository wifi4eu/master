import {Component} from "@angular/core";
import {HelpdeskIssue} from "../shared/models/helpdesk-issue-details.model";

@Component({
    templateUrl: 'helpdesk.component.html'
})

export class HelpdeskComponent {
    private issues: HelpdeskIssue[];
    private selectedIssues: HelpdeskIssue[];
    private issueSelected: HelpdeskIssue;
    private issueSelectedOriginal: HelpdeskIssue;
    private issueIndex: number;
    private display: boolean;

    constructor() {
        this.issues = [
            new HelpdeskIssue("Supplier", "Password", "Austria", "12/12/2017", "00:00", "DG Connect", "Resolved", "john.smith@mail.com", "Hi, I can't login as a mayor into Beneficiary portal with my temporary password that you sent on my email address. Thanks.", "", ""),
            new HelpdeskIssue("Supplier", "Login", "Austria", "12/12/2017", "00:00", "Member State", "Resolved", "doomguy@idsoftware.com", "Gonna get mine, get outta my way!", "it's gonna be", "gonna be"),
            new HelpdeskIssue("Beneficiary", "Registration", "Austria", "12/12/2017", "00:00", "DG Connect", "Pending"),
            new HelpdeskIssue("Member State", "Approval", "Austria", "12/12/2017", "00:00", "Member State", "Pending"),
            new HelpdeskIssue("Beneficiary", "Login", "Austria", "12/12/2017", "00:00", "DG Connect", "Resolved"),
            new HelpdeskIssue("Beneficiary", "Registration", "Austria", "12/12/2017", "00:00", "DG Connect", "Resolved"),
            new HelpdeskIssue("Supplier", "Password", "Austria", "12/12/2017", "00:00", "DG Connect", "Pending"),
            new HelpdeskIssue("Supplier", "Password", "Austria", "12/12/2017", "00:00", "Member State", "Pending")
        ];
        this.issueSelected = new HelpdeskIssue();
        this.display = false;
    }

    viewIssueDetails(issue: HelpdeskIssue, rowIndex: number) {
        this.issueIndex = rowIndex;
        this.issueSelected = issue;
        this.makeIssueSelectedCopy(issue);
        this.display = true;
    }

    resolveIssues() {
        for (var i = 0; i < this.selectedIssues.length; i++) {
            this.selectedIssues[i].setStatus("Resolved");
        }
    }

    setAsResolved() {
        this.display = false;
        this.issueSelected.setStatus("Resolved");
        this.issues[this.issueIndex] = this.issueSelected;
        this.issueSelected = new HelpdeskIssue();
    }

    keepAsPending() {
        this.display = false;
        this.issueSelected.setStatus("Pending");
        this.issues[this.issueIndex] = this.issueSelected;
        this.issueSelected = new HelpdeskIssue();
    }

    cancel() {
        this.display = false;
        this.issues[this.issueIndex] = this.issueSelectedOriginal;
        this.issueSelected = new HelpdeskIssue();
    }

    makeIssueSelectedCopy(issue: HelpdeskIssue) {
        this.issueSelectedOriginal = new HelpdeskIssue(issue.getPortal(), issue.getTopic(), issue.getMemberState(), issue.getDate(), issue.getTime(), issue.getAssignedTo(), issue.getStatus(), issue.getFrom(), issue.getIssueSummary(), issue.getMemberStateComments(), issue.getDgConnectComments());
    }
}

