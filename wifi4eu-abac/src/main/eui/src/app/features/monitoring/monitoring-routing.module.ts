import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MonitoringTableComponent } from './components/monitoringTable.component';

@NgModule({
    imports: [
        RouterModule.forChild([
            { path: '', component: MonitoringTableComponent }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class MonitoringRoutingModule {

}
