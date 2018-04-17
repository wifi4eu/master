import { Component } from '@angular/core';
import { SearchParametersService } from '../../../../core/services/search-parameters.service';
import { SearchParameters } from '../../../../core/models/search-parameters.model';

@Component({
    templateUrl: './installation-list.component.html'
})
export class InstallationListComponent {
    //-- Component properties
    _timeout: any = null;
    totalResults: number = 0;
    beneficiarySelected : string;
    beneficiarySuggestions : string[];

    getBenegiciarySuggestions(event) {
        this.beneficiarySuggestions= ["patata","portugal"];
        console.log("getSuggestions :", this.beneficiarySuggestions);
        let query = encodeURIComponent(event.query);
        // this.countryService.getCountries().then(countries => {
        //     this.filteredCountriesSingle = this.filterCountry(query, countries);
        // });
    }

    // constructor(public searchParametersService: SearchParametersService) { }

    // onBeneficiaryKeyPress() {
    //     this._timeout = null;
    //     this.searchParametersService.parameters.page = 0;

    //     let currentInput = this.searchParametersService.parameters.criteria.keywords;

    //     if (this._timeout) {
    //         window.clearTimeout(this._timeout);
    //     }

    //     this._timeout = window.setTimeout(() => {
    //         this._timeout = null;

    //         if (this.searchParametersService.parameters.criteria.keywords === currentInput) {
    //             this.onSearchBeneficiary();
    //         }
    //     }, 1000);
    // }


    onBeneficiarySelected(){
        console.log('search installation site for this supplier');
    }
}
