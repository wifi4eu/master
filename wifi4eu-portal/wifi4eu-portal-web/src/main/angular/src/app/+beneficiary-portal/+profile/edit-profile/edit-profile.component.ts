import { Component, Input, OnChanges, Output } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { ApplicationApi } from "../../../shared/swagger/api/ApplicationApi";
import { UserApi } from "../../../shared/swagger/api/UserApi";
import { UserDTOBase, UserDTO } from "../../../shared/swagger/model/UserDTO";
import { MunicipalityDTOBase } from "../../../shared/swagger/model/MunicipalityDTO";
import { RegistrationDTOBase } from "../../../shared/swagger/model/RegistrationDTO";
import { RegistrationApi } from "../../../shared/swagger/api/RegistrationApi";
import { MunicipalityApi } from "../../../shared/swagger/api/MunicipalityApi";
import { BeneficiaryDTOBase } from "../../../shared/swagger/model/BeneficiaryDTO";
import { ResponseDTOBase } from "../../../shared/swagger/model/ResponseDTO";
import { ApplicationDTOBase } from "../../../shared/swagger/model/ApplicationDTO";
import { LocalStorageService } from "angular-2-local-storage";
import { SharedService } from "../../../shared/shared.service";
import { UserThreadsApi } from "../../../shared/swagger/api/UserThreadsApi";
import { UserThreadsDTOBase } from "../../../shared/swagger/model/UserThreadsDTO";
import { MayorApi } from "../../../shared/swagger/api/MayorApi";
import { CallApi } from "../../../shared/swagger/api/CallApi";
import { MayorDTOBase } from "../../../shared/swagger/model/MayorDTO";
import { ThreadApi } from "../../../shared/swagger/api/ThreadApi";
import { NutsApi } from "../../../shared/swagger/api/NutsApi";
import { BeneficiaryApi } from "../../../shared/swagger/api/BeneficiaryApi";
import { ThreadDTOBase } from "../../../shared/swagger/model/ThreadDTO";
import { UserRegistrationDTO, UserRegistrationDTOBase } from "../../../shared/swagger/model/UserRegistrationDTO";
import { Logs } from "selenium-webdriver";
import { LauDTOBase, LauDTO } from "../../../shared/swagger/model/LauDTO";
import { NutsDTOBase } from "../../../shared/swagger/model/NutsDTO";
import { LauApi } from "../../../shared/swagger/api/LauApi";
import { ViewChild } from "@angular/core";
import { NgForm } from "@angular/forms";
import { Observable } from "rxjs/Observable";
import { TranslateService } from "ng2-translate";
import { CallDTO, CallDTOBase, OrganizationApi, OrganizationDTOBase } from "../../../shared/swagger";
import { CookieService } from "ngx-cookie-service";
import { UserContactDetailsBase } from "../../../shared/swagger";


@Component({
    selector: 'edit-beneficiary-profile',
    templateUrl: 'edit-profile.component.html',
    providers: [OrganizationApi, CallApi, ApplicationApi, BeneficiaryApi, NutsApi, LauApi, UserApi, RegistrationApi, MunicipalityApi, UserThreadsApi, MayorApi, ThreadApi]
})

export class BeneficiaryEditProfileComponent {
    private successRegistration: boolean = false;
    private repeatEmail: string = '';
    private emailsMatch: boolean = false;
    private css_class_municipalities: string[] = ['notValid'];
    private css_class_email: string[] = ['notValid'];
    private countries: NutsDTOBase[] = [];
    private addUser: boolean = false;
    private addContact: boolean = false;
    private idMunicipalityNewContactUser: number = 0;
    private country: NutsDTOBase;
    private laus: LauDTOBase[] = [];
    private user: UserDTOBase = new UserDTOBase;
    private users: UserContactDetailsBase[][] = [];
    private usersModified: number[] = [];
    private userMain: UserContactDetailsBase;
    private finalBeneficiary: BeneficiaryDTOBase = new BeneficiaryDTOBase();
    private municipalitiesSelected: boolean = false;
    private municipalities: MunicipalityDTOBase[] = [];
    private newMunicipalities: MunicipalityDTOBase[] = [];
    private newMayors: MayorDTOBase[] = [];
    private mayors: MayorDTOBase[] = [];
    private editedUser: UserDTOBase = new UserDTOBase();
    private currentEditIndex: number = 0;
    private isMunicipalityEditable = {};
    private displayUser: boolean = false;
    private displayMunicipality: boolean = false;
    private displayMayor: boolean = false;
    private submittingData = false;
    private isRegisterHold: boolean = false;
    private withdrawingRegistration: boolean = false;
    private withdrawnSuccess: boolean = false;
    private threadId: number;
    private hasDiscussion: boolean[] = [];
    private discussionThreads: ThreadDTOBase[] = [];
    private allDocumentsUploaded: boolean[] = [];
    private documentUploaded: boolean = false;
    private oneRegsitration: boolean = false;
    private oneRegistrationNumber: number = 0;
    private threadsByUser: UserThreadsDTOBase[] = [];
    private userThreads: ThreadDTOBase[] = [];
    private buttonEnabled: boolean = false;
    private displayDeleteMunicipality: boolean = false;
    private deleteMunicipalityId: number = 0;
    private emailConfirmations: string[] = [''];
    private addMunicipality: boolean = false;
    private multipleMunicipalities: boolean = true;
    private lauSuggestions: LauDTOBase[] = [];
    private readonly MAX_LENGTH = 2;
    private initialUser: UserDTOBase = new UserDTOBase();
    @ViewChild('municipalityForm') municipalityForm: NgForm;
    private organizationId: number = 0;
    private isOrganisation: boolean = false;
    private currentCall: CallDTOBase;
    private emailPattern = new RegExp("(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\\])");
    private newUserEmail: string = '';
    private registrationIndex: number = null;
    private associationName: String = '';
    private registration: RegistrationDTOBase;
    private hasAssociation: boolean = false;
    private nameCookieApply: string = "hasRequested";
    private registrations: RegistrationDTOBase[] = [];
    private contactIdToDeactvate: number = 0;
    private displayDeactivatemodal: boolean = false;

    constructor(private cookieService: CookieService, private callApi: CallApi, private applicationApi: ApplicationApi, private beneficiaryApi: BeneficiaryApi, private translateService: TranslateService, private nutsApi: NutsApi, private lauApi: LauApi, private threadApi: ThreadApi, private userThreadsApi: UserThreadsApi, private userApi: UserApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private localStorageService: LocalStorageService, private router: Router, private route: ActivatedRoute, private sharedService: SharedService) {
        this.loadDataEditProfile();
    }

    private loadDataEditProfile() {
        this.user = new UserDTOBase;
        this.municipalities = [];
        this.mayors = [];
        this.editedUser = new UserDTOBase();
        this.emailConfirmations = [''];
        this.css_class_municipalities = ['notValid'];
        this.css_class_email = ['notValid'];
        if (this.newMayors.length > 0) {
            for (let a = 0; a < this.newMayors.length; a++) {
                this.laus[a] = null;
            }
        }
        this.isMunicipalityEditable = {};
        this.newMayors = [];
        this.newMunicipalities = [];
        this.emailsMatch = false;
        this.buttonEnabled = false;
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        this.nutsApi.getNutsByLevel(0).subscribe(
            (nuts: NutsDTOBase[]) => {
                this.countries = nuts;
            }, error => {
                console.log(error);
            }
        );

        this.callApi.getCurrentCall().subscribe(
            (call: CallDTOBase) => {
                this.currentCall = call;
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
                                    this.registrations = registrations;
                                    if (registrations.length == 1) {
                                        this.oneRegsitration = true;
                                        this.oneRegistrationNumber = registrations[0].municipalityId;
                                        if (registrations[0].allFilesFlag == 1) {
                                            this.documentUploaded = true;
                                        }
                                        this.registration = registrations[0];
                                    } else {
                                        this.oneRegsitration = false;
                                    }
                                    if (registrations[0].organisationId != 0) {
                                        this.isOrganisation = true;
                                        this.finalBeneficiary.organisationId = registrations[0].organisationId;
                                        this.organizationId = registrations[0].organisationId;
                                        this.finalBeneficiary.associationName = registrations[0].associationName;
                                        this.registration = registrations[0];
                                    }
                                    for (let registration of registrations) {
                                        if (registration.municipalityId == 0) {
                                            continue;
                                        }
                                        this.allDocumentsUploaded.push(registration.allFilesFlag == 1);
                                        this.isRegisterHold = (registration.status == 0); // 0 status is HOLD
                                        this.municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                                            (municipality: MunicipalityDTOBase) => {
                                                this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                                                    (mayor: MayorDTOBase) => {
                                                        this.municipalities.push(municipality);
                                                        this.checkEditPermissionMunicipality(municipality.id);
                                                        this.mayors.push(mayor);
                                                        if (this.municipalities.length > 0 && this.municipalities.length < 2) {
                                                            if (this.country == null) {
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
                                        this.userApi.getUsersFromRegistration(registration.id).subscribe(
                                            (users: UserContactDetailsBase[]) => {
                                                this.users[registration.municipalityId] = users;
                                                this.userMain = users.find(x => x.main === 1);
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

    private isVoucherApplied(idRegistration: number) {
        if (this.cookieService.check(this.nameCookieApply + "_" + idRegistration)) {
            if (this.cookieService.get(this.nameCookieApply + "_" + idRegistration) == "true") {
                return true;
            }
        }
        return false;
    }

    private checkEditPermissionMunicipality(municipalityId: number) {
        this.applicationApi.isMunicipalityEditable(municipalityId).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.isMunicipalityEditable[municipalityId] = response.data;
                    if (response.data) {
                        //Check if municipality have applied cookie and then disable input fields
                        var appliedExist = this.registrations.some(registration => this.isVoucherApplied(registration.id) === true);
                        this.isMunicipalityEditable[municipalityId] = !appliedExist;
                    }
                }
            }
        );
    }

    private addExtraMunicipality() {
        if (this.multipleMunicipalities) {
            this.newMunicipalities.push(new MunicipalityDTOBase());
            this.newMayors.push(new UserDTOBase());
            this.emailConfirmations.push('');
            this.css_class_email.push('notValid');
            this.css_class_municipalities.push('notValid');
            setTimeout(() => {
                let i = this.newMunicipalities.length - 1;
                var element = document.getElementById("scrollMunicipality-" + i);
                element.scrollIntoView({ behavior: "smooth" });
            }, 200);
        }
        this.checkMunicipalitiesSelected();
    }

    private removeExtraMunicipality(index: number, deleteCount: number = 1) {
        this.newMunicipalities.splice(index, deleteCount);
        this.laus.splice(index, deleteCount);
        this.newMayors.splice(index, deleteCount);
        this.laus[index] = null;
        this.emailConfirmations.splice(index, deleteCount);
        this.css_class_email.splice(index, deleteCount);
        this.css_class_municipalities.splice(index, deleteCount);
        if (this.newMayors.length < 1) {
            this.checkMunicipalitiesSelected();
            this.municipalitiesSelected = true;
        } else {
            this.municipalitiesSelected = true;
            this.checkMunicipalitiesSelected();
        }
        this.checkEmailsMatch();
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
            if (!this.laus[i]) {
                this.municipalitiesSelected = false;
                this.css_class_municipalities[i] = 'notValid';
            } else {
                this.css_class_municipalities[i] = 'isValid';
                this.municipalitiesSelected = true;
            }
        }
    }

    private openModal(idMunicipality: number) {
        if (this.buttonEnabled) {
            this.sharedService.growlTranslation('Error, you can\'t delete a municipality if there are changes to save. Please confirm the changes or cancel them before deleting municipaliies', 'benefPortal.beneficiary.deleteMunicipality.changesNotSaved', 'warn');
        } else {
            this.deleteMunicipalityId = idMunicipality;
            this.displayDeleteMunicipality = true;
        }
    }

    private deleteMunicipality() {
        if (this.deleteMunicipalityId != 0) {
            this.municipalityApi.deleteMunicipalityFromId(this.deleteMunicipalityId).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.sharedService.growlTranslation('Your municipality were succesfully deleted.', 'benefPortal.beneficiary.deleteMunicipality.Success', 'success');
                        this.loadDataEditProfile();
                    } else {
                        this.sharedService.growlTranslation('Error. You can\'t delete this municipality. At least one municipality should remain in the registration', 'benefPortal.beneficiary.deleteMunicipality.Error', 'warn');
                    }
                    this.closeModal();
                }, error => {
                    this.sharedService.growlTranslation('Error, you can\'t delete this municipality', 'benefPortal.beneficiary.deleteMunicipality.ErrorMunicipality', 'warn');
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

    private checkEmailsMatch() {
        this.emailsMatch = false;
        for (let i = 0; i < this.newMayors.length; i++) {
            if (this.newMayors[i].email != this.emailConfirmations[i] || this.emailConfirmations[i].length < 1) {
                this.emailsMatch = false;
                this.css_class_email[i] = 'notValid';
            } else {
                this.css_class_email[i] = 'isValid';
                this.emailsMatch = true;
            }
        }
    }

    private submitNewMunicipalities() {
        for (let i = 0; i < this.newMunicipalities.length; i++) {
            this.newMunicipalities[i].name = this.laus[i].name1;
            this.newMunicipalities[i].country = this.municipalities[0].country;
            this.newMunicipalities[i].lauId = this.laus[i].id;
        }
        this.finalBeneficiary.municipalities = [];
        for (let municipality of this.newMunicipalities) {
            this.finalBeneficiary.municipalities.push(municipality);
        }

        let language = this.translateService.currentLang;
        if (!language) {
            language = 'en';
        }
        this.finalBeneficiary.lang = language;
        this.finalBeneficiary.mayors = [];
        for (let mayor of this.newMayors) {
            this.finalBeneficiary.mayors.push(mayor);
        }
        this.finalBeneficiary.user = this.user;
        this.beneficiaryApi.submitNewMunicipalities(this.finalBeneficiary).subscribe(
            (data: ResponseDTOBase) => {
                if (data.success) {
                    this.successRegistration = true;
                    this.sharedService.growlTranslation('Your municipality has been added successfully.', 'benefPortal.beneficiary.addMunicipalities.Success', 'success');
                    this.loadDataEditProfile();
                    this.submittingData = false;
                    this.goBackToProfile();

                } else {
                    this.sharedService.growlTranslation('An error ocurred while trying to add the municipalities. Please try again latern', 'benefPortal.beneficiary.addMunicipalities.Error', 'error');
                    this.submittingData = false;
                }
            }, error => {
                this.sharedService.growlTranslation('You are trying to add a municipality already existing.', 'benefPortal.beneficiary.addMunicipalities.duplicated', 'warn');
                this.loadDataEditProfile();
                this.submittingData = false;
            }
        );
    }

    private preventPaste(event: any) {
        return false;
    }

    private closeModal() {
        this.registrationIndex = null;
        this.deleteMunicipalityId = 0;
        this.displayDeleteMunicipality = false;
        this.addUser = false;
        this.addContact = false;
        this.displayDeactivatemodal = false;
    }

    private editProfile() {
        this.submittingData = true;

        for (let i = 0; i < this.municipalities.length; i++) {
            if (this.isMunicipalityEditable[this.municipalities[i].id]) {
                this.municipalityApi.updateMunicipalityDetails(this.municipalities[i]).subscribe(
                    (response: ResponseDTOBase) => {
                        if (response.success) {
                            this.mayorApi.updateMayorDetails(this.mayors[i]).subscribe(
                                (response: ResponseDTOBase) => {
                                    if (response.success) {
                                        this.mayors[this.currentEditIndex] = response.data;
                                        let usersToSubmit: UserContactDetailsBase[] = [];
                                        for (let index = 0; index < this.registrations.length; index++) {
                                            for (let z = 0; z < this.users[this.registrations[index].municipalityId].length; z++) {
                                                let user = this.users[this.registrations[index].municipalityId][z];
                                                if (user.main === 1) {
                                                    user = this.userMain;
                                                }
                                                if (this.usersModified.indexOf(user.id) != -1) {
                                                    usersToSubmit.push(user);
                                                }
                                            }
                                        }
                                        if (usersToSubmit.length > 0) {
                                            let update = {};
                                            update['users'] = usersToSubmit;
                                            this.userApi.updateUserDetails(update).subscribe(
                                                (response: ResponseDTOBase) => {
                                                    if (response.success) {
                                                        this.user = response.data;
                                                        if (this.newMunicipalities.length > 0) {
                                                            this.submitNewMunicipalities();
                                                        } else {
                                                            this.sharedService.growlTranslation('Your profile data was updated successfully.', 'shared.editProfile.save.success', 'success');
                                                            this.goBackToProfile();
                                                        }

                                                    } else {
                                                        this.sharedService.growlTranslation('An error ocurred while trying to update your profile data. Please, try again later.', 'shared.editProfile.save.error', 'error');
                                                    }
                                                }
                                            );
                                        }
                                    }
                                }
                            );
                        }
                    }
                );
            }
        }



        /* if(this.registration.associationName != null && this.registration.associationName != ""){
            this.registrationApi.updateAssociationName(this.registration).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.registrationFinish = true;
                        this.checkFinishedCalls();
                    } else {
                        hasBeenAnError = true
                    }
                }, error => {
                    console.log(error);
                    this.registrationFinish = true;
                    this.checkFinishedCalls();
                    hasBeenAnError = true
                }
            );
        } else {
            this.registrationFinish = true;
            this.checkFinishedCalls();
        } */

        /* 
                if (hasBeenAnError) {
                    this.sharedService.growlTranslation('An error ocurred while trying to update your profile data. Please, try again later.', 'shared.editProfile.save.error', 'error');
                } else {
                    this.sharedService.growlTranslation('Your profile data was updated successfully.', 'shared.editProfile.save.success', 'success');
                    this.goBackToProfile();
                } */
    }

    private goBackToProfile() {
        this.router.navigate(['../'], { relativeTo: this.route });
    }

    private checkButtonEnabled(event, i) {
        this.buttonEnabled = false;
        if (this.municipalities[i].address != null && this.municipalities[i].addressNum != null && this.municipalities[i].postalCode != null && this.mayors[i].name != null && this.mayors[i].surname != null && this.mayors[i].email != null
            && this.municipalities[i].address.trim() != "" && this.municipalities[i].addressNum.trim() != "" && this.municipalities[i].postalCode.trim() != "" && this.mayors[i].name.trim() != "" && this.mayors[i].surname.trim() != "" && this.mayors[i].email.trim() != "") {
            this.buttonEnabled = true;
            if (this.registration.associationName != null && this.registration.associationName.trim() != "") {
                if (this.newMunicipalities.length > 0) {
                    for (let j = 0; j < this.newMunicipalities.length; j++) {
                        if (this.newMunicipalities[j].address != null && this.newMunicipalities[j].addressNum != null && this.newMunicipalities[j].postalCode != null && this.newMayors[j].name != null && this.newMayors[j].surname != null && (this.newMunicipalities[j].address.trim() == "" || this.newMunicipalities[j].addressNum.trim() == "" || this.newMunicipalities[j].postalCode.trim() == "" || this.newMayors[j].name.trim() == "" || this.newMayors[j].surname.trim() == "")) {
                            this.buttonEnabled = false;
                            break;
                        }
                    }
                } else {
                    this.emailsMatch = true;
                    this.municipalitiesSelected = true;
                }
            } else {
                this.emailsMatch = true;
                this.municipalitiesSelected = true;
            }
        }
    }

    private addNewContactToMunicipality(municipalityId: number) {
        this.idMunicipalityNewContactUser = municipalityId;
        this.addUser = true;
    }

    private closeAddNewContactModal() {
        this.newUserEmail = '';
        this.addUser = false;
    }

    private addNewContact() {
        if (this.newUserEmail.trim() != '' && this.idMunicipalityNewContactUser != 0) {
            this.addContact = true;
            this.beneficiaryApi.invitateContactBeneficiary(this.idMunicipalityNewContactUser, this.newUserEmail).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.sharedService.growlTranslation('Email sent successfully', response.data, 'success');
                        this.addContact = false;
                        this.addUser = false;
                        this.closeModal();
                    } else {
                        this.addContact = false;
                        this.sharedService.growlTranslation(response.data, response.error.errorMessage, 'error');
                        this.closeModal();
                    }
                }, error => {
                    this.addContact = false;
                    this.sharedService.growlTranslation('An error occurred. Please, try again later.', 'shared.email.error', 'error');
                    this.closeModal();
                }
            );
            this.newUserEmail = '';
        } else {
            this.sharedService.growlTranslation('Please, complete the email field to add a new contact', 'benefPortal.profile.addNewContact.empty', 'error');
        }
    }


    private checkButtonEnabledUser(event, id) {
        this.buttonEnabled = true;
        if (this.usersModified.indexOf(id) == -1) {
            this.usersModified.push(id);
        }
        for (let index = 0; index < this.registrations.length; index++) {
            for (let z = 0; z < this.users[this.registrations[index].municipalityId].length; z++) {
                let user = this.users[this.registrations[index].municipalityId][z];
                if (user.main === 1) {
                    user = this.userMain;
                }
                let addressValid = user.address != null && user.addressNum != null && user.postalCode != null && user.city != null && user.country != null &&
                    (user.address.trim() != "" && user.addressNum.trim() != "" && user.postalCode.trim() != "" && user.city.trim() != "" && user.country.trim() != "");
                let userDetailsValid = user.name != null && user.surname != null && user.email != null && (user.name.trim() != "" && user.surname.trim() != "" && user.email.trim() != "");

                if (!addressValid || !userDetailsValid) {
                    this.buttonEnabled = false;
                }
            }
        }

        if (this.newMunicipalities.length > 0) {
            for (let j = 0; j < this.newMunicipalities.length; j++) {
                if (this.newMunicipalities[j].address != null && this.newMunicipalities[j].addressNum != null && this.newMunicipalities[j].postalCode != null && this.newMayors[j].name != null && this.newMayors[j].surname != null && (this.newMunicipalities[j].address.trim() == "" || this.newMunicipalities[j].addressNum.trim() == "" || this.newMunicipalities[j].postalCode.trim() == "" || this.newMayors[j].name.trim() == "" || this.newMayors[j].surname.trim() == "")) {
                    this.buttonEnabled = false;
                    break;
                }
            }
        } else if (this.buttonEnabled) {
            this.buttonEnabled = true;
            this.emailsMatch = true;
            this.municipalitiesSelected = true;
        }
    }


    private deactivateContactModal() {
        this.userApi.deactivateRegistrationUser(this.registration.id, this.contactIdToDeactvate).subscribe(
            (responseDTO: ResponseDTOBase) => {
                this.sharedService.growlTranslation('Deactivate contact successfully', 'shared.deactivate.sucess', 'success');
                this.closeModal();
                this.goBackToProfile();
            }, error => {
                this.sharedService.growlTranslation('An error occurred. Please, try again later.', 'shared.error.api.generic', 'error');
                this.closeModal();
            }
        );
        this.closeModal();
    }

    private deactivateShowModal(i) {
        this.contactIdToDeactvate = i;
        this.displayDeactivatemodal = true;
    }


}