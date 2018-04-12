import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './core/components/home/home.component';

@NgModule({
    imports: [
        RouterModule.forRoot([
            { path: '', redirectTo: 'screen/home', pathMatch: 'full' },
            { path: 'index.jsp', redirectTo: 'screen/home' },
            { path: 'screen/home', component: HomeComponent },
            { path: 'screen/installation-report', loadChildren: 'app/features/installation-report/installation-report.module#InstallationReportModule' },
            { path: 'screen/module2', loadChildren: 'app/features/+module2/module2.module#Module2Module' }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule {

}
