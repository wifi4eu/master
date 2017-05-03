import {Component} from "@angular/core";
import {SupplierDetails} from "../../shared/models/supplier-details.model";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {LocalStorageService} from "angular-2-local-storage";

@Component({
    templateUrl: 'profile.component.html', providers: [SupplierApi]
})

export class SupplierProfileComponent {
    private selectedSupplier: SupplierDTOBase;
    private supplierDetails: SupplierDetails;
    private display: boolean;
    private displayContact: boolean;
    private displayCompany: boolean;
    private displayLegal: boolean;
    private user;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi) {
        this.supplierDetails = new SupplierDetails();
        this.display = false;
        this.displayContact = false;
        this.displayCompany = false;
        this.displayLegal = false;
        this.user;
        this.selectedSupplier = new SupplierDTOBase();

        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        if (this.user != null) {
            this.supplierApi.getSupplierById(this.user.userId).subscribe(
                response => {
                    this.selectedSupplier = response;
                },
                error => {
                    console.log(error);
                }
            );
        }


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
