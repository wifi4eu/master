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

@Component({
    templateUrl: 'beneficiary-registrations-details.component.html',
    providers: [MunicipalityApi, MayorApi, RegistrationApi, ThreadApi]
})

export class DgConnBeneficiaryRegistrationsDetailsComponent {
    private lauId: number = null;
    private municipalities: MunicipalityDTOBase[] = [];
    private mayors: MayorDTOBase[] = [];
    private registrations: RegistrationDTOBase[] = [];
    private discussionThread: ThreadDTOBase = null;
    private entitiesChecked: boolean[] = [];
    private entityCheckboxIndex: number = null;

    constructor(private route: ActivatedRoute, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private registrationApi: RegistrationApi, private threadApi: ThreadApi, private sharedService: SharedService, private sanitizer: DomSanitizer) {
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
                for (let municipality of municipalities) {
                    this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                        (mayor: MayorDTOBase) => {
                            this.registrationApi.getRegistrationByMunicipalityId(municipality.id).subscribe(
                                (registration: RegistrationDTOBase) => {
                                    if (registration) {
                                        this.entitiesChecked.push(false);
                                        this.registrations.push(registration);
                                        this.mayors.push(mayor);
                                        this.municipalities.push(municipality);
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

    private requestLegalDocuments() {
        this.registrationApi.requestLegalDocuments(this.registrations[this.entityCheckboxIndex].id).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    let entityNumber = (this.entityCheckboxIndex + 1);
                    this.sharedService.growlTranslation('An email has been sent to the legal representant of the Entity #' + entityNumber + ' to supply the legal documents for the registration.','dgConn.duplicatedBeneficiaryDetails.requestLegalDocuments.success', 'success', String(entityNumber));
                    //this.getRegistrationDetailsInfo();
                } else {
                    this.sharedService.growlTranslation('An error occurred while trying to request the legal documents of the registration. Please, try again later.','dgConn.duplicatedBeneficiaryDetails.requestLegalDocuments.error', 'error');
                }
                console.log(response);
            }
        );
    }

    private assignLegalEntity() {
        if (this.entityCheckboxIndex != null) {
            this.registrationApi.assignLegalEntity(this.registrations[this.entityCheckboxIndex].id).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        let entityNumber = (this.entityCheckboxIndex + 1);
                        this.sharedService.growlTranslation('You successfully assigned the authentic legal entity to the Entity #' + entityNumber + '.','dgConn.duplicatedBeneficiaryDetails.assignLegalEntity.success', 'success', String(entityNumber));
                        //this.getRegistrationDetailsInfo();
                    } else {
                        this.sharedService.growlTranslation('An error occurred while trying to assign the authentic legal entity. Please, try again later.','dgConn.duplicatedBeneficiaryDetails.assignLegalEntity.error', 'error');
                    }
                    console.log(response);
                }
            );
        }
    }

    private validateMunicipality() {
        if (this.entityCheckboxIndex != null) {
            this.registrations[this.entityCheckboxIndex].status = 2;
            this.registrationApi.createRegistration(this.registrations[this.entityCheckboxIndex]).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.sharedService.growlTranslation('You successfully validated the municipality.','dgConn.duplicatedBeneficiaryDetails.validateMunicipality.success', 'success');
                    } else {
                        this.sharedService.growlTranslation('An error occurred while trying to validate the municipality. Please, try again later.','dgConn.duplicatedBeneficiaryDetails.validateMunicipality.error', 'error');
                    }
                }
            );
        }
    }

    private invalidateMunicipality() {
        if (this.entityCheckboxIndex != null) {
            this.registrations[this.entityCheckboxIndex].status = 1;
            this.registrationApi.createRegistration(this.registrations[this.entityCheckboxIndex]).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.sharedService.growlTranslation('You successfully invalidated the municipality.','dgConn.duplicatedBeneficiaryDetails.invalidateMunicipality.success', 'success');
                    } else {
                        this.sharedService.growlTranslation('An error occurred while trying to invalidate the municipality. Please, try again later.','dgConn.duplicatedBeneficiaryDetails.invalidateMunicipality.error', 'error');
                    }
                }
            );
        }
    }
}