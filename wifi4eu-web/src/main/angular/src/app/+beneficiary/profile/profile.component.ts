import {Component, Input} from "@angular/core";
import {BeneficiaryDetails} from "../beneficiary-details.model";

@Component({
    moduleId: module.id,
    selector: 'beneficiary-profile-component',
    templateUrl: 'profile.component.html'
})
export class BeneficiaryProfileComponent {

    @Input('beneficiaryDetails') beneficiaryDetails: BeneficiaryDetails;
    display: boolean = false;

    constructor() {
        this.beneficiaryDetails = new BeneficiaryDetails();
    }

    changingPassword() {
        this.display = true;
    }

    checkPassword() {
        return this.beneficiaryDetails.newPassword === this.beneficiaryDetails.repeatNewPassword;
    }

}