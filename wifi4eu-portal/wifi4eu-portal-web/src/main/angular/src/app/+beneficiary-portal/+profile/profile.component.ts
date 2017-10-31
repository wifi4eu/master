import {Component} from "@angular/core";
import {UserApi} from "../../shared/swagger/api/UserApi";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {CustomAccordionBoxComponent} from "../../shared/components/custom-accordion-box/custom-accordion-box.component";
import {UxAccordionBoxesComponent} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-ui-elements/ux-accordion-box/ux-accordion-boxes.component";

@Component({
    selector: 'beneficiary-profile', templateUrl: 'profile.component.html', providers: [UserApi, RegistrationApi, MunicipalityApi]
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

    constructor(private userApi: UserApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi) {
        // Get a random beneficiary user from the DB for testing purposes
        let type = Math.floor(Math.random() * (3 - 2 + 1) ) + 2;
        this.userApi.getUsersByType(type).subscribe(
            (users: UserDTOBase[]) => {
                this.user = users[Math.floor(Math.random() * users.length)];
                if (this.user.type == 3) {
                    this.representing = true;
                }
                Object.assign(this.editedUser, this.user);
                this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
                    (registrations: RegistrationDTOBase[]) => {
                        for (let registration of registrations) {
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
            }
        );
    }

    displayModal(name: string, index?: number) {
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

    saveUserChanges() {
        this.submittingData = true;
        this.userApi.createUser(this.editedUser).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.user = response.data;
                    this.closeModal();
                    this.submittingData = false;
                }
            }
        );
    }

    saveMunicipalityChanges() {
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

    saveMayorChanges() {
        this.submittingData = true;
        this.userApi.createUser(this.editedMayor).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.mayors[this.currentEditIndex] = response.data;
                    this.closeModal();
                    this.submittingData = false;
                }
            }
        );
    }

    closeModal() {
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

    checkPasswordsMatch() {
        if (this.newPassword.length > 0 && this.newPassword == this.repeatNewPassword) {
            this.passwordsMatch = true;
        } else {
            this.passwordsMatch = false;
        }
    }
}