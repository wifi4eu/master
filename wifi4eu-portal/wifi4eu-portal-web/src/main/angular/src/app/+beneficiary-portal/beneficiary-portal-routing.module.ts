import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {VoucherComponent} from "./+voucher/voucher.component";
import {DiscussionComponent} from "./+discussion/discussion.component";
import {BeneficiaryProfileComponent} from "./+profile/profile.component";
import {AdditionalInfoComponent} from "./+additional-info/additional-info.component";
import {ManageInstallationComponent} from "./manage-installation/manage-installation.component";
import {InstallationDetailsComponent} from "./details-installation/installation-details.component";
import {AccessPointListComponent} from "./access-point-list/access-point-list.component";
import {AccessPointDetailsComponent} from "./access-point-details/access-point-details.component";
import { BeneficiaryEditProfileComponent } from "./+profile/edit-profile/edit-profile.component";


@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            redirectTo: 'voucher'
        }, {
            path: 'voucher',
            component: VoucherComponent,
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
            path: 'installations/:municipalityId',
            component: ManageInstallationComponent
        }, {
            path: 'details/:id',
            component: InstallationDetailsComponent
        }, {
            path: 'access-point/:id',
            component: AccessPointListComponent
        }, {
            path: 'access-point/details/:id',
            component: AccessPointDetailsComponent
        }, {
            path: 'profile/edit-profile',
            component: BeneficiaryEditProfileComponent
        }
        
        
    ])],
    exports: [RouterModule]
})
export class BeneficiaryPortalRoutingModule {
}