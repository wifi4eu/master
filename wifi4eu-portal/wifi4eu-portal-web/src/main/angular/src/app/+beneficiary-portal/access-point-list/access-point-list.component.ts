import 'rxjs/add/operator/switchMap';
import {Component, OnInit} from '@angular/core';
import {BeneficiaryDisplayedListDTOBase} from "../../shared/swagger/model/BeneficiaryDisplayedListDTO";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {ActivatedRoute, Router} from "@angular/router";
import {BeneficiaryService} from "../../core/services/beneficiary-service";
import {SearchParametersService} from "../../core/services/search-parameters.service";
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {ErrorHandlingService} from "../../core/services/error.service";
import {AccessPointBase} from "../../shared/swagger/model/AccessPoint";
import {AccesspointsApi} from "../../shared/swagger/api/AccesspointsApi";


@Component({
    templateUrl: './access-point-list.component.html'
})
export class AccessPointListComponent {

    private beneficiary: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;
    private totalResults: number = 0;
    private accessPoints: AccessPointBase[];
    private installationSiteName: string = '';
    private accessPoint: AccessPointBase = new AccessPointBase();

    //observable that gets the id from route params
    private idSub: any;

    constructor(private uxService: UxService, private router: Router, private route: ActivatedRoute,
                private beneficiaryService: BeneficiaryService, public searchParametersService: SearchParametersService,
                private accessPointApi: AccesspointsApi, private errorHandlingService: ErrorHandlingService) {

        if (this.beneficiaryService.beneficiarySelected != undefined) {
            this.beneficiary = this.beneficiaryService.beneficiarySelected;
        } else {
            // this.beneficiaryService.growlNotSelected();
        }

        this.idSub = this.route.params.subscribe(params => {
            this.searchParametersService.parameters.id_installationSite = +params['id'];
            this.installationSiteName = params['name'];
        });
        this.accessPoint.idInstallationSite = this.searchParametersService.parameters.id_installationSite;
    }

    onPage(event: any) {
        if (this.searchParametersService.parameters.id_installationSite != undefined) {
            this.searchParametersService.parameters.delta = event.rows;
            this.searchParametersService.parameters.page = event.first;
            this.searchParametersService.parameters.fieldOrder = event.sortField ? event.sortField : "number";
            this.searchParametersService.parameters.order = event.sortOrder > 0 ? "asc" : "desc";
            this.onSearch();
        }
    }

    onSearch() {
        this.totalResults = 0;
        this.accessPointApi.getAccessPointPerInstallationSite(this.searchParametersService.parameters).subscribe((response: ResponseDTOBase) => {
            if (response.success) {
                this.accessPoints = response.data.data;
                this.totalResults = response.data.count;
            }
        }, error => {
            console.log(error);
            return this.errorHandlingService.handleError(error);
        });
    }

    openUpdateAccessPoint() {
        // this.uxService.openModal('updateAccessPoint');
    }

}
