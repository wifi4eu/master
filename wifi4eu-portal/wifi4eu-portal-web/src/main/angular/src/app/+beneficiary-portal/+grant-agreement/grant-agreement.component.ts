/* --- IMPORTS --- */
// Angular imports
import { Component } from "@angular/core";
import { LocalStorageService } from "angular-2-local-storage";
import { Router, ActivatedRoute } from '@angular/router';

// DTO's & API imports
import { UserDTOBase, RegistrationApi, RegistrationDTOBase, MayorApi, MayorDTOBase, CallApi, CallDTOBase, MunicipalityApi, MunicipalityDTOBase, ApplicationDTOBase, ApplicationApi } from "../../shared/swagger";
import { HAMMER_GESTURE_CONFIG } from "@angular/platform-browser";

@Component ({
    selector: 'grant-agreement.component.ts',
    templateUrl: 'grant-agreement.component.html',
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
    private calls: CallDTOBase[] = [];

    // Constructor properties
    private isMayor: boolean = false;
    private confirmButtons: Array<boolean> = [];

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

    // getDateSring method properties
    private selectionDate: Date;
    private localeDate: Array<String>;
    
    // Properties for Datatable (TO BE COMPLETED)
    private supplierSelectedDates: Array<String> = [];
    private grantAgreementDates: Array<String> = [];
    private confirmButtonDisabled: boolean = false;

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
        private router: Router, private route: ActivatedRoute
    ) {
        /* Authenticate user */
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        let storedRegistrations = this.localStorage.get('registrationQueue') ? JSON.parse(this.localStorage.get('registrationQueue').toString()) : null;
        this.storedRegistrationQueues = storedRegistrations ? storedRegistrations : [];

        /* Get all the registrations from the user */
        if (this.user != null) {
            this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
                (registrations: RegistrationDTOBase[]) => {
                    // this.registrationsDocs = registrations;
                    // this.registrations = registrations;
                    // this.checkForCalls(registrations);

                    /* Get application for each municipality */ 
                    this.callApi.allCalls().subscribe(
                        (calls: CallDTOBase[]) => {
                            this.calls = calls;
                            for(let i = 0; i < registrations.length; i++) {
                                this.applicationApi.getApplicationByCallIdAndRegistrationId(this.calls[(this.calls.length)-1].id, registrations[i].id).subscribe(
                                    (application : ApplicationDTOBase) => {
                                        if (application.id != 0) {
                                            this.municipalityApi.getMunicipalityById(registrations[i].municipalityId).subscribe(
                                                (municipality : MunicipalityDTOBase) => {
                                                    this.applications.push(application);
                                                    this.registrations.push(registrations[i]);
                                                    this.municipalities.push(municipality);
                                                    if(i === 0) {this.grantAgreementDates.push(this.getStringDate(1529922797000));}  
                                                    //!registrations[i].isSubmission ? this.confirmButtons.push(true) : this.confirmButtons.push(false);
                                                    
                                                    // application.selectSupplierDate != (0 || null) ? this.confirmButtonDisabled = false : this.confirmButtonDisabled = true;
                                                    // console.log("Registrations are ", this.registrations);
                                                    // console.log("First confirmation is ", this.registrations[0].isSubmission);
                                                }
                                            );
                                        }
                                    }
                                );
                            }
                            // console.log("Dates are ", this.grantAgreementDates);
                            // console.log("Applications are ", this.applications);
                            // console.log("Confirm network buttons are ", this.confirmButtons);
                            
                        }
                    );
                }
            );
        }
    }

    /* --- METHODS --- */
    /* Allows beneficiary to select another supplier supplier */
    private selectWifiInstallation(i) {
        this.router.navigate(['/beneficiary-portal/select-supplier/', this.municipalities[i].id]);
    }

    /* Method that toggles if confirm network button is clickable */
    private confirmButton() {
        if(this.grantAgreementDates) {
            if(this.applications) {
                this.confirmButtonDisabled = false;
            }
        }
    }

    /* TO BE COMPLETED */
    /* Confirm and send email to network installation company */ 
    private confirmInstallation() {
        console.log("Write a -Confirm Network Installation- method");
    }
    
    /* Redirect to selected supplier details */
    private supplierDetails(event) {
        this.router.navigate(['/beneficiary-portal/selected-supplier-details', this.municipalities[event].id, this.applications[event].supplierId]);
    }
    
    /* Get displayed string date from epoch number */
    private getStringDate(epoch) {
        this.selectionDate = new Date(epoch);
        this.localeDate = this.selectionDate.toLocaleDateString().split(' ');
        return this.localeDate[0];
    }

    /* TO BE COMPLETED */
    private agreementDetails(i) {
        this.router.navigate(['../grant-agreement/sign-grant-agreement/' + this.municipalities[i].registrations[0].id], { relativeTo: this.route });
    }

    private signGrantAgreement(index) {
        this.grantAgreementDates.push(this.getStringDate(1530255941000));
    }

    /* TO BE COMPLETED */
    /* Method that returns when was grant agreement signed, fake for the moment */



// End of class export    
}












/* import {Component, ViewChild} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {LocalStorageService} from "angular-2-local-storage";
import {Observable} from "rxjs/Observable";
import {SharedService} from "../../shared/shared.service";



@Component({
    selector: 'grant-agreement.component',
    templateUrl: 'grant-agreement.component.html'
})

export class GrantAgreementComponent {
    constructor( private sharedService: SharedService, private router: Router, private route: ActivatedRoute,) {
    }

    private goToSignGrantAgreement(){
        this.router.navigate(['../grant-agreement/sign-grant-agreement'], { relativeTo: this.route });
    }
    
} */