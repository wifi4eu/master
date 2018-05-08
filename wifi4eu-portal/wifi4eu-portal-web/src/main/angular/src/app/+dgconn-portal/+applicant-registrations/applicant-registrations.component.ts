import { Component } from "@angular/core";
import { animate, style, transition, trigger } from "@angular/animations";
import { ApplicationApi } from "../../shared/swagger/api/ApplicationApi";
import { CallApi } from "../../shared/swagger/api/CallApi";
import { NutsApi } from "../../shared/swagger/api/NutsApi";
import { ApplicantListItemDTOBase } from "../../shared/swagger/model/ApplicantListItemDTO";
import { CallDTOBase } from "../../shared/swagger/model/CallDTO";
import { NutsDTOBase } from "../../shared/swagger/model/NutsDTO";
import { PagingSortingDTOBase } from "../../shared/swagger/model/PagingSortingDTO";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import * as FileSaver from "file-saver";

@Component({
    templateUrl: 'applicant-registrations.component.html',
    providers: [ApplicationApi, CallApi, NutsApi],
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

export class DgConnApplicantRegistrationsComponent {
    private calls: CallDTOBase[] = [];
    private currentCall : CallDTOBase = null;
    private currentIndex : number = 0;
    private country: NutsDTOBase = null;
    private countries: NutsDTOBase[] = [];
    private inputSearch: string = '';
    private searchingByName: boolean = false;
    private nameSearched: string = '';
    private applicantListItems: ApplicantListItemDTOBase[] = [];
    private totalItems: number = 0;
    private page: number = 0;
    private itemsPerPage: number = 5;
    private totalPages: number = 1;
    private rowsPerPageOptions: number[] = [5, 10, 20];
    private sortField: string = 'name';
    private sortOrder: number = 1;
    private loadingData: boolean = false;
    private downloadingList: boolean = false;

    constructor(private applicationApi: ApplicationApi, private callApi: CallApi, private nutsApi: NutsApi) {
        this.callApi.allCalls().subscribe(
            (calls: CallDTOBase[]) => {
                if (calls.length > 0) {
                    this.currentCall = calls[0];
                    this.calls = calls;
                }
            }
        );
        this.nutsApi.getNutsByLevel(0).subscribe(
            (countries: NutsDTOBase[]) => {
                this.countries = countries;
            }
        );
    }

    private inputSearchApplicants() {
        this.page = 0;
        this.searchApplicants();
    }

    private searchApplicants() {
        if (this.currentCall) {
            this.loadingData = true;
            let pagingAndSortingData = new PagingSortingDTOBase();
            pagingAndSortingData.offset = this.itemsPerPage * this.page;
            pagingAndSortingData.count = this.itemsPerPage;
            pagingAndSortingData.orderField = this.sortField;
            pagingAndSortingData.orderType = this.sortOrder;
            let countryCode = '%';
            if (this.country != null) {
                countryCode = this.country.countryCode;
            }
            if (this.inputSearch.trim().length > 0) {
                this.searchingByName = true;
                this.nameSearched = this.inputSearch.trim();
                this.applicationApi.findDgconnApplicantsListByCallIdSearchingName(this.currentCall.id, countryCode, this.nameSearched, pagingAndSortingData).subscribe(
                    (response: ResponseDTOBase) => {
                        this.loadingData = false;
                        if (response.success) {
                            this.totalItems = response.xtotalCount;
                            this.totalPages = this.totalItems / this.itemsPerPage;
                            this.applicantListItems = response.data;
                        }
                    }, error => {
                        this.loadingData = false;
                    }
                );
            } else {
                this.applicationApi.findDgconnApplicantsListByCallId(this.currentCall.id, countryCode, pagingAndSortingData).subscribe(
                    (response: ResponseDTOBase) => {
                        this.loadingData = false;
                        if (response.success) {
                            this.totalItems = response.xtotalCount;
                            this.totalPages = this.totalItems / this.itemsPerPage;
                            this.applicantListItems = response.data;
                        }
                    }, error => {
                        this.loadingData = false;
                    }
                );
            }
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
        this.searchApplicants();
    }

    private changeCall(event) {
        if (event['index'] != null) {
            let index = event['index'];
            if (this.calls[index]) {
                this.currentIndex = index;
                this.currentCall = this.calls[index];
                this.searchApplicants();
            }
        }
    }

    private changeCountry(event) {
        this.searchApplicants();
    }

    private exportListExcel() {
        if (!this.loadingData && !this.downloadingList) {
            this.downloadingList = true;
            let countryCode = '%';
            if (this.country != null) {
                countryCode = this.country.countryCode;
            }
            if (this.searchingByName) {
                this.applicationApi.exportExcelDGConnApplicantsListSearchingName(this.currentCall.id, countryCode, this.nameSearched).subscribe(
                    (response) => {
                        let blob = new Blob([response], {type: "application/vnd.ms-excel"});
                        FileSaver.saveAs(blob, "applicants.xls");
                        this.downloadingList = false;
                    }
                );
            } else {
                this.applicationApi.exportExcelDGConnApplicantsList(this.currentCall.id, countryCode).subscribe(
                    (response) => {
                        let blob = new Blob([response], {type: "application/vnd.ms-excel"});
                        FileSaver.saveAs(blob, "applicants.xls");
                        this.downloadingList = false;
                    }
                );
            }
        }
    }
}