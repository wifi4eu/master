import {Component} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {NutsApi} from "../../swagger/api/NutsApi";
import {NutsDTOBase} from "../../swagger/model/NutsDTO";

@Component({
    selector: 'helpdesk-form-component', templateUrl: 'helpdesk-form.component.html', providers: [NutsApi]
})
export class HelpdeskFormComponent {

    private expanded: boolean;
    private nuts: NutsDTOBase[];

    constructor(private uxService: UxService, private nutsApi: NutsApi) {
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
}
