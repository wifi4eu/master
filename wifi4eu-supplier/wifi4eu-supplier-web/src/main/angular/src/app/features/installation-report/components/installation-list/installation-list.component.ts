import { Component } from '@angular/core';
import { SearchParametersService } from '../../../../core/services/search-parameters.service';
import { SearchParameters } from '../../../../core/models/search-parameters.model';

@Component({
    templateUrl: './installation-list.component.html'
})
export class InstallationListComponent {
       //-- Component properties
       _timeout: any = null;
       totalResults : number = 0;

       constructor( public searchParametersService : SearchParametersService) {}
   
       onBeneficiaryKeyPress() {
           this._timeout  = null;
           this.searchParametersService.parameters.page = 0;
           
           let currentInput = this.searchParametersService.parameters.criteria.keywords;
           
           if (this._timeout) {
              window.clearTimeout(this._timeout);
           }
           
           this._timeout = window.setTimeout(() => {
             this._timeout = null;
       
             if (this.searchParametersService.parameters.criteria.keywords === currentInput) {
               this.onSearch();
             }
            },1000);
         }
   
       
     onSearch() {
        console.log('search beneficiary');
     }
}
