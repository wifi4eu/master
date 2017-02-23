import {Component, Input} from "@angular/core";
import {BeneficiaryDetails} from "../beneficiary-details.model";
import {EntityDetails} from "../../+entity/entity-details.model";
import {CountryDetails} from "../../+entity/country-details.model";
import {MunicipalityDetails} from "../../+entity/municipality-details.model";
import {ProfileService} from "./profile.service";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";

@Component({
    moduleId: module.id,
    selector: 'beneficiary-profile-component',
    templateUrl: 'profile.component.html',
    providers: [ProfileService]
})
export class BeneficiaryProfileComponent {

    @Input('beneficiaryDetails') beneficiaryDetails: BeneficiaryDetails;
    @Input('entityDetails') entityDetails: EntityDetails;
    @Input('countryDetails') countryDetails: CountryDetails;
    @Input('municipalityDetails') municipalityDetails: MunicipalityDetails;

    display: boolean;
    displayLegal: boolean;
    displayMayor: boolean;
    displayRepresentative: boolean;


    constructor(private profileService: ProfileService, private uxService: UxService) {

        this.beneficiaryDetails = new BeneficiaryDetails();
        this.entityDetails = new EntityDetails();
        this.display = false;
        this.displayLegal = false;
        this.displayMayor = false;
        this.displayRepresentative = false;
    }

    onSubmit() {
        // TODO - In a real application, make a request to a remote url with the query
        // and return results, for demo we get it at client side.
        this.profileService.changePassword(this.beneficiaryDetails).subscribe(data => console.log(data), error => {
            this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not change password, ignore this when NG is working in offline mode'
            });
            console.log('WARNING: Could not change password');
        });
    }

    changingPassword() {
        this.display = true;
    }

    legalEntity() {
        this.displayLegal = true;
    }

    mayorEdit() {
        this.displayMayor = true;
    }

    representativeEdit() {
        this.displayRepresentative = true;
    }

    checkPassword() {
        return this.beneficiaryDetails.newPassword === this.beneficiaryDetails.repeatNewPassword;
    }
}
