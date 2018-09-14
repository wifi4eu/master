import { Component } from "@angular/core";
import { animate, style, transition, trigger } from "@angular/animations";
import { BeneficiaryApi } from "../../shared/swagger/api/BeneficiaryApi";
import { BeneficiaryListItemDTOBase } from "../../shared/swagger/model/BeneficiaryListItemDTO";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import * as FileSaver from "file-saver";

@Component({
    templateUrl: 'beneficiary-registrations.component.html',
    providers: [BeneficiaryApi],
    animations: [
        trigger(
            'enterSpinner', [
                transition(':enter', [
                    style({opacity: 0}),
                    animate('200ms', style({opacity: 1}))
                ]),
                transition(':leave', [
                    style({opacity: 1}),
                    animate('200ms', style({opacity: 0}))
                ])
            ]
        )
    ]
})

export class DgConnBeneficiaryRegistrationsComponent {
    private inputSearch: string = '';
    private searchingByName: boolean = false;
    private nameSearched: string = '';
    private beneficiaryListItems: BeneficiaryListItemDTOBase[] = [];
    private totalItems: number = 0;
    private page: number = 0;
    private itemsPerPage: number = 5;
    private totalPages: number = 1;
    private rowsPerPageOptions: number[] = [5, 10, 20];
    private sortField: string = 'name';
    private sortOrder: number = 1;
    private loadingData: boolean = false;
    private downloadingCSV: boolean = false;

    constructor(private beneficiaryApi: BeneficiaryApi) {
    }

    private inputSearchMunicipalities() {
        this.page = 0;
        this.searchMunicipalities();
    }

    private searchMunicipalities() {
        this.loadingData = true;
        if (this.inputSearch.trim().length > 0) {
            this.searchingByName = true;
            this.nameSearched = this.inputSearch.trim();
            this.beneficiaryApi.findDgconnBeneficiaresListSearchingName(this.inputSearch.trim(), this.itemsPerPage * this.page, this.itemsPerPage, this.sortField, this.sortOrder).subscribe(
                (response: ResponseDTOBase) => {
                    this.loadingData = false;
                    if (response.success) {
                        this.totalItems = response.xtotalCount;
                        this.totalPages = this.totalItems / this.itemsPerPage;
                        this.beneficiaryListItems = response.data;
                    }
                }
            );
        } else {
            this.searchingByName = false;
            this.nameSearched = '';
            this.beneficiaryApi.findDgconnBeneficiaresList(this.itemsPerPage * this.page, this.itemsPerPage, this.sortField, this.sortOrder).subscribe(
                (response: ResponseDTOBase) => {
                    this.loadingData = false;
                    if (response.success) {
                        this.totalItems = response.xtotalCount;
                        this.totalPages = this.totalItems / this.itemsPerPage;
                        this.beneficiaryListItems = response.data;
                    }
                }
            );
        }
    }

    private loadData(event) {
        if (event['rows'] != null)
            this.itemsPerPage = event['rows'];
        if (event['first'] != null)
            this.page = event['first'] / this.itemsPerPage;
        if (event['pageCount'] != null)
            this.totalPages = event['pageCount'];
        if (event['sortField'] != null)
            this.sortField = event['sortField'];
        if (event['sortOrder'] != null)
            this.sortOrder = event['sortOrder'];
        this.searchMunicipalities();
    }

    private exportListCSV() {
        if (!this.loadingData && !this.downloadingCSV) {
            this.downloadingCSV = true;
            if (this.searchingByName) {
                this.beneficiaryApi.exportExcelDGConnBeneficiariesListSearchingName(this.nameSearched).subscribe(
                    (response) => {
                        let blob = new Blob([response], {type: "application/vnd.ms-excel"});
                        FileSaver.saveAs(blob, "beneficiaries.xls");
                        // if (response.success) {
                        //     let csvData = encodeURI('data:text/csv;charset=utf-8,' + response.data);
                        //     let link = document.createElement("a");
                        //     // link.download = 'beneficiaries.csv';
                        //     link.download = 'beneficiaries.xls';
                        //     link.href = csvData;
                        //     document.body.appendChild(link);
                        //     link.click();
                        //     document.body.removeChild(link);
                        //     link.remove();
                        // }
                        this.downloadingCSV = false;
                    }
                );
            } else {
                this.beneficiaryApi.exportExcelDGConnBeneficiariesList().subscribe(
                    (response) => {
                        let blob = new Blob([response], {type: "application/vnd.ms-excel"});
                        FileSaver.saveAs(blob, "beneficiaries.xls");
                        // let csvData = encodeURI('data:text/csv;charset=utf-8,' + response.data);
                        // let link = document.createElement("a");
                        // link.download = 'beneficiaries.csv';
                        // link.download = 'beneficiaries.xls';
                        // link.href = blob;
                        // document.body.appendChild(link);
                        // link.click();
                        // document.body.removeChild(link);
                        // link.remove();
                        this.downloadingCSV = false;
                    }
                );
            }
        }
    }
}