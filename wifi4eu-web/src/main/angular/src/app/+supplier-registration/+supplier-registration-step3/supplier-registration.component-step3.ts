import {Component, Input} from "@angular/core";
import {SupplierRegstration} from "../supplier-registration.model";


@Component({templateUrl: 'supplier-registration.component-step3.html'})
export class SupplierRegistrationComponent3 {
    @Input('company') company: SupplierRegstration;

}