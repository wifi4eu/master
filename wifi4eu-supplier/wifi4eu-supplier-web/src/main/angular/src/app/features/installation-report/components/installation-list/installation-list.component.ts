import { Component } from '@angular/core';
import { SearchParametersService } from '../../../../core/services/search-parameters.service';
import { SearchParameters } from '../../../../core/models/search-parameters.model';
import { MunicipalityApi } from '../../../../shared/swagger/api/MunicipalityApi';
import { MunicipalityDTO } from '../../../../shared/swagger/model/MunicipalityDTO';
import { LocalStorageService } from "angular-2-local-storage";
import { UxService } from '@eui/ux-commons';


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
    beneficiarySuggestions: string[];
    supplier: {};
    private legalChecks: boolean[] = [false, false, false];

    constructor(private municipalityApi: MunicipalityApi, private localStorageService : LocalStorageService,
        public searchParametersService: SearchParametersService, private uxService: UxService) {
        this.supplier = this.localStorageService.get('supplierId');
    }


    getBenegiciarySuggestions(event) {
        this.beneficiarySuggestions = ["patata", "portugal", "arbol"];
        this.totalResults=3;
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
        this.isBeneficiarySelected=true;
    }

    openConfirmInstallation() {
        this.uxService.openModal('confirmInstallation');
      }
    
    closeConfirmInstallation(){
        this.uxService.closeModal('confirmInstallation');
        this.legalChecks= [false, false, false];
    }

    openUpdateInstallationSite(){
        this.uxService.openModal('updateInstallationSite');
    }

    closeUpdateInstallationSite(){
        this.uxService.closeModal('updateInstallationSite');
    }
}
