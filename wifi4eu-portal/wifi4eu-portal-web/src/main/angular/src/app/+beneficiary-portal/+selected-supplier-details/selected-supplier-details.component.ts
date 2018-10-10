/* -- IMPORTS -- */
// Angular features 
import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { LocalStorageService } from "angular-2-local-storage";
import { Router } from '@angular/router';

// Project Api's
import { MunicipalityApi, RegistrationApi, CallApi, ApplicationApi, CallDTOBase, RegistrationDTOBase, ApplicationDTOBase, SupplierApi, SupplierDTOBase, ResponseDTOBase, UserApi } from "../../shared/swagger";

// Project DTO's
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";

@Component ({
  selector: 'selected-supplier-component',
  templateUrl: './selected-supplier-details.component.html',
  providers: [MunicipalityApi, RegistrationApi, CallApi, ApplicationApi, SupplierApi, UserApi]
})

export class SelectedSupplierDetailsComponent {
  
  /* -- PROPERTIES -- */
  // Project DTO's
  private registration: RegistrationDTOBase;
  private application: ApplicationDTOBase;
  private supplier: SupplierDTOBase;
  private supplierContactUser: UserDTOBase;
  private calls: Array<CallDTOBase>

  // User characteristics
  private user: UserDTOBase;
  private storedRegistrationQueues = [];
  
  // Component specific properties
  private municipality: MunicipalityDTOBase; 
  private municipalityId: number;
  private paramsSupplierId: number;
  private changedSupplierChoice: boolean = false;
  private hasConfirmedInstallation: boolean = true;

  // Date supplier was selected
  private selectionDate: Date;
  private localeDate: Array<String>;
  private displayedDate: String;
  private displayDate: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private localStorage: LocalStorageService,
    private router: Router,
    private registrationApi: RegistrationApi,
    private callApi: CallApi,
    private applicationApi: ApplicationApi,
    private supplierApi: SupplierApi,
    private userApi: UserApi,
    private municipalityApi: MunicipalityApi
  ) {

    /* Get params from URL */
    this.route.params.subscribe(
      params => {
          this.municipalityId = Number(params['municipalityId']);
          this.paramsSupplierId = Number(params['supplierId']);
      }
    );

    /* Authenticate user */
    let storedUser = this.localStorage.get('user');
    this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
    let storedRegistrations = this.localStorage.get('registrationQueue') ? JSON.parse(this.localStorage.get('registrationQueue').toString()) : null;
    this.storedRegistrationQueues = storedRegistrations ? storedRegistrations : [];

    /* Check if user registration municipalities matches params */
    if (this.user != null) {
      this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
        (registrations: RegistrationDTOBase[]) => {
          for(var i = 0; i < registrations.length; i++) {
            if(registrations[i].municipalityId === this.municipalityId) {
              this.registration = registrations[i];
              !this.registration.installationSiteConfirmation ? this.hasConfirmedInstallation = false : this.hasConfirmedInstallation = true;
              if(this.registration) {
                this.municipalityApi.getMunicipalityById(this.registration.municipalityId).subscribe(
                  (municipality: MunicipalityDTOBase) => {
                    this.municipality = municipality;
                  }
                );
              }
            }
          }
          
          /* Get current application of the beneficiary */
          this.callApi.allCalls().subscribe(
            (calls: CallDTOBase[]) => {
              this.calls = calls;
              if(this.calls != null && this.calls.length != 0) {
                this.applicationApi.getApplicationByCallIdAndRegistrationId(calls[(calls.length-1)].id, this.registration.id, new Date().getTime()).subscribe(
                  (application: ApplicationDTOBase) => {
                    this.application = application;
                    if(this.application.supplierId !== this.paramsSupplierId) {
                      this.changedSupplierChoice = true;
                    }
                    this.getSupplierDetails(this.paramsSupplierId, this.registration.id, this.application.id);
                    this.getSupplierMainContact(this.paramsSupplierId, this.calls[(this.calls.length-1)].id, this.registration.id, this.application.id);
                    }
                  );
                }
              }
            ); 
        }
      );
    }
    // End of constructor  
  }
  
  /*  -- METHODS -- */
  /* Get supplier details from supplierId requested through params */
  getSupplierDetails(supplierId, registrationId, applicationId) {
    this.supplierApi.getDetailsBySupplierId(supplierId, this.calls[(this.calls.length-1)].id, registrationId, applicationId).subscribe(
      (supplier: SupplierDTOBase) => {            
        this.supplier = supplier;
      }
    );
    /* Get the date when supplier was selected if the supplier hasn't changed his choice */
    if((this.application.supplierId === this.paramsSupplierId) && (this.application.supplierId != null))  {
      this.getStringDate(this.application.selectSupplierDate);
      this.displayDate = true; 
    }
  }

  /* Get supplier main contact details from supplierId requested through params */
  getSupplierMainContact(supplierId, callId, registrationId, applicationId) {
    this.userApi.getSupplierMainContact(supplierId, callId, registrationId, applicationId).subscribe(
      (supplierContact: UserDTOBase) => {
        this.supplierContactUser = supplierContact;
      }
    );
  }

  /* Get displayed string date from epoch number */
  private getStringDate(epoch) {
    this.selectionDate = new Date(epoch);
    this.localeDate = this.selectionDate.toLocaleDateString().split(' ');
    this.displayedDate = this.localeDate[0];
  }

  /* Allow beneficiary to change selected supplier */
  private changeSupplier() {
    this.router.navigate(['/beneficiary-portal/select-supplier', this.registration.municipalityId]);
  }
  
  /* Assign supplier to the beneficiary application */
  // NEW METHODS
  private saveAndNotify() {
    this.application.supplierId = this.paramsSupplierId;
    this.applicationApi.assignSupplier(this.calls[(this.calls.length-1)].id, this.registration.municipalityId, this.application).subscribe(
      (resAplication: ResponseDTOBase) => {
        this.router.navigate(['/beneficiary-portal/my-voucher']);
      }, error => {
        console.log("ERROR on email sending");
      }
    );
  }

// End of exported class
}