import {Component, Input} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {HelpdeskissuesApi} from "../../swagger/api/HelpdeskissuesApi";
import {HelpdeskIssueDTO, HelpdeskIssueDTOBase} from "../../swagger/model/HelpdeskIssueDTO";
import {NutsApi} from "../../swagger/api/NutsApi";
import {NutsDTOBase} from "../../swagger/model/NutsDTO";
import {ResponseDTO} from "../../swagger/model/ResponseDTO";

@Component({
    selector: 'helpdesk-form-component',
    templateUrl: 'helpdesk-form.component.html',
    providers: [NutsApi, HelpdeskissuesApi]
})
export class HelpdeskFormComponent {
    private helpdeskIssue: HelpdeskIssueDTO;
    private expanded: boolean;
    private success: boolean;
    private nuts: NutsDTOBase[];
    @Input('portal') portal: string;
    private emailPattern = new RegExp(/^[a-z0-9_-]+(?:\.[a-z0-9_-]+)*@(?:[a-z0-9]{2,6}?\.)+[a-z0-9]{2,6}?$/i);

    constructor(private uxService: UxService, private nutsApi: NutsApi, private helpdeskApi: HelpdeskissuesApi) {
        this.helpdeskIssue = new HelpdeskIssueDTOBase();
        this.expanded = false;
        this.expanded = false;
        this.nutsApi.getNutsByLevel(0).subscribe(
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
        this.helpdeskIssue.createDate = Date.now();
        this.helpdeskIssue.assignedTo = "Member State";
        this.helpdeskIssue.status = 0;
        this.helpdeskApi.createHelpdeskIssue(this.helpdeskIssue).subscribe(
            (issue: ResponseDTO) => {
                if (issue.success) {
                    this.success = true;
                    this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                        detail: 'Your message was successfully sent.'
                    });
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
