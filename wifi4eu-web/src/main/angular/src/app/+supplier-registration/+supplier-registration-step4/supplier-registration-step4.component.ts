import {Component, Input, EventEmitter, Output} from "@angular/core";
import {SupplierRegistration} from "../supplier-registration.model";
import {CompanyDTOBase} from "../../shared/swagger/model/CompanyDTO";
import {ContactPersonDTOBase} from "../../shared/swagger/model/ContactPersonDTO";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";

@Component({
    selector: 'supplier-registration-step4-component',
    templateUrl: 'supplier-registration-step4.component.html',
    providers: [SupplierApi]
})

export class SupplierRegistrationComponentStep4 {
    @Input('registration') registration: SupplierRegistration;
    @Input('selection') selection: boolean[];
    @Input('beneficiaryDTO') companyDTO: CompanyDTOBase;
    @Input('beneficiaryDTO') contactDTO: ContactPersonDTOBase;
    private supplier: SupplierDTOBase;
    private legalChecks: boolean[];
    private successCaptcha: boolean;
    private display: boolean;

    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;
    @Output() gotoStep: EventEmitter<number>;
    @Output() onSuccess: EventEmitter<boolean>;
    @Output() onFailure: EventEmitter<boolean>;

    constructor(private supplierApi: SupplierApi) {
        this.display = false;
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
        this.gotoStep = new EventEmitter<number>();
        this.onSuccess = new EventEmitter<boolean>();
        this.onFailure = new EventEmitter<boolean>();
        this.supplier = new SupplierDTOBase();
        this.legalChecks = [false, false];
        this.successCaptcha = false;
    }

    openModal() {
        this.display = true;
    }

    private onCaptchaComplete(response: any) {
        this.successCaptcha = response.success;
    }

    onSubmit() {
        this.createSupplierDTO();
        this.supplierApi.createSupplier(this.supplier).subscribe(
            supplier => {
                console.log(supplier);
            },
            error => {
                console.log(error);
            }
        );
    }

    createSupplierDTO() {
        this.supplier.companyDTO = new CompanyDTOBase();
        this.supplier.companyDTO.name = this.registration.companyName;
        this.supplier.companyDTO.address = this.registration.legalAddress;
        this.supplier.companyDTO.vat = this.registration.vatNumber;
        this.supplier.companyDTO.bic = this.registration.bic;
        this.supplier.companyDTO.accountNumber = this.registration.bankAccount;
        this.supplier.companyDTO.website = this.registration.companyWeb;
        this.supplier.contactPersonDTO = new ContactPersonDTOBase();
        this.supplier.contactPersonDTO.name = this.registration.name;
        this.supplier.contactPersonDTO.surname = this.registration.surname;
        this.supplier.contactPersonDTO.phone = this.registration.phonePrefix + " " + this.registration.phoneNumber;
        this.supplier.contactPersonDTO.email = this.registration.email;
        this.supplier.legalCheck1 = this.legalChecks[0];
        this.supplier.legalCheck2 = this.legalChecks[1];
        this.supplier.createDate = new Date().getTime();
    }
}
