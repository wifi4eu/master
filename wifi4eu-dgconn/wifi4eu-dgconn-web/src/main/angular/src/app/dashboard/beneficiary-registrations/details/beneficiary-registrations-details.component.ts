import {Component} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {MunicipalityApi} from "../../../shared/swagger/api/MunicipalityApi";
import {MunicipalityDTOBase} from "../../../shared/swagger/model/MunicipalityDTO";
import {MayorApi} from "../../../shared/swagger/api/MayorApi";
import {MayorDTOBase} from "../../../shared/swagger/model/MayorDTO";
import {RegistrationApi} from "../../../shared/swagger/api/RegistrationApi";
import {RegistrationDTOBase} from "../../../shared/swagger/model/RegistrationDTO";
import {ThreadApi} from "../../../shared/swagger/api/ThreadApi";
import {ThreadDTOBase} from "../../../shared/swagger/model/ThreadDTO";
import {ResponseDTOBase} from "../../../shared/swagger/model/ResponseDTO";
import {SharedService} from "../../../shared/shared.service";
import {DomSanitizer} from "@angular/platform-browser";
import {ThreadMessageDTOBase} from "../../../shared/swagger/model/ThreadMessageDTO";
import {BeneficiaryApi} from "../../../shared/swagger/api/BeneficiaryApi";

@Component({
    templateUrl: 'beneficiary-registrations-details.component.html',
    providers: [MunicipalityApi, MayorApi, RegistrationApi, ThreadApi, BeneficiaryApi]
})

export class DgConnBeneficiaryRegistrationsDetailsComponent {
    private lauId: number = null;
    private municipalities: MunicipalityDTOBase[] = [];
    private mayors: MayorDTOBase[] = [];
    private registrations: RegistrationDTOBase[] = [];
    private discussionThread: ThreadDTOBase = null;
    private displayedMessages: ThreadMessageDTOBase[] = [];
    private entitiesChecked: boolean[] = [];
    private entityCheckboxIndex: number = null;
    private searchMessagesQuery: string = '';
    private issueRegistration: number;

    constructor(private route: ActivatedRoute, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private registrationApi: RegistrationApi, private threadApi: ThreadApi, private beneficiaryApi: BeneficiaryApi, private sharedService: SharedService, private sanitizer: DomSanitizer) {
        this.route.params.subscribe(
            params => {
                this.lauId = params['id'];
                this.getRegistrationDetailsInfo();
            }
        );
    }

    private getRegistrationDetailsInfo() {
        this.municipalityApi.getMunicipalitiesByLauId(this.lauId).subscribe(
            (municipalities: MunicipalityDTOBase[]) => {
                for (let i = 0; i < municipalities.length; i++) {
                    let municipality = municipalities[i];
                    this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                        (mayor: MayorDTOBase) => {
                            this.registrationApi.getRegistrationByMunicipalityId(municipality.id).subscribe(
                                (registration: RegistrationDTOBase) => {
                                    if (registration) {
                                        this.entitiesChecked.push(false);
                                        this.registrations.push(registration);
                                        this.mayors.push(mayor);
                                        this.municipalities.push(municipality);
                                        if(this.registrations.length == municipalities.length){
                                          this.getIssue();
                                        }
                                    }
                                }
                            );
                        }
                    );
                }
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

    private checkEntity(index: number) {
        if (!this.entitiesChecked[index]) {
            this.entityCheckboxIndex = null;
        } else {
            this.entityCheckboxIndex = index;
            for (let i = 0; i < this.entitiesChecked.length; i++) {
                if (i != index) {
                    this.entitiesChecked[i] = false;
                }
            }
        }
    }

    private requestLegalDocuments(index: number) {
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

    private getIssue(){
        this.beneficiaryApi.getIssueTypeBeneficiaryRegistrations(JSON.stringify(this.registrations)).subscribe(
            (response: ResponseDTOBase) => {
                if(response.success){
                    this.issueRegistration = response.data;
                }
            }
        )
    }

    private invalidateMunicipality(index: number) {
        if (index != null) {
            this.registrations[index].status = 1;
            this.registrationApi.createRegistration(this.registrations[index]).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                      this.getIssue();
                        this.sharedService.growlTranslation('You successfully invalidated the municipality.','dgConn.duplicatedBeneficiaryDetails.invalidateMunicipality.success', 'success');
                    } else {
                        this.sharedService.growlTranslation('An error occurred while trying to invalidate the municipality. Please, try again later.','dgConn.duplicatedBeneficiaryDetails.invalidateMunicipality.error', 'error');
                    }
                }
            );
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
}