import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
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
    imports: [RouterModule.forChild([
        {
            path: '',
            redirectTo: 'portal'
        }, {
            path: 'portal',
            component: DgConnPortalComponent
        }, {
            path: 'publication',
            component: DgConnPublicationComponent
        }, {
            path: 'voucher',
            component: DgConnVoucherComponent
        }, {
            path: 'statistics',
            component: DgConnStatisticsComponent
        }, {
            path: 'helpdesk',
            component: DgConnHelpdeskComponent
        }, {
            path: 'supplier-registrations',
            component: DgConnSupplierRegistrationsComponent
        }, {
            path: 'beneficiary-registrations',
            component: DgConnBeneficiaryRegistrationsComponent
        }, {
            path: 'beneficiary-registrations/:id',
            component: DgConnBeneficiaryRegistrationsDetailsComponent
        }, {
            path: 'manage-lau',
            component: DgConnManageLauComponent,
        }, {
            path: 'discussion',
            component: DgConnDiscussionComponent,
        }
    ])],
    exports: [RouterModule]
})

export class DgConnDashboardRoutingModule {
}