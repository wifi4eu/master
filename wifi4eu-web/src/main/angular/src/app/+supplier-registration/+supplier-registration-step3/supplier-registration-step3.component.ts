import {Component, Input, EventEmitter, Output} from "@angular/core";
import {SupplierRegstration} from "../supplier-registration.model";


@Component({
    selector: 'supplier-registration-step3-component',
    templateUrl: 'supplier-registration-step3.component.html'
})
export class SupplierRegistrationComponentStep3 {
    @Input('company') company: SupplierRegstration;
    @Input('selection') selection: boolean[];

    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;

    constructor() {
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
    }

}