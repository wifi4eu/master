import { NgModule } from '@angular/core';
import { InstallationReportRoutingModule } from './installation-report-routing.module';
import { InstallationReportComponent } from './installation-report.component';
import { Page2Component } from './components/page2/page2.component';

import { SharedModule } from '../../shared/shared.module';
import { InstallationListComponent } from './components/installation-list/installation-list.component';
import { SearchParametersService } from '../../core/services/search-parameters.service';

@NgModule({
    imports: [
        SharedModule,
        InstallationReportRoutingModule
    ],
    declarations: [
        InstallationListComponent,
        Page2Component
    ],
    providers: [
        SearchParametersService
    ],
    bootstrap: [
        InstallationListComponent
    ]
})
export class InstallationReportModule {
}
