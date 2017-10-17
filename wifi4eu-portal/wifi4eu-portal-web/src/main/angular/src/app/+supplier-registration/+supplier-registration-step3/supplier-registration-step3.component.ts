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

    //private phonePrefix: string;
    private confirmEmailField: string;
    private emailMatches: boolean;
    private emailPattern: string = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?";
    private confirmEmail: string;

    constructor() {
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
    }

    onSubmit(step: number) {
        this.onNext.emit(step);
    }

    stepBack(step: number) {
        this.onBack.emit(step);
    }

    checkIfEmailMatches() {
        this.emailMatches = false;
        if (this.supplierDTO.contactEmail === this.confirmEmailField) {
            this.emailMatches = true;
        }
    }

    keyPressPrefix(event: any) {
        const pattern = /[0-9\+]/;
        let inputChar = String.fromCharCode(event.charCode);
        if (!pattern.test(inputChar)) {
            event.preventDefault();
        }
    }
}
