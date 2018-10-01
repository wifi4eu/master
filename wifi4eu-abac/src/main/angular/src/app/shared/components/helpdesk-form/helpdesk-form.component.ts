import {Component, Input} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {HelpdeskApi} from "../../swagger/api/HelpdeskApi";
import {HelpdeskIssueDTO} from "../../swagger/model/HelpdeskIssueDTO";
import {NutsApi} from "../../swagger/api/NutsApi";
import {NutsDTOBase} from "../../swagger/model/NutsDTO";
import {ResponseDTO} from "../../swagger/model/ResponseDTO";

@Component({
    selector: 'helpdesk-form-component', templateUrl: 'helpdesk-form.component.html', providers: [NutsApi, HelpdeskApi]
})
export class HelpdeskFormComponent {
    private helpdeskIssue: HelpdeskIssueDTO;
    private expanded: boolean;
    private success: boolean;
    private nuts: NutsDTOBase[];
    @Input('portal') portal: string;

    constructor(private uxService: UxService, private nutsApi: NutsApi, private helpdeskApi: HelpdeskApi) {
        //this.helpdeskIssue = new HelpdeskDTOBase();
        this.expanded = false;
        this.expanded = false;
        this.nutsApi.findNutsByLevel(0).subscribe(
            nuts => {
                this.nuts = nuts;
            },
            error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get nuts, ignore this when NG is working in offline mode'
                });
                console.log('WARNING: Could not get nuts', error);
            }
        );
    }

    sendIssue() {
        this.helpdeskIssue.portal = this.portal;
        this.helpdeskIssue.createDate = new Date().getTime();
        this.helpdeskIssue.assignedTo = "Member State";
        //this.helpdeskIssue.status = "Pending";
        this.helpdeskIssue.status = 1;
        this.helpdeskApi.createHelpdeskIssue(this.helpdeskIssue).subscribe(
            (issue: ResponseDTO) => {
                if (issue.success) {
                    this.success = true;
                }
            }, error => {
                this.uxService.growl({
                    severity: 'error',
                    summary: 'ERROR',
                    detail: 'An error occurred when sending your issue. Please try again.'
                });
            }
        );
    }
}
