import { Component, ViewChild } from "@angular/core";
import { animate, style, transition, trigger } from "@angular/animations";
import { ActivatedRoute, Router } from '@angular/router';
import { ApplicationApi } from "../../shared/swagger/api/ApplicationApi";
import { CallApi } from "../../shared/swagger/api/CallApi";
import { NutsApi } from "../../shared/swagger/api/NutsApi";
import { ApplicantListItemDTOBase } from "../../shared/swagger/model/ApplicantListItemDTO";
import { CallDTOBase } from "../../shared/swagger/model/CallDTO";
import { NutsDTOBase } from "../../shared/swagger/model/NutsDTO";
import { PagingSortingDTOBase } from "../../shared/swagger/model/PagingSortingDTO";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import * as FileSaver from "file-saver";
import { Subscription } from "rxjs/Subscription";
import { DataTable } from "primeng/primeng";

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
    private page: number = 0;
    private itemsPerPage: number = 5;
    private totalItems: number = 0;
    private totalPages: number = 1;
    private rowsPerPageOptions: number[] = [5, 10, 20];
    private sortField: string = 'name';
    private sortOrder: number = 1;
    private loadingData: boolean = false;
    private downloadingList: boolean = false;
    private firstDataDownload: boolean = true;
    private componentURL = '/dgconn-portal/applicant-registrations';
    private findApplicantsSubscription: Subscription = new Subscription();
    @ViewChild("tableApplicants") tableApplicants: DataTable;

    constructor(private applicationApi: ApplicationApi, private callApi: CallApi, private nutsApi: NutsApi, private activatedRoute: ActivatedRoute, private router: Router) {
        this.callApi.allCalls().subscribe(
            (calls: CallDTOBase[]) => {
                if (calls.length > 0) {
                    this.currentCall = calls[0];
                    this.calls = calls;
                    this.nutsApi.getNutsByLevel(0).subscribe(
                        (countries: NutsDTOBase[]) => {
                            this.countries = countries;
                            this.activatedRoute.queryParams.subscribe(
                                queryParams => {
                                    if (queryParams['name']) {
                                        this.inputSearch = queryParams['name'];
                                        this.searchingByName = true;
                                    }
                                    if (queryParams['country']) {
                                        this.country = this.countryCodeExists(queryParams['country']);
                                    }
                                    if (queryParams['items']) {
                                        let items = queryParams['items'];
                                        if (items <= 7) {
                                            this.itemsPerPage = 5;
                                        } else if (items > 7 && items <= 14) {
                                            this.itemsPerPage = 10;
                                        } else if (items > 14) {
                                            this.itemsPerPage = 20;
                                        }
                                    }
                                    this.firstDataDownload = false;
                                    this.page = 0;
                                    this.searchApplicants();
                                }
                            );
                        }
                    );
                }
            }
        );
    }

    private searchApplicants() {
        if (this.currentCall) {
            this.applicantListItems = [];
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
            this.findApplicantsSubscription.unsubscribe();
            if (this.inputSearch.trim().length > 0) {
                this.searchingByName = true;
                this.nameSearched = this.inputSearch.trim();
                this.findApplicantsSubscription = this.applicationApi.findDgconnApplicantsListByCallIdSearchingName(this.currentCall.id, countryCode, this.nameSearched, pagingAndSortingData).subscribe(
                    (response: ResponseDTOBase) => {
                        this.loadingData = false;
                        if (response.success) {
                            this.applicantListItems = response.data;
                            this.totalItems = response.xtotalCount;
                            this.tableApplicants.totalRecords = this.totalItems;
                            this.totalPages = this.totalItems / this.itemsPerPage;
                            this.tableApplicants.pageLinks = this.totalPages;
                        }
                    }, error => {
                        this.loadingData = false;
                    }
                );
            } else {
                this.searchingByName = false;
                this.findApplicantsSubscription = this.applicationApi.findDgconnApplicantsListByCallId(this.currentCall.id, countryCode, pagingAndSortingData).subscribe(
                    (response: ResponseDTOBase) => {
                        this.loadingData = false;
                        if (response.success) {
                            this.applicantListItems = response.data;
                            this.totalItems = response.xtotalCount;
                            this.tableApplicants.totalRecords = this.totalItems;
                            this.totalPages = this.totalItems / this.itemsPerPage;
                            this.tableApplicants.pageLinks = this.totalPages;
                        }
                    }, error => {
                        this.loadingData = false;
                    }
                );
            }
        }
    }

    private countryCodeExists(countryCode: string) {
        let country = null;
        for (let c of this.countries) {
            if (c.countryCode == countryCode.toUpperCase()) {
                country = c;
            }
        }
        return country;
    }

    private searchByName() {
        if (this.inputSearch.trim().length > 0) {
            this.searchingByName = true;
            this.nameSearched = this.inputSearch.trim();
        } else {
            this.searchingByName = false;
            this.nameSearched = '';
        }
        this.filterApplicantsSearch();
    }

    private filterApplicantsSearch() {
        let nameSearched = null;
        if (this.searchingByName && this.nameSearched.trim().length > 0) {
            nameSearched = this.nameSearched;
        }
        let countryCode = null;
        if (this.country != null) {
            countryCode = this.country.countryCode;
        }
        let numItems = null;
        if (this.itemsPerPage <= 5) {
            numItems = 5;
        } else if (this.itemsPerPage > 5 && this.itemsPerPage <= 10) {
            numItems = 10;
        } else if (this.itemsPerPage > 10) {
            numItems = 20;
        }
        this.router.navigate([this.componentURL], {queryParams: {name: nameSearched, country: countryCode, items: numItems}});
    }

    private paginateData(event) {
        if (event['rows'] != null) {
            if (this.itemsPerPage != event['rows']) {
                this.itemsPerPage = event['rows'];
                this.filterApplicantsSearch();
            }
        }
        if (event['first'] != null) {
            if (this.page != event['first'] / this.itemsPerPage) {
                this.page = event['first'] / this.itemsPerPage;
                this.searchApplicants();
            }
        }
    }

    private sortData(event) {
        if (event['field'] != null)
            this.sortField = event['field'];
        if (event['order'] != null)
            this.sortOrder = event['order'];
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
                        let blob = new Blob([response], {type: 'application/vnd.ms-excel'});
                        FileSaver.saveAs(blob, 'applicants.xls');
                        this.downloadingList = false;
                    }
                );
            } else {
                this.applicationApi.exportExcelDGConnApplicantsList(this.currentCall.id, countryCode).subscribe(
                    (response) => {
                        let blob = new Blob([response], {type: 'application/vnd.ms-excel'});
                        FileSaver.saveAs(blob, 'applicants.xls');
                        this.downloadingList = false;
                    }
                );
            }
        }
    }
}