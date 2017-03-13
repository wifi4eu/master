import {Component} from "@angular/core";


@Component({templateUrl: 'supplier-portal.component.html'})
export class SupplierPortal {
    private display: boolean;

    constructor() {
        this.display = false;
    }

    openModal() {
        this.display = true;
    }
}
