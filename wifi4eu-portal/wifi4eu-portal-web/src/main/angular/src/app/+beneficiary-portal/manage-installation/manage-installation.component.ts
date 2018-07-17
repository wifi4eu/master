import {Component, ViewEncapsulation} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {LocalStorageService} from "angular-2-local-storage";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {SharedService} from "app/shared/shared.service";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {BeneficiaryDisplayedListDTOBase} from "../../shared/swagger/model/BeneficiaryDisplayedListDTO";
import {InstallationSite} from '../../shared/swagger/model/InstallationSite';
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {UxService} from '@ec-digit-uxatec/eui-angular2-ux-commons';
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {InstallationsiteApi} from "../../shared/swagger/api/InstallationsiteApi";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {SearchParametersService} from "../../core/services/search-parameters.service";
import {BeneficiaryService} from "../../core/services/beneficiary-service";
import {AccesspointsApi} from "../../shared/swagger/api/AccesspointsApi";
import {AccessPointBase} from "../../shared/swagger/model/AccessPoint";


@Component({
    templateUrl: 'manage-installation.component.html',
    providers: [MunicipalityApi, BeneficiaryApi, InstallationsiteApi, SearchParametersService, AccesspointsApi]
})


export class ManageInstallationComponent {

    private user: UserDTOBase;
    private municipality: MunicipalityDTOBase;
    private registration: RegistrationDTOBase;
    //-- Component properties
    _timeout: any = null;
    totalResults: number = 0;
    private openModal: boolean = false;
    private revisionModal: boolean = false;
    private accessPoints: AccessPointBase[];
    private beneficiarySelected: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;
    private installationSites: InstallationSite[] = [];
    private isReportSent: boolean = false;
    private supplier: {};
    private legalChecks: boolean[] = [false, false, false];
    private accessPoint;
    private displayConfirmingData: boolean = false;
    private indicators = {
        'id' : 0,
        'beneficiaryIndicator' : false
    }

    constructor(private accessPoinstApi: AccesspointsApi, private installationsiteApi: InstallationsiteApi, private  beneficiaryApi: BeneficiaryApi, private localStorageService: LocalStorageService, public searchParametersService: SearchParametersService, private beneficiaryService: BeneficiaryService, private uxService: UxService, private router: Router, private route: ActivatedRoute, private localStorage: LocalStorageService, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private sharedService: SharedService) {
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            let municipalityId;
            this.route.params.subscribe(params => municipalityId = params['municipalityId']);
            if (municipalityId != null) {
                this.municipalityApi.getUsersMunicipalityById(municipalityId).subscribe(
                    (response: ResponseDTOBase) => {
                        if (response.success) {
                            this.municipality = response.data;
                            this.searchParametersService.parameters.id_beneficiary = this.municipality.id;
                            this.beneficiaryService.beneficiarySelected = this.municipality;
                            // this.onSearch();
                            this.registration = response.data.registrations[0];
                            this.indicators["id"] = this.registration.id;
                        } else{
                            this.sharedService.growlTranslation('You are not logged in!', response.error.errorMessage, 'warn');
                            this.router.navigateByUrl('/home');
                        }
                    }, error => {
                    }
                );
            }
        } else {
            this.sharedService.growlTranslation('You are not logged in!', 'shared.error.notloggedin', 'warn');
            this.router.navigateByUrl('/home');
        }
     }

    onPage(event: any) {
        this.searchParametersService.parameters.delta = event.rows;
        this.searchParametersService.parameters.page = event.first;
        this.searchParametersService.parameters.fieldOrder = event.sortField ? event.sortField : "id";
        this.searchParametersService.parameters.order = event.sortOrder > 0 ? "asc" : "desc";
        this.onSearch();
    }

    onSearch() {
        this.totalResults = 0;
        this.installationsiteApi.getInstallationSiteListByBeneficiary(this.searchParametersService.parameters).subscribe((response: ResponseDTOBase) => {
            if (response.success) {
                this.installationSites = response.data.data;
                this.totalResults = response.data.count;
            }
        })
    }

    openConfirmInstallation() {
        this.openModal = true;
    }

    closeConfirmInstallation() {
        this.openModal = false;
        this.legalChecks = [false, false, false];
    }

    openReportInstallation() {
        this.revisionModal = true;
    }

    closeReportInstallation() {
        this.revisionModal = false;
    }

    sendConfirmInstallation() {
        this.displayConfirmingData = true;
        // this.registration.beneficiaryIndicator = true;
        this.indicators['beneficiaryIndicator'] = true;
        this.registrationApi.confirmOrRejectInstallationReport(this.indicators).subscribe((response: ResponseDTOBase) => {
            this.registration = response.data;    
            this.displayConfirmingData = false;
            }, error => {
                console.log(error);
                this.displayConfirmingData = false;
            }
        );
        this.openModal = false;
    }

    sendReportInstallation() {
        this.displayConfirmingData = true;
        // this.registration.wifiIndicator = false;
        // this.registration.beneficiaryIndicator = false;
        this.indicators['beneficiaryIndicator'] = false;
        this.registrationApi.confirmOrRejectInstallationReport(this.indicators).subscribe((response: ResponseDTOBase) => {
                this.registration = response.data;   
                this.displayConfirmingData = false;
            }, error => {
                console.log(error);
                this.displayConfirmingData = false;
            }
        );
        this.revisionModal = false;
    }

    private goToDetails(installationNumber: number) {
        this.router.navigate(['../../details/' + this.installationSites[installationNumber].id], {relativeTo: this.route});
    }

    private goToList(accessPointNumber: number) {
        let inputParameters = new Object;
        inputParameters["id_installationSite"] = this.installationSites[accessPointNumber].id;
        this.accessPoinstApi.getAccessPointPerInstallationSite(inputParameters).subscribe(
            accessPointResult => {

            }, error => {
                console.log(error);
            }
        );
        this.router.navigate(['../../access-point/' + this.installationSites[accessPointNumber].id], {relativeTo: this.route});
    }

    checkActionsAvailable(){
        if (!this.registration.installationSiteConfirmation){
            if (this.registration.installationSiteRejection){
                if (this.registration.installationSiteSubmission > this.registration.installationSiteRejection){
                    return false;
                }
            } else {
                if (this.registration.installationSiteSubmission){
                    return false;
                }
            }
        }
        return true;
    }


}