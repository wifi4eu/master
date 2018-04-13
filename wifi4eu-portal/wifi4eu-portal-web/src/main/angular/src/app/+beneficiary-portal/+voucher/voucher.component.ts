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
import {ActivatedRoute, Router} from "@angular/router";

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
    private loadingButtons: boolean[] = [];
    private dateNumber: string;
    private hourNumber: string;
    private voucherApplied: string = "";
    private openedCalls: string = "";
    private isMayor: boolean = true;
    private registration: RegistrationDTOBase;
    private mayor: MayorDTOBase;
    private docsOpen: boolean [] = [];
    private registrationsDocs: RegistrationDTOBase[] = [];


    constructor(private router: Router, private route: ActivatedRoute, private localStorage: LocalStorageService, private applicationApi: ApplicationApi, private callApi: CallApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private sharedService: SharedService) {
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        // Check if there are Calls
        if (this.user != null) {
            this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
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
                                if (this.mayor.name == this.user.name && this.mayor.surname == this.user.surname)
                                    this.isMayor = true;
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
                            if (municipality != null) {
                                this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                                    (mayor: MayorDTOBase) => {
                                        if (this.currentCall) {
                                            this.applicationApi.getApplicationByCallIdAndRegistrationId(this.currentCall.id, registration.id).subscribe(
                                                (application: ApplicationDTOBase) => {
                                                    this.registrations.push(registration);
                                                    this.municipalities.push(municipality);
                                                    this.mayors.push(mayor);
                                                    if (application.id != 0) {
                                                        this.applications.push(application);
                                                    }
                                                    this.loadingButtons.push(false);
                                                    let date = new Date(this.currentCall.startDate);
                                                    // date.setMinutes(date.getMinutes() + date.getTimezoneOffset());
                                                    this.dateNumber = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getMonth() + 1)).slice(-2) + "/" + date.getFullYear();
                                                    this.hourNumber = ('0' + date.getHours()).slice(-2) + ":" + ('0' + date.getMinutes()).slice(-2);
                                                    if ((this.currentCall.startDate - new Date().getTime()) <= 0) {
                                                        this.voucherCompetitionState = 2;
                                                        this.openedCalls = "greyImage";
                                                    } else {
                                                        this.voucherCompetitionState = 1;
                                                    }
                                                    // this.checkForDocuments();
                                                    if (this.applications.length == this.registrations.length) {
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
            },
            error => {
                console.log(error);
                this.currentCall = null;
                this.voucherCompetitionState = 0;
            }
        );
    }

    private goToDocuments(registrationNumber: number) {
        this.router.navigate(['../additional-info/', this.registrations[registrationNumber].municipalityId], {relativeTo: this.route});
    }

    private applyForVoucher(registrationNumber: number) {
        let startCallDate = this.currentCall.startDate;
        let actualDateTime = new Date().getTime();

        if (startCallDate <= actualDateTime) {
            // TODO: Llamar al nuevo servicio de Apply for voucher
            // this.loadingButton = true;
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
                            // this.loadingButton = false;
                            this.loadingButtons[registrationNumber] = false;
                            this.sharedService.growlTranslation('Your request for voucher has been submitted successfully. Wifi4Eu will soon let you know if you got a voucher for free wi-fi.', 'benefPortal.voucher.statusmessage5', 'success');
                            this.voucherApplied = "greyImage";
                        }
                    }
                }
            );
        }
    }

    private openApplyForVoucher() {
        this.voucherCompetitionState = 2;
    }

    private goToProfile() {
        window.location.href = "/#/beneficiary-portal/profile";
    }

    private checkForDocuments() {
        if (this.isMayor) {
            for (let i = 0; i < this.registrations.length; i++) {

                console.log(this.registrations[i]);
                this.docsOpen[i] = (this.registrations[i].legalFile1 != null && this.registrations[i].legalFile4 == null && this.registrations[i].legalFile2 == null && this.registrations[i].legalFile3 != null);
                console.log(this.docsOpen[i]);
            }
        } else {
            for (let i = 0; i < this.registrations.length; i++) {

                console.log(this.docsOpen);
                console.log(this.registrations[i]);
                this.docsOpen[i] = (this.registrations[i].legalFile1 != null && this.registrations[i].legalFile4 != null && this.registrations[i].legalFile2 != null && this.registrations[i].legalFile3 != null);
                console.log(this.docsOpen[i]);
            }
        }
    }
}
