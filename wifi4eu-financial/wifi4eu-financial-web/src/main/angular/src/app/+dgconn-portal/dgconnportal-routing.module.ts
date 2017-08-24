import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {DgConnPortalComponent} from "./dgconnportal.component";
import {DgConnTimelineComponent} from "./+timeline/timeline.component";
import {DgConnPublicationComponent} from "./+publication/publication.component";
import {DgConnVoucherComponent} from "./+voucher/voucher.component";

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
            loadChildren: 'app/+dgconn-portal/+statistics/statistics.module#DgConnPortalStatisticsModule',
            // canActivate: [AppGuard]
        }
    ])],
    exports: [RouterModule]
})
export class DgConnectPortalRoutingModule {
}