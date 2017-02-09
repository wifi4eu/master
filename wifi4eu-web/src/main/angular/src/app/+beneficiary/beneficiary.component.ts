import {Component, EventEmitter, Input, Output} from "@angular/core";
import {BeneficiaryDetails} from "./beneficiary-details.model";

@Component({
    selector: 'beneficiary-component', templateUrl: 'beneficiary.component.html'
})
export class BeneficiaryComponent {

    mayorEmailMatches: boolean = false;
    representativeEmailMatches: boolean = false;

    @Input('beneficiaryDetails') beneficiaryDetails: BeneficiaryDetails;
    @Output() onNext = new EventEmitter<number>();

    constructor() {
    }

    onSubmit(step: number) {
        this.onNext.emit(step);
    }

    checkIfMayorEmailMatches() {
        if (this.beneficiaryDetails.email === this.beneficiaryDetails.confirmEmail) {
            this.mayorEmailMatches = true;
        } else {
            this.mayorEmailMatches = false;
        }
    }

    checkIfRepresentativeEmailMatches() {
        if (this.beneficiaryDetails.emailRepresentative === this.beneficiaryDetails.confirmEmailRepresentative) {
            this.representativeEmailMatches = true;
        } else {
            this.representativeEmailMatches = false;
        }
    }

    allEmailsMatch() {
        if (this.beneficiaryDetails.representativeSelected && !this.representativeEmailMatches) {
            return false;
        }
        if (!this.mayorEmailMatches) {
            return false;
        }
        return true;
    }

    /* Old Check Functions, not used anymore

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
     */
}
