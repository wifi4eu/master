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
    private originalIssues: HelpdeskIssueDTO[];

    
    constructor(private helpdeskApi: HelpdeskissuesApi) {
        this.helpdeskApi.allHelpdeskIssues().subscribe(issues => {this.issues = issues; this.originalIssues = issues;});
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
            this.helpdeskApi.createHelpdeskIssue(this.selectedIssues[i]).subscribe(
              data => {
                this.helpdeskApi.allHelpdeskIssues().subscribe(issues => this.issues = issues);
              }
            );
        }
        
    }

    setAsResolved() {
        this.display = false;
        this.issueSelected.status = 1;
        this.helpdeskApi.createHelpdeskIssue(this.issueSelected).subscribe(
            data => {
                this.helpdeskApi.allHelpdeskIssues().subscribe(issues => {this.issues = issues; this.originalIssues = issues;});
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

    filterData(stringSearch: string) {
      if(typeof stringSearch != "undefined" && stringSearch != ""){
        stringSearch = stringSearch.toLocaleLowerCase();
        let helpdesksFiltered = this.originalIssues.map(
          (issue: HelpdeskIssueDTOBase) => {
            issue.portal = issue.portal || "";
            issue.assignedTo = issue.assignedTo || "";
            issue.topic = issue.topic || "";
            issue.memberState = issue.memberState || "";
            return issue;
          }
        ).filter(issue => {return (issue.portal.toLocaleLowerCase().match(stringSearch)  || issue.assignedTo.toLocaleLowerCase().match(stringSearch) || issue.topic.toLocaleLowerCase().match(stringSearch) || issue.memberState.match(stringSearch)) });
        this.issues = [...helpdesksFiltered];
      } else{
        this.issues = [...this.originalIssues];
      }    
    }

}

