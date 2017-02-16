import {Component} from '@angular/core';

@Component({
    templateUrl: 'voucher.component.html',
})
export class VoucherComponent {

    private competitionRejected: boolean;
    private competitionOpen: boolean;
    private competitionRegistered: boolean;

    constructor() {
        this.competitionOpen = false;
        this.competitionRegistered = false;
        this.competitionRejected = false;
    }

    beginCompetition() {
        this.competitionOpen = true;
    }

    applyForVoucher() {
        this.competitionRegistered = true;
    }
}