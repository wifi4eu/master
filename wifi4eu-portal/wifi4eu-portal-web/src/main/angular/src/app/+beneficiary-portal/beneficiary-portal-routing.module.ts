import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {DiscussionComponent} from "./+discussion/discussion.component";
import {BeneficiaryProfileComponent} from "./+profile/profile.component";
import {VoucherComponent} from "./+voucher/voucher.component";

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: VoucherComponent,
        }, {
            path: 'discussion-forum/:threadId',
            component: DiscussionComponent
        }, {
            path: 'profile',
            component: BeneficiaryProfileComponent
        }
    ])],
    exports: [RouterModule]
})
export class BeneficiaryPortalRoutingModule {
}