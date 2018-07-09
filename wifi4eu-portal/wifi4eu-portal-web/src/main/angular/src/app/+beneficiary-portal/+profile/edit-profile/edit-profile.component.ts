import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {UserApi} from "../../../shared/swagger/api/UserApi";
import {UserDTOBase} from "../../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../../shared/swagger/model/MunicipalityDTO";
import {RegistrationDTOBase} from "../../../shared/swagger/model/RegistrationDTO";
import {RegistrationApi} from "../../../shared/swagger/api/RegistrationApi";
import {MunicipalityApi} from "../../../shared/swagger/api/MunicipalityApi";
import {ResponseDTOBase} from "../../../shared/swagger/model/ResponseDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {SharedService} from "../../../shared/shared.service";
import {UserThreadsApi} from "../../../shared/swagger/api/UserThreadsApi";
import {UserThreadsDTOBase} from "../../../shared/swagger/model/UserThreadsDTO";
import {MayorApi} from "../../../shared/swagger/api/MayorApi";
import {MayorDTOBase} from "../../../shared/swagger/model/MayorDTO";
import {ThreadApi} from "../../../shared/swagger/api/ThreadApi";
import {ThreadDTOBase} from "../../../shared/swagger/model/ThreadDTO";
import { Logs } from "selenium-webdriver";

@Component({
    selector: 'edit-beneficiary-profile',
    templateUrl: 'edit-profile.component.html',
    providers: [UserApi, RegistrationApi, MunicipalityApi, UserThreadsApi, MayorApi, ThreadApi]
})

export class BeneficiaryEditProfileComponent {
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
    private hasDiscussion: boolean []= [];
    private discussionThreads: ThreadDTOBase[] = [];
    private allDocumentsUploaded: boolean [] = [];
    private documentUploaded: boolean = false;
    private oneRegsitration: boolean = false;
    private oneRegistrationNumber: number = 0;
    private threadsByUser : UserThreadsDTOBase[] = [];
    private userThreads: ThreadDTOBase [] = [];
    private municipalityFinish: boolean = false;
    private mayorFinish: boolean = false;
    private userFinish: boolean = false;
    private buttonEnabled: boolean =  false;

    constructor(private threadApi: ThreadApi, private userThreadsApi: UserThreadsApi, private userApi: UserApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private localStorageService: LocalStorageService, private router: Router, private route: ActivatedRoute, private sharedService: SharedService) {
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            this.userApi.getUserById(this.user.id).subscribe(
                (user: UserDTOBase) => {
                    if (this.user != null) {
                        this.user = user;
                        if (this.user.type == 2 || this.user.type == 3) {
                            Object.assign(this.editedUser, this.user);
                            this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
                                (registrations: RegistrationDTOBase[]) => {
                                    if (registrations.length == 1) {
                                        this.oneRegsitration = true;
                                        this.oneRegistrationNumber = registrations[0].municipalityId;
                                        if (registrations[0].allFilesFlag == 1) {
                                            this.documentUploaded = true;
                                        }
                                    } else {
                                        this.oneRegsitration = false;
                                    }
                                    for (let registration of registrations) {
                                        this.allDocumentsUploaded.push(registration.allFilesFlag == 1);
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
                    }
                }, error => {
                    this.localStorageService.remove('user');
                    this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later."', 'shared.error.api.generic', 'error');
                }
            );
            this.userThreadsApi.getUserThreadsByUserId(this.user.id).subscribe(
                (utsByUser: UserThreadsDTOBase[]) => {
                    for (let utByUser of utsByUser) {
                        this.threadApi.getThreadById(utByUser.threadId).subscribe(
                            (thread: ThreadDTOBase) => {
                                if (thread != null) {
                                    this.userThreads.push(thread);
                                    this.userThreadsApi.getUserThreadsByThreadId(thread.id).subscribe(
                                        (utsByThread: UserThreadsDTOBase[]) => {
                                            this.discussionThreads.push(thread);
                                            if (utsByThread.length > 1) {
                                                 for (let i = 0; i < utsByThread.length; ++i) {
                                                    if (utsByThread[i].userId != this.user.id) {
                                                        this.threadsByUser.push(utsByThread[i]);
                                                        this.hasDiscussion.push(true);
                                                        
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

    private editProfile() {
        this.submittingData = true;
        for(let i = 0; i < this.municipalities.length; i++){
            this.municipalityApi.updateMunicipalityDetails(this.municipalities[i]).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.municipalityFinish = true;
                        this.checkFinishedCalls();
                        this.municipalities[this.currentEditIndex] = response.data;
                    }
                }
            );
            this.mayorApi.updateMayorDetails(this.mayors[i]).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.mayorFinish = true;
                        this.checkFinishedCalls();
                        this.mayors[this.currentEditIndex] = response.data;
                    }
                }
            );
        }
        this.userApi.updateUserDetails(this.user).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.userFinish = true;
                    this.checkFinishedCalls();
                    this.user = response.data;
                }
            }
        );

      
    }

    private checkFinishedCalls(){
        if(this.municipalityFinish && this.mayorFinish && this.userFinish){
            this.submittingData = false;
        }
    }

    private checkButtonEnabled(event, i){
         this.buttonEnabled = false
        if(this.municipalities[i].address != null && this.municipalities[i].addressNum != null && this.municipalities[i].postalCode != null && this.mayors[i].name != null  && this.mayors[i].surname != null  && this.mayors[i].email != null
         && this.municipalities[i].address.trim() != "" && this.municipalities[i].addressNum.trim() != "" && this.municipalities[i].postalCode.trim() != "" && this.mayors[i].name.trim() != ""  && this.mayors[i].surname.trim() != ""  && this.mayors[i].email.trim() != ""){
                this.buttonEnabled = true;
        } else {
            this.buttonEnabled = false

        }
    }

    private checkButtonEnabledUser(event){
    if(this.user.name != null && this.user.surname != null && this.user.name.trim() != "" && this.user.surname.trim() != ""){
        this.buttonEnabled = true;
    } else {
        this.buttonEnabled = false
    }
    }
}