import { Component, OnInit, ViewChild, HostListener } from '@angular/core';
import { RegistrationDTOBase } from "../../shared/swagger/model/RegistrationDTO";
import { CallApi } from "../../shared/swagger/api/CallApi";
import { CallDTOBase } from "../../shared/swagger/model/CallDTO";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { LocalStorageService } from "angular-2-local-storage";
import { RegistrationApi } from "../../shared/swagger/api/RegistrationApi";
import { MunicipalityApi } from "../../shared/swagger/api/MunicipalityApi";
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { LauApi } from "../../shared/swagger/api/LauApi";
import { LauDTOBase } from "../../shared/swagger/model/LauDTO";
import { NutsApi } from "../../shared/swagger/api/NutsApi";
import { NutsDTOBase } from "../../shared/swagger/model/NutsDTO";

import { ApplicationApi } from "../../shared/swagger/api/ApplicationApi";

import { SupplierApi, ResponseDTO, ApplicationDTOBase, SuppliedRegionDTOBase } from '../../shared/swagger';
import { SupplierDTOBase } from "../../shared/swagger/model/SupplierDTO";

import { Paginator, DataGrid } from 'primeng/primeng';


@Component({
  selector: 'app-+select-supplier',
  templateUrl: './select-supplier.component.html',
  providers: [ApplicationApi, CallApi, SupplierApi, MunicipalityApi, LauApi, NutsApi]
})
export class selectSupplierComponent {

  /* To get municipality region */
  private currentCall: CallDTOBase = new CallDTOBase();
  private user: UserDTOBase;
  private storedRegistrationQueues = [];
  private municipality: MunicipalityDTOBase;
  private municipalities: MunicipalityDTOBase[] = [];
  private registration: RegistrationDTOBase;
  private region: NutsDTOBase = {};
  
  /* To get region suppliers */
  private supplier: SupplierDTOBase;
  private suppliers: SupplierDTOBase[] = [];
  private searchSuppliersInput: string = '';
  private displayedSuppliers: SupplierDTOBase[] = [];
  private suppliersCopy: SupplierDTOBase[] = [];

  /* Assigning supplier and feedback settings */
  private application: ApplicationDTOBase;
  private selectedSupplier: SupplierDTOBase;
  private displayMessage: boolean = false;
  private hasSupplierAssigned: boolean = false;
  
  /* Datatable */
  private page: any = 0;
  private itemsPerPageSelector = [10, 20, 50, 100];
  private itemsPerPage: any = this.itemsPerPageSelector[1];

  @ViewChild("gridSuppliers") gridSuppliers: DataGrid;
  @ViewChild("paginator") paginator: Paginator;

  /* Search for the registered suppliers in the specific supplied region of the beneficiary */ 
  /* Part 1: Get region FK specific to the beneficiary */
  constructor(private applicationApi: ApplicationApi, private supplierApi: SupplierApi, private callApi: CallApi, private localStorage: LocalStorageService, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private lauApi: LauApi, private nutsApi: NutsApi) { 
    
    
    
    let storedUser = this.localStorage.get('user');
    this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
    let storedRegistrations = this.localStorage.get('registrationQueue') ? JSON.parse(this.localStorage.get('registrationQueue').toString()) : null;
    this.storedRegistrationQueues = storedRegistrations ? storedRegistrations : [];
    // Check if there are Calls
    if (this.user != null) {
      this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
        (registrations: RegistrationDTOBase[]) => {
          this.registration = registrations[0];
          
          /* Get current application of the beneficiary */
            this.callApi.allCalls().subscribe(
              (calls: CallDTOBase[]) => {
                  this.applicationApi.getApplicationByCallIdAndRegistrationId(calls[0].id, this.registration.id).subscribe(
                    (application: ApplicationDTOBase) => {
                      this.application = application;
                      if (application.supplierId != (null || undefined || 0)) {
                        this.hasSupplierAssigned = true;
                      }

                      this.municipalityApi.getMunicipalityById(registrations[0].municipalityId).subscribe(
                        (municipality: MunicipalityDTOBase) => {
                          this.municipalities.push(municipality);
                            this.lauApi.getLauById(municipality.lauId).subscribe(
                              (laus: LauDTOBase) => {
                                this.nutsApi.getNutsByCode(laus.nuts3).subscribe(
                                  (nuts: NutsDTOBase) => {
                                    this.region.id = nuts.id;
                                    this.getSuppliers();
                                  }
                                );    
                              }
                            );
                        }
                      );  
                  
                    }
                  );
              }
            );

        }
      );
    }
  
}

  /* Part 2: Get all suppliers that supply the specific region of the beneficiary */
  getSuppliers() {
    // Get all suppliers of beneficiary region
    if(this.region.id != 0){
      this.supplierApi.getSuppliersListByRegionId(this.region.id).subscribe(
        (suppliers: SupplierDTOBase[]) => {
          this.suppliers = suppliers;
          this.suppliersCopy = this.suppliers;

          // Get previously selected supplier (if already applied)
          if(this.hasSupplierAssigned) {
            this.supplierApi.getSupplierById(this.application.supplierId).subscribe(
              (supplier: SupplierDTOBase) => {
                // THIS CODE SHOULD BE UNCOMENTED!!
                // this.selectedSupplier = supplier;      
              }
            );
            // THIS IS A PROVISIONAL CODE!!
            this.selectedSupplier = this.suppliers[1];
          }

        }
      );
    }
  }

  /* Search bar */
  private searchSuppliers() {
    this.suppliers = this.suppliersCopy;
    this.displayedSuppliers = [];
    for (let supplier of this.suppliers) {
      if (supplier.name && supplier.vat) {
        if (supplier.name.toLowerCase().indexOf(this.searchSuppliersInput.toLowerCase()) != -1 ||
            supplier.vat.toLowerCase().indexOf(this.searchSuppliersInput.toLowerCase()) != -1) {
              this.displayedSuppliers.push(supplier);
            }
        this.suppliers = this.displayedSuppliers;
      }
    }
  }

  /* Toggles boolean to allow you select a new supplier */
  private changeSupplier() {
    (this.hasSupplierAssigned) ? this.hasSupplierAssigned = false : this.hasSupplierAssigned = true;
  }

  /* Modal for supplier selection confirmation */
  private selectSupplier() {
    (this.displayMessage) ? this.displayMessage = false : this.displayMessage = true; 
  }

  /* Assign supplier Id to the benficiary application */
  private assignSupplier() {
    (this.displayMessage) ? this.displayMessage = false : this.displayMessage = true;
    this.application.supplierId = this.selectedSupplier.id; 

    this.applicationApi.assignSupplier(this.application).subscribe(
      (resAplication: ApplicationDTOBase) => {
      }
    );
    this.hasSupplierAssigned = true;
  }

}
