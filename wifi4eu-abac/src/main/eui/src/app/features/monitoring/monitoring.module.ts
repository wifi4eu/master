import { NgModule } from '@angular/core';
import { ApiModule } from '../../shared/api.module';
import { MonitoringRoutingModule } from './monitoring-routing.module';
import { MonitoringTableComponent } from './components/monitoringTable.component';
import { TableModule } from 'primeng/table';
import { CheckboxModule } from 'primeng/components/checkbox/checkbox';

@NgModule({
    imports: [
        ApiModule,
        TableModule,
        MonitoringRoutingModule,
        CheckboxModule
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
