import {NgModule} from "@angular/core";
import {SharedModule} from "../../shared/shared.module";
import {DgConnFirstReportComponent} from "./first-report/firstReport.component";
import {DgConnStatisticsComponent} from "./statistics.component";
import {StatisticsPortalRoutingModule} from "./statistics-routing.module";

@NgModule({
    imports: [
        SharedModule, StatisticsPortalRoutingModule
    ],
    declarations: [
        DgConnFirstReportComponent, DgConnStatisticsComponent
    ]
})
export class DgConnPortalStatisticsModule {
}