import {Component, Input, Output, EventEmitter} from "@angular/core";
import {SupplierRegstration} from "../supplier-registration.model";
import {CompanyDTOBase} from "../../shared/swagger/model/CompanyDTO";


@Component({selector: 'supplier-registration-step1-component', templateUrl: 'supplier-registration-step1.component.html'})
export class SupplierRegistrationComponentStep1 {
    //@Input('company') company: SupplierRegstration;
    @Input('registration') registration: SupplierRegstration;

    @Output() onNext = new EventEmitter<number>();

    onSubmit(step: number) {
        this.onNext.emit(step);
    }
}
