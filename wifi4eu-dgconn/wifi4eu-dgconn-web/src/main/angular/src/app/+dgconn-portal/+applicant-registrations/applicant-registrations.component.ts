import { Component, ViewChild } from "@angular/core";
import { animate, style, transition, trigger } from "@angular/animations";
import { ActivatedRoute, Router } from '@angular/router';
import { SharedService } from "../../shared/shared.service";
import { ApplicationApi } from "../../shared/swagger/api/ApplicationApi";
import { CallApi } from "../../shared/swagger/api/CallApi";
import { NutsApi } from "../../shared/swagger/api/NutsApi";
import { ApplicantListItemDTOBase } from "../../shared/swagger/model/ApplicantListItemDTO";
import { CallDTOBase } from "../../shared/swagger/model/CallDTO";
import { NutsDTOBase } from "../../shared/swagger/model/NutsDTO";
import { CorrectionRequestEmailDTOBase } from "../../shared/swagger/model/CorrectionRequestEmailDTO";
import { PagingSortingDTOBase } from "../../shared/swagger/model/PagingSortingDTO";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import * as FileSaver from "file-saver";
import { Subscription } from "rxjs/Subscription";
import { DataTable } from "primeng/primeng";
import { TranslateService } from "ng2-translate/ng2-translate";

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
    private correctionRequestsEmailAvailable: boolean = false;
    private displayCorrectionEmails: boolean = false;
    private sendingCorrectionEmails: boolean = false;
    private correctionRequestsEmailCounter: number = 0;
    private correctionRequestsEmailDate: string = null;
    private correctionRequestsEmailTime: string = null;
    private warningTooltipMessages: string[] = [];
    private warning1Message: string = '';
    private warning2Message: string = '';
    private warning3Message: string = '';
    private hasNew: boolean = false;

    private sendNotificationsPsswd: string = '';
    private showNotificationModal: boolean = false;

    constructor(private applicationApi: ApplicationApi, private callApi: CallApi, private nutsApi: NutsApi, private activatedRoute: ActivatedRoute, private router: Router, private sharedService: SharedService, private translateService: TranslateService) {
        this.callApi.allCalls().subscribe(
            (calls: CallDTOBase[]) => {
                if (calls.length > 0) {
                    this.currentCall = calls[0];
                    this.calls = calls;
                    this.getCorrectionRequestsEmailData(this.currentCall.id);
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
                                    if (queryParams['page']) {
                                        this.page = queryParams['page'];
                                    }
                                    if (queryParams['order']) {
                                        let order = queryParams['order'];
                                        if (order.toString().toLowerCase().trim() == 'asc')
                                            this.sortOrder = 1;
                                        else if (order.toString().toLowerCase().trim() == 'desc')
                                            this.sortOrder = -1;
                                    }
                                    if (queryParams['sortField']) {
                                        let sortField = queryParams['sortField'].toString().toLowerCase().trim();
                                        if (sortField == 'countryCode' || sortField == 'counter' || sortField == 'mediation' || sortField == 'supportingdocuments')
                                            this.sortField = sortField;
                                        else
                                            this.sortField = 'name';
                                    }
                                    this.firstDataDownload = false;
                                    this.searchApplicants();
                                }
                            );
                        }
                    );
                }
            }
        );
        this.translateService.get('dgConn.badge.warning1Info').subscribe(
            (translatedString: string) => {
                this.warning1Message = translatedString;
            }
        );
        this.translateService.get('dgConn.badge.warning2Info').subscribe(
            (translatedString: string) => {
                this.warning2Message = translatedString;
            }
        );
        this.translateService.get('dgConn.badge.warning3Info').subscribe(
            (translatedString: string) => {
                this.warning3Message = translatedString;
            }
        );
    }

    private searchApplicants() {
        if (this.currentCall) {
            this.applicantListItems = [];
            this.warningTooltipMessages = [];
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
                        if (response.success) {
                            this.totalItems = response.xtotalCount;
                            this.tableApplicants.totalRecords = this.totalItems;
                            this.totalPages = this.totalItems / this.itemsPerPage;
                            this.tableApplicants.pageLinks = this.totalPages;
                            if (this.page > this.totalPages) {
                                this.page = 0;
                                this.filterApplicantsSearch();
                            } else {
                                this.applicantListItems = response.data;
                                this.updateWarningTooltipMessages();
                                this.loadingData = false;
                            }
                        }
                    }, error => {
                        this.loadingData = false;
                    }
                );
            } else {
                this.searchingByName = false;
                this.findApplicantsSubscription = this.applicationApi.findDgconnApplicantsListByCallId(this.currentCall.id, countryCode, pagingAndSortingData).subscribe(
                    (response: ResponseDTOBase) => {
                        if (response.success) {
                            this.totalItems = response.xtotalCount;
                            this.tableApplicants.totalRecords = this.totalItems;
                            this.totalPages = this.totalItems / this.itemsPerPage;
                            this.tableApplicants.pageLinks = this.totalPages;
                            if (this.page > this.totalPages) {
                                this.page = 0;
                                this.filterApplicantsSearch();
                            } else {
                                this.applicantListItems = response.data;
                                this.updateWarningTooltipMessages();
                                this.loadingData = false;
                            }
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
        let page = null;
        if (this.page != 0) {
            page = this.page;
        }
        let order = null;
        if (this.sortOrder == 1)
            order = 'asc';
        else if (this.sortOrder == -1)
            order = 'desc';
        let sortField = null;
        if (this.sortField != null) {
            sortField = this.sortField;
        }
        this.router.navigate([this.componentURL], {queryParams: {name: nameSearched, country: countryCode, items: numItems, page: page, order: order, sortField: sortField}});
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
                this.filterApplicantsSearch();
            }
        }
    }

    private sortData(event) {
        if (event['field'] != null)
            this.sortField = event['field'];
        if (event['order'] != null)
            this.sortOrder = event['order'];
        this.filterApplicantsSearch();
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

    private displayCorrectionEmailsModal() {
       this.showNotificationModal = true;
       this.sendNotificationsPsswd = '';
    }

    private sendCorrectionEmails() {
        if (this.currentCall != null && this.correctionRequestsEmailAvailable) {
            this.sendingCorrectionEmails = true;
            this.applicationApi.sendCorrectionEmails(this.sendNotificationsPsswd ,this.currentCall.id).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        if (response.data != null) {
                            let correctionRequest = response.data;
                            let timestamp = new Date(correctionRequest.date);
                            this.correctionRequestsEmailDate = ('0' + timestamp.getUTCDate()).slice(-2) + '/' + ('0' + (timestamp.getUTCMonth() + 1)).slice(-2) + "/" + timestamp.getUTCFullYear();
                            this.correctionRequestsEmailTime = ('0' + (timestamp.getUTCHours() + 2)).slice(-2) + ':' + ('0' + timestamp.getUTCMinutes()).slice(-2);
                            this.correctionRequestsEmailCounter = correctionRequest.buttonPressedCounter;
                        }
                        this.applicationApi.checkIfCorrectionRequestEmailIsAvailable(this.currentCall.id).subscribe(
                            (enabled: boolean) => {
                                if (enabled)
                                    this.correctionRequestsEmailAvailable = true;
                                else
                                    this.correctionRequestsEmailAvailable = false;
                            }
                        );
                        this.sharedService.growlTranslation('An email has been sent to the representants of the legal entities to supply the legal documents for the registration.', 'dgConn.duplicatedBeneficiaryDetails.requestLegalDocuments.success', 'success');
                    } else {
                        if(response.error.errorCode == 20){
                          this.sharedService.growlTranslation('An error occurred while sending notifications.', response.error.errorMessage, 'error');
                        }
                    }
                    this.closeModal();
                }, error => {
                    this.sharedService.growlTranslation('An error occurred while trying to request the legal documents of the registration. Please, try again later.', 'dgConn.duplicatedBeneficiaryDetails.requestLegalDocuments.error', 'error');
                    this.closeModal();
                }
            );
        }
    }

    private closeModal() {
        this.sendingCorrectionEmails = false;
        this.displayCorrectionEmails = false;
        this.showNotificationModal = false;
    }

    private getCorrectionRequestsEmailData(callId: number) {
        if (callId != null) {
            this.applicationApi.checkIfCorrectionRequestEmailIsAvailable(callId).subscribe(
                (enabled: boolean) => {
                    if (enabled)
                        this.correctionRequestsEmailAvailable = true;
                    else
                        this.correctionRequestsEmailAvailable = false;
                }
            );
            this.applicationApi.getLastCorrectionRequestEmail(callId).subscribe(
                (correctionEmail: CorrectionRequestEmailDTOBase) => {
                    if (correctionEmail != null) {
                        let timestamp = new Date(correctionEmail.date);
                        this.correctionRequestsEmailDate = ('0' + timestamp.getUTCDate()).slice(-2) + '/' + ('0' + (timestamp.getUTCMonth() + 1)).slice(-2) + "/" + timestamp.getUTCFullYear();
                        this.correctionRequestsEmailTime = ('0' + (timestamp.getUTCHours() + 2)).slice(-2) + ':' + ('0' + timestamp.getUTCMinutes()).slice(-2);
                        this.correctionRequestsEmailCounter = correctionEmail.buttonPressedCounter;
                    }
                }
            );
        }
    }

    private updateWarningTooltipMessages() {
        for (let item of this.applicantListItems) {
            let warningTooltipMessage = null;
            if (item.warning1) {
                warningTooltipMessage = "1) " + this.warning1Message;
            }
            if (item.warning2) {
                if (warningTooltipMessage != null) {
                    warningTooltipMessage += "<br/><br/>2) " + this.warning2Message;
                } else {
                    warningTooltipMessage = "2) " + this.warning2Message;
                }
            }
            if (item.warning3) {
                if (warningTooltipMessage != null) {
                    warningTooltipMessage += "<br/><br/>3) " + this.warning3Message;
                } else {
                    warningTooltipMessage = "3) " + this.warning3Message;
                }
            }
            this.warningTooltipMessages.push(warningTooltipMessage);
        }
    }
}