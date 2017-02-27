import {Component} from "@angular/core";
import {CountryDetails} from "../../models/country-details.model";
import {EntityService} from "../../../+beneficiary-registration/+beneficiary-registration-step1/legal-entity.service";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";

@Component({
    selector: 'helpdesk-form-component', templateUrl: 'helpdesk-form.component.html', providers: [EntityService]
})
export class HelpdeskFormComponent {

    expanded: boolean = false;
    countries: CountryDetails[];

    constructor(private entityService: EntityService, private uxService: UxService) {
        this.entityService.getCountries().subscribe(countries => {
            this.countries = countries;
        }, error => {
            this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not get countries, ignore this when NG is working in offline mode'
            });
            console.log('WARNING: Could not get countries');
        });
    }
}
