import {Component} from "@angular/core";
import {HelpdeskDTO, HelpdeskDTOBase} from '../shared/swagger/model/HelpdeskDTO';
import {HelpdeskApi} from '../shared/swagger/api/HelpdeskApi'

@Component({
    templateUrl: 'helpdesk.component.html', providers: [HelpdeskApi]
})

export class HelpdeskComponent {
    private issues: HelpdeskDTOBase[];
    private selectedIssues: HelpdeskDTOBase[];
    private issueSelected: HelpdeskDTOBase;
    private issueSelectedOriginal: HelpdeskDTOBase;
    private display: boolean;

    constructor(private helpdeskApi: HelpdeskApi) {
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
        this.issueSelected = new HelpdeskDTOBase();
        this.display = false;
    }

    viewIssueDetails(issue: HelpdeskDTOBase, rowIndex: number) {
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
        this.helpdeskApi.getHelpdeskIssue(this.issues[rowIndex].issueId).subscribe(helpdeskIssue => this.issueSelected = helpdeskIssue);
        this.makeIssueSelectedCopy(this.issueSelected);
        this.display = true;
    }

    resolveIssues() {
        for (var i = 0; i < this.selectedIssues.length; i++) {
            this.selectedIssues[i].status = "Resolved";
            this.helpdeskApi.createHelpdeskIssue(this.selectedIssues[i]).subscribe();
        }
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
    }

    setAsResolved() {
        this.display = false;
        this.issueSelected.status = "Resolved";
        this.helpdeskApi.createHelpdeskIssue(this.issueSelected).subscribe();
        this.issueSelected = new HelpdeskDTOBase();
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
    }

    keepAsPending() {
        this.display = false;
        this.issueSelected.status = "Pending";
        this.helpdeskApi.createHelpdeskIssue(this.issueSelected).subscribe();
        this.issueSelected = new HelpdeskDTOBase();
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
    }

    cancel() {
        this.display = false;
        this.issueSelected = new HelpdeskDTOBase();
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
    }

    makeIssueSelectedCopy(issue: HelpdeskDTOBase) {
        this.issueSelectedOriginal = new HelpdeskDTOBase();
        this.issueSelectedOriginal.issueId = issue.issueId;
        this.issueSelectedOriginal.portal = issue.portal;
        this.issueSelectedOriginal.topic = issue.topic;
        this.issueSelectedOriginal.memberState = issue.memberState;
        this.issueSelectedOriginal.date = issue.date;
        this.issueSelectedOriginal.assignedTo = issue.assignedTo;
        this.issueSelectedOriginal.status = issue.status;
        this.issueSelectedOriginal.from = issue.from;
        this.issueSelectedOriginal.issueSummary = issue.issueSummary;
        this.issueSelectedOriginal.memberStateComments = issue.memberStateComments;
        this.issueSelectedOriginal.dgConnectComments = issue.dgConnectComments;
    }

    formatTimestamp(timestamp) {
        let date = new Date(timestamp);
        return date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear() + " " + date.getHours() + ":" + ((date.getMinutes() < 10) ? ("0" + date.getMinutes()) : date.getMinutes());
    }
}

