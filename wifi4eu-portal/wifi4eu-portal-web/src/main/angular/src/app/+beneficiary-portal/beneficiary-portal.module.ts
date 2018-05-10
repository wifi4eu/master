import { NgModule } from "@angular/core";
import { SharedModule } from "../shared/shared.module";
import { BeneficiaryPortalRoutingModule } from "./beneficiary-portal-routing.module";
import { VoucherComponent } from "../+beneficiary-portal/+voucher/voucher.component";
import { DiscussionComponent } from "./+discussion/discussion.component";
import { BeneficiaryProfileComponent } from "./+profile/profile.component";
import { AdditionalInfoComponent } from "./+additional-info/additional-info.component";
import { selectSupplierComponent } from './+select-supplier/select-supplier.component';
import { DataGridModule } from "primeng/primeng";

@NgModule({
    imports: [
        SharedModule, BeneficiaryPortalRoutingModule, DataGridModule
    ],
    declarations: [
        VoucherComponent,
        DiscussionComponent,
        BeneficiaryProfileComponent,
        AdditionalInfoComponent,
        selectSupplierComponent
    ]
    // ,
    // bootstrap: [BeneficiaryPortalComponent]
})
export class BeneficiaryPortalModule {
}