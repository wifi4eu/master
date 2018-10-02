import { Component, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from '@angular/router';
import { SupplierApi } from "../../shared/swagger/api/SupplierApi";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import { animate, style, transition, trigger } from "@angular/animations";
import { SupplierListItemDTO } from "../../shared/swagger/model/SupplierListItemDTO";
import { DataTable } from "primeng/primeng";

@Component({
    templateUrl: 'supplier-registrations.component.html',
    providers: [SupplierApi],
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

export class DgConnSupplierRegistrationsComponent {
    private inputSearch: string = '';
    private searchingByName: boolean = false;
    private nameSearched: string = '';
    private supplierListItems: SupplierListItemDTO[] = [];
    private totalItems: number = 0;
    private page: number = 0;
    private itemsPerPage: number = 10;
    private totalPages: number = 1;
    private rowsPerPageOptions: number[] = [10, 50, 100];
    private sortField: string = 'name';
    private sortOrder: number = 1;
    private loadingData: boolean = false;
    private firstDataDownload: boolean = true;
    private componentURL = '/dgconn-portal/supplier-registrations';
    @ViewChild('tableSuppliers') private tableSuppliers: DataTable;

    constructor(private supplierApi: SupplierApi, private activatedRoute: ActivatedRoute, private router: Router) {
        this.getQueryParams();
    }

    private getQueryParams() {
        this.activatedRoute.queryParams.subscribe(
            queryParams => {
                if (queryParams['name']) {
                    this.inputSearch = queryParams['name'];
                    this.searchingByName = true;
                }
                if (queryParams['items']) {
                    let items = queryParams['items'];
                    if (items <= 29)
                        this.itemsPerPage = 10;
                    else if (items > 29 && items <= 74)
                        this.itemsPerPage = 50;
                    else if (items > 74)
                        this.itemsPerPage = 100;
                }
                if (queryParams['page'])
                    this.page = queryParams['page'];
                if (queryParams['order']) {
                    let order = queryParams['order'];
                    if (order.toString().toLowerCase().trim() == 'asc')
                        this.sortOrder = 1;
                    else if (order.toString().toLowerCase().trim() == 'desc')
                        this.sortOrder = -1;
                }
                if (queryParams['sortField']) {
                    let sortField = queryParams['sortField'].toString();
                    if (sortField == 'website' || sortField == 'vat' || sortField == 'numberRegistrations')
                        this.sortField = sortField;
                    else
                        this.sortField = 'name';
                }
                this.searchSuppliers();
                this.firstDataDownload = false;
            }
        );
    }

    private searchSuppliers() {
        this.supplierListItems = [];
        this.loadingData = true;
        if (this.inputSearch.trim().length > 0) {
            this.searchingByName = true;
            this.nameSearched = this.inputSearch.trim();
            this.supplierApi.findDgconnSuppliersListSearchingName(this.nameSearched, this.page, this.itemsPerPage, this.sortField, this.sortOrder).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.totalItems = response.xtotalCount;
                        this.tableSuppliers.totalRecords = this.totalItems;
                        this.totalPages = this.totalItems / this.itemsPerPage;
                        this.tableSuppliers.pageLinks = this.totalPages;
                        if (this.page > this.totalPages) {
                            this.page = 0;
                            this.filterSuppliersSearch();
                        } else {
                            this.supplierListItems = response.data;
                            this.loadingData = false;
                        }
                    }
                }, error => {
                    this.loadingData = false;
                }
            );
        } else {
            this.searchingByName = false;
            this.supplierApi.findDgconnSuppliersList(this.page, this.itemsPerPage, this.sortField, this.sortOrder).subscribe(
                (response: ResponseDTOBase) => {
                    this.loadingData = false;
                    if (response.success) {
                        this.totalItems = response.xtotalCount;
                        this.tableSuppliers.totalRecords = this.totalItems;
                        this.totalPages = this.totalItems / this.itemsPerPage;
                        this.tableSuppliers.pageLinks = this.totalPages;
                        if (this.page > this.totalPages) {
                            this.page = 0;
                            this.filterSuppliersSearch();
                        } else {
                            this.supplierListItems = response.data;
                            this.loadingData = false;
                        }
                    }
                }, error => {
                    this.loadingData = false;
                }
            );
        }
    }

    private searchByName() {
        if (this.inputSearch.trim().length > 0) {
            this.searchingByName = true;
            this.nameSearched = this.inputSearch.trim();
        } else {
            this.searchingByName = false;
            this.nameSearched = '';
        }
        this.filterSuppliersSearch();
    }

    private filterSuppliersSearch() {
        let nameSearched = null;
        if (this.searchingByName && this.nameSearched.trim().length > 0) {
            nameSearched = this.nameSearched;
        }
        let numItems = null;
        if (this.itemsPerPage <= 29) {
            numItems = 10;
        } else if (this.itemsPerPage > 29 && this.itemsPerPage <= 74) {
            numItems = 50;
        } else if (this.itemsPerPage > 74) {
            numItems = 100;
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
        this.router.navigate([this.componentURL], {queryParams: {name: nameSearched, items: numItems, page: page, order: order, sortField: sortField}});
    }

    private paginateData(event) {
        if (event['rows'] != null) {
            if (this.itemsPerPage != event['rows']) {
                this.itemsPerPage = event['rows'];
                this.filterSuppliersSearch();
            }
        }
        if (event['first'] != null) {
            if (this.page != event['first'] / this.itemsPerPage) {
                this.page = event['first'] / this.itemsPerPage;
                this.filterSuppliersSearch();
            }
        }
    }

    private sortData(event) {
        if (event['field'] != null)
            this.sortField = event['field'];
        if (event['order'] != null)
            this.sortOrder = event['order'];
        this.filterSuppliersSearch();
    }
}