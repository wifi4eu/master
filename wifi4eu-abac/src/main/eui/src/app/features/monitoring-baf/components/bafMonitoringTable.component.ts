import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Table } from 'primeng/components/table/table';
import { ResponseDTO, BAFMonitoringRowDTO, CountryDTO } from '../../../shared/model/DTOs';
import { ApiModule } from '../../../shared/api.module';
import { UxService } from '@eui/ux-core';

@Component({
    templateUrl: './bafMonitoringTable.component.html'
})
export class BAFMonitoringTableComponent implements OnInit{

    private cols: any[];
    private countries: CountryDTO[];
    private bafStatuses: string[] = [];
    private rows: BAFMonitoringRowDTO[];
    private filterTimeout: any;
    private filterCountry: string;
    private filterName: string;
    private filterBAFStatus: string;

    @ViewChild('monitoring') monitoringTable: Table;

    constructor(protected api: ApiModule, protected uxService: UxService){
        this.cols = [
            { field: 'countryCode', header: 'Country' },
            { field: 'accountName', header: 'Account Name' },
            { field: 'bafStatus', header: 'BAF Status' }
        ];
    }

    ngOnInit() {
        this.monitoringTable.multiSortMeta = [
            { field: 'countryCode', order: 1 },
            { field: 'accountName', order: 1 }
        ];
        this.loadData();

    }

    loadData() {
        this.api.getBAFMonitoringData().subscribe(bafMonitoringRows => {
            this.rows = bafMonitoringRows;

            for (let i = 0; i < this.rows.length; i++) {
                let bafStatus = this.rows[i].bafStatus;
                if (bafStatus !== undefined && bafStatus !== null && bafStatus.trim() !== '' && this.bafStatuses.indexOf(bafStatus) === -1){
                    this.bafStatuses.push(bafStatus);
                }
            }
            this.bafStatuses.sort();
        });
        this.api.getCountries().subscribe(countries => this.countries = countries);
    }

    clearFilters(){
        this.filterCountry = undefined;
        this.filterName = undefined;
        this.filterBAFStatus = undefined;
        this.applyFilters();
    }

    applyFilters(){
        if (this.filterTimeout) {
            clearTimeout(this.filterTimeout);
        }
        this.filterTimeout = setTimeout(() => {
          if (this.filterCountry === 'undefined'){
              this.filterCountry = undefined;
          }
          if (this.filterBAFStatus === 'undefined'){
              this.filterBAFStatus = undefined;
          }
          this.monitoringTable.filters = {
              'countryCode': { value: this.filterCountry, matchMode: 'equals' },
              'accountName': { value: this.filterName, matchMode: 'contains' },
              'bafStatus' : { value: this.filterBAFStatus, matchMode: 'equals' },
          };
          this.monitoringTable._filter();
        }, 200);
    }
}
