import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {DgConnPortalComponent} from "./dgconnportal.component";
import {DgConnTimelineComponent} from "./+timeline/timeline.component";
import {DgConnPublicationComponent} from "./+publication/publication.component";
import {DgConnVoucherComponent} from "app/+dgconn-portal/+voucher/voucher.component";
import {DgConnStatisticsComponent} from "./+statistics/statistics.component";
import {DgConnSupplierRegistrationsComponent} from "./+supplier-registrations/supplier-registrations.component";
import {DgConnBeneficiaryRegistrationsComponent} from "./+beneficiary-registrations/beneficiary-registrations.component";
import {DgConnListMayorComponent} from "./+mayors-list/mayors-list.component";
import {DgConnDiscussionComponent} from "./+discussion/discussion.component";

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: DgConnPortalComponent,
        }, {
            path: 'timeline',
            component: DgConnTimelineComponent,
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
            path: 'mayors-list',
            component: DgConnListMayorComponent,
        }, {
            path: 'discussion',
            component: DgConnDiscussionComponent,
        }


    ])],
    exports: [RouterModule]
})
export class DgConnectPortalRoutingModule {
}