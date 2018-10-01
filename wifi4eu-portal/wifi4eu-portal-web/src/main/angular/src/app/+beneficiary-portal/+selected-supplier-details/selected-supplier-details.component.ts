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

  // User characteristics
  private user: UserDTOBase;
  private storedRegistrationQueues = [];
  
  // Component specific properties
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
    private userApi: UserApi
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
            }
          }
          
          /* Get current application of the beneficiary */
          this.callApi.allCalls().subscribe(
            (calls: CallDTOBase[]) => {
              this.applicationApi.getApplicationByCallIdAndRegistrationId(calls[(calls.length-1)].id, this.registration.id).subscribe(
                (application: ApplicationDTOBase) => {
                  this.application = application;
                  if(this.application.supplierId !== this.paramsSupplierId) {
                    this.changedSupplierChoice = true;
                  }
                  this.getSupplierDetails(this.paramsSupplierId, this.municipalityId);
                  this.getSupplierMainContact(this.paramsSupplierId, this.municipalityId);
                  }
                );
              }
            ); 
        }
      );
    }
    // End of constructor  
  }
  
  /*  -- METHODS -- */
  /* Get supplier details from supplierId requested through params */
  getSupplierDetails(supplierId, municipalityId) {
    this.supplierApi.getSupplierDetailsById(supplierId, municipalityId).subscribe(
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
  getSupplierMainContact(supplierId, municipalityId) {
    this.userApi.getSupplierMainContact(supplierId, municipalityId).subscribe(
      (supplierContact: UserDTOBase) => {
        this.supplierContactUser = supplierContact;
        console.log("Supplier contact user is ", this.supplierContactUser);
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
  private saveAndNotify() {    
    if(!this.application.supplierId) {
      this.application.supplierId = this.paramsSupplierId;
      this.assignSupplierAndNotify();
    }

    else if(this.changedSupplierChoice) {
      this.supplierApi.notifyRejectedSupplier(this.municipalityId).subscribe(
        (res: ResponseDTOBase) => {
          this.application.supplierId = this.paramsSupplierId;
          this.assignSupplierAndNotify();
        }
      );  
    } 
    
  }
  
  assignSupplierAndNotify() {
    this.applicationApi.assignSupplier(this.registration.municipalityId, this.application).subscribe(
      (resAplication: ResponseDTOBase) => {
        this.supplierApi.notifySelectedSupplier(this.municipalityId).subscribe(
          (res: ResponseDTOBase) => {
            this.changedSupplierChoice = false;
            this.router.navigate(['/beneficiary-portal/my-voucher']);
          }, error => {
            console.log("ERROR on email sending");
          }
        );
        
      }
    );
  }

// End of exported class
}