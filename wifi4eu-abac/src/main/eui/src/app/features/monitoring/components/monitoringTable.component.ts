import { Component, OnInit } from '@angular/core';
import { MonitoringRowDTO } from '../../../shared/model/MonitoringRowDTO';
import { ApiModule } from '../../../shared/api.module';

@Component({
    templateUrl: './monitoringTable.component.html'
})
export class MonitoringTableComponent implements OnInit{
  
    private rows: MonitoringRowDTO[];
  
    constructor(protected api: ApiModule){
    }
  
    ngOnInit() {
        this.api.getMonitoringData().toPromise().then(rows => this.rows = rows);
    }

    loadData() {
        this.api.getMonitoringData().subscribe(monitoringRows => {
            this.rows = monitoringRows;
        });
    }
}
