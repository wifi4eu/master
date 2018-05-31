/* -- IMPORTS -- */
// Angular features 
import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { LocalStorageService } from "angular-2-local-storage";

// Project Api's
import { MunicipalityApi, RegistrationApi, CallApi, ApplicationApi, CallDTOBase, RegistrationDTOBase, ApplicationDTOBase, SupplierApi, SupplierDTOBase } from "../../shared/swagger";

// Project DTO's
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";

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

  // Date supplier was selected
  private selectionDate: Date;
  private localeDate: Array<String>;
  private displayedDate: String;


  constructor(
    private route: ActivatedRoute,
    private localStorage: LocalStorageService,
    private municipalityApi: MunicipalityApi,
    private registrationApi: RegistrationApi,
    private callApi: CallApi,
    private applicationApi: ApplicationApi,
    private supplierApi: SupplierApi
  ) {
    /* Observable<string> */
    const id: any = route.params.map(p => p.id);
    this.municipalityId = id.source.value.municipalityId;
    console.log("The municiplaity id is ", id.source.value.municipalityId);
    
    this.municipalityApi.getMunicipalityById(this.municipalityId).subscribe(
      (municipality: MunicipalityDTOBase) => {
        this.municipality = municipality;
        console.log("Obtained municipality is ", municipality);
      });    

      
      
      
      
      let storedUser = this.localStorage.get('user');
      this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
      let storedRegistrations = this.localStorage.get('registrationQueue') ? JSON.parse(this.localStorage.get('registrationQueue').toString()) : null;
      this.storedRegistrationQueues = storedRegistrations ? storedRegistrations : [];
    
      if (this.user != null) {
        this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
          (registrations: RegistrationDTOBase[]) => {
            this.registration = registrations[0];
            
            // Check if there are Calls
          this.callApi.allCalls().subscribe(
            (calls: CallDTOBase[]) => {
              // Get current application of the beneficiary
                  this.applicationApi.getApplicationByCallIdAndRegistrationId(calls[0].id, this.registration.id).subscribe(
                    (application: ApplicationDTOBase) => {
                      this.application = application;
                      console.log("Application is: ", this.application);
                      this.getSupplierDetails();  
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
      getSupplierDetails() {
        this.supplierApi.getSupplierDetailsById(this.application.supplierId).subscribe(
          (supplier: SupplierDTOBase) => {            
            this.supplier = supplier;
          }
        );
        // Get the date when supplier was selected
        this.getStringDate(this.application.date);
      }

      /* Get displayed string date from epoch number */
      private getStringDate(epoch) {
        this.selectionDate = new Date(epoch);
        this.localeDate = this.selectionDate.toLocaleDateString().split(' ');
        this.displayedDate = this.localeDate[0];
      }


      /* Allow beneficiary to change selected supplier */
      private changeSupplier() {

      }

      /* Assign supplier to the beneficiary application */
      private assignSupplier() {
        
      }

// End of exported class
}