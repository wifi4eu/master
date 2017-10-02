import {NgModule} from "@angular/core";

import {SharedModule} from '../shared/shared.module';
import {BeneficiaryPortalRoutingModule} from './beneficiary-portal-routing.module';
import {BeneficiaryPortalComponent} from './beneficiary-portal.component';
import {BeneficiaryProfileComponent} from './+profile/profile.component';
import {VoucherComponent} from "../+beneficiary-portal/+voucher/voucher.component";
import {SelectSupplierComponent} from "./+voucher/select-supplier/select-supplier.component";

@NgModule({
    imports: [
        SharedModule, BeneficiaryPortalRoutingModule
    ],
    declarations: [
        VoucherComponent,
        BeneficiaryPortalComponent,
        BeneficiaryProfileComponent,
        SelectSupplierComponent
    ],
    bootstrap: [BeneficiaryPortalComponent]
})
export class BeneficiaryPortalModule {
}