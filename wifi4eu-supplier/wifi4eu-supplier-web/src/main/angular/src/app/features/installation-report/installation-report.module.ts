import { NgModule } from '@angular/core';
import { InstallationReportRoutingModule } from './installation-report-routing.module';
import { InstallationReportComponent } from './installation-report.component';
import { InstallationDetailsComponent } from './components/installation-details/installation-details.component';

import { SharedModule } from '../../shared/shared.module';
import { InstallationListComponent } from './components/installation-list/installation-list.component';
import { UpdateInstallationSite } from "./components/update-installation-site/update-installation-site.component"
import { SearchParametersService } from '../../core/services/search-parameters.service';
import {AutoCompleteModule, DataTableModule, CheckboxModule, TooltipModule, DropdownModule} from "primeng/primeng";
import { EqualValidator } from '../../core/directives/validate-equals.directive'; 
import { InstallationsiteApi } from '../../shared/swagger/api/InstallationsiteApi';
import { BeneficiaryApi } from '../../shared/swagger';
import { InstallationSiteDetailResolver } from '../../core/services/installation-site.service';

@NgModule({
    imports: [
        SharedModule,
        InstallationReportRoutingModule,
        AutoCompleteModule,
        DropdownModule,
        DataTableModule,
        CheckboxModule,
        TooltipModule        
    ],
    declarations: [
        InstallationListComponent,
        UpdateInstallationSite,
        EqualValidator,
        InstallationDetailsComponent
    
    ],
    providers: [
        SearchParametersService,
        InstallationSiteDetailResolver,
        InstallationsiteApi
    ],
    bootstrap: [
        InstallationListComponent
    ]
})
export class InstallationReportModule {
}
