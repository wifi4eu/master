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
    private searchMessagesQuery: string = '';
    private cssClassInvalidReason: string = '';
    private registrationIssues: number[] = [];
    private selectedIndex = null;
    private invalidateReason: string = '';
    private displayValidate = false;
    private displayInvalidate = false;
    private loadingData = false;
    private processingRequest = false;

    constructor(private sanitizer: DomSanitizer, private route: ActivatedRoute, private sharedService: SharedService, private applicationApi: ApplicationApi, private beneficiaryApi: BeneficiaryApi, private registrationApi: RegistrationApi, private threadApi: ThreadApi, private userApi: UserApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi) {
        this.loadingData = true;
        this.route.params.subscribe(
            params => {
                this.lauId = params['lauId'];
                this.callId = params['callId'];
                this.getApplicationDetailsInfo();
            }
        );
    }

    private getApplicationDetailsInfo() {
        if (this.lauId && this.callId) {
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
                                                                    this.applications.push(application);
                                                                    this.municipalities.push(municipality);
                                                                    this.registrations.push(registration);
                                                                    this.users.push(user);
                                                                    if (this.registrations.length == this.municipalities.length) {
                                                                        this.registrationIssues.push(0);
                                                                        this.setRegistrationIssue(registration, (this.registrationIssues.length - 1));
                                                                    }
                                                                    if (this.applications.length == (applications.length - failCount)) {
                                                                        this.loadingData = false;
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
        }
    }

    private getLegalFileUrl(index: number, fileNumber: number) {
        switch (fileNumber) {
            case 1:
                return this.sanitizer.bypassSecurityTrustUrl(this.registrations[index].legalFile1);
            case 2:
                return this.sanitizer.bypassSecurityTrustUrl(this.registrations[index].legalFile2);
            case 3:
                return this.sanitizer.bypassSecurityTrustUrl(this.registrations[index].legalFile3);
            case 4:
                return this.sanitizer.bypassSecurityTrustUrl(this.registrations[index].legalFile4);
        }
    }

    private requestLegalDocuments(index: number) {
        if (index != null) {
            this.registrationApi.requestLegalDocuments(this.registrations[index].id).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.sharedService.growlTranslation('An email has been sent to the representants of the legal entities to supply the legal documents for the registration.', 'dgConn.duplicatedBeneficiaryDetails.requestLegalDocuments.success', 'success');
                    } else {
                        this.sharedService.growlTranslation('An error occurred while trying to request the legal documents of the registration. Please, try again later.', 'dgConn.duplicatedBeneficiaryDetails.requestLegalDocuments.error', 'error');
                    }
                }
            );
        }
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

    private closeModal() {
        this.cssClassInvalidReason = '';
        this.selectedIndex = null;
        this.invalidateReason = '';
        this.displayValidate = false;
        this.displayInvalidate = false;
        this.processingRequest = false;
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

    private validateApplication() {
        if (!this.processingRequest) {
            this.processingRequest = true;
            if (this.selectedIndex != null) {
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
            this.processingRequest = true;
            if (this.selectedIndex != null && this.invalidateReason.trim().length > 0) {
                if (this.invalidateReason.length <= 255) {
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
                } else {
                    this.processingRequest = false;
                    this.sharedService.growlTranslation('The invalidate the municipality message is bigger than 255. Please, reduce the message.', 'dgConn.duplicatedBeneficiaryDetails.invalidateMunicipality.maxLength', 'error');
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

    private maxLength(event) {
        if (this.invalidateReason.length > 255) {
            this.sharedService.growlTranslation('The invalidate the municipality message is bigger than 255. Please, reduce the message.', 'dgConn.duplicatedBeneficiaryDetails.invalidateMunicipality.maxLength', 'error');
            this.cssClassInvalidReason = 'notValid';
        } else {
            this.cssClassInvalidReason = 'isValid';
        }
    }
}