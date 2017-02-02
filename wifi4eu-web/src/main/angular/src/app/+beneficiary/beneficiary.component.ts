import {Component, EventEmitter, Input, Output} from "@angular/core";
import {BeneficiaryDetails} from "./beneficiary-details.model";

@Component({
    selector: 'beneficiary-component',
    templateUrl: 'beneficiary.component.html',
    styles: [`.wrong-detail { box-shadow: 0px 0px 2px 1px red; }`]
})
export class BeneficiaryComponent {
    @Input('beneficiaryDetails') beneficiaryDetails: BeneficiaryDetails;
    @Input('completedSteps') completedSteps: boolean[];
    @Input('activeSteps') activeSteps: boolean[];
    @Input('currentStep') currentStep: number;
    wrongDetails: string [];

    constructor() {
        this.wrongDetails = [];
    }

    @Output() onNext = new EventEmitter<number>();

    nextStep(step: number) {
        this.onNext.emit(step);
    }

    checkMayorDetails() {
        if (this.beneficiaryDetails.treatment == null || this.beneficiaryDetails.treatment == "") {
            this.wrongDetails.push("treatment");
            console.log("treatment is empty!");
        }
        if (this.beneficiaryDetails.name == null || this.beneficiaryDetails.name == "") {
            this.wrongDetails.push("name");
            console.log("name is empty!");
        }
        if (this.beneficiaryDetails.surname == null || this.beneficiaryDetails.surname == "") {
            this.wrongDetails.push("surname");
            console.log("surname is empty!");
        }
        if (this.beneficiaryDetails.email == null || this.beneficiaryDetails.email == "") {
            this.wrongDetails.push("email");
            console.log("email is empty!");
        }
        if (this.beneficiaryDetails.confirmEmail == null || this.beneficiaryDetails.confirmEmail == "") {
            this.wrongDetails.push("confirmEmail");
            console.log("confirmEmail is empty!");
        }
    }

    checkRepresentativeDetails() {
        if (this.beneficiaryDetails.treatmentRepresentative == null || this.beneficiaryDetails.treatmentRepresentative == "") {
            this.wrongDetails.push("treatmentRepresentative");
            console.log("treatmentRepresentative is empty!");
        }
        if (this.beneficiaryDetails.nameRepresentative == null || this.beneficiaryDetails.nameRepresentative == "") {
            this.wrongDetails.push("nameRepresentative");
            console.log("nameRepresentative is empty!");
        }
        if (this.beneficiaryDetails.surnameRepresentative == null || this.beneficiaryDetails.surnameRepresentative == "") {
            this.wrongDetails.push("surnameRepresentative");
            console.log("surnameRepresentative is empty!");
        }
        if (this.beneficiaryDetails.roleRepresentative == null || this.beneficiaryDetails.roleRepresentative == "") {
            this.wrongDetails.push("roleRepresentative");
            console.log("roleRepresentative is empty!");
        }
        if (this.beneficiaryDetails.emailRepresentative == null || this.beneficiaryDetails.emailRepresentative == "") {
            this.wrongDetails.push("emailRepresentative");
            console.log("emailRepresentative is empty!");
        }
        if (this.beneficiaryDetails.confirmEmailRepresentative == null || this.beneficiaryDetails.confirmEmailRepresentative == "") {
            this.wrongDetails.push("confirmEmailRepresentative");
            console.log("confirmEmailRepresentative is empty!");
        }
    }

    checkIfWrong(detail: string) {
        if (this.wrongDetails.indexOf(detail) > -1) {
            return true;
        } else {
            return false;
        }
    }
}
