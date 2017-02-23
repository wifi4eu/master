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

    display: boolean;
    displayLegal: boolean;
    displayMayor: boolean;
    displayRepresentative: boolean;


    constructor() {
        this.beneficiaryDetails = new BeneficiaryDetails();
        this.entityDetails = new EntityDetails();
        this.display = false;
        this.displayLegal = false;
        this.displayMayor = false;
        this.displayRepresentative = false;
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
