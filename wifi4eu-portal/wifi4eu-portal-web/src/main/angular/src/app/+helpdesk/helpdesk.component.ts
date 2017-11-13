import {Component} from "@angular/core";
import {HelpdeskIssueDTO, HelpdeskIssueDTOBase} from "../shared/swagger/model/HelpdeskIssueDTO";
import {HelpdeskissuesApi} from "../shared/swagger/api/HelpdeskissuesApi";

@Component({
    templateUrl: 'helpdesk.component.html', providers: [HelpdeskissuesApi]
})

export class HelpdeskComponent {
    private issues: HelpdeskIssueDTO[];
    private selectedIssues: HelpdeskIssueDTO[];
    private issueSelected: HelpdeskIssueDTOBase;
    private display: boolean;


    constructor(private helpdeskApi: HelpdeskissuesApi) {
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
        this.issueSelected = new HelpdeskIssueDTOBase();
        this.display = false;

    }

    viewIssueDetails(issue: HelpdeskIssueDTO, rowIndex: number) {
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
        this.helpdeskApi.getHelpdeskIssueById(this.issues[rowIndex].id).subscribe(helpdeskIssue => this.issueSelected = helpdeskIssue);
        var makeIssueSelectedCopy = this.issues.slice(0, this.issues.length);
        this.display = true;
    }

    resolveIssues() {
        for (var i = 0; i < this.selectedIssues.length; i++) {
            this.selectedIssues[i].status = 1;
            this.helpdeskApi.createHelpdeskIssue(this.selectedIssues[i]).subscribe();
        }
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
    }

    setAsResolved() {
        this.display = false;
        this.issueSelected.status = 1;
        this.helpdeskApi.createHelpdeskIssue(this.issueSelected).subscribe(
            data => {
                this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
            },
            error => {
                console.log(error);
            }
        );
        this.issueSelected = new HelpdeskIssueDTOBase();
    }

    keepAsPending() {
        this.display = false;
        this.issueSelected.status = 2;
        this.helpdeskApi.createHelpdeskIssue(this.issueSelected).subscribe(
            data => {
                this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
            },
            error => {
                console.log(error);
            }
        );
        this.issueSelected = new HelpdeskIssueDTOBase();
    }

    cancel() {
        this.display = false;
        this.issueSelected = new HelpdeskIssueDTOBase();
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
    }

}

