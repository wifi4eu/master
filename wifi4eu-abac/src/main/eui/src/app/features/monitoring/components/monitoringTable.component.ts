import { Component, OnInit } from '@angular/core';
import { MonitoringRowDTO } from '../../../shared/model/MonitoringRowDTO';
import { ApiModule } from '../../../shared/api.module';

@Component({
    templateUrl: './monitoringTable.component.html'
})
export class MonitoringTableComponent implements OnInit{
  
    private cols: any[];
    private rows: MonitoringRowDTO[];
    private showLEF: boolean = true;
    private showBC: boolean = false;
    private showLC: boolean = false;
  
    constructor(protected api: ApiModule){
        this.cols = [
            { field: 'countryCode', header: '<br/>Country' },
            { field: 'municipality', header: '<br/>Municipality' },
            { field: 'registrationNumber', header: 'Registration<br/>Number' },
            { field: 'lefStatus', header: '<br/>LEF Status', isFor: 'lef' },
            { field: 'bcStatus', header: '<br/>BC Status', isFor: 'bc' },
            { field: 'lcStatus', header: '<br/>LC Status', isFor: 'lc' },
            { field: 'signatureDate', header: 'Date of<br/>signature' },
            { field: 'counterSignatureDate', header: 'Date of<br/>counter signature' },
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
  
    showColumn(isFor){
        return isFor === undefined ||
            (isFor === 'lef' && this.showLEF) ||
            (isFor === 'bc' && this.showBC) ||
            (isFor === 'lc' && this.showLC)
        ;
    }
}
