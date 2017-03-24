import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {VoucherComponent} from './+voucher/voucher.component';
import {BeneficiaryProfileComponent} from "./+profile/profile.component";
import {SelectSupplierComponent} from "./+voucher/select-supplier/select-supplier.component";

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: 'voucher',
            component: VoucherComponent,
        }, {
            path: 'profile',
            component: BeneficiaryProfileComponent
        }, {
            path: 'voucher/select-supplier',
            component: SelectSupplierComponent
        }
    ])],
    exports: [RouterModule]
})
export class BeneficiaryPortalRoutingModule {
}