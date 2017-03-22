import {Component, Input, Output, EventEmitter} from "@angular/core";
import {SupplierRegistration} from "../supplier-registration.model";
import {CompanyDTOBase} from "../../shared/swagger/model/CompanyDTO";


@Component({selector: 'supplier-registration-step1-component', templateUrl: 'supplier-registration-step1.component.html'})
export class SupplierRegistrationComponentStep1 {
    //@Input('company') company: SupplierRegistration;
    @Input('registration') registration: SupplierRegistration;

    @Output() onNext = new EventEmitter<number>();

    onSubmit(step: number) {
        this.onNext.emit(step);
    }
}
