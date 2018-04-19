import {Component, ViewChild} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {LocalStorageService} from "angular-2-local-storage";
import {Observable} from "rxjs/Observable";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {SharedService} from "../../shared/shared.service";
import {DomSanitizer} from "@angular/platform-browser";
import {MayorApi} from "../../shared/swagger/api/MayorApi";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";


@Component({
    selector: 'beneficiary-additional-info-component',
    templateUrl: 'additional-info.component.html',
    providers: [MunicipalityApi, MayorApi]
})

export class AdditionalInfoComponent {
    private user: UserDTOBase;
    private municipality: MunicipalityDTOBase;
    private registration: RegistrationDTOBase;
    private mayor: MayorDTOBase;
    private documentFiles: File[] = [];
    private documentUrls: string[] = [];
    private reader: FileReader = new FileReader();
    private filesUploaded: boolean = false;
    private isMayor: boolean = false;
    @ViewChild('document1') private document1: any;
    @ViewChild('document2') private document2: any;
    @ViewChild('document3') private document3: any;
    @ViewChild('document4') private document4: any;
    private displayConfirmingData: boolean = false;
    private date: number;

    constructor(private sanitizer: DomSanitizer, private route: ActivatedRoute, private localStorageService: LocalStorageService, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private registrationApi: RegistrationApi, private sharedService: SharedService, private router: Router) {
        let storedUser = this.localStorageService.get('user');
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
                this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
                    (registrations: RegistrationDTOBase[]) => {
                        if (registrations.length == 1) {
                            this.mayorApi.getMayorByMunicipalityId(municipalityId).subscribe(
                                (mayor: MayorDTOBase) => {
                                    this.mayor = mayor;
                                    if (this.mayor.name == this.user.name && this.mayor.surname == this.user.surname) {
                                        this.isMayor = true;
                                    } else {
                                        this.isMayor = false
                                    }
                                }, error => {
                                    this.isMayor = false;
                                }
                            );
                        } else {
                            this.isMayor = false;
                        }
                    }
                );

            }

        } else {
            this.sharedService.growlTranslation('You are not logged in!', 'shared.error.notloggedin', 'warn');
            this.router.navigateByUrl('/home');
        }
    }

    private uploadFile(event: any, index: number = 0) {
        if (this.registration.allFilesFlag != 1) {
            this.filesUploaded = true;
            if (event.target.files[0]) {
                if (event.target.files[0].size > 1024000) {
                    this.sharedService.growlTranslation('The file you uploaded is too big. Max file size allowed is 1 MB.', 'benefPortal.file.toobig.maxsize', 'warn', {size: '1 MB'});
                    this.removeFile(index);
                    return;
                }
                this.documentFiles[index] = event.target.files[0];
                this.reader.readAsDataURL(this.documentFiles[index]);
                let subscription = Observable.interval(200).subscribe(
                    x => {
                        if (this.reader.result != "") {
                            this.documentUrls[index] = this.reader.result;
                            if (this.documentUrls[0] && this.documentUrls[1] && this.documentUrls[2] && this.documentUrls[3])
                                this.filesUploaded = true;
                            subscription.unsubscribe();
                        }
                    }
                );
            } else {
                this.removeFile(index);
            }
        } else {
            this.sharedService.growlTranslation('You can\'t upload documents right now', 'shared.cantUploadDocs', 'error');
            this.filesUploaded = false;

        }
    }

    private removeFile(index: number) {
        this.documentFiles[index] = null;
        this.documentUrls[index] = '';
        switch (index) {
            case 0:
                this.document1.nativeElement.value = '';
                break;
            case 1:
                this.document2.nativeElement.value = '';
                break;
            case 2:
                this.document3.nativeElement.value = '';
                break;
            case 3:
                this.document4.nativeElement.value = '';
                break;
        }
    }


    private getLegalFileUrl(fileNumber: number) {
        switch (fileNumber) {
            case 1:
                return this.sanitizer.bypassSecurityTrustUrl(this.registration.legalFile1);
            case 2:
                return this.sanitizer.bypassSecurityTrustUrl(this.registration.legalFile2);
            case 3:
                return this.sanitizer.bypassSecurityTrustUrl(this.registration.legalFile3);
            case 4:
                return this.sanitizer.bypassSecurityTrustUrl(this.registration.legalFile4);
        }
    }

    private onSubmit() {
        if (this.registration.allFilesFlag != 1) {

            if (this.documentUrls[0]) {
                this.registration.legalFile1 = this.documentUrls[0];
            }
            if (this.documentUrls[1]) {
                this.registration.legalFile2 = this.documentUrls[1];
            }
            if (this.documentUrls[2]) {
                this.registration.legalFile3 = this.documentUrls[2];
            }
            if (this.documentUrls[3]) {
                this.registration.legalFile4 = this.documentUrls[3];
            }

            this.displayConfirmingData = true;
            this.updateMailings();
            this.registrationApi.createRegistration(this.registration).subscribe(
                (response: ResponseDTOBase) => {
                    this.displayConfirmingData = false;
                    if (response.success) {
                        this.sharedService.growlTranslation('Your registration was successfully updated.', 'shared.registration.update.success', 'success');
                        this.registration = response.data;


                        this.router.navigateByUrl('/beneficiary-portal/voucher');
                    } else {
                        this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
                    }
                }, error => {
                    this.displayConfirmingData = false;
                    this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
                }
            );
        } else {
            this.sharedService.growlTranslation('You cant upload documents right now', 'shared.cantUploadDocs', 'error');
            this.filesUploaded = false;

        }
    }

    private updateMailings() {
        if (!this.isMayor) {
            let date = new Date();
            this.date = date.getTime();

            if (this.registration.legalFile1 && this.registration.legalFile2 && this.registration.legalFile3 && this.registration.legalFile4) {
                this.registration.allFilesFlag = 1;
                this.registration.mailCounter = 0;
            } else {
                this.registration.allFilesFlag = 0;
                this.registration.uploadTime = 0;
                this.registration.mailCounter = 3;
            }
        } else {
            if (this.registration.legalFile1 && this.registration.legalFile3) {
                this.registration.allFilesFlag = 1;
                this.registration.mailCounter = 0;
            } else {
                this.registration.allFilesFlag = 0;
                this.registration.uploadTime = 0;
                this.registration.mailCounter = 3;
            }
            this.registration.uploadTime = this.date;
        }
    }

    private deleteFromServer(index: number) {
        if (this.registration.allFilesFlag != 1) {
            this.filesUploaded = true;
            switch (index) {
                case 0:
                    this.registration.legalFile1 = null;
                    break;
                case 1:
                    this.registration.legalFile2 = null;
                    break;
                case 2:
                    this.registration.legalFile3 = null;
                    break;
                case 3:
                    this.registration.legalFile4 = null;
                    break;
            }
            this.updateMailings();
            this.displayConfirmingData = true;
            this.registrationApi.createRegistration(this.registration).subscribe(
                (response: ResponseDTOBase) => {
                    this.displayConfirmingData = false;
                    if (response.success) {
                        this.sharedService.growlTranslation('Your registration was successfully updated.', 'shared.registration.update.success', 'success');
                        this.registration = response.data;
                        // this.router.navigateByUrl('/beneficiary-portal/voucher');
                    } else {
                        this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
                    }
                }, error => {
                    this.displayConfirmingData = false;
                    this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
                }
            );
        } else {
            this.sharedService.growlTranslation('You cant upload documents right now', 'shared.cantUploadDocs', 'error');
            this.filesUploaded = false;
        }
    }
}
