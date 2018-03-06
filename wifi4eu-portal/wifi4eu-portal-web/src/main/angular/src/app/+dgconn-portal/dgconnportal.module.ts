import {NgModule} from "@angular/core";
import {SharedModule} from "../shared/shared.module";
import {DgConnectPortalRoutingModule} from "./dgconnportal-routing.module";
import {DgConnPortalComponent} from "./dgconnportal.component";
import {DgConnPublicationComponent} from "./+publication/publication.component";
import {DgConnVoucherComponent} from "app/+dgconn-portal/+voucher/voucher.component";
import {DgConnStatisticsComponent} from "./+statistics/statistics.component";
import {DgConnSupplierRegistrationsComponent} from "./+supplier-registrations/supplier-registrations.component";
import {DgConnBeneficiaryRegistrationsComponent} from "./+beneficiary-registrations/beneficiary-registrations.component";
import {DgConnManageLauComponent} from "./+manage-lau/manage-lau.component";
import {DgConnDiscussionComponent} from "./+discussion/discussion.component";
import { PaginatorModule } from "primeng/primeng";
import { SharedModule as SharedNgModule } from 'primeng/primeng';
import {DgConnBeneficiaryRegistrationsDetailsComponent} from "./+beneficiary-registrations/+details/beneficiary-registrations-details.component";
import {DgConnSupplierRegistrationsDetailsComponent} from "./+supplier-registrations/details/supplier-registrations-details.component";

@NgModule({
    imports: [
        SharedModule, DgConnectPortalRoutingModule, SharedNgModule
    ],
    declarations: [
        DgConnPortalComponent,
        DgConnPublicationComponent, 
        DgConnVoucherComponent,
        DgConnStatisticsComponent, 
        DgConnSupplierRegistrationsComponent, 
        DgConnBeneficiaryRegistrationsComponent,
        DgConnBeneficiaryRegistrationsDetailsComponent,
        DgConnSupplierRegistrationsDetailsComponent,
        DgConnManageLauComponent,
        DgConnDiscussionComponent
    ],
    bootstrap: [DgConnPortalComponent]
})
export class DgConnPortalModule {
}