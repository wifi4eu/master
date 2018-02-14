import {NgModule} from "@angular/core";
import {SharedModule} from "../shared/shared.module";
import {DgConnDashboardRoutingModule} from "./dgconn.dashboard-routing.module";
import {DgConnPortalComponent} from "./portal/dgconnportal.component";
import {DgConnPublicationComponent} from "./publication/publication.component";
import {DgConnVoucherComponent} from "./voucher/voucher.component";
import {DgConnStatisticsComponent} from "./statistics/statistics.component";
import {DgConnHelpdeskComponent} from "./helpdesk/helpdesk.component";
import {DgConnSupplierRegistrationsComponent} from "./supplier-registrations/supplier-registrations.component";
import {DgConnBeneficiaryRegistrationsComponent} from "./beneficiary-registrations/beneficiary-registrations.component";
import {DgConnBeneficiaryRegistrationsDetailsComponent} from "./beneficiary-registrations/details/beneficiary-registrations-details.component";
import {DgConnManageLauComponent} from "./manage-lau/manage-lau.component";
import {DgConnDiscussionComponent} from "./discussion/discussion.component";

@NgModule({
    imports: [
        SharedModule, DgConnDashboardRoutingModule
        // SharedModule, DgConnDashboardRoutingModule, SharedNgModule
    ],
    declarations: [
        DgConnPortalComponent,
        DgConnPublicationComponent,
        DgConnVoucherComponent,
        DgConnStatisticsComponent,
        DgConnHelpdeskComponent,
        DgConnSupplierRegistrationsComponent,
        DgConnBeneficiaryRegistrationsComponent,
        DgConnBeneficiaryRegistrationsDetailsComponent,
        DgConnManageLauComponent,
        DgConnDiscussionComponent
    ],
    bootstrap: [DgConnPortalComponent]
})

export class DgConnDashboardModule {
}