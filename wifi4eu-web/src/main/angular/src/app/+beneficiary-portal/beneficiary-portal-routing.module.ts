import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {VoucherComponent} from './+voucher/voucher.component';
import {BeneficiaryProfileComponent} from "./+profile/profile.component";

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: VoucherComponent,
        },
        {
            path: 'voucher',
            component: VoucherComponent,
        }, {
            path: 'profile',
            component: BeneficiaryProfileComponent
        }
    ])],
    exports: [RouterModule]
})
export class BeneficiaryPortalRoutingModule {
}