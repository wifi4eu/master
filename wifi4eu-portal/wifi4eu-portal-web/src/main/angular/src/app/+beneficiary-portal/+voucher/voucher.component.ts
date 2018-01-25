import {Component} from '@angular/core';
import {ApplicationApi} from "../../shared/swagger/api/ApplicationApi";
import {CallApi} from "../../shared/swagger/api/CallApi";
import {CallDTOBase} from "../../shared/swagger/model/CallDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {ApplicationDTOBase} from "../../shared/swagger/model/ApplicationDTO";
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {MayorApi} from "../../shared/swagger/api/MayorApi";
import {SharedService} from "../../shared/shared.service";

@Component({
    templateUrl: 'voucher.component.html',
    providers: [ApplicationApi, CallApi, RegistrationApi, MunicipalityApi, MayorApi]
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
    private displayMunicipality: boolean = false;
    private shownMunicipalityIndex: number;
    private loadingButton: boolean = false;
    private loadingButtons: boolean[] = [];
    private dateNumber: string;
    private hourNumber: string;
    private showTimeline: boolean = false;
    private showTimer: boolean = false;

    constructor(private localStorage: LocalStorageService, private applicationApi: ApplicationApi, private callApi: CallApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private sharedService: SharedService) {
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        // Check if there are Calls
        this.checkForOpenCalls();
        if (this.user != null) {
            this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
                (registrations: RegistrationDTOBase[]) => {
                    this.checkForCalls(registrations);
                }
            );
        }
    }

    checkForOpenCalls() {
        this.callApi.allCalls().subscribe(
            calls => {
                this.currentCall = calls[0];
                this.showTimeline = true;
                this.showTimer = true;
                let date = new Date(this.currentCall.startDate);
                date.setMinutes(date.getMinutes() + date.getTimezoneOffset());
                this.dateNumber = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getMonth() + 1)).slice(-2) + "/" + date.getFullYear();
                this.hourNumber = ('0' + date.getHours()).slice(-2) + ":" + ('0' + date.getMinutes()).slice(-2);
            }, error => {
                console.log(error);
                this.currentCall = null;
            }
        );
    }

    private checkForCalls(registrations: RegistrationDTOBase[]) {
        this.callApi.allCalls().subscribe(
            calls => {
                this.currentCall = calls[0];
                if (this.currentCall != null) {
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
                                                }
                                            );
                                        }
                                    }
                                );
                            }
                        );
                    }
                    if ((this.currentCall.startDate - new Date().getTime()) <= 0) {
                        this.voucherCompetitionState = 2;
                    } else {
                        this.voucherCompetitionState = 1;
                        let date = new Date(this.currentCall.startDate);
                        date.setMinutes(date.getMinutes() + date.getTimezoneOffset());
                        this.dateNumber = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getMonth() + 1)).slice(-2) + "/" + date.getFullYear();
                        this.hourNumber = ('0' + date.getHours()).slice(-2) + ":" + ('0' + date.getMinutes()).slice(-2);
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

    private applyForVoucher(registrationNumber: number) {
        // TODO: Llamar al nuevo servicio de Apply for voucher
        this.loadingButton = true;
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
                        this.loadingButton = false;
                        this.loadingButtons[registrationNumber] = false;
                        this.sharedService.growlTranslation('Your request for voucher has been submitted successfully. Wifi4Eu will soon let you know if you got a voucher for free wi-fi.', 'benefPortal.voucher.statusmessage5', 'success');
                    }
                }
            }
        );
    }

    private openApplyForVoucher() {
        this.voucherCompetitionState = 2;
    }

    private showMunicipalityData(index: number) {
        this.shownMunicipalityIndex = index;
        this.displayMunicipality = true;
    }

    private hideMunicipalityData() {
        this.displayMunicipality = false;
    }

    private goToProfile() {
        window.location.href = "/#/beneficiary-portal/profile";
    }
}