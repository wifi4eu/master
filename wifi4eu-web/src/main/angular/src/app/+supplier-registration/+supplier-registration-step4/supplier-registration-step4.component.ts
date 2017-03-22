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
    @Input('supplierDTO') supplierDTO: SupplierDTOBase;

    @Input('selection') selection: boolean[];

    private legalChecks: boolean[];
    private successCaptcha: boolean;
    private display: boolean;

    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;
    @Output() gotoStep: EventEmitter<number>;
    @Output() onSuccess: EventEmitter<boolean>;
    @Output() onFailure: EventEmitter<boolean>;

    constructor(private supplierApi: SupplierApi) {
        this.legalChecks = [false, false];
        this.successCaptcha = false;
        this.display = false;

        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
        this.gotoStep = new EventEmitter<number>();
        this.onSuccess = new EventEmitter<boolean>();
        this.onFailure = new EventEmitter<boolean>();
    }

    openModal() {
        this.display = true;
    }

    private onCaptchaComplete(response: any) {
        this.successCaptcha = response.success;
    }

    onSubmit() {
        this.supplierApi.createSupplier(this.supplierDTO).subscribe(
            supplier => {
                console.log(supplier);
            },
            error => {
                console.log(error);
            }
        );
    }
}
