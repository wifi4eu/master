import { Component } from "@angular/core";
import { SupplierApi } from "../../../shared/swagger/api/SupplierApi";
import { ResponseDTOBase } from "../../../shared/swagger/model/ResponseDTO";
import { animate, style, transition, trigger } from "@angular/animations";
import { SupplierListItemDTO } from "../../../shared/swagger/model/SupplierListItemDTO";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import {CallApi} from "../../../shared/swagger/api/CallApi";
import {ApplicationApi} from "../../../shared/swagger/api/ApplicationApi";
import {TranslateService} from "ng2-translate";
import {ConfigureGlobalCommitmentsApi} from "../../../shared/swagger/api/ConfigureGlobalCommitmentsApi";
//import {GlobalCommitmentDTO} from "../../../shared/swagger/model/GlobalCommitmentDTO";



@Component({
    templateUrl: 'configureGlobalCommitments.component.html',
    providers: [SupplierApi, CallApi, ApplicationApi, ConfigureGlobalCommitmentsApi],
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

export class DgConfigureGlobalCommitmentsComponent {
    private inputSearch: string = '';
    private supplierListItems: SupplierListItemDTO[] = [];
    private totalItems: number = 0;
    private page: number = 0;
    private itemsPerPage: number = 5;
    private totalPages: number = 1;
    private rowsPerPageOptions: number[] = [5, 10, 20];
    private sortField: string = 'name';
    private sortOrder: number = 1;
    private loadingData: boolean = false;
    private globalCommitments: ResponseDTOBase;

    constructor(private supplierApi: SupplierApi, private http: Http, private configureGlobalCommitmentsApi: ConfigureGlobalCommitmentsApi) {
     this.page = 0;
     this.loadingData = true;
     //this.supplierApi.findDgconnSuppliersList(this.page, this.itemsPerPage, this.sortField, this.sortOrder).subscribe(
     this.configureGlobalCommitmentsApi.configureGlobalCommitments().subscribe(
        //(globalCommitments: GlobalCommitmentDTO[]) => {
        (response: ResponseDTOBase) => {
            this.loadingData = false;
            if (response.success) {
                this.totalItems = response.xtotalCount;
                this.totalPages = this.totalItems / this.itemsPerPage;
                //this.supplierListItems = response.data;
                this.globalCommitments = response;
                //alert(response.data[0].id);
                //alert(this.globalCommitments.data[0].id);
            }
        }
     );
    }

    private inputSearchSuppliers() {
        this.page = 0;
        this.searchSuppliers();
    }

    private searchSuppliers() {
        this.loadingData = true;
        if (this.inputSearch.trim().length > 0) {
            this.supplierApi.findDgconnSuppliersListSearchingName(this.inputSearch.trim(), this.page, this.itemsPerPage, this.sortField, this.sortOrder).subscribe(
                (response: ResponseDTOBase) => {
                    this.loadingData = false;
                    if (response.success) {
                        this.totalItems = response.xtotalCount;
                        this.totalPages = this.totalItems / this.itemsPerPage;
                        this.supplierListItems = response.data;
                    }
                }
            );
        } else {
            this.supplierApi.findDgconnSuppliersList(this.page, this.itemsPerPage, this.sortField, this.sortOrder).subscribe(
                (response: ResponseDTOBase) => {
                    this.loadingData = false;
                    if (response.success) {
                        this.totalItems = response.xtotalCount;
                        this.totalPages = this.totalItems / this.itemsPerPage;
                        this.supplierListItems = response.data;
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
        this.searchSuppliers();
    }


}