import {NgModule} from "@angular/core";
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

// import {SelectSupplierComponent} from "./+voucher/select-supplier/select-supplier.component";

@NgModule({
    imports: [
        SharedModule, BeneficiaryPortalRoutingModule
    ],
    declarations: [
        VoucherComponent,
        DiscussionComponent,
        BeneficiaryProfileComponent,
        AdditionalInfoComponent,
        ManageInstallationComponent,
        InstallationDetailsComponent,
        AccessPointListComponent,
        AccessPointDetailsComponent
        // SelectSupplierComponent
    ]
    // ,
    // bootstrap: [BeneficiaryPortalComponent]
})
export class BeneficiaryPortalModule {
}