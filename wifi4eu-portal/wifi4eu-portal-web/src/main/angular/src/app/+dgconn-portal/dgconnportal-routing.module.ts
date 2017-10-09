import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {DgConnPortalComponent} from "./dgconnportal.component";
import {DgConnTimelineComponent} from "./+timeline/timeline.component";
import { DgConnPublicationComponent } from "./+publication/publication.component";
import { DgConnListMayorComponent } from "./+mayors-list/mayors-list.component";
import {DgConnVoucherComponent} from "./+voucher/voucher.component";
import {DgConnRegistrationsComponent} from "./+registrations/registrations.component";
import {DgConnSupplierRegistrationsComponent} from "./+supplier-registrations/supplier-registrations.component";

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: DgConnPortalComponent,
        }, {
            path: 'timeline',
            component: DgConnTimelineComponent
        }, {
            path: 'publication',
            component: DgConnPublicationComponent
        }, {
            path: 'voucher',
            component: DgConnVoucherComponent
        }, {
            path: 'statistics',
            loadChildren: 'app/+dgconn-portal/+statistics/statistics.module#DgConnPortalStatisticsModule'
        }, {
            path: 'registrations',
            component: DgConnRegistrationsComponent
        }, {
            path: 'mayors-list',
            component: DgConnListMayorComponent
        }, {
            path: 'supplier-registrations',
            component: DgConnSupplierRegistrationsComponent
        }

    ])],
    exports: [RouterModule]
})
export class DgConnectPortalRoutingModule {
}