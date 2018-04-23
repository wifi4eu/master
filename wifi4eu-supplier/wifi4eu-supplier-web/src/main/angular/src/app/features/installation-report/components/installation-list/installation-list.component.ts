import { Component, ViewChild } from '@angular/core';
import { SearchParametersService } from '../../../../core/services/search-parameters.service';
import { SearchParameters } from '../../../../core/models/search-parameters.model';
import { MunicipalityApi } from '../../../../shared/swagger/api/MunicipalityApi';
import { MunicipalityDTO } from '../../../../shared/swagger/model/MunicipalityDTO';
import { LocalStorageService } from "angular-2-local-storage";
import { UxService } from '@eui/ux-commons';

import { InstallationSite } from '../../../../core/models/installation-site.model';

@Component({
    templateUrl: './installation-list.component.html',
    providers: [MunicipalityApi]
})

export class InstallationListComponent {
    //-- Component properties
    _timeout: any = null;
    totalResults: number = 0;
    beneficiarySelected: string;
    isBeneficiarySelected: boolean = false;
    isReportSent: boolean = false;
    beneficiarySuggestions: string[];
    supplier: {};
    private legalChecks: boolean[] = [false, false, false];
    private installationSites: InstallationSite[] = [];

    constructor(private municipalityApi: MunicipalityApi, private localStorageService: LocalStorageService,
        public searchParametersService: SearchParametersService, private uxService: UxService) {
        this.supplier = this.localStorageService.get('supplierId');
    }


    getBenegiciarySuggestions(event) {
        this.beneficiarySuggestions = ["patata", "portugal", "arbol"];
        this.totalResults = 3;
        let query = encodeURIComponent(event.query);

        console.log("getSuggestions :", this.supplier, ' ', query);
        // this.municipalityApi.getMunicipalitiesSupplierId(supplierId, query).subscribe(data => {
        //   if (data['succeeded'] && data['body']) {
        //     this.beneficiarySuggestions = data['body']['data'];
        //     this.totalResults = data['body']['count'];
        //   }
        // this.countryService.getCountries().then(countries => {
        //     this.filteredCountriesSingle = this.filterCountry(query, countries);
        // });
    }

    onBeneficiarySelected() {
        console.log('search installation site for this supplier: ', this.beneficiarySelected);
        // this.municipalityApi.getMunicipalitiesSupplierId(supplierId, query);
        // this.countryService.getCountries().then(countries => {
        //     this.filteredCountriesSingle = this.filterCountry(query, countries);
        // });
        this.isBeneficiarySelected = true;
        this.onSearch();
    }


    onPage(event: any) {
        if (this.isBeneficiarySelected) {
            console.log(event.sortField, ' ',  event.sortOrder );
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

        this.totalResults= this.installationSites.length;
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
        successBanner.style.display="block";
        successBanner.scrollIntoView({behavior: "smooth"});
        this.closeConfirmInstallation();
    }

    openUpdateInstallationSite() {
        this.uxService.openModal('updateInstallationSite');
    }

}
