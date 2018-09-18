import { NgModule } from "@angular/core";
import { RouterModule, ActivatedRouteSnapshot, RouterStateSnapshot } from "@angular/router";
import { VoucherComponent } from "./+voucher/voucher.component";
import { DiscussionComponent } from "./+discussion/discussion.component";
import { BeneficiaryProfileComponent } from "./+profile/profile.component";
import { AdditionalInfoComponent } from "./+additional-info/additional-info.component";
import { ManageInstallationComponent } from "./manage-installation/manage-installation.component";
import { InstallationDetailsComponent } from "./details-installation/installation-details.component";
import { AccessPointListComponent } from "./access-point-list/access-point-list.component";
import { AccessPointDetailsComponent } from "./access-point-details/access-point-details.component";
import { BeneficiaryEditProfileComponent } from "./+profile/edit-profile/edit-profile.component";
import { MyHistoryComponent } from "./my-history/my-history.component";
import { MyVoucherComponent } from "./+grant-agreement/grant-agreement.component";
import { SignGrantAgreementComponent } from "./+grant-agreement/+sign-grant-agreement/sign-grant-agreement.component";
import { CanDeactivateGuard } from "../can-deactivate-guard.service";
import { ConfirmationService, ConfirmDialogModule } from "primeng/primeng";

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
            component: AdditionalInfoComponent,
            canDeactivate: [CanDeactivateGuard]
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
        }, {
            path: 'my-history',
            component: MyHistoryComponent
        }, {
            path: 'my-voucher/grant-agreement',
            component: MyVoucherComponent,
        }, {
            path: 'my-voucher/grant-agreement/sign-grant-agreement/:id',
            component: SignGrantAgreementComponent,
        }
    ])],
    providers: [CanDeactivateGuard, ConfirmationService],
    exports: [RouterModule]
})
export class BeneficiaryPortalRoutingModule {
}