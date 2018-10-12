import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
    { path: '', redirectTo: 'screen/home', pathMatch: 'full' },
    { path: 'index.jsp', redirectTo: 'screen/home' },
    { path: 'screen/home', loadChildren: './features/home/home.module#HomeModule' },
    { path: 'screen/monitoring', loadChildren: './features/monitoring/monitoring.module#MonitoringModule' },
    { path: 'screen/bafMonitoring', loadChildren: './features/monitoring-baf/monitoring-baf.module#BAFMonitoringModule' },
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes),
    ],
    exports: [RouterModule],
})
export class AppRoutingModule {}
