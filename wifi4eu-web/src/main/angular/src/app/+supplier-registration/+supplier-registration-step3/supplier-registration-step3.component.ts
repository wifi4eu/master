import {Component, Input, EventEmitter, Output} from "@angular/core";
import {SupplierRegstration} from "../supplier-registration.model";


@Component({
    selector: 'supplier-registration-step3-component',
    templateUrl: 'supplier-registration-step3.component.html'
})
export class SupplierRegistrationComponentStep3 {
    @Input('registration') registration: SupplierRegstration;
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
}