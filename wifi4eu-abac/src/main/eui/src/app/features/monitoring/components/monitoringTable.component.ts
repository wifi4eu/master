import { Component, OnInit, ViewChild } from '@angular/core';
import { Table } from 'primeng/components/table/table';
import { MonitoringRowDTO, CountryDTO } from '../../../shared/model/DTOs';
import { ApiModule } from '../../../shared/api.module';
import { UxMessageBoxComponent } from '@eui/ux-commons';
import { UxService } from '@eui/ux-core';

@Component({
    templateUrl: './monitoringTable.component.html'
})
export class MonitoringTableComponent implements OnInit{

    private errorMessage: string;

    private cols: any[];
    private countries: CountryDTO[];
    private lefStatuses: string[] = [];
    private bcStatuses: string[] = [];
    private lcStatuses: string[] = [];
    private rows: MonitoringRowDTO[];

    private showLEF: boolean = true;
    private showBC: boolean = true;
    private showLC: boolean = true;

    private filterTimeout: any;
    private filterCountry: string;
    private filterName: string;
    private filterLEFStatus: string;
    private filterBCStatus: string;
    private filterLCStatus: string;

    private selectedLegalEntities = [];

    @ViewChild('monitoring') monitoringTable: Table;

    constructor(protected api: ApiModule, protected uxService: UxService){
        this.cols = [
            { field: 'selected', header: 'Select' },
            { field: 'countryCode', header: '<br/>Country' },
            { field: 'municipality', header: '<br/>Municipality' },
            { field: 'registrationNumber', header: 'Registration<br/>Number' },
            { field: 'lefStatus', header: '<br/>LEF Status', isFor: 'lef' },
            { field: 'lefAbacRef', header: '<br/>LEF ABAC ref', isFor: 'lef' },
            { field: 'bcStatus', header: '<br/>BC Status', isFor: 'bc' },
            { field: 'bcAbacRef', header: '<br/>BC ABAC ref', isFor: 'bc' },
            { field: 'lcStatus', header: '<br/>LC Status', isFor: 'lc' },
            { field: 'lcAbacRef', header: '<br/>LC ABAC ref', isFor: 'lc' },
            { field: 'signatureDate', header: 'Date of<br/>signature' },
            { field: 'counterSignatureDate', header: 'Date of<br/>counter signature' },
        ];
    }

    ngOnInit() {
        this.monitoringTable.multiSortMeta = [
            { field: 'countryCode', order: 1 },
            { field: 'municipality', order: 1 }
        ];
        this.loadData();

    }

    loadData() {
        this.selectedLegalEntities = [];
        this.api.getMonitoringData().subscribe(monitoringRows => {
            this.rows = monitoringRows;
            for (let i = 0; i < this.rows.length; i++) {
                let
                    lefStatus = this.rows[i].lefStatus,
                    bcStatus = this.rows[i].bcStatus,
                    lcStatus = this.rows[i].lcStatus
                ;
                if (lefStatus !== undefined && lefStatus !== '' && this.lefStatuses.indexOf(lefStatus) === -1){
                    this.lefStatuses.push(lefStatus);
                }
                if (bcStatus !== undefined && bcStatus !== '' && this.bcStatuses.indexOf(bcStatus) === -1){
                    this.bcStatuses.push(bcStatus);
                }
                if (lcStatus !== undefined && lcStatus !== '' && this.lcStatuses.indexOf(lcStatus) === -1){
                    this.lcStatuses.push(lcStatus);
                }
            }
            this.lefStatuses.sort();
            this.bcStatuses.sort();
            this.lcStatuses.sort();
        });
        this.api.getCountries().subscribe(countries => this.countries = countries);
    }

    showColumn(isFor){
        return isFor === undefined ||
            (isFor === 'lef' && this.showLEF) ||
            (isFor === 'bc' && this.showBC) ||
            (isFor === 'lc' && this.showLC)
        ;
    }

    clearFilters(){
        this.filterCountry = undefined;
        this.filterName = undefined;
        this.filterLEFStatus = undefined;
        this.filterBCStatus = undefined;
        this.filterLCStatus = undefined;
        this.applyFilters();
    }

    applyFilters(){
        if (this.filterTimeout) {
            clearTimeout(this.filterTimeout);
        }
        this.filterTimeout = setTimeout(() => {
          this.monitoringTable.filters = {
              'countryCode': { value: this.filterCountry, matchMode: 'equals' },
              'municipality': { value: this.filterName, matchMode: 'contains' },
              'lefStatus' : { value: this.filterLEFStatus, matchMode: 'equals' },
              'bcStatus' : { value: this.filterBCStatus, matchMode: 'equals' },
              'lcStatus' : { value: this.filterLCStatus, matchMode: 'equals' },
          };
          this.monitoringTable._filter();
        }, 200);
    }

    countersignSelected(userConfirmedOperation) {

        if (userConfirmedOperation) {
            this.api.counterSignGrantAgreements(this.selectedLegalEntities).subscribe(
                event => {
                    this.showSuccess();
                    this.loadData();
                },
                (err) => {
                    this.showError(err.message);
                }
            );
        }
    }

    showError(message: string){
        this.errorMessage = message;
        this.uxService.openMessageBox('messagebox_fail');
    }

    showSuccess(){
        this.uxService.openMessageBox('messagebox_countersign_success');
    }
}
