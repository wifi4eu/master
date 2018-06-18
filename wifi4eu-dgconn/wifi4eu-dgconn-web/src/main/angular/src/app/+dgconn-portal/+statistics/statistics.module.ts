import {NgModule} from "@angular/core";
import {SharedModule} from "../../shared/shared.module";
import {DgConnFirstReportComponent} from "./first-report/first-report.component";
import {DgConnStatisticsComponent} from "./statistics.component";
import {StatisticsPortalRoutingModule} from "./statistics-routing.module";
import {ChartsModule} from "ng2-charts";
import {DgConnSecondReportComponent} from "./second-report/second-report.component";
import {DgConnThirdReportComponent} from "./third-report/third-report.component";
import {DgConnFourthReportComponent} from "./fourth-report/fourth-report.component";


@NgModule({
    imports: [
        SharedModule, StatisticsPortalRoutingModule, ChartsModule
    ],
    declarations: [
        DgConnFirstReportComponent, DgConnStatisticsComponent, DgConnSecondReportComponent, DgConnThirdReportComponent, DgConnFourthReportComponent
    ]
})
export class DgConnPortalStatisticsModule {
}