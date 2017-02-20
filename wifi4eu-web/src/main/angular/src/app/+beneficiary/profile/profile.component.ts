import {Component, Input} from "@angular/core";
import {BeneficiaryDetails} from "../beneficiary-details.model";

@Component({
    moduleId: module.id,
    selector: 'beneficiary-profile-component',
    templateUrl: 'profile.component.html'
})
export class BeneficiaryProfileComponent {

    @Input('beneficiaryDetails') beneficiaryDetails: BeneficiaryDetails;

    constructor() {
        this.beneficiaryDetails = new BeneficiaryDetails();

        console.log("Repeat new password:", this.beneficiaryDetails.repeatNewPassword);
    }

    display: boolean = false;

    changingPassword() {
        this.display = true;
    }

    checkPassword() {
        console.log("Checkihng password..");
        console.log(this.beneficiaryDetails.newPassword);
        console.log(this.beneficiaryDetails.repeatNewPassword);
        console.log(this.beneficiaryDetails.newPassword === this.beneficiaryDetails.repeatNewPassword);
        return this.beneficiaryDetails.newPassword === this.beneficiaryDetails.repeatNewPassword;

    }

}