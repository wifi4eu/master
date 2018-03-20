import { Component, ViewChild, ElementRef } from "@angular/core";
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
import { ThreadApi } from "../../shared/swagger/api/ThreadApi";
import { ThreadDTOBase } from "../../shared/swagger/model/ThreadDTO";

@Component({
    selector: 'beneficiary-profile',
    templateUrl: 'profile.component.html',
    providers: [UserApi, RegistrationApi, MunicipalityApi, UserThreadsApi, MayorApi, ThreadApi]
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
    private withdrawingRegistration: boolean = false;
    private withdrawnSuccess: boolean = false;
    private threadId: number;
    private hasDiscussion: boolean = false;
    private discussionThreads: ThreadDTOBase[] = [];
    @ViewChild("emailInput") emailInput: ElementRef;
    @ViewChild("emailMayor") emailMayor: ElementRef;

    constructor(private threadApi: ThreadApi, private userThreadsApi: UserThreadsApi, private userApi: UserApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private localStorageService: LocalStorageService, private router: Router, private route: ActivatedRoute, private sharedService: SharedService) {
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
                                            this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                                                (mayor: MayorDTOBase) => {
                                                    this.municipalities.push(municipality);
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
            this.userThreadsApi.getUserThreadsByUserId(this.user.id).subscribe(
                (utsByUser: UserThreadsDTOBase[]) => {
                    for (let utByUser of utsByUser) {
                        this.threadApi.getThreadById(utByUser.threadId).subscribe(
                            (thread: ThreadDTOBase) => {
                                if (thread != null) {
                                    this.userThreadsApi.getUserThreadsByThreadId(thread.id).subscribe(
                                        (utsByThread: UserThreadsDTOBase[]) => {
                                            this.discussionThreads.push(thread);
                                            if (utsByThread.length > 1) {
                                                for (let utByThread of utsByThread) {
                                                    if (utByThread.userId != this.user.id && !this.hasDiscussion) {
                                                        this.threadId = thread.id;
                                                        this.hasDiscussion = true;
                                                    }
                                                }
                                            }
                                        }
                                    );
                                }
                            }
                        );
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

    private disableEvent(event) {
      if(event.cancelable){
        event.preventDefault();
      }      
      return false;
    }

    private addEventListeners(events, element) {
      events.forEach(event => {
        element.addEventListener(event, this.disableEvent.bind(this));
      });
    }

    private displayModal(name: string, index?: number) {
        switch (name) {
            case 'user':
                this.displayUser = true;
                this.addEventListeners(['dragenter', 'dragover', 'drop', 'keydown', 'paste', 'cut'], this.emailInput.nativeElement);
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
                this.addEventListeners(['dragenter', 'dragover', 'drop', 'keydown', 'paste', 'cut'], this.emailMayor.nativeElement);
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
        if(this.editedUser.email != this.user.email){
          this.editedUser.email = this.user.email;
        }
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
        if(this.editedMayor.email != this.mayors[this.currentEditIndex].email){
          this.editedMayor.email = this.mayors[this.currentEditIndex].email;
        }
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
        if (!this.withdrawingRegistration && !this.withdrawnSuccess) {
            this.withdrawingRegistration = true;
            this.userApi.deleteUser(this.user.id).subscribe(
                (data: ResponseDTOBase) => {
                    if (data.success) {
                        this.sharedService.growlTranslation('Your applications were succesfully deleted.', 'benefPortal.beneficiary.deleteApplication.Success', 'success');
                        this.sharedService.logout();
                        this.withdrawingRegistration = false;
                        this.withdrawnSuccess = true;
                    }
                }, error => {
                    this.sharedService.growlTranslation('An error occurred an your applications could not be deleted.', 'benefPortal.beneficiary.deleteApplication.Failure', 'error');
                    this.withdrawingRegistration = false;
                    this.withdrawnSuccess = true;
                }
            );
        }
    }

    private goToDiscussion() {
        this.router.navigate(['../discussion-forum/', this.threadId], {relativeTo: this.route});
    }

    private preventPaste(event: any) {
        return false;
    }
}