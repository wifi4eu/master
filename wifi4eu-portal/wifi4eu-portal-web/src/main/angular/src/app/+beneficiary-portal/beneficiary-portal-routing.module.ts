import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { VoucherComponent } from "./+voucher/voucher.component";
import { DiscussionComponent } from "./+discussion/discussion.component";
import { BeneficiaryProfileComponent } from "./+profile/profile.component";
import { AdditionalInfoComponent } from "./+additional-info/additional-info.component";
import { SelectSupplierComponent } from "./+select-supplier/select-supplier.component";
import { SelectedSupplierDetailsComponent } from "./+selected-supplier-details/selected-supplier-details.component";
import { MyVoucherComponent } from "./+my-voucher/my-voucher.component";

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            redirectTo: 'voucher'
        }, {
            path: 'voucher',
            component: VoucherComponent,
        }, {
            path: 'my-voucher',
            component: MyVoucherComponent
        }, {
            path: 'discussion-forum/:threadId',
            component: DiscussionComponent
        }, {
            path: 'profile',
            component: BeneficiaryProfileComponent
        }, {
            path: 'additional-info/:municipalityId',
            component: AdditionalInfoComponent
        }, {
            path: 'selected-supplier-details/:municipalityId',
            component: SelectedSupplierDetailsComponent
        }, {
            path: 'select-supplier/:municipalityId',
            component: SelectSupplierComponent
        },
    ])],
    exports: [RouterModule]
})
export class BeneficiaryPortalRoutingModule {
}