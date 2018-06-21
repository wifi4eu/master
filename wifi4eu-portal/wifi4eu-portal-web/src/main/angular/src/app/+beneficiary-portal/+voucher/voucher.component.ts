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
import {Http, RequestOptions, Headers} from "@angular/http";

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
    4 = Voucher awarded. You can now click on 'Sign grant agreement'. 
    5 = Voucher awarded. You can now click on 'Select Wifi installation company'. 
    6 = Voucher awarded. You already selected a Wi-Fi installation company. 
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
    private uploadDate: string[] = [];
    private uploadHour: string[] = [];
    private voucherApplied: string = "";
    private selectionDate: Date;
    private localeDate: Array<String>;
    private displayedDate: String;
    private openedCalls: string = "";
    private isMayor: boolean = false;
    private registration: RegistrationDTOBase;
    private mayor: MayorDTOBase;
    private docsOpen: boolean [] = [];
    private registrationsDocs: RegistrationDTOBase[] = [];
    private storedRegistrationQueues = [];
    private disableQueuing = [];
    private displayError = false;
    private errorMessage = null;
    private rabbitmqURI: string = "/queue";

    private httpOptions = {
        headers: new Headers({
            'Content-Type': 'application/json'
        })
    };

    constructor(private router: Router, private route: ActivatedRoute, private localStorage: LocalStorageService, private applicationApi: ApplicationApi, private callApi: CallApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private mayorApi: MayorApi, private sharedService: SharedService, private http: Http) {
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        let storedRegistrations = this.localStorage.get('registrationQueue') ? JSON.parse(this.localStorage.get('registrationQueue').toString()) : null;
        this.storedRegistrationQueues = storedRegistrations ? storedRegistrations : [];
        // Check if there are Calls
        if (this.user != null) {
            this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
                /* this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe( */
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
                                                    } else {
                                                        this.applications.push(null);
                                                    }
                                                    var res = this.storedRegistrationQueues.filter((queue) => {
                                                        return registration.id == queue['idRegistration'];
                                                    })
                                                    this.disableQueuing.push(res[0] ? res[0] : null);

                                                    this.loadingButtons.push(false);
                                                    let date = new Date(this.currentCall.startDate);
                                                    this.dateNumber = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getUTCMonth() + 1)).slice(-2) + "/" + date.getUTCFullYear();
                                                    this.hourNumber = ('0' + (date.getUTCHours() + 2)).slice(-2) + ":" + ('0' + date.getUTCMinutes()).slice(-2);
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
                                                            else if(app.date) {
                                                                // Get the date when supplier was selected
                                                                this.getStringDate(app.date);
                                                            }
                                                        }
                                                        if (allApplied) {
                                                            this.voucherCompetitionState = 3;
                                                            this.voucherApplied = "greyImage";
                                                        }
                                                        if (application.voucherAwarded) {
                                                            this.voucherCompetitionState = 5;
                                                        }
                                                        if (application.supplierId) {
                                                            this.voucherCompetitionState = 6;
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

    private applyForVoucher(registrationNumber: number, event) {
        let startCallDate = this.currentCall.startDate;
        let actualDateTime = new Date().getTime();

        if (startCallDate <= actualDateTime) {
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

                event.target.style.pointerEvents = "none";
                event.target.style.opacity = "0.5";
                event.target.disabled = true;

            } else {
                //trying to apply before sending the support documents
                this.sharedService.growlTranslation(
                    "An error occurred and your application could not be received.",
                    "shared.registration.update.error",
                    "error"
                )
            }
        } else {
            //trying to apply before the opening of the call
            this.sharedService.growlTranslation(
                "An error occurred and your application could not be received.",
                "shared.registration.update.error",
                "error"
            )
        }
    }

    private closeModal() {
        this.errorMessage = null;
        this.displayError = false;
    }

    private openApplyForVoucher() {
        this.voucherCompetitionState = 2;
    }

    private goToProfile() {
        window.location.href = "/#/beneficiary-portal/profile";
    }

    private checkForDocuments() {

        if (this.isMayor) {
            this.docsOpen[0] = (this.registrations[0].legalFile1 != null && this.registrations[0].legalFile3 != null);

            if (this.docsOpen[0]) {
                let uploaddate = new Date(this.registrations[0].uploadTime);
                this.uploadDate[0] = ('0' + uploaddate.getUTCDate()).slice(-2) + "/" + ('0' + (uploaddate.getMonth() + 1)).slice(-2) + "/" + uploaddate.getFullYear();
                this.uploadHour[0] = ('0' + uploaddate.getHours()).slice(-2) + ":" + ('0' + uploaddate.getMinutes()).slice(-2);
            }
        } else {
            for (let i = 0; i < this.registrations.length; i++) {
                this.docsOpen[i] = (this.registrations[i].legalFile1 != null && this.registrations[i].legalFile3 != null);
                if (this.docsOpen[i]) {
                    let uploaddate = new Date(this.registrations[i].uploadTime);
                    this.uploadDate[i] = ('0' + uploaddate.getUTCDate()).toString().slice(-2) + "/" + ('0' + (uploaddate.getMonth() + 1)).slice(-2) + "/" + uploaddate.getFullYear();
                    this.uploadHour[i] = ('0' + uploaddate.getHours()).toString().slice(-2) + ":" + ('0' + uploaddate.getMinutes()).slice(-2);
                }
            }


        }
    }

    private selectWifiInstallation(i) {
        this.router.navigate(['/beneficiary-portal/select-supplier/', this.registrations[i].municipalityId], {relativeTo: this.route});
    }

    /* Get displayed string date from epoch number */
    private getStringDate(epoch) {
        this.selectionDate = new Date(epoch);
        this.localeDate = this.selectionDate.toLocaleDateString().split(' ');
        this.displayedDate = this.localeDate[0];
    }

}
