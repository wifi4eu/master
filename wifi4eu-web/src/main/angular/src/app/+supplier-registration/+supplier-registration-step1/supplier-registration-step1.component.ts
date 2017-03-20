import {Component, Input} from "@angular/core";
import {SupplierRegstration} from "../supplier-registration.model";


@Component({selector: 'supplier-registration-step1-component', templateUrl: 'supplier-registration-step1.component.html'})
export class SupplierRegistrationComponentStep1 {
    @Input('company') company: SupplierRegstration;
}
