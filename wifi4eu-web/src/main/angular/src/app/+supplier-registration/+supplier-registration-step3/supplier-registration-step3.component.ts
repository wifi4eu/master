import {Component, Input, EventEmitter, Output} from "@angular/core";
import {SupplierRegistration} from "../supplier-registration.model";


@Component({
    selector: 'supplier-registration-step3-component',
    templateUrl: 'supplier-registration-step3.component.html'
})
export class SupplierRegistrationComponentStep3 {
    @Input('registration') registration: SupplierRegistration;
    @Input('selection') selection: boolean[];

    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;

    private emailDiffers : boolean;

    constructor() {
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
        this.emailDiffers = true;
    }

    onSubmit(step: number) {
        this.onNext.emit(step);
    }

    stepBack(step: number) {
        this.onBack.emit(step);
    }

    checkIfEmailDiffers() {
        this.emailDiffers = true;
        if (this.registration.email === this.registration.confirmEmail) {
            this.emailDiffers = false;
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