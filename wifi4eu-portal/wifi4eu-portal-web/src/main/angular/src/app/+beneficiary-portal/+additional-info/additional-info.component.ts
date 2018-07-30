import { Component, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { LocalStorageService } from "angular-2-local-storage";
import { Observable } from "rxjs/Observable";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { MunicipalityApi } from "../../shared/swagger/api/MunicipalityApi";
import { RegistrationDTOBase } from "../../shared/swagger/model/RegistrationDTO";
import { RegistrationApi } from "../../shared/swagger/api/RegistrationApi";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import { SharedService } from "../../shared/shared.service";
import { DomSanitizer } from "@angular/platform-browser";
import { MayorApi } from "../../shared/swagger/api/MayorApi";
import { MayorDTOBase } from "../../shared/swagger/model/MayorDTO";
import { Location } from "@angular/common";


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
    private deleteBlocker: boolean = false;
    private doc1: boolean = false;
    private doc2: boolean = false;
    private doc3: boolean = false;
    private doc4: boolean = false;
    private displayConfirmClose: boolean = false;

    private fileURL: string = '/wifi4eu/api/registration/registrations/';

    constructor(private sanitizer: DomSanitizer, private route: ActivatedRoute, private localStorageService: LocalStorageService, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private registrationApi: RegistrationApi, private sharedService: SharedService, private router: Router, private location: Location) {
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
                                this.checkFirstDocuments();

                            }, error => {
                            }
                        );
                    }, error => {
                    }
                );
                this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
                    (registrations: RegistrationDTOBase[]) => {
                        if (registrations.length == 1) {
                            this.mayorApi.getMayorByMunicipalityId(municipalityId).subscribe(
                                (mayor: MayorDTOBase) => {
                                    this.mayor = mayor;
                                    if (this.mayor.name == this.user.name && this.mayor.surname == this.user.surname) {
                                        this.isMayor = true;
                                    } else {
                                        this.isMayor = false;
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

    private checkFirstDocuments() {
        if (!this.registration.legalFile1Size || !this.registration.legalFile3Size) {
            this.deleteBlocker = true;
        } else {
            this.deleteBlocker = false;
        }
        return true;
    }

    private uploadFile(event: any, index: number = 0) {
        if (this.registration.allFilesFlag != 1) {
            this.filesUploaded = true;
            if (event.target.files[0]) {
                if (event.target.files[0].size > 1024000) {
                    this.sharedService.growlTranslation('The file you uploaded is too big. Max file size allowed is 1 MB.', 'benefPortal.file.toobig.maxsize', 'warn', { size: '1 MB' });
                    this.removeFile(index);
                    return;
                }
                if (event.target.files[0].type == "application/pdf" || event.target.files[0].type == "image/png" || event.target.files[0].type == "image/jpg" || event.target.files[0].type == "image/jpeg") {
                    this.documentFiles[index] = event.target.files[0];
                    this.reader.readAsDataURL(this.documentFiles[index]);
                    let subscription = Observable.interval(200).subscribe(
                        x => {
                            if (this.reader.result != "") {
                                this.documentUrls[index] = this.reader.result;
                                this.filesUploaded = true;
                                switch (index) {
                                    case 0:
                                        this.doc1 = true;
                                        break;
                                    case 1:
                                        this.doc2 = true;
                                        break;
                                    case 2:
                                        this.doc3 = true;
                                        break;
                                    case 3:
                                        this.doc4 = true;
                                        break;
                                }
                                subscription.unsubscribe();
                            }
                        }
                    );
                } else {
                    this.sharedService.growlTranslation('Please, select a valid file.', 'shared.incorrectFormat', 'warn');
                    this.filesUploaded = false;
                }
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
        this.filesUploaded = false;
        this.documentUrls[index] = '';
        switch (index) {
            case 0:
                this.document1.nativeElement.value = '';
                this.doc1 = false;
                break;
            case 1:
                this.document2.nativeElement.value = '';
                this.doc2 = false;
                break;
            case 2:
                this.document3.nativeElement.value = '';
                this.doc3 = false;
                break;
            case 3:
                this.document4.nativeElement.value = '';
                this.doc4 = false;
                break;
        }
        if (this.doc1 || this.doc2 || this.doc3 || this.doc4) {
            this.filesUploaded = true;
        }
        this.checkFirstDocuments();
    }

    private onSubmit() {
        if (this.registration.allFilesFlag != 1) {
            if (this.documentUrls[0]) {
                this.registration.legalFile1Mime = this.documentUrls[0];
                this.registration.legalFile1Size = this.documentFiles[0].size;
            }
            if (this.documentUrls[1]) {
                this.registration.legalFile2Mime = this.documentUrls[1];
                this.registration.legalFile2Size = this.documentFiles[1].size;
            }
            if (this.documentUrls[2]) {
                this.registration.legalFile3Mime = this.documentUrls[2];
                this.registration.legalFile3Size = this.documentFiles[2].size;
            }
            if (this.documentUrls[3]) {
                this.registration.legalFile4Mime = this.documentUrls[3];
                this.registration.legalFile4Size = this.documentFiles[3].size;
            }
            this.displayConfirmingData = true;
            this.registrationApi.updateRegistrationDocuments(this.registration).subscribe(
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
        this.checkFirstDocuments();
    }

    // private updateMailings() {
    //     if (!this.isMayor) {
    //         if (this.registration.legalFile1Size && this.registration.legalFile2Size && this.registration.legalFile3Size && this.registration.legalFile4Size) {
    //             this.registration.allFilesFlag = 1;
    //             this.registration.mailCounter = 0;
    //         } else {
    //             this.registration.allFilesFlag = 0;
    //             this.registration.uploadTime = 0;
    //             this.registration.mailCounter = 3;
    //         }
    //     } else {
    //         if (this.registration.legalFile1Size && this.registration.legalFile3Size) {
    //             this.registration.allFilesFlag = 1;
    //             this.registration.mailCounter = 0;
    //         } else {
    //             this.registration.allFilesFlag = 0;
    //             this.registration.uploadTime = 0;
    //             this.registration.mailCounter = 3;
    //         }
    //     }
    // }

    private deleteFromServer(index: number) {
        if (this.registration.allFilesFlag != 1) {
            this.filesUploaded = true;
            switch (index) {
                case 0:
                    this.registration.legalFile1Mime = null;
                    break;
                case 1:
                    this.registration.legalFile2Mime = null;
                    break;
                case 2:
                    this.registration.legalFile3Mime = null;
                    break;
                case 3:
                    this.registration.legalFile4Mime = null;
                    break;
            }
            this.displayConfirmingData = true;
            this.registrationApi.deleteRegistrationDocuments(this.registration).subscribe(
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

    confirmClose() {
        this.displayConfirmClose = true;
    }

    cancelBack() {
        this.displayConfirmClose = false;
    }

    private goBack() {
        this.location.back();
    }

}
