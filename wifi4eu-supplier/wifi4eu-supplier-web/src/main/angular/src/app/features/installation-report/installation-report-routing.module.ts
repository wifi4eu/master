import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { InstallationListComponent } from './components/installation-list/installation-list.component';
import { Page2Component } from './components/page2/page2.component';
import { InstallationReportComponent } from './installation-report.component';

@NgModule({
    imports: [
        RouterModule.forChild([
            { path: '', component: InstallationListComponent },
            { path: 'page2', component: Page2Component }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class InstallationReportRoutingModule {
}
