import { NgModule } from '@angular/core';
import { ApiModule } from '../../shared/api.module';
import { MonitoringRoutingModule } from './monitoring-routing.module';
import { MonitoringTableComponent } from './components/monitoringTable.component';
import { TableModule } from 'primeng/table';

@NgModule({
    imports: [
        ApiModule,
        TableModule,
        MonitoringRoutingModule
    ],
    declarations: [
        MonitoringTableComponent
    ],
    bootstrap: [
        MonitoringTableComponent
    ]
})
export class MonitoringModule {
}
