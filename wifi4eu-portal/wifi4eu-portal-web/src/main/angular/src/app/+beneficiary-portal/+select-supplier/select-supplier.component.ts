import { Component, OnInit, ViewChild } from '@angular/core';
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

import { SupplierApi, ResponseDTO, ApplicationDTOBase } from '../../shared/swagger';
import { SupplierDTOBase } from "../../shared/swagger/model/SupplierDTO";

import { Paginator, DataGrid } from 'primeng/primeng';


@Component({
  selector: 'app-+select-supplier',
  templateUrl: './select-supplier.component.html',
  providers: [ApplicationApi, CallApi, SupplierApi, MunicipalityApi, LauApi, NutsApi]
})
export class selectSupplierComponent {

  private supplier: SupplierDTOBase;
  private currentCall: CallDTOBase = new CallDTOBase();
  private user: UserDTOBase;
  private storedRegistrationQueues = [];
  private municipalities: MunicipalityDTOBase[] = [];
  private registration: RegistrationDTOBase;

  private suppliers: SupplierDTOBase[] = [];
  private searchSuppliersInput: string = '';
  private displayedSuppliers: SupplierDTOBase[] = [];
  private suppliersCopy: SupplierDTOBase[] = [];

  application: ApplicationDTOBase;
  selectedSupplier: SupplierDTOBase;
  displayMessage: boolean = false;
  disableButton: boolean = true;
  
  // region: NutsDTOBase = null;
  region: any = {};
  page: any = 0;
  itemsPerPageSelector = [10, 20, 50, 100];
  itemsPerPage: any = this.itemsPerPageSelector[1];
  municipality: object;

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
              console.log("Registrations has municipalityID " + registrations[0].municipalityId);

                this.municipalityApi.getMunicipalityById(registrations[0].municipalityId).subscribe(
                  (municipality: MunicipalityDTOBase) => {
                    this.municipalities.push(municipality);
                    console.log("Municipalities has lauId " + municipality.lauId);

                      this.lauApi.getLauById(municipality.lauId).subscribe(
                        (laus: LauDTOBase) => {
                          console.log("Laus has nuts3 code equal to " + laus.nuts3);
                        
                          this.nutsApi.getNutsByCode(laus.nuts3).subscribe(
                            (nuts: NutsDTOBase) => {
                              console.log("Nuts has id " + nuts.id);
                              this.region.id = nuts.id;
                              console.log("The type of this.region.id is " + typeof(this.region));
                              console.log(this.region.id);
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

  }

  /* Part 2: Get all suppliers that supply the specific region of the beneficiary */
  getSuppliers() {
    if(this.region.id != 0){
      console.log(this.region.id);
      this.supplierApi.getSuppliersListByRegionId(this.region.id).subscribe(
        (suppliers: SupplierDTOBase[]) => {
          console.log("Supplier list is ", suppliers);
          this.suppliers = suppliers;
          this.suppliersCopy = this.suppliers;
        });
    }        
  }

  /* Search bar */
  private searchSuppliers() {
        this.suppliers = this.suppliersCopy;
        this.displayedSuppliers = [];
        console.log("suppliers is ", this.suppliers);
        console.log("suppliers copy is ", this.suppliersCopy);
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

  /* Modal for supplier selection confirmation */
  private selectSupplier() {
    (this.displayMessage) ? this.displayMessage = false : this.displayMessage = true; 
    console.log("Selected supplier is ", this.selectedSupplier);
    this.getApplication();
  }

  /* Get current application of the beneficiary */
  private getApplication() {
    this.callApi.allCalls().subscribe(
      (calls: CallDTOBase[]) => {
        console.log("Call ID is ", calls[0].id);
        console.log("Registration FK is ", this.registration);
          this.applicationApi.getApplicationByCallIdAndRegistrationId(calls[0].id, this.registration.id).subscribe(
            (application: ApplicationDTOBase) => {
              this.application = application;
              if(application != null) {
                this.disableButton = false;
              }
            }
          );
      }
    );
  }

  /* Assign supplier Id to the benficiary application */
  private assignSupplier() {
    (this.displayMessage) ? this.displayMessage = false : this.displayMessage = true;
    this.application.supplierId = this.selectedSupplier.id; 
    console.log("Application sent is ", this.application);

    this.applicationApi.assignSupplier(this.application).subscribe(
      (resAplication: ApplicationDTOBase) => {
        console.log("Result of application saving is ", resAplication);
      }
    );
  }

}
