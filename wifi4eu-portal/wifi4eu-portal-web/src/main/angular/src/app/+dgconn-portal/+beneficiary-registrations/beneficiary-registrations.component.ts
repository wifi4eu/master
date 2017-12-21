import {Component, Input, IterableDifferFactory} from "@angular/core";
import {RegistrationApi} from "../../shared/swagger/api/registrationApi";


@Component({
    templateUrl: 'beneficiary-registrations.component.html', providers: [RegistrationApi]
})

export class DgConnBeneficiaryRegistrationsComponent {

    constructor(private registrationApi: RegistrationApi) {
        this.registrationApi.getAllGroupedRegistrations().subscribe( registrations => {
            console.log("DUPLICATES", registrations);
        })
    }
}