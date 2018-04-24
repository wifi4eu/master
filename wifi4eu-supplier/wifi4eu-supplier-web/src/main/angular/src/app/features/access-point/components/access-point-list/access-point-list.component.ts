import { Component } from '@angular/core';
import { BeneficiaryDisplayedListDTOBase } from '../../../../shared/swagger';
import { UxService } from '@eui/ux-commons';
import { Router, ActivatedRoute } from '@angular/router';
import { BeneficiaryService } from '../../../../core/services/beneficiary-service';
import { SearchParametersService } from '../../../../core/services/search-parameters.service';

@Component({
    templateUrl: './access-point-list.component.html'
})
export class AccessPointListComponent {

    beneficiary: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;
    totalResults: number = 0;
    private accessPoints: string[] = [];

    constructor(private uxService: UxService, private router: Router, private route: ActivatedRoute,
        private beneficiaryService: BeneficiaryService, public searchParametersService: SearchParametersService) {
        if (this.beneficiaryService.beneficiarySelected != undefined) {
            this.beneficiary = this.beneficiaryService.beneficiarySelected;
        } else {
            router.navigate(['screen/installation-report']);
        }
    }


    onPage(event: any) {
        console.log(event.sortField, ' ', event.sortOrder);
        this.searchParametersService.parameters.delta = event.rows;
        this.searchParametersService.parameters.page = event.first;
        this.searchParametersService.parameters.fieldOrder = event.sortField ? event.sortField : "number";
        this.searchParametersService.parameters.order = event.sortOrder > 0 ? "asc" : "desc";
        // this.onSearch();
    }

}
