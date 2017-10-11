import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {VoucherComponent} from './+voucher/voucher.component';
import {BeneficiaryProfileComponent} from "./+profile/profile.component";
import {DiscussionComponent} from "./+discussion/discussion.component";

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: VoucherComponent,
        }, {
            path: 'profile',
            component: BeneficiaryProfileComponent
        }, {
            path: 'discussion',
            component: DiscussionComponent
        }
    ])],
    exports: [RouterModule]
})
export class BeneficiaryPortalRoutingModule {
}