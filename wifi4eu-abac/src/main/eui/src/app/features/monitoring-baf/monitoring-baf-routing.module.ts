import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BAFMonitoringTableComponent } from './components/bafMonitoringTable.component';

@NgModule({
    imports: [
        RouterModule.forChild([
            { path: '', component: BAFMonitoringTableComponent }
        ])
    ],
    exports: [
        RouterModule
    ]
})
export class BAFMonitoringRoutingModule {

}
