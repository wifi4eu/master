import {Component, Input, OnChanges, Output} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {UserApi} from "../../../shared/swagger/api/UserApi";
import {UserDTOBase} from "../../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../../shared/swagger/model/MunicipalityDTO";
import {RegistrationDTOBase} from "../../../shared/swagger/model/RegistrationDTO";
import {RegistrationApi} from "../../../shared/swagger/api/RegistrationApi";
import {MunicipalityApi} from "../../../shared/swagger/api/MunicipalityApi";
import {BeneficiaryDTOBase} from "../../../shared/swagger/model/BeneficiaryDTO";
import {ResponseDTOBase} from "../../../shared/swagger/model/ResponseDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {SharedService} from "../../../shared/shared.service";
import {UserThreadsApi} from "../../../shared/swagger/api/UserThreadsApi";
import {UserThreadsDTOBase} from "../../../shared/swagger/model/UserThreadsDTO";
import {MayorApi} from "../../../shared/swagger/api/MayorApi";
import {MayorDTOBase} from "../../../shared/swagger/model/MayorDTO";
import {ThreadApi} from "../../../shared/swagger/api/ThreadApi";
import {NutsApi} from "../../../shared/swagger/api/NutsApi";
import {BeneficiaryApi} from "../../../shared/swagger/api/beneficiaryApi";
import {ThreadDTOBase} from "../../../shared/swagger/model/ThreadDTO";
import {Logs} from "selenium-webdriver";
import {LauDTOBase, LauDTO} from "../../../shared/swagger/model/LauDTO";
import {NutsDTOBase} from "../../../shared/swagger/model/NutsDTO";
import {LauApi} from "../../../shared/swagger/api/LauApi";
import {ViewChild} from "@angular/core";
import {NgForm} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import { TranslateService } from "ng2-translate";


@Component({
    selector: 'edit-beneficiary-profile',
    templateUrl: 'edit-profile.component.html',
    providers: [BeneficiaryApi, NutsApi, LauApi, UserApi, RegistrationApi, MunicipalityApi, UserThreadsApi, MayorApi, ThreadApi]
})

export class BeneficiaryEditProfileComponent {
    private successRegistration: boolean = false;
    private repeatEmail: string = '';
    private emailsMatch: boolean = false;
    private css_class_municipalities: string[] = ['notValid'];
    private css_class_email: string[] = ['notValid'];
    private countries: NutsDTOBase[] = [];
    private country: NutsDTOBase;
    private laus: LauDTOBase[] = [];
    private user: UserDTOBase = new UserDTOBase;
    private finalBeneficiary: BeneficiaryDTOBase = new BeneficiaryDTOBase();
    private municipalitiesSelected: boolean = false;
    private municipalities: MunicipalityDTOBase[] = [];
    private newMunicipality: MunicipalityDTOBase = new MunicipalityDTOBase();
    private newMayor: MayorDTOBase = new MayorDTOBase();
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
    private displayDeleteMunicipality: boolean = false;
    private deleteMunicipalityId: number = 0;
    private addMunicipality: boolean = false;
    private multipleMunicipalities: boolean = false;
    private lauSuggestions: LauDTOBase[] = [];
    private readonly MAX_LENGTH = 2;
    private initialUser: UserDTOBase = new UserDTOBase();
    @ViewChild('municipalityForm') municipalityForm: NgForm;
    private organizationId: number = 0;
    private emailPattern = new RegExp("(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\\])");

    constructor(private beneficiaryApi: BeneficiaryApi, private translateService: TranslateService, private nutsApi: NutsApi, private lauApi: LauApi, private threadApi: ThreadApi, private userThreadsApi: UserThreadsApi, private userApi: UserApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private localStorageService: LocalStorageService, private router: Router, private route: ActivatedRoute, private sharedService: SharedService) {
        this.loadDataEditProfile();
    }

    private loadDataEditProfile(){
        this.user = new UserDTOBase;
        this.municipalities = [];
        this.mayors = [];
        this.editedUser = new UserDTOBase();
        this.editedMunicipality = new MunicipalityDTOBase();
        this.editedMayor = new MayorDTOBase();
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        this.nutsApi.getNutsByLevel(0).subscribe(
            (nuts: NutsDTOBase[]) => {
                this.countries = nuts;
            }, error => {
                console.log(error);
            }
        );

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
                                    this.finalBeneficiary.organisationId = registrations[0].organisationId;
                                    this.finalBeneficiary.associationName = registrations[0].associationName;
                                    for (let registration of registrations) {
                                        this.allDocumentsUploaded.push(registration.allFilesFlag == 1);
                                        this.isRegisterHold = (registration.status == 0); // 0 status is HOLD
                                        this.municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                                            (municipality: MunicipalityDTOBase) => {
                                                this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                                                    (mayor: MayorDTOBase) => {
                                                        this.municipalities.push(municipality);
                                                        this.mayors.push(mayor);
                                                        if (this.municipalities.length > 0 && this.municipalities.length < 2){
                                                            if (this.country == null){
                                                                this.lauApi.getLauById(this.municipalities[0].lauId).subscribe(
                                                                    (country: LauDTO) => {
                                                                      this.country = country;
                                                                    }, error => {
                                                                        console.log(error);
                                                                    }
                                                                );
                                                            }
                                                        }
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

    private addNewMunicipality(){
        this.addMunicipality = true;
    }

    private cancelAddMunicipality(){
        this.addMunicipality = false;
        this.newMunicipality = new MunicipalityDTOBase();
        this.newMayor = new MayorDTOBase();
        this.laus = [];
    }

    private search(event: any) {
        let query = encodeURIComponent(event.query);
        if (this.country != null && query.length >= this.MAX_LENGTH) {
            this.lauApi.getLausByCountryCodeAndName1ContainingIgnoreCase(this.country.countryCode, query).subscribe(
                (laus: LauDTOBase[]) => {
                    this.lauSuggestions = laus;
                }
            );
        } else {
            this.lauSuggestions = [];
        }
    }

    private checkMunicipalitiesSelected() {
        this.municipalitiesSelected = false;
        for (let i = 0; i < this.laus.length; i++) {
            if (!this.laus[i].id) {
                this.municipalitiesSelected = false;
                if (!this.multipleMunicipalities) {
                    this.municipalityForm.controls['municipality'].setErrors({'incorrect': true});
                }
                else {
                    this.municipalityForm.controls[`municipality-${i}`].setErrors({'incorrect': true});
                }
                this.css_class_municipalities[i] = 'notValid';
            } else {
                if (!this.multipleMunicipalities) {
                    if (this.municipalityForm.controls['municipality'] != undefined) this.municipalityForm.controls['municipality'].setErrors(null);
                }
                else {
                    this.municipalityForm.controls[`municipality-${i}`].setErrors(null);
                }
                this.css_class_municipalities[i] = 'isValid';
                this.municipalitiesSelected = true;
            }
        }
    }

    private openModal(idMunicipality: number){
        this.deleteMunicipalityId = idMunicipality;
        this.displayDeleteMunicipality = true;
    }

    private deleteMunicipality(){
        if (this.deleteMunicipalityId != 0){
            this.municipalityApi.deleteMunicipalityFromId(this.deleteMunicipalityId).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.sharedService.growlTranslation('Your municipality were succesfully deleted.', 'benefPortal.beneficiary.deleteMunicipality.Success', 'success');
                        this.loadDataEditProfile();
                    } else {
                        this.sharedService.growlTranslation('Error. You can\'t delete this municipality. At least one municipality should remain in the registration', 'benefPortal.beneficiary.deleteMunicipality.Error', 'warn');
                    }
                    this.closeModal();
                }
            );
        } else {
            this.sharedService.growlTranslation('Error, you can\'t delete this municipality', 'benefPortal.beneficiary.deleteMunicipality.ErrorMunicipality', 'warn');
            this.closeModal();
        }
    }

    clearMunicipality(index) {
        if (typeof this.laus[index] == "string") {
            this.laus[index] = null;
        }
    }

    private checkEmailsMatch(){
        this.emailsMatch = false;
        if (this.newMayor.email != this.repeatEmail || this.repeatEmail.length < 1){
            this.emailsMatch = false;
        } else if (this.emailPattern.test(this.repeatEmail)) {
            this.emailsMatch = true;
        }
    }

    private submit(){
        this.newMunicipality.name = this.laus[0].name1;
        this.newMunicipality.lauId = this.laus[0].id;
        this.finalBeneficiary.municipalities = [];
        this.finalBeneficiary.municipalities.push(this.newMunicipality);
        this.finalBeneficiary.mayors = [];
        let language = this.translateService.currentLang;
        if (!language) {
            language = 'en';
        }
        this.finalBeneficiary.lang = language;
        this.finalBeneficiary.mayors.push(this.newMayor);
        this.initialUser.type = 3;
        this.finalBeneficiary.user = this.initialUser;
        this.beneficiaryApi.submitBeneficiaryRegistration(this.finalBeneficiary).subscribe(
            (data: ResponseDTOBase) => {
                if (data.success) {
                    this.successRegistration = true;
                    this.loadDataEditProfile();
                } else {
                    this.successRegistration = false;
                }
            }, error => {
                this.successRegistration = false;
            }
        );
    }

    private preventPaste(event: any) {
        return false;
    }

    private closeModal(){
        this.deleteMunicipalityId = 0;
        this.displayDeleteMunicipality = false;
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