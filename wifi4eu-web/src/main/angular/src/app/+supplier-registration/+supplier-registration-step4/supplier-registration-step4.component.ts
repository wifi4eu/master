import {Component, Input, EventEmitter, Output} from "@angular/core";
import {SupplierRegstration} from "../supplier-registration.model";

@Component({
    selector: 'supplier-registration-step4-component',
    templateUrl: 'supplier-registration-step4.component.html'
})

export class SupplierRegistrationComponentStep4 {
    @Input('company') company: SupplierRegstration;
    @Input('selection') selection: boolean[];

    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;
    @Output() gotoStep: EventEmitter<number>;
    @Output() onSuccess: EventEmitter<boolean>;
    @Output() onFailure: EventEmitter<boolean>;


    display: boolean;

    constructor() {
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

}
