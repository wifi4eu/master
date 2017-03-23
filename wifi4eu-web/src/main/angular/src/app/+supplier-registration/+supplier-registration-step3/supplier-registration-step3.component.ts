import {Component, Input, EventEmitter, Output} from "@angular/core";
import {SupplierRegistration} from "../supplier-registration.model";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";

@Component({
    selector: 'supplier-registration-step3-component',
    templateUrl: 'supplier-registration-step3.component.html'
})
export class SupplierRegistrationComponentStep3 {
    @Input('supplierDTO') supplierDTO: SupplierDTOBase;

    @Input('selection') selection: boolean[];

    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;

    private phonePrefix: string;
    private confirmEmail: string;

    constructor() {
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
    }

    onSubmit(step: number) {
        this.supplierDTO.contactPersonDTO.phone = this.phonePrefix + this.supplierDTO.contactPersonDTO.phone;
        this.onNext.emit(step);
    }

    stepBack(step: number) {
        this.onBack.emit(step);
    }

    checkEmail() {
        return this.supplierDTO.contactPersonDTO.email !== this.confirmEmail
    }

    keyPressPrefix(event: any) {
        const pattern = /[0-9\+]/;
        let inputChar = String.fromCharCode(event.charCode);
        if (!pattern.test(inputChar)) {
            event.preventDefault();
        }
    }
}