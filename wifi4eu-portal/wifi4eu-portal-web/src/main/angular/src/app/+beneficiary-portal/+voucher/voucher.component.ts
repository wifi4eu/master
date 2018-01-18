import { Component } from '@angular/core';
import { ApplicationApi } from "../../shared/swagger/api/ApplicationApi";
import { CallApi } from "../../shared/swagger/api/CallApi";
import { CallDTOBase } from "../../shared/swagger/model/CallDTO";
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { LocalStorageService } from "angular-2-local-storage";
import { RegistrationApi } from "../../shared/swagger/api/RegistrationApi";
import { RegistrationDTOBase } from "../../shared/swagger/model/RegistrationDTO";
import { ApplicationDTOBase } from "../../shared/swagger/model/ApplicationDTO";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {MayorApi} from "../../shared/swagger/api/MayorApi";
import {SharedService} from "../../shared/shared.service";

@Component({
    templateUrl: 'voucher.component.html', providers: [ApplicationApi, CallApi, RegistrationApi, MunicipalityApi, MayorApi]
})

export class VoucherComponent {
    private voucherCompetitionState: number;
    private user: UserDTOBase;
    private currentCall: CallDTOBase = new CallDTOBase();
    private registrations: RegistrationDTOBase[] = [];
    private municipalities: MunicipalityDTOBase[] = [];
    private mayors: MayorDTOBase[] = [];
    private applications: ApplicationDTOBase[] = [];
    private displayRegistrationSelect: boolean = false;
    private allApplied: boolean = false;
    private loadingButtons: boolean[] = [];

    constructor(private localStorage: LocalStorageService, private applicationApi: ApplicationApi, private callApi: CallApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private sharedService: SharedService) {
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        // Check if there are Calls
        if (this.user != null) {
            this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
                (registrations: RegistrationDTOBase[]) => {
                    this.checkForCalls(registrations);
                }
            );
        }
    }

    private checkForCalls(registrations: RegistrationDTOBase[]) {
        this.callApi.allCalls().subscribe(
            calls => {
                this.currentCall = calls[0];
                if (this.currentCall != null) {
                    // First, check if the call has already began
                    if ((this.currentCall.startDate - new Date().getTime()) <= 0) {
                        this.voucherCompetitionState = 2;
                        for (let registration of registrations) {
                            this.applicationApi.getApplicationByCallIdAndRegistrationId(this.currentCall.id, registration.id).subscribe(
                                (application: ApplicationDTOBase) => {
                                    this.municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                                        (municipality: MunicipalityDTOBase) => {
                                            if (municipality != null) {
                                                this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                                                    (mayor: MayorDTOBase) => {
                                                        this.registrations.push(registration);
                                                        this.municipalities.push(municipality);
                                                        this.mayors.push(mayor);
                                                        this.applications.push(application);
                                                        this.loadingButtons.push(false);
                                                        if (application != null) {
                                                            this.voucherCompetitionState = 3;
                                                        }
                                                        this.checkAllApplied();
                                                    }
                                                );
                                            }
                                        }
                                    );
                                }
                            );
                        }
                    } else {
                        // The competition hasn't started, display the timer
                        this.voucherCompetitionState = 1;
                    }
                } else {
                    // Display "no competition active" message
                    this.voucherCompetitionState = 0;
                }
            },
            error => {
                console.log(error);
                this.currentCall = null;
                this.voucherCompetitionState = 0;
            }
        );
    }

    private applyForVoucher() {
        for (let i = 0; i < this.registrations.length; i++) {
            if (!this.applications[i]) {
                this.sendApplication(i);
            }
        }
        // if (this.registrations.length == 1) {
        //     this.sendApplication(0);
        // } else {
        //     this.displayRegistrationSelect = true;
        // }
    }

    private sendApplication(registrationNumber: number) {
        // TODO: Llamar al nuevo servicio de Apply for voucher
        this.loadingButtons[registrationNumber] = true;
        let newApplication = new ApplicationDTOBase();
        newApplication.callId = this.currentCall.id;
        newApplication.registrationId = this.registrations[registrationNumber].id;
        newApplication.date = new Date().getTime();
        newApplication.supplierId = null;
        this.applicationApi.createApplication(newApplication).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    if (response.data) {
                        this.applications[registrationNumber] = response.data;
                        this.voucherCompetitionState = 3;
                        this.loadingButtons[registrationNumber] = false;
                        this.displayRegistrationSelect = false;
                        this.checkAllApplied();
                        this.sharedService.growlTranslation('Your request for voucher has been submitted successfully. Wifi4Eu will soon let you know if you got a voucher for free wi-fi.', 'voucher.statusmessage5', 'success');
                    }
                }
            }
        );
    }

    private checkAllApplied() {
        let allApplicationsCorrect = true;
        for (let application of this.applications) {
            if (!application) {
                allApplicationsCorrect = false;
                break;
            }
        }
        this.allApplied = allApplicationsCorrect;
    }
}