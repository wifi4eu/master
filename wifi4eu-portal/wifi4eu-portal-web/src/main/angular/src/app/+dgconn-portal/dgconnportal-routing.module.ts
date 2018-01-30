import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {DgConnPortalComponent} from "./dgconnportal.component";
import {DgConnPublicationComponent} from "./+publication/publication.component";
import {DgConnVoucherComponent} from "app/+dgconn-portal/+voucher/voucher.component";
import {DgConnStatisticsComponent} from "./+statistics/statistics.component";
import {DgConnSupplierRegistrationsComponent} from "./+supplier-registrations/supplier-registrations.component";
import {DgConnBeneficiaryRegistrationsComponent} from "./+beneficiary-registrations/beneficiary-registrations.component";
import {DgConnManageLauComponent} from "./+manage-lau/manage-lau.component";
import {DgConnDiscussionComponent} from "./+discussion/discussion.component";
import { DgConnBeneficiaryRegistrations2Component } from "app/+dgconn-portal/+beneficiary-registrations2/beneficiary-registrations2.component";

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: DgConnPortalComponent,
        }, {
            path: 'publication',
            component: DgConnPublicationComponent,
        }, {
            path: 'voucher',
            component: DgConnVoucherComponent,
        }, {
            path: 'statistics',
            component: DgConnStatisticsComponent,
        }, {
            path: 'supplier-registrations',
            component: DgConnSupplierRegistrationsComponent,
        }, {
            path: 'beneficiary-registrations',
            component: DgConnBeneficiaryRegistrationsComponent,
        }, {
            path: 'beneficiary-registrations-new',
            component: DgConnBeneficiaryRegistrations2Component,
        },{
            path: 'manage-lau',
            component: DgConnManageLauComponent,
        }, {
            path: 'discussion',
            component: DgConnDiscussionComponent,
        }


    ])],
    exports: [RouterModule]
})
export class DgConnectPortalRoutingModule {
}