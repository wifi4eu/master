import {Component, Input} from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";
import {BeneficiaryDisplayedListDTOBase} from "../../shared/swagger/model/BeneficiaryDisplayedListDTO";
import {InstallationSiteBase} from "../../shared/swagger/model/InstallationSite";
import {InstallationsiteApi} from "../../shared/swagger/api/InstallationsiteApi";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {SharedService} from "../../shared/shared.service";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {Location} from '@angular/common';


@Component({
    templateUrl: './installation-details.component.html',
    providers: [InstallationsiteApi, MunicipalityApi]
})
export class InstallationDetailsComponent {
    beneficiary: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;
    private installationSite: InstallationSiteBase = new InstallationSiteBase();
    private installationDetails: InstallationSiteBase;
    private user: UserDTOBase;
    private municipality;
    private name: string;
    private number: string;
    private portal: string;

    constructor(private _location: Location, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private sharedService: SharedService, private localStorage: LocalStorageService, private router: Router, private route: ActivatedRoute, private installationsiteApi: InstallationsiteApi, private localStorageService: LocalStorageService) {
        let storedUser = this.localStorage.get('user');
        let id;
        this.route.params.subscribe(params => id = params['id']);
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
                (registrations: RegistrationDTOBase[]) => {
                    this.municipalityApi.getMunicipalityById(registrations[0].municipalityId).subscribe(
                        (municipality: MunicipalityDTOBase) => {
                            this.municipality = municipality;

                        }
                    );
                });


            this.installationsiteApi.getInstallationSite(id).subscribe(
                installation => {
                    this.installationSite = installation;
                    this.name = this.installationSite['data'].name;
                    this.number = this.installationSite['data'].number;
                    this.portal = this.installationSite['data'].url;

                }, error => {
                }
            );
        } else {
            this.sharedService.growlTranslation('You are not logged in!', 'shared.error.notloggedin', 'warn');
            this.router.navigateByUrl('/home');
        }


    }
    goBack(){
        this._location.back()
    }

}
