import { animate, style, transition, trigger } from "@angular/animations";
import { Component, ViewChild } from "@angular/core";
import { LocalStorageService } from "angular-2-local-storage";
import { Observable } from "rxjs/Observable";
import { SharedService } from "../../shared/shared.service";
import { UserApi } from "../../shared/swagger/api/UserApi";
import { SupplierApi } from "../../shared/swagger/api/SupplierApi";
import { NutsApi } from "../../shared/swagger/api/NutsApi";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { SupplierDTOBase } from "../../shared/swagger/model/SupplierDTO";
import { NutsDTOBase } from "../../shared/swagger/model/NutsDTO";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";

// Languages functionality
import {UxEuLanguages, UxLanguage} from "@ec-digit-uxatec/eui-angular2-ux-language-selector";
import { UserDetailsService } from "../../core/services/user-details.service";

@Component({
    selector: 'supplier-profile',
    templateUrl: 'profile.component.html',
    styleUrls: ['profile.component.scss'],
    providers: [UserApi, SupplierApi, NutsApi],
    animations: [
        trigger(
            'enterSpinner', [
                transition(':enter', [
                    style({opacity: 0}),
                    animate('200ms', style({opacity: 1}))
                ]),
                transition(':leave', [
                    style({opacity: 1}),
                    animate('200ms', style({opacity: 0}))
                ])
            ]
        )
    ]
})

export class SupplierProfileComponent {
    private user: UserDTOBase = new UserDTOBase();
    private supplier: SupplierDTOBase = new SupplierDTOBase();
    private editedSupplier: SupplierDTOBase = new SupplierDTOBase();
    private supportedRegions: NutsDTOBase[][] = [];
    private selectedCountriesNames: string[] = [];
    private displayContact: boolean = false;
    private displayCompany: boolean = false;
    private withdrawingRegistration: boolean = false;
    private withdrawnSuccess: boolean = false;
    private submittingData: boolean = false;
    private isLogoUploaded: boolean = false;
    private deletingLogo: boolean = false;
    private fetchingData: boolean = false;
    private displayLanguageModal: boolean = false;
    private logoUrl: FileReader = new FileReader();
    private logoFile: File;
    private emailPattern = new RegExp("(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\\])");
    private websitePattern: string = "(([wW][wW][wW]\\.)|([hH][tT][tT][pP][sS]?:\\/\\/([wW][wW][wW]\\.)?))?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,256}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
    @ViewChild('logoInput') private logoInput: any;
    private regionsToRender: NutsDTOBase[] = [];

    private newLanguageArray: string = "bg,cs,da,de,et,el,en,es,fr,it,lv,lt,hu,mt,nl,pl,pt,ro,sk,sl,fi,sv,hr,ga";
    private selectedLanguage: UxLanguage = UxEuLanguages.languagesByCode['en'];
    protected modalIsOpen: boolean = false;
    protected languageRows: UxLanguage [] [];
    protected languages: UxLanguage [];
    private users: UserDTOBase[] = [];
    private withdrawingRegistrationConfirmation: boolean = false;

    private addContact: boolean = false;
    private newUserEmail: string = '';
    private addUser: boolean = false;

    constructor(private localStorageService: LocalStorageService, private sharedService: SharedService, private supplierApi: SupplierApi, private nutsApi: NutsApi, private userApi: UserApi) {
        this.fetchingData = true;
        if (this.sharedService.user) {
            this.user = this.sharedService.user;
            this.fetchData();
            this.loadLanguages();
        } else {
            this.sharedService.loginEmitter.map(() => {
                this.user = this.sharedService.user;
                this.fetchData();
                this.loadLanguages();
            });
        }
    }

    private fetchData() {
        this.supplierApi.getSupplierByUserId(this.user.id, new Date().getTime()).subscribe(
            (supplier: SupplierDTOBase) => {
                if (supplier != null) {
                    this.supplier = supplier;
                    Object.assign(this.editedSupplier, this.supplier);
                    this.nutsApi.getNutsByLevel(0).subscribe(
                        (countries: NutsDTOBase[]) => {
                            this.supplier.suppliedRegions;
                            for (let country of countries) {
                                let regions = this.supplier.suppliedRegions.filter(x => x.regionId.countryCode == country.countryCode);
                                regions.map((filtered) => {
                                    if (!this.supportedRegions[country.label]) {
                                        this.selectedCountriesNames.push(country.label);
                                        this.supportedRegions[country.label] = [];
                                    }
                                    this.supportedRegions[country.label].push(filtered.regionId);
                                });
                            }
                            this.regionsToRender = this.supportedRegions[this.selectedCountriesNames[0]];
                            // ADD CONTACT 
                            //this.users = this.supplier.users; //uncomment
                            this.users.push(this.user); //delete
                            this.fetchingData = false;
                        }
                    );
                }
            }
        );
    }

    private selectCountry(event, tableReference) {
        let name = this.selectedCountriesNames[event.index];
        this.regionsToRender = this.supportedRegions[name];
        tableReference.reset();
    }

    private displayModal(name: string) {
        switch (name) {
            case 'withdraw':
                this.withdrawingRegistrationConfirmation = true;
                break;
            case 'contact':
                this.displayContact = true;
                break;
            case 'company':
                this.displayCompany = true;
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


    private saveContactChanges() {
        this.submittingData = true;
        this.supplierApi.updateContactDetails(this.editedSupplier).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.supplier = response.data;
                    this.closeModal();
                    this.submittingData = false;
                } else {
                    this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
                    this.submittingData = false;
                }
            }, error => {
                this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
                this.submittingData = false;
            }
        );
    }

    private saveDetailsChanges() {
        this.submittingData = true;
        this.supplierApi.updateSupplierDetails(this.editedSupplier).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.supplier = response.data;
                    this.closeModal();
                    this.submittingData = false;
                } else {
                    this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
                    this.submittingData = false;
                }
            }, error => {
                this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
                this.submittingData = false;
            }
        );
    }

    private changeLogo(event) {
        if (event.target.files.length > 0) {
            this.logoFile = event.target.files[0];
            if (this.logoFile.size > 2560000) {
                this.sharedService.growlTranslation('The file you uploaded is too big. Max file size allowed is 2.5 MB.', 'benefPortal.file.toobig.maxsize', 'warn', {size: '2.5 MB'});
                this.clearLogoFile();
                return;
            }
            if (this.logoFile.type != "image/png" && this.logoFile.type != "image/jpg" && this.logoFile.type != "image/jpeg") {
                this.uploadWrong();
                return;
            }
            let imageStatus = "";
            let image = new Image();
            image.onload = function () {
                imageStatus = "correct";
            };
            image.onerror = function () {
                imageStatus = "wrong";
            };
            image.src = URL.createObjectURL(this.logoFile);
            let subscription = Observable.interval(200).subscribe(
                x => {
                    switch (imageStatus) {
                        case "correct":
                            this.uploadCorrect();
                            subscription.unsubscribe();
                            break;
                        case "wrong":
                            this.uploadWrong();
                            subscription.unsubscribe();
                            break;
                    }
                }
            );
        }
    }

    private uploadCorrect(): any {
        this.logoUrl.readAsDataURL(this.logoFile);
        let subscription = Observable.interval(200).subscribe(
            x => {
                if (this.logoUrl.result != "") {
                    this.editedSupplier.logo = this.logoUrl.result;
                    this.isLogoUploaded = true;
                    subscription.unsubscribe();
                }
            }
        );
    }

    private uploadWrong(): any {
        this.clearLogoFile();
        this.sharedService.growlTranslation('The file you uploaded is not a valid image file.', 'shared.growl.fileNotValid', 'error');
    }

    private clearLogoFile() {
        this.logoInput.nativeElement.value = "";
        this.isLogoUploaded = false;
        this.logoUrl = new FileReader();
        this.logoFile = null;
        this.editedSupplier.logo = null;
    }

    private withdrawRegistration() {
        this.withdrawingRegistrationConfirmation = false;
        if (!this.withdrawingRegistration && !this.withdrawnSuccess) {
            this.withdrawingRegistration = true;
            this.userApi.deleteUser(this.user.id).subscribe(
                (data: ResponseDTOBase) => {
                    if (data.success) {
                        this.sharedService.growlTranslation('Your applications were succesfully deleted.', 'benefPortal.beneficiary.withdrawRegistration.Success', 'success');
                        this.withdrawingRegistration = false;
                        this.withdrawnSuccess = true;
                        var port = window.location.port ? ':' + window.location.port : '';
                        window.location.href = window.location.protocol + "//" + window.location.hostname + port+'/wifi4eu/index.html';
                    }
                }, error => {
                    this.sharedService.growlTranslation('An error occurred an your applications could not be deleted.', 'benefPortal.beneficiary.withdrawRegistration.Failure', 'error');
                    this.withdrawingRegistration = false;
                    this.withdrawnSuccess = false;
                }
            );
        }
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
        this.displayLanguageModal === false? this.displayLanguageModal = true : this.displayLanguageModal = false;
    }

    private selectLanguage(lang) {
       this.userApi.updateLanguage(lang).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.sharedService.growlTranslation('Your notification languaguage was succesfully changed.', 'shared.registration.update.success', 'success');
                    this.selectedLanguage = this.languages.find(language => language.code === lang);
                    this.sharedService.update();
                    this.changeLanguage();
                } else {
                    this.sharedService.growlTranslation('An error occurred and your notification language change.', 'shared.registration.update.error', 'error');
                    this.changeLanguage();
                }
            }, error => {
                this.sharedService.growlTranslation('An error occurred and your notification language change.', 'shared.registration.update.error', 'error');
                this.changeLanguage();
            }
       );
    }

    private deleteLogo() {
        this.deletingLogo = true;
        this.clearLogoFile();
    }

    private closeModal(){
        this.displayContact = false;
        this.displayCompany = false;
        this.deletingLogo = false;
        this.clearLogoFile();
        Object.assign(this.editedSupplier, this.supplier);
    }
/* ADD CONTACT
    private closeAddNewContactModal(){
        this.newUserEmail = '';
        this.addUser = false;
    }

    private addNewContactToSupplier(){
        this.addUser = true;
    }

    private addNewContact(){
        if (this.newUserEmail.trim() != '' && this.supplier.id != 0){
            this.addContact = true;
            this.supplierApi.invitateContactSupplier(this.supplier.id, this.newUserEmail).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success){
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
            this.sharedService.growlTranslation('Please, complete the email field to add a new contact', 'supplierPortal.profile.addNewContact.empty', 'error');
        }
    }
*/
}