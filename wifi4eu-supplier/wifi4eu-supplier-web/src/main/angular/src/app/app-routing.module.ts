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
            { path: 'screen/access-point/:id/:name', loadChildren: 'app/features/access-point/access-point.module#AccessPointModule' }
        ], {useHash: true})
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule {

}
