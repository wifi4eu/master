import {NgModule} from "@angular/core";
import {SharedModule} from "../../shared/shared.module";
import {DgConnFirstReportComponent} from "./first-report/first-report.component";
import {DgConnStatisticsComponent} from "./statistics.component";
import {StatisticsPortalRoutingModule} from "./statistics-routing.module";
import {ChartsModule} from "ng2-charts";


@NgModule({
    imports: [
        SharedModule, StatisticsPortalRoutingModule, ChartsModule
    ],
    declarations: [
        DgConnFirstReportComponent, DgConnStatisticsComponent
    ]
})
export class DgConnPortalStatisticsModule {
}