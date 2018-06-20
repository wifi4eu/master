/* -- IMPORTS -- */
// Angular features 
import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { LocalStorageService } from "angular-2-local-storage";
import { Router } from '@angular/router';

// Project Api's
import { MunicipalityApi, RegistrationApi, CallApi, ApplicationApi, CallDTOBase, RegistrationDTOBase, ApplicationDTOBase, SupplierApi, SupplierDTOBase, ResponseDTOBase } from "../../shared/swagger";

// Project DTO's
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { Observable } from "rxjs";

@Component ({
  selector: 'selected-supplier-component',
  templateUrl: './selected-supplier-details.component.html',
  providers: [MunicipalityApi, RegistrationApi, CallApi, ApplicationApi, SupplierApi]
})

export class SelectedSupplierDetailsComponent {
  
  /* -- PROPERTIES -- */
  // Project DTO's
  private municipality: MunicipalityDTOBase;
  private registration: RegistrationDTOBase;
  private call: CallDTOBase;
  private application: ApplicationDTOBase;
  private supplier: SupplierDTOBase;

  // User characteristics
  private user: UserDTOBase;
  private storedRegistrationQueues = [];
  
  // Component specific properties
  private municipalityId: number;
  private paramsSupplierId: number;
  private changedSupplierChoice: boolean = false;

  // Date supplier was selected
  private selectionDate: Date;
  private localeDate: Array<String>;
  private displayedDate: String;
  private displayDate: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private localStorage: LocalStorageService,
    private router: Router,
    private municipalityApi: MunicipalityApi,
    private registrationApi: RegistrationApi,
    private callApi: CallApi,
    private applicationApi: ApplicationApi,
    private supplierApi: SupplierApi
  ) {

  /* Observable<string> */
  this.route.params.subscribe(
    params => {
        this.municipalityId = Number(params['municipalityId']);
        this.paramsSupplierId = Number(params['supplierId']);
    }
  );
  
  this.municipalityApi.getMunicipalityById(this.municipalityId).subscribe(
    (municipality: MunicipalityDTOBase) => {
      this.municipality = municipality;
    }
  );    

  let storedUser = this.localStorage.get('user');
  this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
  let storedRegistrations = this.localStorage.get('registrationQueue') ? JSON.parse(this.localStorage.get('registrationQueue').toString()) : null;
  this.storedRegistrationQueues = storedRegistrations ? storedRegistrations : [];

  if (this.user != null) {
    this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
      (registrations: RegistrationDTOBase[]) => {
        this.registration = registrations[1];
        
        // Check if there are Calls
      this.callApi.allCalls().subscribe(
        (calls: CallDTOBase[]) => {
          // Get current application of the beneficiary
              this.applicationApi.getApplicationByCallIdAndRegistrationId(calls[0].id, this.registration.id).subscribe(
                (application: ApplicationDTOBase) => {
                  this.application = application;
                  if(this.application.supplierId !== this.paramsSupplierId) {
                    this.changedSupplierChoice = true;
                  }
                  console.log("Present application is ", this.application);
                  this.getSupplierDetails(this.paramsSupplierId);  
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
  // Get supplier details from supplierId requested through params
  getSupplierDetails(supplierId) {
    this.supplierApi.getSupplierDetailsById(supplierId).subscribe(
      (supplier: SupplierDTOBase) => {            
        this.supplier = supplier;
      }
    );
    // Get the date when supplier was selected if the supplier hasn't changed his choice
    if((this.application.supplierId === this.paramsSupplierId) && (this.application.supplierId != (null || undefined || 0)) )  {
      this.getStringDate(this.application.date);
      this.displayDate = true; 
    }
  }

  /* Get displayed string date from epoch number */
  private getStringDate(epoch) {
    this.selectionDate = new Date(epoch);
    this.localeDate = this.selectionDate.toLocaleDateString().split(' ');
    this.displayedDate = this.localeDate[0];
  }

  /* Allow beneficiary to change selected supplier */
  private changeSupplier() {
    this.router.navigate(['/beneficiary-portal/select-supplier', this.municipality.id]);
  }
  
  /* Assign supplier to the beneficiary application */
  private saveAndNotify() {
    console.log("Municipality ID is ", this.municipality.id);
    console.log("Previous supplier id was ", this.application.supplierId);
    console.log("Supplier Id being selected is ", this.paramsSupplierId);
    
    if(this.application.supplierId == (null || undefined || 0)) {
      this.application.supplierId = this.paramsSupplierId;
      this.assignSupplierAndNotify();
    }

    else if(this.changedSupplierChoice) {
      this.supplierApi.notifyRejectedSupplier(this.municipalityId).subscribe(
        (res: ResponseDTOBase) => {
          console.log("Result of rejections is ", res);
          this.application.supplierId = this.paramsSupplierId;
          this.assignSupplierAndNotify();
        }
      );  
    } 
    
    console.log("-- End of method --")
    this.changedSupplierChoice = false;
    // this.router.navigate(['/beneficiary-portal/my-voucher']);
  }
  
  assignSupplierAndNotify() {
    this.applicationApi.assignSupplier(this.application).subscribe(
      (resAplication: ResponseDTOBase) => {
        // this.getStringDate(resAplication.data.date);
        console.log("New supplier saved!!");
        
        this.supplierApi.notifySelectedSupplier(this.municipality.id).subscribe(
          (res: ResponseDTOBase) => {
            console.log("The result of sending email is ", res);
          }, error => {
            console.log("An ERROR ocurred");
          }
        );

      }
    );
  }

// End of exported class
}