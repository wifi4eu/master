/* --- IMPORTS --- */
// Angular imports
import { Component } from "@angular/core";
import { LocalStorageService } from "angular-2-local-storage";
import { Router, ActivatedRoute } from '@angular/router';

// DTO's & API imports
import { UserDTOBase, RegistrationApi, RegistrationDTOBase, MayorApi, MayorDTOBase, CallApi, CallDTOBase, MunicipalityApi, MunicipalityDTOBase, ApplicationDTOBase, ApplicationApi, GrantAgreementApi, GrantAgreementDTOBase, GrantAgreementDTO, ResponseDTO } from "../../shared/swagger";
import { HAMMER_GESTURE_CONFIG } from "@angular/platform-browser";
import { SharedService } from "../../shared/shared.service";

@Component ({
    selector: 'my-voucher.component.ts',
    templateUrl: 'my-voucher.component.html',
    providers: [SharedService, GrantAgreementApi, RegistrationApi, MayorApi, CallApi, MunicipalityApi, ApplicationApi] 
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
    private startDate: string = '';

    /* -- voucherCompetitionState values --
    0 = There are no calls created
    1 = There is a call created, but not started. DISPLAY TIMER
    2 = There is a call created, already started. You can 'Apply For Voucher'
    3 = Call created & started. You clicked 'Apply For Voucher' and are waiting for the approvement.
    */
   
    private voucherCompetitionState: number;
    private showPermissionsModal: boolean;
    private hasSigned: GrantAgreementDTO [] = [];
    private date: String [] = [];

    constructor(
        private localStorage: LocalStorageService,
        private registrationApi: RegistrationApi,
        private mayorApi: MayorApi,
        private callApi: CallApi,
        private municipalityApi: MunicipalityApi,
        private applicationApi: ApplicationApi,
        private router: Router, private route: ActivatedRoute,
        private grantAgreementApi: GrantAgreementApi,
        private sharedService : SharedService

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
                    /* Get application for each municipality */ 
                    this.callApi.allCalls().subscribe(
                        (calls: CallDTOBase[]) => {
                            this.calls = calls;
                            for(let i = 0; i < registrations.length; i++) {
                                this.applicationApi.getVoucherApplicationByCallIdAndRegistrationId(this.calls[(this.calls.length)-1].id, registrations[i].id, new Date().getTime()).subscribe(
                                    (response : ResponseDTO) => {
                                        if (response.data != null && response.data.id != 0) {
                                            this.municipalityApi.getMunicipalityById(registrations[i].municipalityId).subscribe(
                                                (municipality : MunicipalityDTOBase) => {
                                                    this.grantAgreementApi.getGrantAgreementByApplicationId(response.data.id, new Date().getTime()).subscribe(
                                                        (res: ResponseDTO )=>{                                                    
                                                            let grantAgreement = res.data;
                                                            if(grantAgreement != null && grantAgreement.dateSignature != null){
                                                                grantAgreement.dateSignature = new Date(grantAgreement.dateSignature);
                                                                grantAgreement['formattedDateSignature'] = ('0' + grantAgreement.dateSignature.getUTCDate()).slice(-2) + "/" + ('0' + ( grantAgreement.dateSignature.getUTCMonth() + 1)).slice(-2) + "/" +  grantAgreement.dateSignature.getUTCFullYear();
                                                                this.hasSigned.push(grantAgreement);
                                                                this.date[i] = ('0' + grantAgreement.dateSignature.getUTCDate()).slice(-2) + "/" + ('0' + ( grantAgreement.dateSignature.getUTCMonth() + 1)).slice(-2) + "/" +  grantAgreement.dateSignature.getUTCFullYear();
                                                                this.registrations.push(registrations[i]);
                                                                this.applications.push(response.data);
                                                                this.municipalities.push(municipality);
                                                                this.grantAgreementDates.push(this.date[i]);
                                                          } else {
                                                                this.hasSigned.push(null);
                                                                this.registrations.push(registrations[i]);
                                                                this.applications.push(response.data);
                                                                this.municipalities.push(municipality);
                                                                this.grantAgreementDates.push(null);
                                                          }
                                                          
                                                    }, error => {
                                                        console.log(error);                                                        
                                                    });
                                                }
                                            );
                                        }
                                    }
                                );
                            }
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

    /* Confirm and send email to network installation company */ 
    private confirmInstallation(i) {
        this.router.navigate(['/beneficiary-portal/installations/', this.registrations[i].municipalityId]);
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

    /* Navigate to sign grant agreement */
    private agreementDetails(i) {
        this.grantAgreementApi.isUserAuthorizedSignGrantAgreement(this.applications[i].id).subscribe((response: boolean) => {
            if(!response){
                this.showPermissionsModal = true;
                return;
            }
            this.router.navigate(['/beneficiary-portal/my-voucher/sign-grant-agreement/' + this.municipalities[i].registrations[0].id]);
          })
        
    }

    private closeModal() {
        this.showPermissionsModal = false;
    }

    /* Navigate to installation sites details */
    installationSiteDetails(i) {
        this.router.navigate(['beneficiary-portal/installations/' + this.registrations[i].municipalityId]);
    }
}