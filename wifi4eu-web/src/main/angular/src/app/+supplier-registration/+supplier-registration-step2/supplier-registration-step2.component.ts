import {Component, Input, EventEmitter, Output} from "@angular/core";
import {SupplierRegstration} from "../supplier-registration.model";

@Component({
    selector: 'supplier-registration-step2-component',
    templateUrl: 'supplier-registration-step2.component.html'
})
export class SupplierRegistrationComponentStep2 {
    @Input('company') company: SupplierRegstration;
    @Input('selection') selection: boolean[];

    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;

    constructor() {
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
    }
}