import { Component, ViewChild, OnInit } from '@angular/core';
import { SearchParametersService } from '../../../../core/services/search-parameters.service';
import { SearchParameters } from '../../../../core/models/search-parameters.model';
import { BeneficiaryApi } from '../../../../shared/swagger/api/BeneficiaryApi';
import { UxService } from '@eui/ux-commons';

import { BeneficiaryDisplayedListDTOBase, ResponseDTOBase, ResponseDTO } from '../../../../shared/swagger';
import { BeneficiaryService } from '../../../../core/services/beneficiary-service';
import { InstallationsiteApi } from '../../../../shared/swagger/api/InstallationsiteApi';
import { InstallationSite, InstallationSiteBase } from '../../../../shared/swagger/model/InstallationSite';
import { ErrorHandlingService } from '../../../../core/services/error.service';

@Component({
    templateUrl: './installation-list.component.html',
    providers: [BeneficiaryApi]
})

export class InstallationListComponent implements OnInit {
    //-- Component properties
    _timeout: any = null;
    totalResults: number = 0;

    private installationSite: InstallationSiteBase = new InstallationSiteBase();

    private beneficiarySelected: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;
    private beneficiarySuggestions: BeneficiaryDisplayedListDTOBase[] = [];
    private isBeneficiarySelected: boolean = false;
    private installationSites: InstallationSite[] = [];
    private isReportSent: boolean = false;
    private supplier: {};
    private legalChecks: boolean[] = [false, false, false];


    constructor(private beneficiaryApi: BeneficiaryApi, private installationSiteApi: InstallationsiteApi,
        public searchParametersService: SearchParametersService, private uxService: UxService,
        private beneficiaryService: BeneficiaryService, private errorHandlingService: ErrorHandlingService) {
        if (this.beneficiaryService.beneficiarySelected != undefined) {
            this.beneficiarySelected = this.beneficiaryService.beneficiarySelected;
            this.isBeneficiarySelected = true;
            this.installationSite.municipality = this.beneficiarySelected.id;
            this.onSearch();
            this.checkIfWifiIndicator();
        }
    }

    ngOnInit() {
        this.beneficiaryApi.getBeneficiariesList().subscribe((response: ResponseDTOBase) => {
            if (response.success) {
                this.beneficiarySuggestions = response.data;
            } else {
                return this.errorHandlingService.handleError(response.error);
            }
        }, error => {
            console.log(error);
            return this.errorHandlingService.handleError(error);
        });
    }

    onBeneficiarySelected() {
        //get installation sites from this beneficiary
        this.isBeneficiarySelected = true;
        this.beneficiaryService.beneficiarySelected = this.beneficiarySelected;
        this.searchParametersService.parameters.id_beneficiary = this.beneficiarySelected.id;
        this.installationSite.municipality = this.beneficiarySelected.id;
        this.onSearch();
        this.checkIfWifiIndicator();
    }

    checkIfWifiIndicator(){
        if(this.beneficiarySelected.wifiIndicator){
            this.isReportSent = true;
        } else{
            this.isReportSent = false;
        }
    }

    onPage(event: any) {
        if (this.isBeneficiarySelected) {
            this.searchParametersService.parameters.delta = event.rows;
            this.searchParametersService.parameters.page = event.first;
            this.searchParametersService.parameters.fieldOrder = event.sortField ? event.sortField : "number";
            this.searchParametersService.parameters.order = event.sortOrder > 0 ? "asc" : "desc";
            this.onSearch();
        }
    }

    onSearch() {
        this.totalResults = 0;

        this.installationSiteApi.getInstallationSiteListByBeneficiary(this.searchParametersService.parameters).subscribe((response: ResponseDTOBase) => {
            if (response.success) {
                this.installationSites = response.data.data;
                this.totalResults = response.data.count;
            } else {
                return this.errorHandlingService.handleError(response.error);
            }
        }, error => {
            console.log(error);
            return this.errorHandlingService.handleError(error);
        });
    }

    openConfirmInstallation() {
        this.uxService.openModal('confirmInstallation');
    }

    closeConfirmInstallation() {
        this.uxService.closeModal('confirmInstallation');
        this.legalChecks = [false, false, false];
    }

    sendConfirmInstallation() {
        this.beneficiaryApi.confirmWifiIndicatorByMunicipalityId(this.beneficiarySelected.id).subscribe((response: ResponseDTOBase) => {
            if (response.success) {
                this.isReportSent = true;
                let successBanner = document.getElementById("success");
                successBanner.style.display = "block";
                successBanner.scrollIntoView({ behavior: "smooth" });
            }
        }, error => {
            console.log(error);
            return this.errorHandlingService.handleError(error);
        });
        this.closeConfirmInstallation();
    }

    openUpdateInstallationSite() {
        this.uxService.openModal('updateInstallationSite');
    }

    byId(bf1: BeneficiaryDisplayedListDTOBase, bf2: BeneficiaryDisplayedListDTOBase) {
        return bf1.id === bf2.id;
    }


}
