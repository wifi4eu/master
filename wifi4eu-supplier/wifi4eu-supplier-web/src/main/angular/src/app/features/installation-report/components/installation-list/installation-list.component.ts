import { Component, ViewChild } from '@angular/core';
import { SearchParametersService } from '../../../../core/services/search-parameters.service';
import { SearchParameters } from '../../../../core/models/search-parameters.model';
import { BeneficiaryApi } from '../../../../shared/swagger/api/BeneficiaryApi';
import { LocalStorageService } from "angular-2-local-storage";
import { UxService } from '@eui/ux-commons';

import { InstallationSite } from '../../../../core/models/installation-site.model';
import { BeneficiaryDisplayedListDTOBase } from '../../../../shared/swagger';
import { BeneficiaryService } from '../../../../core/services/beneficiary-service';

@Component({
    templateUrl: './installation-list.component.html',
    providers: [BeneficiaryApi]
})

export class InstallationListComponent {
    //-- Component properties
    _timeout: any = null;
    totalResults: number = 0;
    beneficiarySelected: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;
    isBeneficiarySelected: boolean = false;
    isReportSent: boolean = false;
    beneficiarySuggestions: BeneficiaryDisplayedListDTOBase[] = [];
    supplier: {};
    private legalChecks: boolean[] = [false, false, false];
    private installationSites: InstallationSite[];

    constructor(private beneficiaryApi: BeneficiaryApi, private localStorageService: LocalStorageService,
        public searchParametersService: SearchParametersService, private uxService: UxService,
        private beneficiaryService: BeneficiaryService) {
        this.supplier = this.localStorageService.get('supplierId');
        if (this.beneficiaryService.beneficiarySelected != undefined) {
            this.beneficiarySelected = this.beneficiaryService.beneficiarySelected;
            this.isBeneficiarySelected = true;
            this.onSearch();
        }
    }


    getBenegiciarySuggestions(event) {
        let query = encodeURIComponent(event.query);

        this.beneficiaryApi.getBeneficiariesList().subscribe((data: BeneficiaryDisplayedListDTOBase[]) => {
            this.beneficiarySuggestions = data;
            this.totalResults = this.beneficiarySuggestions.length;
        });
    }

    onBeneficiarySelected() {
        //get installation sites from this beneficiary
        this.isBeneficiarySelected = true;
        this.beneficiaryService.beneficiarySelected = this.beneficiarySelected;
        this.onSearch();
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
        /*search*/
        console.log('search');

        this.installationSites = [];
        let installationSite = new InstallationSite(1, 'London', 'domain.com/London');
        this.installationSites.push(new InstallationSite(1, 'London', 'domain.com/London'));

        let instalationSite2 = new InstallationSite(2, 'oxford', 'domain.com/oxford');
        this.installationSites.push(new InstallationSite(2, 'oxford', 'domain.com/oxford'));

        this.totalResults = this.installationSites.length;
    }

    onChangesAutocomplete(event) {
        if (this.beneficiaryService.beneficiarySelected != this.beneficiarySelected) {
            this.isBeneficiarySelected = false;
            this.installationSites = [];
        }
    }

    openConfirmInstallation() {
        this.uxService.openModal('confirmInstallation');
    }

    closeConfirmInstallation() {
        this.uxService.closeModal('confirmInstallation');
        this.legalChecks = [false, false, false];
    }

    sendConfirmInstallation() {
        this.isReportSent = true;
        let successBanner = document.getElementById("success");
        successBanner.style.display = "block";
        successBanner.scrollIntoView({ behavior: "smooth" });
        this.closeConfirmInstallation();
    }

    openUpdateInstallationSite() {
        this.uxService.openModal('updateInstallationSite');
    }

}
