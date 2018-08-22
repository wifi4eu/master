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
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {InstallationsiteApi} from "../../shared/swagger/api/InstallationsiteApi";
import {MayorApi} from "../../shared/swagger/api/MayorApi";
import {Location} from '@angular/common';
import { SharedService } from '../../shared/shared.service';


@Component({
    templateUrl: './access-point-list.component.html',
    providers: [MunicipalityApi, MayorApi, BeneficiaryApi, InstallationsiteApi, SearchParametersService, AccesspointsApi, ErrorHandlingService]
})
export class AccessPointListComponent {

    private beneficiary: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;
    private totalResults: number = 0;
    private accessPoints: AccessPointBase[];
    private installationSiteName: string = '';
    private accessPoint: AccessPointBase = new AccessPointBase();
    private user: UserDTOBase;
    private registration: RegistrationDTOBase;
    private municipalityName: String;
    //observable that gets the id from route params
    private idSub: any;

    constructor(private _location: Location, private installationsiteApi: InstallationsiteApi, private municipalityApi: MunicipalityApi, private registrationApi: RegistrationApi, private uxService: UxService, private router: Router, private route: ActivatedRoute,
                private beneficiaryService: BeneficiaryService, public searchParametersService: SearchParametersService, private sharedService: SharedService,
                private accessPointApi: AccesspointsApi, private errorHandlingService: ErrorHandlingService, private localStorage: LocalStorageService) {
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            if (this.beneficiaryService.beneficiarySelected != undefined) {
                this.municipalityName = this.beneficiaryService.beneficiarySelected.name;
            } else {
                this.router.navigateByUrl('/home');
                this.sharedService.growlTranslation('You are not logged in!', 'error.404.AccessPointNotFound', 'warn');
            }

            this.idSub = this.route.params.subscribe(params => {
                this.searchParametersService.parameters.id_installationSite = +params['id'];
                this.installationsiteApi.getInstallationSite(this.searchParametersService.parameters.id_installationSite).subscribe(
                    installation => {
                        this.installationSiteName = installation['data'].name;
                    }, error => {
                        console.log(error);
                    }
                );

            });
            this.accessPoint.idInstallationSite = this.searchParametersService.parameters.id_installationSite;

        } else {
            this.router.navigateByUrl('/home');
        }
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

    private goToDetails(APNumber: number) {
        this.router.navigate(['../details/' + this.accessPoints[APNumber].id], {relativeTo: this.route});
    }

    goBack(){
        this._location.back()
    }
}
