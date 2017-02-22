import {Component, Input} from "@angular/core";
import {BeneficiaryDetails} from "../beneficiary-details.model";
import {EntityDetails} from "../../+entity/entity-details.model";
import {CountryDetails} from "../../+entity/country-details.model";
import {MunicipalityDetails} from "../../+entity/municipality-details.model";

@Component({
    moduleId: module.id,
    selector: 'beneficiary-profile-component',
    templateUrl: 'profile.component.html'
})
export class BeneficiaryProfileComponent {

    @Input('beneficiaryDetails') beneficiaryDetails: BeneficiaryDetails;
    @Input('entityDetails') entityDetails: EntityDetails;
    @Input('countryDetails') countryDetails: CountryDetails;
    @Input('municipalityDetails') municipalityDetails: MunicipalityDetails;

    display: boolean = false;
    displayLegal: boolean = false;
    displayMayor: boolean = false;


    constructor() {
        this.beneficiaryDetails = new BeneficiaryDetails();
        this.entityDetails = new EntityDetails();
    }

    changingPassword() {
        this.display = true;
    }

    LegalEntity() {
        this.displayLegal = true;
    }

    MayorEdit() {
        this.displayMayor = true;
    }

    checkPassword() {
        return this.beneficiaryDetails.newPassword === this.beneficiaryDetails.repeatNewPassword;
    }
}
