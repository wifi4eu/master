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
    private rows: MonitoringRowDTO[];

    private showLEF: boolean = true;
    private showBC: boolean = true;
    private showLC: boolean = true;

    private filterTimeout: any;
    private filterCountry: string;
    private filterName: string;

    private selectedLegalEntities = [];

    @ViewChild('monitoring') monitoringTable: Table;

    constructor(protected api: ApiModule, protected uxService: UxService){
        this.cols = [
            { field: 'selected', header: 'Select' },
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
        this.monitoringTable.multiSortMeta = [
            { field: 'countryCode', order: 1 },
            { field: 'municipality', order: 1 }
        ];
        this.loadData();

    }

    loadData() {
        this.selectedLegalEntities = [];
        this.api.getMonitoringData().subscribe(monitoringRows => this.rows = monitoringRows);
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
        this.applyFilters();
    }

    applyFilters(){
        if (this.filterTimeout) {
            clearTimeout(this.filterTimeout);
        }
        this.filterTimeout = setTimeout(() => {
          this.monitoringTable.filters = {
              'countryCode': { value: this.filterCountry, matchMode: 'equals' },
              'municipality': { value: this.filterName, matchMode: 'contains' }
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
