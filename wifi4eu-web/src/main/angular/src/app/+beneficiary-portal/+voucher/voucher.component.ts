import {Component} from '@angular/core';
import {TimelineComponent} from '../../shared/components/timeline/timeline.component';

@Component({
    templateUrl: 'voucher.component.html',
})
export class VoucherComponent {
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