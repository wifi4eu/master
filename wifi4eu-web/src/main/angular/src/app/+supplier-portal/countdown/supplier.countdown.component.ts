import {Component} from '@angular/core';

@Component({
    templateUrl: 'supplier.countdown.component.html',
})
export class SupplierCountdownComponent {
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