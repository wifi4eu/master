import { Component } from '@angular/core';
import { ApplicationApi } from "../../shared/swagger/api/ApplicationApi";
import { CallApi } from "../../shared/swagger/api/CallApi";
import { CallDTOBase } from "../../shared/swagger/model/CallDTO";
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { LocalStorageService } from "angular-2-local-storage";
import { RegistrationApi } from "../../shared/swagger/api/RegistrationApi";
import { ConditionsAgreementApi } from "../../shared/swagger/api/ConditionsAgreementApi";
import { RegistrationDTOBase } from "../../shared/swagger/model/RegistrationDTO";
import { ConditionsAgreementDTOBase } from "../../shared/swagger/model/ConditionsAgreementDTO";
import { ApplicationDTOBase } from "../../shared/swagger/model/ApplicationDTO";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import { MayorDTOBase } from "../../shared/swagger/model/MayorDTO";
import { MunicipalityApi } from "../../shared/swagger/api/MunicipalityApi";
import { MayorApi } from "../../shared/swagger/api/MayorApi";
import { SharedService } from "../../shared/shared.service";
import { ActivatedRoute, Router } from "@angular/router";
import { Http, RequestOptions, Headers } from "@angular/http";
@Component({
    templateUrl: 'voucher.component.html',
    providers: [ApplicationApi, CallApi, RegistrationApi, ConditionsAgreementApi, MunicipalityApi, MayorApi]
})

export class VoucherComponent {
    /* -- voucherCompetitionState values --
    0 = There are no calls created
    1 = There is a call created, but not started. DISPLAY TIMER
    2 = There is a call created, already started. You can 'Apply For Voucher'
    3 = Call created & started. You clicked 'Apply For Voucher' and are waiting for the approvement.
     */
    private voucherCompetitionState: number;
    private user: UserDTOBase;
    private currentCall: CallDTOBase = new CallDTOBase();
    private registrations: RegistrationDTOBase[] = [];
    private municipalities: MunicipalityDTOBase[] = [];
    private mayors: MayorDTOBase[] = [];
    private applications: ApplicationDTOBase[] = [];
    private loadingButtons: boolean[] = [];
    //date and hour when call starts
    private startDate: string;
    private startHour: string;
    private endDate: string;
    private endHour: string;
    private uploadDate: string[] = [];
    private uploadHour: string[] = [];
    private voucherApplied: string = "";
    private openedCalls: string = "";
    private isMayor: boolean = false;
    private registration: RegistrationDTOBase;
    private mayor: MayorDTOBase;
    private docsOpen: boolean[] = [];
    private registrationsDocs: RegistrationDTOBase[] = [];
    private storedRegistrationQueues = [];
    private disableQueuing = [];
    private displayError = false;
    private displayCallClosed = false;
    private errorMessage = null;
    private rabbitmqURI: string = "/queue";

    private expandedItems: Array<any> = new Array<any>();
    private signedConditionsAgreement : boolean;
    private conditionsAgreements : Object = {};
    private conditionsAgreement : ConditionsAgreementDTOBase = new ConditionsAgreementDTOBase();
    private disableConditionsAgreements : Object = {};

    private httpOptions = {
        headers: new Headers({
            'Content-Type': 'application/json'
        })
    };


    constructor(private router: Router, private route: ActivatedRoute, private localStorage: LocalStorageService, private applicationApi: ApplicationApi, private callApi: CallApi, private registrationApi: RegistrationApi, private conditionsAgreementApi: ConditionsAgreementApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private sharedService: SharedService, private http: Http) {
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        let storedRegistrations = this.localStorage.get('registrationQueue') ? JSON.parse(this.localStorage.get('registrationQueue').toString()) : null;
        this.storedRegistrationQueues = storedRegistrations ? storedRegistrations : [];
        // Check if there are Calls
        if (this.user != null) {
            this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
                (registrations: RegistrationDTOBase[]) => {
                    this.registrationsDocs = registrations;
                    this.checkForCalls(registrations);
                    if (registrations.length < 2) {
                        // JUST FOR ONE MUNICIPALITY
                        this.registration = registrations[0];
                        this.mayorApi.getMayorByMunicipalityId(registrations[0].municipalityId).subscribe(
                            (mayor: MayorDTOBase) => {
                                this.mayor = mayor;
                                // HERE WE CHECK IF ITS REPRESENTATIVE OR NOT
                                if (this.mayor.name == this.user.name && this.mayor.surname == this.user.surname) {
                                    this.isMayor = true;
                                } else {
                                    this.isMayor = false;
                                }
                            }, error => {
                            }
                        );

                    } else {
                        // MULTIPLE MUNICIPALITIES CONDITIONAL
                        this.isMayor = false;
                    }
                }
            );
        }
    }

    private checkForCalls(registrations: RegistrationDTOBase[]) {
        this.callApi.allCalls().subscribe(
            (calls: CallDTOBase[]) => {
                this.currentCall = calls[0];
                for (let registration of registrations) {
                    this.municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                        (municipality: MunicipalityDTOBase) => {
                            this.conditionsAgreementApi.getConditionsAgreementStatus(registration.id).subscribe(
                                (status : ResponseDTOBase) => {
                                    if (municipality != null) {
                                        this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                                            (mayor: MayorDTOBase) => {
                                                if (this.currentCall) {
                                                    this.applicationApi.getApplicationByCallIdAndRegistrationId(this.currentCall.id, registration.id).subscribe(
                                                        (application: ApplicationDTOBase) => {
                                                            this.registrations.push(registration);
                                                            this.municipalities.push(municipality);
                                                            this.mayors.push(mayor);
                                                            if(status.data == 1) {
                                                                this.conditionsAgreements[municipality.id] = true;
                                                            } else {
                                                                this.conditionsAgreements[municipality.id] = false;
                                                            }
                                                            if (application.id != 0) {
                                                                this.applications.push(application);
                                                                this.disableConditionsAgreements[municipality.id] = true;
                                                            } else {
                                                                this.applications.push(null);
                                                                this.disableConditionsAgreements[municipality.id] = false;
                                                            }
                                                            var res = this.storedRegistrationQueues.filter((queue) => {
                                                                return registration.id == queue['idRegistration'];
                                                            })
                                                            this.disableQueuing.push(res[0] ? res[0] : null);

                                                            this.loadingButtons.push(false);
                                                            let startDateCall = new Date(this.currentCall.startDate);
                                                            let endDateCall = new Date(this.currentCall.endDate);
                                                            this.startDate = ('0' + startDateCall.getUTCDate()).slice(-2) + "/" + ('0' + (startDateCall.getUTCMonth() + 1)).slice(-2) + "/" + startDateCall.getUTCFullYear();
                                                            this.startHour = ('0' + (startDateCall.getUTCHours() + 2)).slice(-2) + ":" + ('0' + startDateCall.getUTCMinutes()).slice(-2);
                                                            this.endDate = ('0' + endDateCall.getUTCDate()).slice(-2) + "/" + ('0' + (endDateCall.getUTCMonth() + 1)).slice(-2) + "/" + endDateCall.getUTCFullYear();
                                                            this.endHour = ('0' + (endDateCall.getUTCHours() + 2)).slice(-2) + ":" + ('0' + endDateCall.getUTCMinutes()).slice(-2);
                                                            
                                                            if ((this.currentCall.startDate - new Date().getTime()) <= 0) {
                                                                this.voucherCompetitionState = 2;
                                                                this.openedCalls = "greyImage";
                                                            } else {
                                                                this.voucherCompetitionState = 1;
                                                            }

                                                            this.checkForDocuments();
                                                            if (this.applications.length == registrations.length) {

                                                                this.disableQueuing.forEach((element, index) => {
                                                                    if (element) {
                                                                        if (element['expires_in'] < Math.floor(new Date().getTime() / 1000)) {
                                                                            this.disableQueuing[index] = null;
                                                                            this.loadingButtons[index] = false;
                                                                        } else {
                                                                            if (this.applications[index] != null) {
                                                                                this.loadingButtons[index] = true;
                                                                                this.disableQueuing[index] = null;
                                                                            }
                                                                        }
                                                                    }
                                                                });

                                                                var newStoredRegistrationQueues = [];
                                                                this.disableQueuing.forEach((disableQueuingEl, index) => {
                                                                    this.loadingButtons[index] = disableQueuingEl ? true : false;
                                                                    if (disableQueuingEl != null) newStoredRegistrationQueues.push(disableQueuingEl);
                                                                });

                                                                this.storedRegistrationQueues = newStoredRegistrationQueues;
                                                                this.localStorage.set('registrationQueue', JSON.stringify(this.storedRegistrationQueues));

                                                                let allApplied = true;
                                                                for (let app of this.applications) {
                                                                    if (!app) {
                                                                        allApplied = false;
                                                                    }
                                                                }
                                                                if (allApplied) {
                                                                    this.voucherCompetitionState = 3;
                                                                    this.voucherApplied = "greyImage";
                                                                }
                                                            }
                                                        }
                                                    );

                                                } else {
                                                    this.registrations.push(registration);
                                                    this.municipalities.push(municipality);
                                                    this.mayors.push(mayor);
                                                    this.loadingButtons.push(false);
                                                    this.voucherCompetitionState = 0;
                                                }
                                            }
                                        );
                                    }
                                }
                            );
                        }
                    );
                }
            },
            error => {
                console.log(error);
                this.currentCall = null;
                this.voucherCompetitionState = 0;
            }
        );
    }

    private goToDocuments(registrationNumber: number) {
        this.router.navigate(['../additional-info/', this.registrations[registrationNumber].municipalityId], { relativeTo: this.route });
    }

    private applyForVoucher(registrationNumber: number, event) {
        //we just need to check this variable
        //voucherCompetitionState is 2 then call is open
        //or when timer component emits that has finished
        if (this.voucherCompetitionState == 2) {
            let startCallDate = this.currentCall.startDate;
            let actualDateTime = new Date().getTime();
            if (!this.loadingButtons[registrationNumber]) {

                let body =
                    '{"callId":' +
                    this.currentCall.id +
                    ', "registrationId":' +
                    this.registrations[registrationNumber].id +
                    ', "userId":' +
                    this.user.id +
                    ', "fileUploadTimestamp":' +
                    this.registrations[registrationNumber].uploadTime +
                    "}";

                this.http.post(this.rabbitmqURI, body, this.httpOptions).subscribe(
                    response => {
                        this.loadingButtons[registrationNumber] = true;
                        this.voucherApplied = "greyImage";
                        this.voucherCompetitionState = 3;

                        var oneHourLater = new Date();
                        oneHourLater.setMinutes(oneHourLater.getMinutes() + 5);
                        var timestamp = Math.floor(oneHourLater.getTime() / 1000);

                        var queueStored = {
                            expires_in: timestamp,
                            idRegistration: this.registrations[registrationNumber].id,
                            call: this.currentCall.id
                        };
                        this.storedRegistrationQueues.push(queueStored);
                        this.localStorage.set(
                            "registrationQueue",
                            JSON.stringify(this.storedRegistrationQueues)
                        );
                        this.sharedService.growlTranslation(
                            "Your request for voucher has been submitted successfully. Wifi4Eu will soon let you know if you got a voucher for free wi-fi.",
                            "benefPortal.voucher.statusmessage5",
                            "success"
                        );
                    },
                    error => {
                        //error sending the information to the MQ
                        this.errorMessage = error;
                        this.displayError = true;
                        this.sharedService.growlTranslation(
                            "An error occurred and your application could not be received.",
                            "shared.registration.update.error",
                            "error"
                        )
                    }
                );
            } else {
                //trying to apply before sending the support documents
                this.sharedService.growlTranslation(
                    "An error occurred and your application could not be received.",
                    "shared.registration.update.error",
                    "error"
                )
            }
        } else if (this.voucherCompetitionState == 1) {
            //trying to apply before the opening of the call
            this.displayCallClosed = true;
        }
    }

    private closeModal() {
        this.errorMessage = null;
        this.displayError = false;
        this.displayCallClosed = false;
    }

    private openApplyForVoucher() {
        this.voucherCompetitionState = 2;
    }

    private goToProfile() {
        window.location.href = "/#/beneficiary-portal/profile";
    }

    private checkForDocuments() {

        if (this.isMayor) {
            this.docsOpen[0] = (this.registrations[0].legalFile1Size != null && this.registrations[0].legalFile1Size > 0 && 
                                this.registrations[0].legalFile2Size != null && this.registrations[0].legalFile2Size > 0 &&
                                this.registrations[0].legalFile3Size != null && this.registrations[0].legalFile3Size > 0 &&
                                this.registrations[0].legalFile4Size != null && this.registrations[0].legalFile4Size > 0
                            );

            if (this.docsOpen[0]) {
                let uploaddate = new Date(this.registrations[0].uploadTime);
                this.uploadDate[0] = ('0' + uploaddate.getUTCDate()).slice(-2) + "/" + ('0' + (uploaddate.getMonth() + 1)).slice(-2) + "/" + uploaddate.getFullYear();
                this.uploadHour[0] = ('0' + uploaddate.getHours()).slice(-2) + ":" + ('0' + uploaddate.getMinutes()).slice(-2);
            }
        } else {
            for (let i = 0; i < this.registrations.length; i++) {
                this.docsOpen[i] = (
                    this.registrations[i].legalFile1Size != null && this.registrations[i].legalFile1Size > 0 &&
                    this.registrations[i].legalFile2Size != null && this.registrations[i].legalFile2Size > 0 && 
                    this.registrations[i].legalFile3Size != null && this.registrations[i].legalFile3Size > 0 &&
                    this.registrations[i].legalFile4Size != null && this.registrations[i].legalFile4Size > 0
                );
                if (this.docsOpen[i]) {
                    let uploaddate = new Date(this.registrations[i].uploadTime);
                    this.uploadDate[i] = ('0' + uploaddate.getUTCDate()).toString().slice(-2) + "/" + ('0' + (uploaddate.getMonth() + 1)).slice(-2) + "/" + uploaddate.getFullYear();
                    this.uploadHour[i] = ('0' + uploaddate.getHours()).toString().slice(-2) + ":" + ('0' + uploaddate.getMinutes()).slice(-2);
                }
            }
        }

    }

    private changeConditionsAgreement(municipality) {
        for(let j = 0; j < this.registrationsDocs.length; j++) {
            if(this.registrationsDocs[j].municipalityId == municipality.id) {
                this.conditionsAgreement.registrationId = this.registrationsDocs[j].id;
                this.conditionsAgreements[municipality.id] == 0 ? this.conditionsAgreement.status = 1 : this.conditionsAgreement.status = 0;
                this.conditionsAgreementApi.changeConditionsAgreementStatus(this.conditionsAgreement).subscribe(
                    (data : ResponseDTOBase) => {
                        if (data.success) {
                            this.sharedService.growlTranslation('Your registration was successfully updated.', 'shared.registration.update.success', 'success');
                            this.conditionsAgreements[municipality.id] = this.conditionsAgreement.status;
                        } else {
                            this.sharedService.growlTranslation('shared.registration.update.error', 'An error occurred and your registration could not be updated.', 'error');
                        }
                    }, error => {
                        this.sharedService.growlTranslation('shared.registration.update.error', 'An error occurred and your registration could not be updated.', 'error');
                    }
                );
                break;
            }
        }
    }

}
