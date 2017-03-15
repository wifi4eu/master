import {Component} from "@angular/core";
import {SupplierDetails} from "../../shared/models/supplier-details.model";


@Component({
    templateUrl: 'supplier-profile.component.html'
})

export class SupplierProfile {

    private supplierDetails: SupplierDetails;
    private display: boolean;
    private displayContact: boolean;
    private displayCompany: boolean;
    private displayLegal: boolean;

    constructor() {
        this.supplierDetails = new SupplierDetails();
        this.display = false;
        this.displayContact = false;
        this.displayCompany = false;
        this.displayLegal = false;
    }

    openModal() {
        this.display = true;
    }

    displayContactModal() {
        this.displayContact = true;
    }

    displayCompanyModal() {
        this.displayCompany = true;
    }

    displayLegalModal() {
        this.displayLegal = true;
    }

    closeModal() {
        this.display = false;
    }

    checkPassword() {
        return this.supplierDetails.newPassword === this.supplierDetails.repeatNewPassword;
    }
}
