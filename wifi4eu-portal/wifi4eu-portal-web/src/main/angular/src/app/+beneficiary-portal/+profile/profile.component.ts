import { Component } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { UserApi } from "../../shared/swagger/api/UserApi";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { RegistrationDTOBase } from "../../shared/swagger/model/RegistrationDTO";
import { RegistrationApi } from "../../shared/swagger/api/RegistrationApi";
import { MunicipalityApi } from "../../shared/swagger/api/MunicipalityApi";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import { LocalStorageService } from "angular-2-local-storage";
import { SharedService } from "../../shared/shared.service";
import { UserThreadsApi } from "../../shared/swagger/api/UserThreadsApi";
import { UserThreadsDTOBase } from "../../shared/swagger/model/UserThreadsDTO";
import { MayorApi } from "../../shared/swagger/api/MayorApi";
import { MayorDTOBase } from "../../shared/swagger/model/MayorDTO";

@Component({
    selector: 'beneficiary-profile',
    templateUrl: 'profile.component.html',
    providers: [UserApi, RegistrationApi, MunicipalityApi, UserThreadsApi, MayorApi]
})

export class BeneficiaryProfileComponent {
    private user: UserDTOBase = new UserDTOBase;
    private municipalities: MunicipalityDTOBase[] = [];
    private mayors: MayorDTOBase[] = [];
    private editedUser: UserDTOBase = new UserDTOBase();
    private editedMunicipality: MunicipalityDTOBase = new MunicipalityDTOBase();
    private editedMayor: MayorDTOBase = new MayorDTOBase();
    private currentEditIndex: number = 0;
    private displayUser: boolean = false;
    private displayMunicipality: boolean = false;
    private displayMayor: boolean = false;
    private submittingData = false;
    private isRegisterHold: boolean = false;
    private userThreads: UserThreadsDTOBase = new UserThreadsDTOBase();
    private threadId: number;
    private hasDiscussion: boolean = false;


    constructor(private userThreadsApi: UserThreadsApi, private userApi: UserApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private localStorageService: LocalStorageService, private router: Router, private route: ActivatedRoute, private sharedService: SharedService) {
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            this.userApi.getUserById(this.user.id).subscribe(
                (user: UserDTOBase) => {
                    this.user = user;
                    if (this.user.type == 2 || this.user.type == 3) {
                        Object.assign(this.editedUser, this.user);
                        this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
                            (registrations: RegistrationDTOBase[]) => {
                                for (let registration of registrations) {
                                    this.isRegisterHold = (registration.status == 0); // 0 status is HOLD
                                    this.municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                                        (municipality: MunicipalityDTOBase) => {
                                            this.municipalities.push(municipality);
                                            this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                                                (mayor: MayorDTOBase) => {
                                                    this.mayors.push(mayor);
                                                }
                                            );
                                        }
                                    );
                                }
                            }
                        );
                    } else {
                        this.sharedService.growlTranslation('You are not allowed to view this page.', 'shared.error.notallowed', 'warn');
                        this.router.navigateByUrl('/home');
                    }
                }, error => {
                    this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later."', 'shared.error.api.generic', 'error');
                    this.router.navigateByUrl('/home');
                }
            );
            this.userThreadsApi.getThreadsByUserId(this.user.id).subscribe(
                (userThreads: UserThreadsDTOBase[]) => {
                    if (userThreads.length > 0) {
                        this.userThreads = userThreads[0];
                        this.threadId = userThreads[0].threadId;
                        this.hasDiscussion = true;
                    }
                }, error => {
                    console.log("service error: ", error);
                }
            );
        } else {
            this.sharedService.growlTranslation('You are not logged in!', 'shared.error.notloggedin', 'warn');
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
                this.userApi.ecasChangePassword().subscribe(
                    (response: ResponseDTOBase) => {
                        if (response.success) {
                            window.location.href = response.data;
                        }
                    }, error => {
                        console.log(error);
                    }
                );
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
        this.mayorApi.createMayor(this.editedMayor).subscribe(
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
        Object.assign(this.editedUser, this.user);
    }

    private deleteRegistration() {
        this.userApi.deleteUser(this.user.id).subscribe(
            (data: ResponseDTOBase) => {
                if (data.success) {
                    this.sharedService.growlTranslation('Your applications were succesfully deleted.', 'benefPortal.beneficiary.deleteApplication.Success', 'success');
                    this.sharedService.logout();
                }
            }, error => {
                this.sharedService.growlTranslation('An error occurred an your applications could not be deleted.', 'benefPortal.beneficiary.deleteApplication.Failure', 'error');
            }
        );
    }

    private goToDiscussion() {
        this.userThreadsApi.getThreadsByUserId(this.user.id).subscribe(
            (userThreads: UserThreadsDTOBase[]) => {
                this.userThreads = userThreads[0];
                this.threadId = userThreads[0].threadId;
                this.router.navigate(['../discussion-forum/', this.threadId], {relativeTo: this.route});
            }, error => {
                console.log("service error: ", error);
            }
        );
    }

    private preventPaste(event: any) {
        return false;
    }
}