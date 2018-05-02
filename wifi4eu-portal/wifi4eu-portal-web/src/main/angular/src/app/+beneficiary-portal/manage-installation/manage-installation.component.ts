import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {LocalStorageService} from "angular-2-local-storage";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {SharedService} from "app/shared/shared.service";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {BeneficiaryDisplayedListDTOBase} from "../../shared/swagger/model/BeneficiaryDisplayedListDTO";
import {InstallationSite} from '../../shared/swagger/model/InstallationSite';
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {UxService} from '@eui/ux-commons';
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {InstallationsiteApi} from "../../shared/swagger/api/InstallationsiteApi";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {MayorApi} from "../../shared/swagger/api/MayorApi";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {SearchParametersService} from "../../core/services/search-parameters.service";
import {BeneficiaryService} from "../../core/services/beneficiary-service";


@Component({
    templateUrl: 'manage-installation.component.html',
    providers: [MunicipalityApi, MayorApi, BeneficiaryApi, InstallationsiteApi]
})


export class ManageInstallationComponent {

    private user: UserDTOBase;
    private municipality: MunicipalityDTOBase;
    private registration: RegistrationDTOBase;
    //-- Component properties
    _timeout: any = null;
    totalResults: number = 0;

    private beneficiarySelected: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;
    private beneficiarySuggestions: BeneficiaryDisplayedListDTOBase[] = [];
    private isBeneficiarySelected: boolean = false;
    private installationSites: InstallationSite[] = [];
    private isReportSent: boolean = false;
    private supplier: {};
    private legalChecks: boolean[] = [false, false, false];

    constructor(private installationsiteApi: InstallationsiteApi, private  beneficiaryApi: BeneficiaryApi, private localStorageService: LocalStorageService, public searchParametersService: SearchParametersService, private beneficiaryService: BeneficiaryService, private uxService: UxService, private router: Router, private route: ActivatedRoute, private localStorage: LocalStorageService, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private sharedService: SharedService) {
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.beneficiaryService.beneficiarySelected != undefined) {
            this.beneficiarySelected = this.beneficiaryService.beneficiarySelected;
            this.isBeneficiarySelected = true;
            this.onSearch();
        }
        if (this.user != null) {
            let municipalityId;
            this.route.params.subscribe(params => municipalityId = params['municipalityId']);
            if (municipalityId != null) {
                this.municipalityApi.getMunicipalityById(municipalityId).subscribe(
                    (municipality: MunicipalityDTOBase) => {
                        this.municipality = municipality;
                        this.registrationApi.getRegistrationByMunicipalityId(this.municipality.id).subscribe(
                            (registration: RegistrationDTOBase) => {
                                this.registration = registration;
                            }, error => {
                            });
                    }, error => {
                    }
                );
            }
        } else {
            this.sharedService.growlTranslation('You are not logged in!', 'shared.error.notloggedin', 'warn');
            this.router.navigateByUrl('/home');
        }


    }

    getBenegiciarySuggestions(event) {
        let query = encodeURIComponent(event.query);

        this.beneficiaryApi.getBeneficiariesList().subscribe((response: ResponseDTOBase) => {
            if (response.success) {
                this.beneficiarySuggestions = response.data;
            }
        });
    }

    onBeneficiarySelected() {
        //get installation sites from this beneficiary
        this.isBeneficiarySelected = true;
        this.beneficiaryService.beneficiarySelected = this.beneficiarySelected;
        this.searchParametersService.parameters.id_beneficiary = this.beneficiarySelected.id;
        this.onSearch();
    }


    onPage(event: any) {
        if (this.isBeneficiarySelected) {
            this.searchParametersService.parameters.delta = event.rows;
            this.searchParametersService.parameters.page = event.first;
            this.searchParametersService.parameters.fieldOrder = event.sortField ? event.sortField : "id";
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
            }
        })
    }

    onChangesAutocomplete(event) {
        if (this.beneficiaryService.beneficiarySelected != this.beneficiarySelected) {
            this.isBeneficiarySelected = false;
            this.installationSites = [];
            this.totalResults = 0;
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
        successBanner.scrollIntoView({behavior: "smooth"});
        this.closeConfirmInstallation();
    }

    openUpdateInstallationSite() {
        this.uxService.openModal('updateInstallationSite');
    }

}