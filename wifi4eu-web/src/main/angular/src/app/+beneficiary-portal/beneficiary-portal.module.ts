import {NgModule} from "@angular/core";

import {SharedModule} from '../shared/shared.module';
import {BeneficiaryPortalRoutingModule} from './beneficiary-portal-routing.module';
import {BeneficiaryPortalComponent} from './beneficiary-portal.component';
import {BeneficiaryProfileComponent} from './profile/profile.component';
import {VoucherComponent} from "../+beneficiary-portal/+voucher/voucher.component";
import {TimerComponent} from "../shared/components/timer/timer.component";
import {TimelineComponent} from "../shared/components/timeline/timeline.component";
import {CustomUxAccordionBoxComponent} from "../shared/components/timeline/custom-ux-accordion-box.component";


@NgModule({
    imports: [
        SharedModule, BeneficiaryPortalRoutingModule
    ],
    declarations: [
        VoucherComponent, CustomUxAccordionBoxComponent, TimerComponent,TimelineComponent,BeneficiaryPortalComponent,BeneficiaryProfileComponent
    ],
    bootstrap: [BeneficiaryPortalComponent]
})
export class BeneficiaryPortalModule {
}