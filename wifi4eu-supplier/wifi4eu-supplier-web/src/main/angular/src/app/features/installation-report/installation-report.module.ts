import { NgModule } from '@angular/core';
import { InstallationReportRoutingModule } from './installation-report-routing.module';
import { InstallationReportComponent } from './installation-report.component';
import { InstallationListComponent } from './components/installation-list/installation-list.component';
import { Page2Component } from './components/page2/page2.component';

import { SharedModule } from '../../shared/shared.module';

@NgModule({
    imports: [
        SharedModule,
        InstallationReportRoutingModule
    ],
    declarations: [
        InstallationReportComponent,
        InstallationListComponent,
        Page2Component
    ],
    bootstrap: [
        InstallationReportComponent
    ]
})
export class InstallationReportModule {
}
