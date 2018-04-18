import { NgModule } from '@angular/core';
import { InstallationReportRoutingModule } from './installation-report-routing.module';
import { InstallationReportComponent } from './installation-report.component';
import { Page2Component } from './components/page2/page2.component';

import { SharedModule } from '../../shared/shared.module';
import { InstallationListComponent } from './components/installation-list/installation-list.component';
import { UpdateInstallationSite } from "./components/update-installation-site/update-installation-site.component"
import { SearchParametersService } from '../../core/services/search-parameters.service';
import {AutoCompleteModule, DataTableModule, CheckboxModule, TooltipModule} from "primeng/primeng";

@NgModule({
    imports: [
        SharedModule,
        InstallationReportRoutingModule,
        AutoCompleteModule,
        DataTableModule,
        CheckboxModule,
        TooltipModule        
    ],
    declarations: [
        InstallationListComponent,
        UpdateInstallationSite,
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
