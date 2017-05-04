import {Component} from "@angular/core";
import {SupplierDetails} from "../../shared/models/supplier-details.model";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {LocalStorageService} from "angular-2-local-storage";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";

@Component({
    templateUrl: 'profile.component.html', providers: [SupplierApi, LauApi]
})

export class SupplierProfileComponent {
    private selectedNuts: LauDTOBase;
    private selectedSupplier: SupplierDTOBase;
    private supplierDetails: SupplierDetails;
    private display: boolean;
    private displayContact: boolean;
    private displayCompany: boolean;
    private displayLegal: boolean;
    private user;


    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi, private lauApi: LauApi) {
        this.supplierDetails = new SupplierDetails();
        this.display = false;
        this.displayContact = false;
        this.displayCompany = false;
        this.displayLegal = false;
        this.user;
        this.selectedSupplier = new SupplierDTOBase();
        this.selectedNuts = new LauDTOBase();

        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        if (this.user != null) {
            this.supplierApi.getSupplierById(this.user.userTypeId).subscribe(
                response => {
                    this.selectedSupplier = response;

                    let partNuts = this.selectedSupplier.nutsIds.split(",");
                    this.lauApi.findLauByNuts3(partNuts[1]).subscribe(
                        result => {
                            let laus = result;
                            this.selectedNuts = laus[0];
                            console.log("result: ", result);
                        },
                        error => {
                            console.log(error);
                        }
                    );
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
