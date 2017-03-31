import {Component} from "@angular/core";

@Component({templateUrl: 'supplier-portal.component.html'})
export class SupplierPortalComponent {
    private voucherCompetitionState: number;

    constructor() {
        this.voucherCompetitionState = 0;
    }

    beginCompetition() {
        this.voucherCompetitionState = 1;
    }

    applyForVoucher() {
        this.voucherCompetitionState = 2;
    }
}