import {NgModule} from "@angular/core";
import {ChartsModule} from "ng2-charts";
import {SharedModule} from "../../shared/shared.module";
import {StatisticsPortalRoutingModule} from "./statistics-routing.module";
import {DgConnStatisticsComponent} from "./statistics.component";
import {DgConnFirstReportComponent} from "./first-report/first-report.component";
import {DgConnSecondReportComponent} from "./second-report/second-report.component";
import {DgConnThirdReportComponent} from "./third-report/third-report.component";
import {DgConnFourthReportComponent} from "./fourth-report/fourth-report.component";

@NgModule({
    imports: [
        ChartsModule, SharedModule, StatisticsPortalRoutingModule
    ],
    declarations: [
        DgConnStatisticsComponent, DgConnFirstReportComponent, DgConnSecondReportComponent, DgConnThirdReportComponent, DgConnFourthReportComponent
    ]
})

export class DgConnPortalStatisticsModule {
}