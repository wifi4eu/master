import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { InstallationListComponent } from './components/installation-list/installation-list.component';
import { InstallationDetailsComponent } from './components/installation-details/installation-details.component';
import { InstallationReportComponent } from './installation-report.component';

@NgModule({
    imports: [
        RouterModule.forChild([
            { path: '', component: InstallationListComponent },
            { path: 'details', component: InstallationDetailsComponent }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class InstallationReportRoutingModule {
}
