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
import { LegalFileDTOBase, LegalFilesViewDTOBase } from "../../shared/swagger";


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
    private documentFilesType1: LegalFileDTOBase[] = [];
    private documentFilesType2: LegalFileDTOBase[] = [];
    private documentFilesType3: LegalFileDTOBase[] = [];
    private documentFilesType4: LegalFileDTOBase[] = [];
    private legalFilesToUpload: LegalFileDTOBase[] = [];
    private reader: FileReader = new FileReader();
    private filesUploaded: boolean = false;
    private isMayor: boolean = false;
    @ViewChild('document1') private document1: any;
    @ViewChild('document2') private document2: any;
    @ViewChild('document3') private document3: any;
    @ViewChild('document4') private document4: any;
    private displayConfirmingData: boolean = false;
    private displayConfirmClose: boolean = false;
    private displayConfirmDelete: boolean = false;
    private removingFile: number;
    private changedDocs: number;

    private fileURL: string = '/wifi4eu/api/registration/getDocument/';

    constructor(private sanitizer: DomSanitizer, private route: ActivatedRoute, private localStorageService: LocalStorageService, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private registrationApi: RegistrationApi, private sharedService: SharedService, private router: Router) {
        let storedUser = this.localStorageService.get('user');
        this.changedDocs = 0;
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
                                this.filesUploaded = this.registration.allFilesFlag == 1 ? true : false;
                                this.registrationApi.getHistoryForType(this.registration.id, 1).subscribe(
                                    (response: ResponseDTOBase) => {
                                        this.documentFilesType1 = response.data;
                                    }, error => {

                                    }
                                );
                                this.registrationApi.getHistoryForType(this.registration.id, 2).subscribe(
                                    (response: ResponseDTOBase) => {
                                        this.documentFilesType2 = response.data;
                                    }, error => {

                                    }
                                );
                                this.registrationApi.getHistoryForType(this.registration.id, 3).subscribe(
                                    (response: ResponseDTOBase) => {
                                        this.documentFilesType3 = response.data;
                                    }, error => {

                                    }
                                );
                                this.registrationApi.getHistoryForType(this.registration.id, 4).subscribe(
                                    (response: ResponseDTOBase) => {
                                        this.documentFilesType4 = response.data;
                                    }, error => {

                                    }
                                );
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
    private checkDocuments() {
        if (!this.registration.allFilesFlag) {
            let type1: boolean = false;
            let type3: boolean = false;
            for (var i = 0; i < this.legalFilesToUpload.length; i++) {
                if (this.legalFilesToUpload[i].fileType == 1) {
                    type1 = true;
                } else if (this.legalFilesToUpload[i].fileType == 3) {
                    type3 = true;
                }
            }
            if (type1 && type3) {
                this.filesUploaded = true;
            } else {
                this.filesUploaded = false;
            }
        }
    }

    private uploadFile(event: any, type: number) {
        if (event.target.files[0]) {
            this.reader = new FileReader();
            if (event.target.files[0].size > 1024000) {
                this.sharedService.growlTranslation('The file you uploaded is too big. Max file size allowed is 1 MB.', 'benefPortal.file.toobig.maxsize', 'warn', { size: '1 MB' });
                this.cleanFile(type);
                return;
            }
            if (event.target.files[0].type == "application/pdf" || event.target.files[0].type == "image/png" || event.target.files[0].type == "image/jpg" || event.target.files[0].type == "image/jpeg") {
                let subscription;
                this.reader.readAsDataURL(event.target.files[0]);
                this.cleanFile(type);
                subscription = Observable.interval(200).subscribe(
                    x => {
                        if (this.reader.result != "") {
                            let file = new LegalFileDTOBase();
                            file.fileData = this.reader.result;
                            file.fileType = type;
                            file.fileName = event.target.files[0].name;
                            file.fileSize = event.target.files[0].size;
                            file.registration = this.registration.id;
                            this.legalFilesToUpload.push(file);
                            this.checkDocuments();
                            switch (type) {
                                case 1:
                                    this.documentFilesType1.push(file);
                                    break;
                                case 2:
                                    this.documentFilesType2.push(file);
                                    break;
                                case 3:
                                    this.documentFilesType3.push(file);
                                    break;
                                case 4:
                                    this.documentFilesType4.push(file);
                                    break;
                                default:
                                    break;
                            }
                            this.changedDocs++;
                            subscription.unsubscribe();
                        }
                    }
                );
            } else {
                this.sharedService.growlTranslation('Please, select a valid file.', 'shared.incorrectFormat', 'warn');
                this.filesUploaded = false;
            }
        } else {
            this.cleanFile(type);
        }
    }

    private cleanFile(type: number) {
        if (this.legalFilesToUpload.length != 0) {
            for (var i = 0; i < this.legalFilesToUpload.length; i++) {
                if (this.legalFilesToUpload[i].fileType == type) {
                    this.legalFilesToUpload = this.legalFilesToUpload.filter(item => item.fileType !== type);
                    break;
                }
            }
            switch (type) {
                case 1:
                    if (this.documentFilesType1.length > 0 && this.documentFilesType1[this.documentFilesType1.length - 1].uploadTime == undefined) {
                        this.documentFilesType1.pop();
                    }
                    break;
                case 2:
                    if (this.documentFilesType2.length > 0 && this.documentFilesType2[this.documentFilesType2.length - 1].uploadTime == undefined) {
                        this.documentFilesType2.pop();
                    }
                    break;
                case 3:
                    if (this.documentFilesType3.length > 0 && this.documentFilesType3[this.documentFilesType3.length - 1].uploadTime == undefined) {
                        this.documentFilesType3.pop();
                    }
                    break;
                case 4:
                    if (this.documentFilesType4.length > 0 && this.documentFilesType4[this.documentFilesType4.length - 1].uploadTime == undefined) {
                        this.documentFilesType4.pop();
                    }
                    break;
                default:
                    return;
            }
            this.checkDocuments();
        }
    }

    private openDeleteModal(type: number) {
        this.displayConfirmDelete = true;
        this.removingFile = type;
    }

    private removeFile(){
        switch (this.removingFile) {
            case 1:
                this.document1.nativeElement.value = "";
                break;
            case 2:
                this.document2.nativeElement.value = "";
                break;
            case 3:
                this.document3.nativeElement.value = "";
                break;
            case 4:
                this.document4.nativeElement.value = "";
                break;
        }
        this.changedDocs--;
        this.cleanFile(this.removingFile);
        this.cancelBack();
    }

    private onSubmit() {
        if (this.legalFilesToUpload.length > 0 || this.changedDocs > 0) {
            let sendObject = new LegalFilesViewDTOBase();
            sendObject.arrayOfFiles = this.legalFilesToUpload;
            this.displayConfirmingData = true;
            this.registrationApi.uploadRegistrationDocuments(this.registration.id, sendObject).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.sharedService.growlTranslation('Your registration was successfully updated.', 'shared.registration.update.success', 'success');
                        this.registration = response.data;
                        this.router.navigateByUrl('/beneficiary-portal/voucher');
                    } else {
                        this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
                    }
                    this.displayConfirmingData = false;
                }, error => {
                    this.displayConfirmingData = false;
                    this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
                }
            );
        } else {
            this.sharedService.growlTranslation('You cant upload documents right now', 'shared.cantUploadDocs', 'error');
        }
    }

    confirmClose() {
        this.displayConfirmClose = true;
    }

    cancelBack() {
        this.displayConfirmClose = false;
        this.displayConfirmDelete = false;
        this.removingFile = null;
    }
}
