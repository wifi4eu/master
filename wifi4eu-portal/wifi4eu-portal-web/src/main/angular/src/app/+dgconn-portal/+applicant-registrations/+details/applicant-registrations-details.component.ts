import { Component } from "@angular/core";
import { animate, style, transition, trigger } from "@angular/animations";
import { DomSanitizer } from "@angular/platform-browser";
import { ActivatedRoute } from "@angular/router";
import { SharedService } from "app/shared/shared.service";
import { ApplicationApi } from "../../../shared/swagger/api/ApplicationApi";
import { BeneficiaryApi } from "../../../shared/swagger/api/BeneficiaryApi";
import { MayorApi } from "../../../shared/swagger/api/MayorApi";
import { MunicipalityApi } from "../../../shared/swagger/api/MunicipalityApi";
import { RegistrationApi } from "../../../shared/swagger/api/RegistrationApi";
import { ThreadApi } from "../../../shared/swagger/api/ThreadApi";
import { UserApi } from "../../../shared/swagger/api/UserApi";
import { ApplicationDTOBase } from "../../../shared/swagger/model/ApplicationDTO";
import { MayorDTOBase } from "../../../shared/swagger/model/MayorDTO";
import { MunicipalityDTOBase } from "../../../shared/swagger/model/MunicipalityDTO";
import { RegistrationDTOBase } from "../../../shared/swagger/model/RegistrationDTO";
import { ThreadDTOBase } from "../../../shared/swagger/model/ThreadDTO";
import { ThreadMessageDTOBase } from "../../../shared/swagger/model/ThreadMessageDTO";
import { ResponseDTOBase } from "../../../shared/swagger/model/ResponseDTO";
import { UserDTOBase } from "../../../shared/swagger/model/UserDTO";
import { LegalFileDTOBase } from "../../../shared/swagger/model/LegalFileDTO";
import { TranslateService } from "ng2-translate";

@Component({
    templateUrl: 'applicant-registrations-details.component.html',
    providers: [ApplicationApi, BeneficiaryApi, MayorApi, MunicipalityApi, RegistrationApi, ThreadApi, UserApi],
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

export class DgConnApplicantRegistrationsDetailsComponent {
    private lauId: number = null;
    private callId: number = null;
    private municipalities: MunicipalityDTOBase[] = [];
    private mayors: MayorDTOBase[] = [];
    private registrations: RegistrationDTOBase[] = [];
    private applications: ApplicationDTOBase[] = [];
    private users: UserDTOBase[] = [];
    private discussionThread: ThreadDTOBase = null;
    private displayedMessages: ThreadMessageDTOBase[] = [];
    private legalFiles: LegalFileDTOBase[][] = [];
    private selectedFilesTypes: number[][] = [];
    private selectedReasonTypes: number[][] = [];
    private correctRequestLegalFilesModal: boolean = false;
    private selectedReasonsCount: number = 0;
    private typeFilesList: string[] = ['', '', '', ''];
    private invalidateReasonsList: string[] = ['', '', '', '', ''];
    private searchMessagesQuery: string = '';
    private registrationIssues: number[] = [];
    private selectedIndex = null;
    private invalidateReason: string = '';
    private displayValidate = false;
    private displayInvalidate = false;
    private displayRequestCorrection = false;
    private loadingData = false;
    private processingRequest = false;

    constructor(private sanitizer: DomSanitizer, private route: ActivatedRoute, private sharedService: SharedService, private applicationApi: ApplicationApi, private beneficiaryApi: BeneficiaryApi, private registrationApi: RegistrationApi, private threadApi: ThreadApi, private userApi: UserApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private translateService: TranslateService) {
        this.route.params.subscribe(
            params => {
                this.lauId = params['lauId'];
                this.callId = params['callId'];
                this.getApplicationDetailsInfo();
            }
        );
        this.translatePageStrings();
    }

    private getApplicationDetailsInfo() {
        if (this.lauId && this.callId) {
            this.clearPageInfo();
            this.loadingData = true;
            this.applicationApi.getApplicationsByCallIdAndLauId(this.callId, this.lauId).subscribe(
                (applications: ApplicationDTOBase[]) => {
                    let failCount = 0;
                    for (let i = 0; i < applications.length; i++) {
                        let application = applications[i];
                        this.registrationApi.getRegistrationById(application.registrationId).subscribe(
                            (registration: RegistrationDTOBase) => {
                                if (registration) {
                                    this.userApi.getUserById(registration.userId).subscribe(
                                        (user: UserDTOBase) => {
                                            if (user) {
                                                this.municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                                                    (municipality: MunicipalityDTOBase) => {
                                                        if (municipality) {
                                                            this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                                                                (mayor: MayorDTOBase) => {
                                                                    this.registrationApi.getLegalFilesByRegistrationId(registration.id).subscribe(
                                                                        (legalFiles: LegalFileDTOBase[]) => {
                                                                            if (mayor) {
                                                                                this.mayors.push(mayor);
                                                                            } else {
                                                                                let mayor = new MayorDTOBase();
                                                                                mayor.id = -1;
                                                                                mayor.municipalityId = municipality.id;
                                                                                mayor.name = '-';
                                                                                mayor.surname = '-';
                                                                                mayor.email = '-';
                                                                                this.mayors.push(mayor);
                                                                            }
                                                                            this.selectedFilesTypes[i] = [];
                                                                            this.selectedReasonTypes[i] = [];
                                                                            this.legalFiles[i] = legalFiles;
                                                                            this.applications.push(application);
                                                                            this.registrations.push(registration);
                                                                            this.users.push(user);
                                                                            this.municipalities.push(municipality);
                                                                            if (this.registrations.length == this.municipalities.length) {
                                                                                this.registrationIssues.push(0);
                                                                                this.setRegistrationIssue(registration, (this.registrationIssues.length - 1));
                                                                            }
                                                                            if (this.applications.length == (applications.length - failCount)) {
                                                                                this.loadingData = false;
                                                                            }
                                                                        }
                                                                    );
                                                                }, (error) => {
                                                                    this.loadingData = false;
                                                                }
                                                            );
                                                        } else {
                                                            failCount++;
                                                        }
                                                    }, (error) => {
                                                        this.loadingData = false;
                                                    }
                                                );
                                            } else {
                                                failCount++;
                                            }
                                        }, (error) => {
                                            this.loadingData = false;
                                        }
                                    );
                                } else {
                                    failCount++;
                                }
                            }, (error) => {
                                this.loadingData = false;
                            }
                        );
                    }
                }, (error) => {
                    this.loadingData = false;
                }
            );
            this.threadApi.getThreadByTypeAndReason(1, String(this.lauId)).subscribe(
                (thread: ThreadDTOBase) => {
                    if (thread) {
                        this.discussionThread = thread;
                        this.displayedMessages = thread.messages;
                    }
                }
            );
        } else {
            this.loadingData = false;
        }
    }

    private setRegistrationIssue(registration: RegistrationDTOBase, index: number) {
        this.registrationApi.getRegistrationIssue(registration).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.registrationIssues[index] = response.data;
                }
            }
        );
    }

    private getLegalFileUrl(index: number, fileType: number) {
        if (index != null) {
            for (let legalFile of this.legalFiles[index]) {
                if (legalFile.type == fileType) {
                    return this.sanitizer.bypassSecurityTrustUrl(legalFile.data);
                }
            }
        }
    }

    // private requestLegalDocuments(index: number) {
    //     if (index != null) {
    //         this.registrationApi.requestLegalDocuments(this.registrations[index].id).subscribe(
    //             (response: ResponseDTOBase) => {
    //                 if (response.success) {
    //                     this.sharedService.growlTranslation('An email has been sent to the representants of the legal entities to supply the legal documents for the registration.', 'dgConn.duplicatedBeneficiaryDetails.requestLegalDocuments.success', 'success');
    //                 } else {
    //                     this.sharedService.growlTranslation('An error occurred while trying to request the legal documents of the registration. Please, try again later.', 'dgConn.duplicatedBeneficiaryDetails.requestLegalDocuments.error', 'error');
    //                 }
    //             }
    //         );
    //     }
    // }

    private displayValidateModal(index: number) {
        if (index != null) {
            if (this.applications[index].status != 2) {
                this.selectedIndex = index;
                this.displayValidate = true;
            }
        }
    }

    private displayInvalidateModal(index: number) {
        if (index != null) {
            if (this.applications[index].status != 1) {
                this.selectedIndex = index;
                this.displayInvalidate = true;
            }
        }
    }

    private displayRequestCorrectionModal(index: number) {
        if (index != null) {
            if (this.selectedFilesTypes[index].length > 0) {
                this.selectedIndex = index;
                this.displayRequestCorrection = true;
            }
        }
    }

    private closeModal() {
        this.selectedReasonTypes[this.selectedIndex] = [];
        this.selectedIndex = null;
        this.invalidateReason = '';
        this.correctRequestLegalFilesModal = false;
        this.displayValidate = false;
        this.displayInvalidate = false;
        this.displayRequestCorrection = false;
        this.processingRequest = false;
    }

    private selectCorrectionReason() {
        if (this.selectedReasonTypes[this.selectedIndex].length == this.selectedFilesTypes[this.selectedIndex].length) {
            let allReasonsCorrect = true;
            for (let selectedReason of this.selectedReasonTypes[this.selectedIndex]) {
                if (selectedReason == null) {
                    this.correctRequestLegalFilesModal = false;
                    break;
                }
            }
            if (allReasonsCorrect)
                this.correctRequestLegalFilesModal = true;
        }
    }

    private validateApplication() {
        if (!this.processingRequest) {
            if (this.selectedIndex != null) {
                this.processingRequest = true;
                this.applications[this.selectedIndex].status = 2;
                this.applicationApi.validateApplication(this.applications[this.selectedIndex]).subscribe(
                    (response: ResponseDTOBase) => {
                        if (response.success) {
                            if (response.data != null) {
                                this.getApplicationDetailsInfo();
                                this.sharedService.growlTranslation('You successfully validated the municipality.', 'dgConn.duplicatedBeneficiaryDetails.validateMunicipality.success', 'success');
                            } else {
                                this.sharedService.growlTranslation('An error occurred while trying to validate the municipality. Please, try again later.', 'dgConn.duplicatedBeneficiaryDetails.validateMunicipality.error', 'error');
                            }
                        } else {
                            this.sharedService.growlTranslation('An error occurred while trying to validate the municipality. Please, try again later.', 'dgConn.duplicatedBeneficiaryDetails.validateMunicipality.error', 'error');
                        }
                        this.closeModal();
                    }, error => {
                        this.sharedService.growlTranslation('An error occurred while trying to validate the municipality. Please, try again later.', 'dgConn.duplicatedBeneficiaryDetails.validateMunicipality.error', 'error');
                        this.closeModal();
                    }
                );
            }
        }
    }

    private invalidateApplication() {
        if (!this.processingRequest) {
            if (this.selectedIndex != null && this.invalidateReason.trim().length > 0) {
                this.processingRequest = true;
                this.applications[this.selectedIndex].invalidateReason = this.invalidateReason;
                this.applications[this.selectedIndex].status = 1;
                this.applicationApi.invalidateApplication(this.applications[this.selectedIndex]).subscribe(
                    (response: ResponseDTOBase) => {
                        if (response.success) {
                            if (response.data != null) {
                                this.getApplicationDetailsInfo();
                                this.sharedService.growlTranslation('You successfully invalidated the municipality.', 'dgConn.duplicatedBeneficiaryDetails.invalidateMunicipality.success', 'success');
                            } else {
                                this.sharedService.growlTranslation('An error occurred while trying to invalidate the municipality. Please, try again later.', 'dgConn.duplicatedBeneficiaryDetails.invalidateMunicipality.error', 'error');
                            }
                        } else {
                            this.sharedService.growlTranslation('An error occurred while trying to invalidate the municipality. Please, try again later.', 'dgConn.duplicatedBeneficiaryDetails.invalidateMunicipality.error', 'error');
                        }
                        this.closeModal();
                    }, error => {
                        this.sharedService.growlTranslation('An error occurred while trying to invalidate the municipality. Please, try again later.', 'dgConn.duplicatedBeneficiaryDetails.invalidateMunicipality.error', 'error');
                        this.closeModal();
                    }
                );
            }
        }
    }

    private requestLegalFilesCorrection() {
        if (!this.processingRequest) {
            if (this.selectedIndex != null) {
                this.processingRequest = true;
                let savedFilesCount = 0;
                for (let i = 0; i < this.selectedFilesTypes[this.selectedIndex].length; i++) {
                    let updatedLegalFile = new LegalFileDTOBase();
                    let fileType = this.selectedFilesTypes[this.selectedIndex][i];
                    for (let legalFile of this.legalFiles[this.selectedIndex]) {
                        if (legalFile.type == fileType) {
                            updatedLegalFile = legalFile;
                            updatedLegalFile.requestCorrection = true;
                            updatedLegalFile.correctionReason = this.selectedReasonTypes[this.selectedIndex][i];
                        }
                    }
                    this.registrationApi.saveLegalFile(updatedLegalFile).subscribe(
                        (resLegalFile: LegalFileDTOBase) => {
                            savedFilesCount++;
                            if (resLegalFile) {
                                if (savedFilesCount == this.selectedFilesTypes[this.selectedIndex].length) {
                                    this.selectedFilesTypes[this.selectedIndex] = [];
                                    this.getApplicationDetailsInfo();
                                    this.closeModal();
                                }
                            }
                        }, error => {
                            savedFilesCount++;
                            if (savedFilesCount == this.selectedFilesTypes[this.selectedIndex].length) {
                                this.selectedFilesTypes[this.selectedIndex] = [];
                                this.getApplicationDetailsInfo();
                                this.closeModal();
                            }
                        }
                    );
                }
            }
        }
    }

    private searchMessages() {
        if (this.searchMessagesQuery.length > 0) {
            this.displayedMessages = [];
            for (let message of this.discussionThread.messages) {
                if (message.message.toLowerCase().indexOf(this.searchMessagesQuery.toLowerCase()) != -1) {
                    this.displayedMessages.push(message);
                }
            }
        } else {
            this.displayedMessages = this.discussionThread.messages;
        }
    }

    private clearPageInfo() {
        this.municipalities = [];
        this.mayors = [];
        this.registrations = [];
        this.applications = [];
        this.users = [];
        this.registrationIssues = []
    }

    private translatePageStrings() {
        this.translateService.get('dgConn.applicantDetails.legalFile.name.type1').subscribe(
            (translatedString: string) => {
                this.typeFilesList[0] = translatedString;
            }
        );
        this.translateService.get('dgConn.applicantDetails.legalFile.name.type2').subscribe(
            (translatedString: string) => {
                this.typeFilesList[1] = translatedString;
            }
        );
        this.translateService.get('dgConn.applicantDetails.legalFile.name.type3').subscribe(
            (translatedString: string) => {
                this.typeFilesList[2] = translatedString;
            }
        );
        this.translateService.get('dgConn.applicantDetails.legalFile.name.type4').subscribe(
            (translatedString: string) => {
                this.typeFilesList[3] = translatedString;
            }
        );
        this.translateService.get('dgConn.applicantDetails.legalFile.reason.cause1').subscribe(
            (translatedString: string) => {
                this.invalidateReasonsList[0] = translatedString;
            }
        );
        this.translateService.get('dgConn.applicantDetails.legalFile.reason.cause2').subscribe(
            (translatedString: string) => {
                this.invalidateReasonsList[1] = translatedString;
            }
        );
        this.translateService.get('dgConn.applicantDetails.legalFile.reason.cause3').subscribe(
            (translatedString: string) => {
                this.invalidateReasonsList[2] = translatedString;
            }
        );
        this.translateService.get('dgConn.applicantDetails.legalFile.reason.cause4').subscribe(
            (translatedString: string) => {
                this.invalidateReasonsList[3] = translatedString;
            }
        );
        this.translateService.get('dgConn.applicantDetails.legalFile.reason.cause5').subscribe(
            (translatedString: string) => {
                this.invalidateReasonsList[4] = translatedString;
            }
        );
    }
}