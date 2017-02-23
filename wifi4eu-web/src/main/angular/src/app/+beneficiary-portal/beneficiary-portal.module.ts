import {NgModule} from "@angular/core";

import {SharedModule} from '../shared/shared.module';
import {BeneficiaryPortalRoutingModule} from './beneficiary-portal-routing.module';
import {BeneficiaryPortalComponent} from './beneficiary-portal.component';
import {VoucherComponent} from "../+beneficiary-portal/+voucher/voucher.component";
import {TimelineComponent} from "../shared/components/timeline/timeline.component";
import {TimerComponent} from "../shared/components/timer/timer.component";


@NgModule({
    imports: [
        SharedModule, BeneficiaryPortalRoutingModule
    ],
    declarations: [
        VoucherComponent, TimelineComponent, TimerComponent,BeneficiaryPortalComponent
    ],
    bootstrap: [BeneficiaryPortalComponent]
})
export class BeneficiaryPortalModule {
}