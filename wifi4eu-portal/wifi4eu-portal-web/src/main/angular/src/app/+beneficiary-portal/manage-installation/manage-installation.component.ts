import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {LocalStorageService} from "angular-2-local-storage";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {SharedService} from "app/shared/shared.service";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {MayorApi} from "../../shared/swagger/api/MayorApi";

@Component({
    templateUrl: 'manage-installation.component.html',
    providers: [MunicipalityApi, MayorApi]
})


export class ManageInstallationComponent {

    private user: UserDTOBase;
    private municipality: MunicipalityDTOBase;
    private registration: RegistrationDTOBase;

    constructor(private router: Router, private route: ActivatedRoute, private localStorage: LocalStorageService, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private sharedService: SharedService) {
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;

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
}