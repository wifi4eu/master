import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {DgConnFirstReportComponent} from "./first-report/first-report.component";
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