import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {DgConnFirstReportComponent} from "./first-report/first-report.component";
import {DgConnStatisticsComponent} from "./statistics.component";
import {DgConnSecondReportComponent} from "./second-report/second-report.component";
import {DgConnThirdReportComponent} from "./third-report/third-report.component";


@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: DgConnStatisticsComponent,
        }, {
            path: 'first-report',
            component: DgConnFirstReportComponent
        }, {
            path: 'second-report',
            component: DgConnSecondReportComponent
        }, {
            path: 'third-report',
            component: DgConnThirdReportComponent
        }
    ])],
    exports: [RouterModule]
})
export class StatisticsPortalRoutingModule {
}