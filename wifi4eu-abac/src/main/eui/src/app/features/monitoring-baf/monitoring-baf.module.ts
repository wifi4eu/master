import { NgModule } from '@angular/core';
import { ApiModule } from '../../shared/api.module';
import { BAFMonitoringRoutingModule } from './monitoring-baf-routing.module';
import { BAFMonitoringTableComponent } from './components/bafMonitoringTable.component';
import { TableModule } from 'primeng/table';
import { CheckboxModule } from 'primeng/components/checkbox/checkbox';

@NgModule({
    imports: [
        ApiModule,
        TableModule,
        BAFMonitoringRoutingModule,
        CheckboxModule
    ],
    declarations: [
        BAFMonitoringTableComponent
    ],
    bootstrap: [
        BAFMonitoringTableComponent
    ]
})
export class BAFMonitoringModule {
}
