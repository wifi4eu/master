import {NgModule} from "@angular/core";
import { HttpModule } from "@angular/http";
import {SharedModule} from "../shared/shared.module";
import {BeneficiaryPortalRoutingModule} from "./beneficiary-portal-routing.module";
import {VoucherComponent} from "../+beneficiary-portal/+voucher/voucher.component";
import {DiscussionComponent} from "./+discussion/discussion.component";
import {BeneficiaryProfileComponent} from "./+profile/profile.component";
import {AdditionalInfoComponent} from "./+additional-info/additional-info.component";
import {ManageInstallationComponent} from "./manage-installation/manage-installation.component";
import {InstallationDetailsComponent} from "./details-installation/installation-details.component";
import {AccessPointListComponent} from "./access-point-list/access-point-list.component";
import {AccessPointDetailsComponent} from "./access-point-details/access-point-details.component";
import { BeneficiaryService } from "../core/services/beneficiary-service";
import { BeneficiaryEditProfileComponent } from "./+profile/edit-profile/edit-profile.component";
import { MyHistoryComponent } from "./my-history/my-history.component";
import { MyVoucherComponent } from "./+grant-agreement/grant-agreement.component";
import { SignGrantAgreementComponent } from "./+grant-agreement/+sign-grant-agreement/sign-grant-agreement.component";
import { BeneficiaryUserComponent } from "./+profile/beneficiary-user/beneficiary-user.component";
import { ConfirmDialogModule } from "primeng/primeng";

// import {SelectSupplierComponent} from "./+voucher/select-supplier/select-supplier.component";

@NgModule({
  imports: [SharedModule, BeneficiaryPortalRoutingModule, HttpModule, ConfirmDialogModule],
    declarations: [
        VoucherComponent,
        DiscussionComponent,
        BeneficiaryProfileComponent,
        AdditionalInfoComponent,
        ManageInstallationComponent,
        InstallationDetailsComponent,
        AccessPointListComponent,
        AccessPointDetailsComponent,
        BeneficiaryEditProfileComponent,
        MyHistoryComponent,
        MyVoucherComponent,
        SignGrantAgreementComponent,
        BeneficiaryUserComponent,
        // SelectSupplierComponent
    ], providers: [
        BeneficiaryService
    ]
    // ,
    // bootstrap: [BeneficiaryPortalComponent]
})
export class BeneficiaryPortalModule {}
