import { Component, OnInit } from '@angular/core';
import { MonitoringRowDTO } from '../../../shared/model/MonitoringRowDTO';
import { ApiModule } from '../../../shared/api.module';

@Component({
    templateUrl: './monitoringTable.component.html'
})
export class MonitoringTableComponent implements OnInit{
  
    private cols: any[];
    private rows: MonitoringRowDTO[];
  
    constructor(protected api: ApiModule){
        this.cols = [
            { field: 'countryCode', header: 'Country' },
            { field: 'municipality', header: 'Municipality' },
            { field: 'registrationNumber', header: 'Registration Number' },
            { field: 'wfStatus', header: 'Status' },
            { field: 'signatureDate', header: 'Date of signature' },
            { field: 'counterSignatureDate', header: 'Date of counter signature' },
        ];
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
