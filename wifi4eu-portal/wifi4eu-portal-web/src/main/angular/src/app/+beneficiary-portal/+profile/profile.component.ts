import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {UserApi} from "../../shared/swagger/api/UserApi";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {CustomAccordionBoxComponent} from "../../shared/components/custom-accordion-box/custom-accordion-box.component";
import {UxAccordionBoxesComponent} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-ui-elements/ux-accordion-box/ux-accordion-boxes.component";
import {LocalStorageService} from "angular-2-local-storage";
import {TranslateService} from "ng2-translate";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {SharedService} from "../../shared/shared.service";

@Component({
    selector: 'beneficiary-profile',
    templateUrl: 'profile.component.html',
    providers: [UserApi, RegistrationApi, MunicipalityApi]
})

export class BeneficiaryProfileComponent {
    private user: UserDTOBase = new UserDTOBase;
    private municipalities: MunicipalityDTOBase[] = [];
    private mayors: UserDTOBase[] = [];
    private editedUser: UserDTOBase = new UserDTOBase();
    private editedMunicipality: MunicipalityDTOBase = new MunicipalityDTOBase();
    private editedMayor: UserDTOBase = new UserDTOBase();
    private accordionBoxItems: CustomAccordionBoxComponent[] = [];
    private representing: boolean = false;
    private currentEditIndex: number = 0;
    private displayUser: boolean = false;
    private displayMunicipality: boolean = false;
    private displayMayor: boolean = false;
    private displayChangePassword: boolean = false;
    private submittingData = false;
    private currentPassword: string = '';
    private newPassword: string = '';
    private repeatNewPassword: string = '';
    private passwordsMatch: boolean = false;
    private isRegisterHold: boolean = false;

    constructor(private userApi: UserApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private localStorageService: LocalStorageService, private translateService: TranslateService, private uxService: UxService, private router: Router, private route: ActivatedRoute, private sharedService: SharedService) {
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            this.userApi.getUserById(this.user.id).subscribe(
                (user: UserDTOBase) => {
                    this.user = user;
                    if (this.user.type == 2 || this.user.type == 3) {
                        if (this.user.type == 3) {
                            this.representing = true;
                        }
                        Object.assign(this.editedUser, this.user);
                        this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
                            (registrations: RegistrationDTOBase[]) => {
                                for (let registration of registrations) {
                                    this.isRegisterHold = (registration.status == 0); // 0 status is HOLD
                                    this.municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                                        (municipality: MunicipalityDTOBase) => {
                                            // If the user is a representative, we need to look for the info of the mayors.
                                            if (this.representing) {
                                                this.registrationApi.getRegistrationsByMunicipalityId(municipality.id).subscribe(
                                                    (municipalityRegistrations: RegistrationDTOBase[]) => {
                                                        for (let municipalityRegistration of municipalityRegistrations) {
                                                            if (municipalityRegistration.role == 'Mayor') {
                                                                this.userApi.getUserById(municipalityRegistration.userId).subscribe(
                                                                    (mayor: UserDTOBase) => {
                                                                        this.municipalities.push(municipality);
                                                                        this.mayors.push(mayor);
                                                                        this.accordionBoxItems.push(new CustomAccordionBoxComponent(new UxAccordionBoxesComponent()));
                                                                    }
                                                                );
                                                            }
                                                        }
                                                    }
                                                );
                                            } else {
                                                this.municipalities.push(municipality);
                                            }
                                        }
                                    );
                                }
                            }
                        );
                    } else {
                        this.sharedService.growlTranslation('You are not allowed to view this page.', 'error.notallowed', 'warn');
                        this.router.navigateByUrl('/home');
                    }
                }, error => {
                    this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later."', 'error.api.generic', 'error');
                    this.router.navigateByUrl('/home');
                }
            );
        } else {
            this.sharedService.growlTranslation('You are not logged in!', 'error.notloggedin', 'warn');
            this.router.navigateByUrl('/home');
        }
    }

    private displayModal(name: string, index?: number) {
        switch (name) {
            case 'user':
                this.displayUser = true;
                break;
            case 'municipality':
                this.currentEditIndex = index;
                Object.assign(this.editedMunicipality, this.municipalities[index]);
                this.displayMunicipality = true;
                break;
            case 'mayor':
                this.currentEditIndex = index;
                Object.assign(this.editedMayor, this.mayors[index]);
                this.displayMayor = true;
                break;
            case 'password':
                this.displayChangePassword = true;
                break;
        }
    }

    private saveUserChanges() {
        this.submittingData = true;
        this.userApi.saveUserChanges(this.editedUser).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.user = response.data;
                    this.closeModal();
                    this.submittingData = false;
                }
            }
        );
    }

    private saveMunicipalityChanges() {
        this.submittingData = true;
        this.municipalityApi.createMunicipality(this.editedMunicipality).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.municipalities[this.currentEditIndex] = response.data;
                    this.closeModal();
                    this.submittingData = false;
                }
            }
        );
    }

    private saveMayorChanges() {
        this.submittingData = true;
        this.userApi.saveUserChanges(this.editedMayor).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.mayors[this.currentEditIndex] = response.data;
                    this.closeModal();
                    this.submittingData = false;
                }
            }
        );
    }

    private closeModal() {
        this.currentEditIndex = 0;
        this.displayUser = false;
        this.displayMunicipality = false;
        this.displayMayor = false;
        this.displayChangePassword = false;
        this.currentPassword = '';
        this.newPassword = '';
        this.repeatNewPassword = '';
        this.passwordsMatch = false;
        Object.assign(this.editedUser, this.user);
    }

    private checkPasswordsMatch() {
        if (this.newPassword.length > 0 && this.newPassword == this.repeatNewPassword) {
            this.passwordsMatch = true;
        } else {
            this.passwordsMatch = false;
        }
    }

    private deleteRegistration() {
        this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
            (registrations: RegistrationDTOBase[]) => {
                let registrationCount = 0;
                for (let registration of registrations) {
                    registration.status = 1;
                    this.registrationApi.createRegistration(registration).subscribe(
                        (data: ResponseDTOBase) => {
                            if (data.success) {
                                registrationCount++;
                                if (registrationCount >= registrations.length) {
                                    this.sharedService.growlTranslation('Your applications were succesfully deleted.', 'beneficiary.deleteApplication.Success', 'success');
                                    this.sharedService.logout();
                                }
                            }
                        }, error => {
                            this.sharedService.growlTranslation('An error occurred an your applications could not be deleted.', 'beneficiary.deleteApplication.Failure', 'error');
                        }
                    );
                }
            }
        );
    }

    private goToDiscussion() {
        this.router.navigate(['../discussion-forum'], {relativeTo: this.route});
    }

    private preventPaste(event: any) {
        return false;
    }
}