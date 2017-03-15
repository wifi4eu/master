import {Component} from "@angular/core";

@Component({templateUrl: 'supplier-registration.component.html'})
export class SupplierRegistration {
    private display: boolean;

    constructor() {
        this.display = false;
    }

    openModal() {
        this.display = true;
    }
}
