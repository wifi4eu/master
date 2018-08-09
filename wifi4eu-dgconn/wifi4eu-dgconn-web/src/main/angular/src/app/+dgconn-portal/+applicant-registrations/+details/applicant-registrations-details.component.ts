import { Component, ViewEncapsulation } from "@angular/core";
import { Location } from "@angular/common";
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
import { VoucherApi } from "../../../shared/swagger/api/VoucherApi";
import { ApplicationDTOBase } from "../../../shared/swagger/model/ApplicationDTO";
import { MayorDTOBase } from "../../../shared/swagger/model/MayorDTO";
import { MunicipalityDTOBase } from "../../../shared/swagger/model/MunicipalityDTO";
import { RegistrationDTOBase } from "../../../shared/swagger/model/RegistrationDTO";
import { ThreadDTOBase, ThreadDTO } from "../../../shared/swagger/model/ThreadDTO";
import { ThreadMessageDTOBase } from "../../../shared/swagger/model/ThreadMessageDTO";
import { ResponseDTOBase, ResponseDTO } from "../../../shared/swagger/model/ResponseDTO";
import { UserDTOBase } from "../../../shared/swagger/model/UserDTO";
import { LegalFileCorrectionReasonDTOBase } from "../../../shared/swagger/model/LegalFileCorrectionReasonDTO";
import { VoucherAssignmentAuxiliarDTOBase } from "../../../shared/swagger/model/VoucherAssignmentAuxiliarDTO";
import { TranslateService } from "ng2-translate";
import * as FileSaver from "file-saver";
import { RegistrationWarningApi, InvalidateReasonApi, ApplicationInvalidateReasonDTO, ApplicationCommentDTO, ApplicationcommentApi, LogEmailDTO, LegalFileDTOBase } from "../../../shared/swagger";
import { NgForm, NgModel } from "@angular/forms";
import { Observable } from "rxjs/Observable";

@Component({
    templateUrl: 'applicant-registrations-details.component.html',
    providers: [ApplicationApi, BeneficiaryApi, MayorApi, MunicipalityApi, RegistrationApi, ThreadApi, UserApi, RegistrationWarningApi, InvalidateReasonApi, ApplicationcommentApi, VoucherApi],
    styleUrls: ['./applicant-registrations-details.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations: [
        trigger(
            'enterSpinner', [
                transition(':enter', [
                    style({ opacity: 0 }),
                    animate('200ms', style({ opacity: 1 }))
                ]),
                transition(':leave', [
                    style({ opacity: 1 }),
                    animate('200ms', style({ opacity: 0 }))
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
    private messagesAuthorRegistration: number[] = [];
    private allApplicationsCount: number = 0;
    private legalFiles: LegalFileCorrectionReasonDTOBase[][] = [];
    private selectedFiles: any[][] = [];
    private selectedReasonTypes: number[][] = [];
    private correctRequestLegalFilesModal: boolean = false;
    private selectedReasonsCount: number = 0;
    private typeFilesList: string[] = ['', '', '', ''];
    private invalidateReasonsList: string[] = ['', '', '', '', '', ''];
    private searchMessagesQuery: string = '';
    private registrationIssues: number[] = [];
    private selectedIndex = null;
    private invalidateReason: string = '';
    private displayValidate = false;
    private displayInvalidate = false;
    private displayRequestCorrection = false;
    private displayCorrespondenceDetail = false;
    private displayCommentModal = false;
    private displaySimulation = false;
    private loadingData = false;
    private processingRequest = false;
    private simulationExists = false;
    private contactUsers: UserDTOBase[][] = [];

    private correctionRequested: LegalFileCorrectionReasonDTOBase[] = [];
    private invalidateChecks = [false, false, false, false, false, false, false, false, false];
    private applicationInvalidateReason: ApplicationInvalidateReasonDTO[][] = [];
    private legalFilesCorrection: LegalFileCorrectionReasonDTOBase[][] = [];
    private listDisabled: number[][] = [];

    private applicationComments: ApplicationCommentDTO[][] = [];
    private page: number[] = [];
    private sizePage: number[] = [];
    private sortField: string[] = [];
    private sortDirection: number[] = [];
    private totalRecords: number[] = [];
    private defaultSize = 5;
    private applicationComment: string = '';

    //-- Correspondence
    private correspondences: LogEmailDTO[][] = [];
    private correspondenceTotalRecords: number[] = [];
    private correspondencePage: number[] = [];
    private correspondenceSizePage: number[] = [];
    private correspondenceSortField: string[] = [];
    private correspondenceSortDirection: number[] = [];
    private correspondenceDialogInfo: LogEmailDTO;
    private buttonStatusEnabled: any[][] = [];

    private fileURL: string = '/wifi4eu/api/registration/getDocument/';

    constructor(
        private applicationCommentApi: ApplicationcommentApi,
        private applicationInvalidateReasonApi: InvalidateReasonApi,
        private registrationWarningApi: RegistrationWarningApi,
        private sanitizer: DomSanitizer,
        private route: ActivatedRoute,
        private sharedService: SharedService,
        private applicationApi: ApplicationApi,
        private beneficiaryApi: BeneficiaryApi,
        private registrationApi: RegistrationApi,
        private threadApi: ThreadApi,
        private userApi: UserApi,
        private municipalityApi: MunicipalityApi,
        private mayorApi: MayorApi,
        private voucherApi: VoucherApi,
        private translateService: TranslateService,
        private location: Location
    ) {
        this.loadingData = true;
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
            this.applicationApi.getApplicationsByCallIdAndLauId(this.callId, this.lauId, new Date().getTime()).subscribe(
                (applications: ApplicationDTOBase[]) => {
                    this.allApplicationsCount = applications.length;
                    let failCount = 0;
                    let correctCount = 0;
                    for (let i = 0; i < applications.length; i++) {
                        if (applications[i].status === 1) {
                            this.applicationInvalidateReasonApi.getInvalidateReasonsByApplication(applications[i].id).subscribe((res: ApplicationInvalidateReasonDTO[]) => {
                                this.applicationInvalidateReason[i] = res;
                            })
                        }
                        let application = applications[i];
                        this.applicationInvalidateReasonApi.changeStatusApplicationEnabled(application.id).subscribe((response: ResponseDTO) => {
                            this.buttonStatusEnabled[i] = response.data;
                        })
                        this.registrationApi.getRegistrationById(application.registrationId).subscribe(
                            (registration: RegistrationDTOBase) => {
                                if (registration) {
                                    this.userApi.getUsersByIdFromRegistration(registration.id).subscribe(
                                        (users: UserDTOBase[]) => {
                                            this.contactUsers[i] = users;
                                        }
                                    )
                                    this.registrationApi.getTypesDisabled(registration.id).subscribe(
                                        (response: ResponseDTO) => {
                                            this.listDisabled[i] = [0,0,0,0];

                                            var typesDisabled :number[] = response.data;
                                            for (var j = 0; j < typesDisabled.length; j++) {
                                                let type = typesDisabled[j];
                                                this.listDisabled[i][type] = 1;
                                            }
                                        }
                                    );
                                    this.userApi.getUserByIdFromRegistration(registration.id).subscribe(
                                        (user: UserDTOBase) => {
                                            if (user) {
                                                this.municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                                                    (municipality: MunicipalityDTOBase) => {
                                                        if (municipality) {
                                                            this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                                                                (mayor: MayorDTOBase) => {
                                                                    this.registrationApi.getLegalFilesByRegistrationId(registration.id, new Date().getTime()).subscribe(
                                                                        (legalFiles: LegalFileCorrectionReasonDTOBase[]) => {
                                                                            if (mayor) {
                                                                                this.mayors[i] = mayor;
                                                                            } else {
                                                                                let mayor = new MayorDTOBase();
                                                                                mayor.id = -1;
                                                                                mayor.municipalityId = municipality.id;
                                                                                mayor.name = '-';
                                                                                mayor.surname = '-';
                                                                                mayor.email = '-';
                                                                                this.mayors[i] = mayor;
                                                                            }
                                                                            this.correctionRequested[i] = legalFiles[i];
                                                                            this.selectedFiles[i] = [];
                                                                            this.selectedReasonTypes[i] = [];
                                                                            this.createFrontEndLegalFiles(registration, i, legalFiles);
                                                                            this.applications[i] = application;
                                                                            this.registrations[i] = registration;
                                                                            this.users[i] = user;
                                                                            this.municipalities[i] = municipality;
                                                                            if (this.registrations.length == this.municipalities.length) {
                                                                                this.registrationIssues[i] = 0;
                                                                            }
                                                                            correctCount++;
                                                                            if (correctCount == (applications.length - failCount)) {
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
                                    //-- Request registration correspondence here
                                    this.correspondenceSortField[i] = "sentDate";
                                    this.correspondenceSortDirection[i] = -1;
                                    this.correspondencePage[i] = 0;
                                    this.correspondenceSizePage[i] = this.defaultSize;
                                    this.municipalityApi.getCorrespondenceByMunicipality(
                                        registration.municipalityId,
                                        this.correspondencePage[i],
                                        this.correspondenceSizePage[i],
                                        this.correspondenceSortField[i],
                                        this.correspondenceSortDirection[i] === 1 ? 'ASC' : 'DESC'
                                    ).subscribe((response: ResponseDTO) => {
                                        this.correspondenceTotalRecords[i] = response.xtotalCount;
                                        this.correspondences[i] = response.data;
                                    });
                                } else {
                                    failCount++;
                                }
                            }, (error) => {
                                this.loadingData = false;
                            }
                        );
                        this.sortField[i] = "datePosted";
                        this.sortDirection[i] = -1;
                        this.page[i] = 0;
                        this.sizePage[i] = this.defaultSize;
                        this.applicationCommentApi.getApplicationCommentsByApplication(application.id, this.page[i], this.sizePage[i], this.sortField[i], this.sortDirection[i] === 1 ? 'ASC' : 'DESC').subscribe((response: ResponseDTO) => {
                            var data = response.data;
                            this.totalRecords[i] = response.xtotalCount;
                            this.applicationComments[i] = response.data;
                        })
                    }
                }, (error) => {
                    this.loadingData = false;
                }
            );
            this.threadApi.getThreadByTypeAndReason(1, String(this.lauId)).subscribe(
                (response: ResponseDTO) => {
                    var thread = response.data;
                    if (thread) {
                        this.discussionThread = thread;
                        this.displayedMessages = thread.messages;
                    }
                }
            );
            this.voucherApi.getVoucherAssignmentAuxiliarByCall(this.callId).subscribe(
                (data: VoucherAssignmentAuxiliarDTOBase) => {
                    if (data != null) {
                        if (!data.hasFreezeListSaved) {
                            this.simulationExists = true;
                        }
                    }
                }
            );
        } else {
            this.loadingData = false;
        }
        let timer = Observable.timer(500, 100);
        let subscription = timer.subscribe(i => {
            if (this.allApplicationsCount != 0 && this.registrations.length == this.allApplicationsCount) {
                this.displayedMessages.forEach(message => {
                    this.registrations.forEach(registration => {
                        for (var i = 0; i < registration.users.length; i++) {
                            let user = registration.users[i];
                            if (user.id == message.authorId) {
                                this.messagesAuthorRegistration.push(registration.id);
                                break;
                            }
                        }
                    });
                });
                if (this.messagesAuthorRegistration.length == this.displayedMessages.length) {
                    subscription.unsubscribe();
                }
            }
        });
    }

    private displayCorrespondenceDetailModal(info) {
        this.correspondenceDialogInfo = info;
        this.displayCorrespondenceDetail = true;
    }

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

    private sortTable(event, index) {
        this.sortField[index] = event.field;
        this.sortDirection[index] = event.order;
        this.page[index] = 0;
        this.filterTable(index);
    }

    private sortCorrespondenceTable(event, index) {
        this.correspondenceSortField[index] = event.field;
        this.correspondenceSortDirection[index] = event.order;
        this.filterCorrespondenceTable(index);
    }

    private filterCorrespondenceTable(index) {
        this.municipalityApi.getCorrespondenceByMunicipality(
            this.registrations[index].municipalityId,
            this.correspondencePage[index],
            this.correspondenceSizePage[index],
            this.correspondenceSortField[index],
            this.correspondenceSortDirection[index] === 1 ? 'ASC' : 'DESC'
        ).subscribe((response: ResponseDTO) => {
            this.correspondenceTotalRecords[index] = response.xtotalCount;
            this.correspondences[index] = response.data;
        });
    }

    private filterTable(index) {
        this.applicationCommentApi.getApplicationCommentsByApplication(
            this.applications[index].id,
            this.page[index],
            this.sizePage[index],
            this.sortField[index],
            this.sortDirection[index] === 1 ? 'ASC' : 'DESC'
        ).subscribe((response: ResponseDTO) => {
            this.totalRecords[index] = response.xtotalCount;
            this.applicationComments[index] = response.data;
        })
    }

    private openCommentModal(index: number) {
        if (index != null) {
            this.selectedIndex = index;
            this.displayCommentModal = true;
        }
    }

    private paginate(event, index) {
        this.sizePage[index] = event.rows;
        this.page[index] = event.page;
        this.filterTable(index);
    }

    private correspondencePaginate(event, index) {
        this.correspondenceSizePage[index] = event.rows;
        this.correspondencePage[index] = event.page;
        this.filterCorrespondenceTable(index);
    }

    private submitApplicationComment(form: NgForm) {
        if (form.valid) {
            if (!this.processingRequest) {
                if (this.applicationComment != null || this.applicationComment.trim() != "") {
                    if (this.applicationComment.length > 256) {
                        form.controls['newComment'].setErrors({ 'invalid': true });
                        return;
                    }
                    this.processingRequest = true;
                    this.applicationCommentApi.createApplicationComment({ applicationId: this.applications[this.selectedIndex].id, comment: this.applicationComment }).subscribe((response) => {
                        this.processingRequest = false;
                        this.page[this.selectedIndex] = 0;
                        this.filterTable(this.selectedIndex);
                        this.sharedService.growlTranslation('Your comment has been created.', 'dgConn.applicantDetails.saveComment.success', 'success');
                        this.closeModal();
                    }, error => {
                        this.sharedService.growlTranslation('An error occurred while trying to save this comment. Please, try again later.', 'dgConn.applicantDetails.saveComment.error', 'error');
                        //this.closeModal();
                    })
                }
            }
        }
    }

    private checkReasonSelected() {
        return this.invalidateChecks.some(reason => reason === true);
    }

    private displayRequestCorrectionModal(index: number) {
        //index is per applicant
        if (index != null) {
            if (this.selectedFiles[index].length > 0) {
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
        this.applicationComment = '';
        this.displayCommentModal = false;
        this.displayCorrespondenceDetail = false;
        this.displaySimulation = false;
    }

    private selectCorrectionReason() {
        if (this.selectedReasonTypes[this.selectedIndex].length == this.selectedFiles[this.selectedIndex].length) {
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
                    this.applicationInvalidateReasonApi.validateApplication(this.applications[this.selectedIndex]).subscribe(
                        (response: ResponseDTOBase) => {
                            if (response.success) {
                                if (response.data != null) {
                                    this.applications[this.selectedIndex].status = 2;

                                    this.getApplicationDetailsInfo();
                                    this.applicationInvalidateReason[this.selectedIndex] = null;
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
            if (this.selectedIndex != null && this.checkReasonSelected()) {
                this.processingRequest = true;
                var reasonsNumber: number[] = [];
                this.invalidateChecks.forEach((invalidateCheck, index) => {
                    if (invalidateCheck === true) {
                        reasonsNumber.push(index + 1);
                    }
                });
                this.applicationInvalidateReasonApi.invalidateApplicationWithReason({ applicationId: this.applications[this.selectedIndex].id, reasons: reasonsNumber }).subscribe((response) => {
                    this.applicationInvalidateReason[this.selectedIndex] = response;
                    this.applications[this.selectedIndex].status = 1;
                    this.sharedService.growlTranslation('You successfully invalidated the municipality.', 'dgConn.duplicatedBeneficiaryDetails.invalidateMunicipality.success', 'success');
                    this.closeModal();
                    this.invalidateChecks = [false, false, false, false, false, false, false, false, false];
                    if (this.simulationExists) {
                        this.displaySimulation = true;
                    }
                }, error => {
                    this.sharedService.growlTranslation('An error occurred while trying to invalidate the municipality. Please, try again later.', 'dgConn.duplicatedBeneficiaryDetails.invalidateMunicipality.error', 'error');
                    this.closeModal();
                    this.invalidateChecks = [false, false, false, false, false, false, false, false, false];
                })
            }
        }
    }

    private requestLegalFilesCorrection() {
        if (!this.processingRequest && this.correctRequestLegalFilesModal) {
            if (this.selectedIndex != null) {
                let savedFilesCount = 0;
                let savedFilesLimit = this.selectedFiles[this.selectedIndex].length;

                this.processingRequest = true;
                for (let i = 0; i < savedFilesLimit; i++) {
                    let updatedLegalFile = this.selectedFiles[this.selectedIndex][i];
                    updatedLegalFile.correctionReason = this.selectedReasonTypes[this.selectedIndex][i];
                    if (updatedLegalFile.correctionReason != -1) {
                        updatedLegalFile.requestCorrection = true;
                    } else {
                        updatedLegalFile.correctionReason = null;
                        updatedLegalFile.requestCorrection = false;
                    }

                    this.registrationApi.saveLegalFile(updatedLegalFile).subscribe(
                        (resLegalFile: LegalFileCorrectionReasonDTOBase) => {
                            savedFilesCount++;
                            if (resLegalFile) {
                                if (savedFilesCount == savedFilesLimit) {
                                    this.applicationApi.sendLegalDocumentsCorrection(this.applications[this.selectedIndex]).subscribe(
                                        (response: ResponseDTOBase) => {
                                            this.selectedFiles[this.selectedIndex] = [];
                                            this.getApplicationDetailsInfo();
                                            this.closeModal();
                                        }, error => {
                                            this.selectedFiles[this.selectedIndex] = [];
                                            this.getApplicationDetailsInfo();
                                            this.closeModal();
                                        }
                                    );
                                }
                            }
                        }, error => {
                            savedFilesCount++;
                            if (savedFilesCount == savedFilesLimit) {
                                this.applicationApi.sendLegalDocumentsCorrection(this.applications[this.selectedIndex]).subscribe(
                                    (response: ResponseDTOBase) => {
                                        this.selectedFiles[this.selectedIndex] = [];
                                        this.getApplicationDetailsInfo();
                                        this.closeModal();
                                    }, error => {
                                        this.selectedFiles[this.selectedIndex] = [];
                                        this.getApplicationDetailsInfo();
                                        this.closeModal();
                                    }
                                );
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
        this.translateService.get('dgConn.applicantDetails.legalFile.name.type3').subscribe(
            (translatedString: string) => {
                this.typeFilesList[1] = translatedString;
            }
        );
        this.translateService.get('dgConn.applicantDetails.legalFile.name.type2').subscribe(
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
        this.translateService.get('dgConn.applicantDetails.legalFile.reason.cause6').subscribe(
            (translatedString: string) => {
                this.invalidateReasonsList[5] = translatedString;
            }
        );
    }

    private createFrontEndLegalFiles(registration: RegistrationDTOBase, index: number, legalFiles?: LegalFileCorrectionReasonDTOBase[]) {
        let finalLegalFiles = [];
        this.registrationApi.getHistoryAll(registration.id).subscribe((response: ResponseDTOBase) => {
            if (response.success) {
                let files = response.data;
                for (let file of files) {
                    let correctionsToAdd = legalFiles.find(correction => correction.legalFile == file.id);
                    if (correctionsToAdd == undefined) {
                        correctionsToAdd = new LegalFileCorrectionReasonDTOBase();
                        correctionsToAdd.registrationId = registration.id;
                        correctionsToAdd.legalFile = file.id;
                        correctionsToAdd.type = file.fileType;
                    }
                    correctionsToAdd.uploadTime = file.uploadTime;
                    finalLegalFiles.push(correctionsToAdd);
                }
            }
            this.legalFiles[index] = finalLegalFiles;
        });
    }


    private goBack() {
        this.location.back();
    }

    private orderList(event, i) {
        this.selectedFiles[i] = this.selectedFiles[i].sort((a, b) => {
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            } else {
                return 0;
            }
        });
    }

    private rerunVoucherSimulation() {
        this.processingRequest = true;
        this.voucherApi.simulateVoucherAssignment(this.callId).subscribe(
            (resp: ResponseDTO) => {
                this.displaySimulation = false;
                this.processingRequest = false;
            }
        );
    }
}