import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { VoucherComponent } from "./+voucher/voucher.component";
import { DiscussionComponent } from "./+discussion/discussion.component";
import { BeneficiaryProfileComponent } from "./+profile/profile.component";
import { AdditionalInfoComponent } from "./+additional-info/additional-info.component";

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
        }, {
            path: 'additional-info',
            component: AdditionalInfoComponent
        }
    ])],
    exports: [RouterModule]
})
export class BeneficiaryPortalRoutingModule {
}