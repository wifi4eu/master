import { Component } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { UserApi } from "../../shared/swagger/api/UserApi";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { RegistrationDTOBase } from "../../shared/swagger/model/RegistrationDTO";
import { RegistrationApi } from "../../shared/swagger/api/RegistrationApi";
import { BeneficiaryApi } from "../../shared/swagger/api/BeneficiaryApi";
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

// Languages functionality
import {UxEuLanguages, UxLanguage} from "@ec-digit-uxatec/eui-angular2-ux-language-selector";
import { UserDetailsService } from "../../core/services/user-details.service";
import { elementAt } from "../../../../node_modules/rxjs/operator/elementAt";

@Component({
    selector: 'beneficiary-profile',
    templateUrl: 'profile.component.html',
    providers: [UserApi, RegistrationApi, MunicipalityApi, UserThreadsApi, MayorApi, ThreadApi, BeneficiaryApi]
})

export class BeneficiaryProfileComponent {
    private user: UserDTOBase = new UserDTOBase;
    private users: UserDTOBase[] = [];
    private municipalities: MunicipalityDTOBase[] = [];
    private mayors: MayorDTOBase[] = [];
    private editedUser: UserDTOBase = new UserDTOBase();
    private editedMunicipality: MunicipalityDTOBase = new MunicipalityDTOBase();
    private editedMayor: MayorDTOBase = new MayorDTOBase();
    private currentEditIndex: number = 0;
    private displayUser: boolean = false;
    private displayMunicipality: boolean = false;
    private displayMayor: boolean = false;
    private displayLanguageModal: boolean = false;
    private submittingData = false;
    private isRegisterHold: boolean = false;
    private withdrawingRegistration: boolean = false;
    private withdrawnSuccess: boolean = false;
    private threadId: number;
    private discussionThreads: ThreadDTOBase[] = [];
    private allDocumentsUploaded: boolean[] = [];
    private documentUploaded: boolean = false;
    private oneRegistrationNumber: number = 0;
    private userThreads: ThreadDTOBase [] = [];
    private orderedUserThreads: ThreadDTOBase [] = [];
    private threadsByUser : UserThreadsDTOBase[] = [];

    private newLanguageArray: string = "bg,cs,da,de,et,el,en,es,fr,it,lv,lt,hu,mt,nl,pl,pt,ro,sk,sl,fi,sv,hr,ga";
    private selectedLanguage: UxLanguage = UxEuLanguages.languagesByCode['en'];
    protected modalIsOpen: boolean = false;
    protected languageRows: UxLanguage [] [];
    protected languages: UxLanguage [];
    private withdrawingRegistrationConfirmation: boolean = false;

    constructor(private beneficiaryApi: BeneficiaryApi, private threadApi: ThreadApi, private userThreadsApi: UserThreadsApi, private userApi: UserApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private localStorageService: LocalStorageService, private router: Router, private route: ActivatedRoute, private sharedService: SharedService) {
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
                                    for (let registration of registrations) {
                                        if (registration.municipalityId == 0){
                                            continue;
                                        }
                                        this.allDocumentsUploaded.push(registration.allFilesFlag == 1);
                                        this.isRegisterHold = (registration.status == 0); // 0 status is HOLD
                                        this.municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                                            (municipality: MunicipalityDTOBase) => {
                                                this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                                                    (mayor: MayorDTOBase) => {
                                                        this.municipalities.push(municipality);                                                                                                                 
                                                        this.mayors.push(mayor);
                                                        // Order the threads array with the municipalities
                                                        if(this.municipalities.length == registrations.length) {
                                                            let indexedThreads = this.userThreads.map(function(element) { return element.title});                                                        
                                                            for(let municipality of this.municipalities) {                
                                                                let exists = indexedThreads.indexOf(municipality.name);                             
                                                                if(exists != -1) {
                                                                    this.orderedUserThreads.push(this.userThreads[exists]);
                                                                } 
                                                                else {
                                                                    this.orderedUserThreads.push(null);                                                                
                                                                }
                                                            }
                                                        }
                                                    }
                                                );
                                            }
                                        );
                                        this.userApi.getUsersFromRegistration(registration.id).subscribe(
                                            (users: UserDTOBase[]) => {
                                                    this.users = users;
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
                                    this.userThreadsApi.getUserThreadsByThreadId(thread.id).subscribe(
                                        (utsByThread: UserThreadsDTOBase[]) => {
                                            this.discussionThreads.push(thread);
                                            if (utsByThread.length > 1) {
                                                this.userThreads.push(thread);
                                                 for (let i = 0; i < utsByThread.length; ++i) {
                                                    if (utsByThread[i].userId != this.user.id) {
                                                        this.threadsByUser.push(utsByThread[i]);
                                                        
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

        this.loadLanguages();
    }

    private withdrawRegistration(){
        this.withdrawingRegistrationConfirmation = true;
    }

    private displayModal(name: string, index?: number) {
        switch (name) {
            case 'withdraw':
                this.withdrawingRegistrationConfirmation = true;
                break;
            case 'user':
                Object.assign(this.editedUser, this.user);
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
        if (this.editedUser.email != this.user.email) {
            this.editedUser.email = this.user.email;
        }
        this.submittingData = true;
        this.userApi.updateUserDetails(this.editedUser).subscribe(
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
        if (this.editedMunicipality.country != this.municipalities[this.currentEditIndex].country) {
            this.editedMunicipality.country = this.municipalities[this.currentEditIndex].country;
        }
        if (this.editedMunicipality.name != this.municipalities[this.currentEditIndex].name) {
            this.editedMunicipality.name = this.municipalities[this.currentEditIndex].name;
        }
        this.submittingData = true;
        this.municipalityApi.updateMunicipalityDetails(this.editedMunicipality).subscribe(
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
        if (this.editedMayor.email != this.mayors[this.currentEditIndex].email) {
            this.editedMayor.email = this.mayors[this.currentEditIndex].email;
        }
        this.submittingData = true;
        this.mayorApi.updateMayorDetails(this.editedMayor).subscribe(
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
        this.displayLanguageModal = false;
    }

    private deleteRegistration() {
        this.withdrawingRegistrationConfirmation = false;
        if (!this.withdrawingRegistration && !this.withdrawnSuccess) {
            this.withdrawingRegistration = true;
            this.userApi.deleteUser(this.user.id).subscribe(
                (data: ResponseDTOBase) => {
                    if (data.success) {
                        this.sharedService.growlTranslation('Your applications were succesfully deleted.', 'benefPortal.beneficiary.deleteApplication.Success', 'success');
                        this.sharedService.logout();
                        this.withdrawingRegistration = false;
                        this.withdrawnSuccess = true;
                    } else {
                        this.sharedService.growlTranslation('An error occurred an your applications could not be deleted.', 'benefPortal.beneficiary.deleteApplication.Failure', 'error');
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

    private checkHasDiscussion(municipality){
      return this.userThreads.some(userThread => userThread.title === municipality.name);
    }

    private goToDiscussion(index) {
        for(let i = 0; i < this.userThreads.length; i++){
            if(this.userThreads[i].title == this.municipalities[index].name){
                this.threadId = this.discussionThreads[i].id;
                this.router.navigate(['../discussion-forum/', this.threadId], {relativeTo: this.route});
           }
        }
    }

    private goToUploadDocuments(idMunicipality) {
        this.router.navigate(['../additional-info/', idMunicipality], { relativeTo: this.route });
    }

    private goToapplyForVOucher() {
        this.router.navigateByUrl('/beneficiary-portal/voucher');
    }

    /* Language functionalities */
    private loadLanguages() {
        if (this.newLanguageArray != null) {
            let codes: string [] = this.newLanguageArray.split(/[ ,]+/g);
            this.languages = UxEuLanguages.getLanguages(codes);
        } else {
            this.languages = UxEuLanguages.getLanguages();
        }
        this.languageRows = this.prepareLanguageRows();

        const userLang = this.languages.find(language => language.code === this.user.lang);
        this.selectedLanguage = userLang;
    }

    private prepareLanguageRows(): UxLanguage [] [] {
        let rows: UxLanguage [] [] = [];
        let row: UxLanguage [] = [];
        for (let i = 0; i < this.languages.length; i++) {
            if (i % 4 == 0) {
                if (row.length > 0) {
                    rows.push(row);
                    row = [];
                }
            }
            row.push(this.languages[i]);
        }

        if (row.length > 0) {
            rows.push(row);
        }

        return rows;
    }

    /* Language modal */
    private changeLanguage() {
        this.displayLanguageModal = true;
       }

    private selectLanguage(lang) {
        this.userApi.updateLanguage(lang).subscribe(
            (data: ResponseDTOBase) => {
                if (data.success) {
                    this.sharedService.growlTranslation('Your registration was successfully updated.', 'shared.registration.update.success', 'success');
                } else {
                    this.sharedService.growlTranslation('shared.registration.update.error', 'An error occurred and your registration could not be updated.', 'error');
                }
            }, error => {
                this.sharedService.growlTranslation('shared.registration.update.error', 'An error occurred and your registration could not be updated.', 'error');
            }
        );
        const newSelectedLang = this.languages.find(language => language.code === lang);
        this.selectedLanguage = newSelectedLang;
        this.displayLanguageModal = false;
    }

    private goToEditProfile() {
        this.router.navigate(['../profile/edit-profile'], { relativeTo: this.route });
    }
}