import {Component} from "@angular/core";
import {HelpdeskDTO, HelpdeskDTOBase} from "../shared/swagger/model/HelpdeskDTO";
import {HelpdeskApi} from "../shared/swagger/api/HelpdeskApi";

@Component({
    templateUrl: 'helpdesk.component.html', providers: [HelpdeskApi]
})

export class HelpdeskComponent {
    private issues: HelpdeskDTO[];
    private selectedIssues: HelpdeskDTO[];
    private issueSelected: HelpdeskDTOBase;
    private display: boolean;


    constructor(private helpdeskApi: HelpdeskApi) {
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
        this.issueSelected = new HelpdeskDTOBase();
        this.display = false;

    }

    viewIssueDetails(issue: HelpdeskDTO, rowIndex: number) {
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
        this.helpdeskApi.getHelpdeskIssue(this.issues[rowIndex].issueId).subscribe(helpdeskIssue => this.issueSelected = helpdeskIssue);
        var makeIssueSelectedCopy = this.issues.slice(0, this.issues.length);
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
        this.helpdeskApi.createHelpdeskIssue(this.issueSelected).subscribe(
            data => {
                this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
            },
            error => {
                console.log(error);
            }
        );
        this.issueSelected = new HelpdeskDTOBase();
    }

    keepAsPending() {
        this.display = false;
        this.issueSelected.status = "Pending";
        this.helpdeskApi.createHelpdeskIssue(this.issueSelected).subscribe(
            data => {
                this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
            },
            error => {
                console.log(error);
            }
        );
        this.issueSelected = new HelpdeskDTOBase();
    }

    cancel() {
        this.display = false;
        this.issueSelected = new HelpdeskDTOBase();
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
    }

}

