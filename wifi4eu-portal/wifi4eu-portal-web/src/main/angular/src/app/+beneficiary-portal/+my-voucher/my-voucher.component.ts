/* --- IMPORTS --- */
// Angular imports
import { Component } from "@angular/core";
import { LocalStorageService } from "angular-2-local-storage";

// DTO's imports
import { UserDTOBase, RegistrationApi, RegistrationDTOBase, MayorApi, MayorDTOBase, CallApi, CallDTOBase, MunicipalityApi, MunicipalityDTOBase, ApplicationDTOBase, ApplicationApi } from "../../shared/swagger";

@Component ({
    selector: 'my-voucher-component',
    templateUrl: 'my-voucher.component.html',
    providers: [RegistrationApi, MayorApi, CallApi, MunicipalityApi, ApplicationApi] 
})

export class MyVoucherComponent {
    /* --- PROPERTIES --- */
    // Constructor initialiser
    private storedRegistrationQueues = [];
    
    // DTO's
    private user: UserDTOBase;
    private registrations: RegistrationDTOBase[] = [];
    private registrationsDocs: RegistrationDTOBase[] = [];
    private registration: RegistrationDTOBase;
    private mayors: MayorDTOBase[] = [];
    private mayor: MayorDTOBase;
    private currentCall: CallDTOBase = new CallDTOBase();
    private municipalities: MunicipalityDTOBase[] = [];
    private applications: ApplicationDTOBase[] = [];

    // Constructor properties
    private isMayor: boolean = false;

    // CheckForCalls properties
    private disableQueuing = [];
    private loadingButtons: boolean[] = [];
    private dateNumber: string;
    private hourNumber: string;
    private openedCalls: string = "";
    private voucherApplied: string = "";

    // CheckForDocuments method properties 
    private docsOpen: boolean [] = [];
    private uploadDate: string[] = [];
    private uploadHour: string[] = [];


        /* -- voucherCompetitionState values --
    0 = There are no calls created
    1 = There is a call created, but not started. DISPLAY TIMER
    2 = There is a call created, already started. You can 'Apply For Voucher'
    3 = Call created & started. You clicked 'Apply For Voucher' and are waiting for the approvement.
     */
    private voucherCompetitionState: number;


    constructor(
        private localStorage: LocalStorageService,
        private registrationApi: RegistrationApi,
        private mayorApi: MayorApi,
        private callApi: CallApi,
        private municipalityApi: MunicipalityApi,
        private applicationApi: ApplicationApi,

       
    ) {
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

    /* --- METHODS --- */
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
// End of class export    
}