import {Component} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {HelpdeskApi} from "../../swagger/api/HelpdeskApi";
import {HelpdeskDTO, HelpdeskDTOBase} from "../../swagger/model/HelpdeskDTO";
import {NutsApi} from "../../swagger/api/NutsApi";
import {NutsDTOBase} from "../../swagger/model/NutsDTO";

@Component({
    selector: 'helpdesk-form-component', templateUrl: 'helpdesk-form.component.html', providers: [NutsApi, HelpdeskApi]
})
export class HelpdeskFormComponent {
    private helpdeskIssue: HelpdeskDTO;
    private expanded: boolean;
    private nuts: NutsDTOBase[];

    constructor(private uxService: UxService, private nutsApi: NutsApi, private helpdeskApi: HelpdeskApi) {
        this.helpdeskIssue = new HelpdeskDTOBase();
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
        console.log(this.helpdeskIssue);
        this.helpdeskIssue.portal = "Beneficiary";
        this.helpdeskIssue.date = new Date();
        this.helpdeskIssue.assignedTo = "Member State";
        this.helpdeskIssue.status = "Pending";
        this.helpdeskApi.createHelpdeskIssue(this.helpdeskIssue).subscribe();
    }
}
