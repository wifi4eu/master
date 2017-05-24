import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {DgConnFirstReportComponent} from "./first-report/firstReport.component";
import {DgConnStatisticsComponent} from "./statistics.component";


@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: DgConnStatisticsComponent,
        }, {
            path: 'first-report',
            component: DgConnFirstReportComponent
        }
    ])],
    exports: [RouterModule]
})
export class StatisticsPortalRoutingModule {
}