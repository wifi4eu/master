import { Component, OnInit, ViewChild, HostListener } from '@angular/core';
import { RegistrationDTOBase } from "../../shared/swagger/model/RegistrationDTO";
import { CallApi } from "../../shared/swagger/api/CallApi";
import { CallDTOBase } from "../../shared/swagger/model/CallDTO";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { LocalStorageService } from "angular-2-local-storage";
import { RegistrationApi } from "../../shared/swagger/api/RegistrationApi";
import { MunicipalityApi } from "../../shared/swagger/api/MunicipalityApi";
import { MunicipalityDTOBase, MunicipalityDTO } from "../../shared/swagger/model/MunicipalityDTO";
import { LauApi } from "../../shared/swagger/api/LauApi";
import { LauDTOBase } from "../../shared/swagger/model/LauDTO";
import { NutsApi } from "../../shared/swagger/api/NutsApi";
import { NutsDTOBase } from "../../shared/swagger/model/NutsDTO";

import { ApplicationApi } from "../../shared/swagger/api/ApplicationApi";

import { SupplierApi, ResponseDTO, ApplicationDTOBase, SuppliedRegionDTOBase } from '../../shared/swagger';
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import { SupplierDTOBase } from "../../shared/swagger/model/SupplierDTO";

import { Paginator, DataGrid } from 'primeng/primeng';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-+select-supplier',
  templateUrl: './select-supplier.component.html',
  providers: [ApplicationApi, CallApi, SupplierApi, MunicipalityApi, LauApi, NutsApi]
})
export class SelectSupplierComponent {

  /* To get municipality region */
  private currentCall: CallDTOBase = new CallDTOBase();
  private user: UserDTOBase;
  private storedRegistrationQueues = [];
  private municipality: MunicipalityDTOBase;
  private municipalities: MunicipalityDTOBase[] = [];
  private municipalityId: number;
  private registration: RegistrationDTOBase;
  private region: NutsDTOBase = {};
  private calls: CallDTOBase[];
  
  /* To get region suppliers */
  private supplier: SupplierDTOBase;
  private suppliers: SupplierDTOBase[] = [];
  private searchSuppliersInput: string = '';
  private displayedSuppliers: SupplierDTOBase[] = [];
  private suppliersCopy: SupplierDTOBase[] = [];
  
  /* Assigning supplier and feedback settings */
  private application: ApplicationDTOBase;
  private selectedSupplier: SupplierDTOBase;
  private oldSupplier: SupplierDTOBase;
  private selectionDate: Date;
  private localeDate: Array<String>;
  private displayedDate: String;
  private displayConfirmModal: boolean = false;
  private hasSupplierAssigned: boolean = true;
  private displayChangeModal: boolean = false;
  
  /* Datatable */
  private page: any = 0;
  private itemsPerPageSelector = [10, 20, 50, 100];
  private itemsPerPage: any = this.itemsPerPageSelector[1];
  
  @ViewChild("gridSuppliers") gridSuppliers: DataGrid;
  @ViewChild("paginator") paginator: Paginator;
  
  constructor(
    private applicationApi: ApplicationApi,
    private supplierApi: SupplierApi,
    private callApi: CallApi,
    private localStorage: LocalStorageService,
    private registrationApi: RegistrationApi,
    private municipalityApi: MunicipalityApi,
    private lauApi: LauApi,
    private nutsApi: NutsApi,
    private router: Router,
    private route: ActivatedRoute
  ) { 
  /* Search for the registered suppliers in the specific supplied region of the beneficiary */ 
    /* Get params from URL */
    const municipalityId: any = route.params.map(p => p.id);
    this.municipalityId = Number(municipalityId.source.value.municipalityId);    
    
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
                        
                        /* Check if the application already has a supplier assigned */
                        if (!application.supplierId) {
                          this.hasSupplierAssigned = false;
                        }
  
                        /* Get validated suppliers given a municipalityId */
                        this.municipalityApi.getMunicipalityById(this.registration.municipalityId).subscribe(
                          (municipality: MunicipalityDTOBase) => {
  
                            if(municipality != null) {
                              this.supplierApi.getValidatedSuppliersListByMunicipalityId(this.municipalityId, this.registration.id, this.calls[(calls.length-1)].id, this.application.id, new Date().getTime()).subscribe(
                              (suppliers: SupplierDTOBase[]) => {
                                this.suppliers = suppliers;
                                this.suppliersCopy = this.suppliers;
                      
                                /* Get previously selected supplier (if it exists) */
                                if(this.hasSupplierAssigned) {
                                  this.supplierApi.getDetailsBySupplierId(this.application.supplierId, this.calls[(calls.length-1)].id, this.registration.id, this.application.id).subscribe(
                                    (supplier: SupplierDTOBase) => {
                                      for(var i = 0; i < this.suppliers.length; i++) {
                                        if(this.suppliers[i].id == supplier.id) {
                                          this.selectedSupplier = this.suppliers[i];
                                          this.oldSupplier = this.suppliers[i];
                                          break;
                                        } 
                                      }
                                    }
                                  );
                                  /* Get the date when supplier was selected */
                                  this.getStringDate(this.application.date);
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
          );

        }
      );
    }
  // End of constructor  
  }
        
  /*  --- METHODS ---- */   
  /* Search bar */
  private searchSuppliers() {
    this.suppliers = this.suppliersCopy;
    this.displayedSuppliers = [];
    for (let supplier of this.suppliers) {
      if (supplier.name && supplier.vat) {
        if (supplier.name.toLowerCase().indexOf(this.searchSuppliersInput.toLowerCase()) != -1) {
          this.displayedSuppliers.push(supplier);
        }
        this.suppliers = this.displayedSuppliers;
      }
    }
  }

  /* Toggles boolean to allow you select a new supplier: REMOVED IN NEW BR 4.1 */
  // Method removed with new Business Requirements 4.1 
  // private changeSupplier() {
  //  (this.hasSupplierAssigned) ? this.hasSupplierAssigned = false : this.hasSupplierAssigned = true;
  // }
  
  /* Get displayed string date from epoch number */
  private getStringDate(epoch) {
    this.selectionDate = new Date(epoch);
    this.localeDate = this.selectionDate.toLocaleDateString().split(' ');
    this.displayedDate = this.localeDate[0];
  }

  /* --- CHANGE SUPPLIER MODAL --- */
  /* Triggers when user clicks on a new row to detect if he changed supplier */
  private onRowSelect() {
    if(this.hasSupplierAssigned) {
      (this.displayChangeModal) ? this.displayChangeModal = false : this.displayChangeModal = true;
    }
    this.hasSupplierAssigned = true;
  }

  /* Comes back to stato quo (before clicking on any row) */ 
  private cancelChange() {
    this.selectedSupplier = this.oldSupplier;
    this.onRowSelect();
  }

  /* Allows you click again in "Select installation company" button */
  private confirmChange() {
    this.router.navigate(['/beneficiary-portal/selected-supplier-details', this.municipalityId, this.selectedSupplier.id]);
  }

  /* --- CONFIRM SUPPLIER MODAL --- */
  /* Modal for supplier selection confirmation */
  private selectSupplier() {
    (this.displayConfirmModal) ? this.displayConfirmModal = false : this.displayConfirmModal = true; 
  }

  /* Access to the supplier details which is the final confirmation screen */
  private confirmSupplier() {
    (this.displayConfirmModal) ? this.displayConfirmModal = false : this.displayConfirmModal = true;
    this.router.navigate(['/beneficiary-portal/selected-supplier-details', this.municipalityId, this.selectedSupplier.id]);
  }
  
// End of exported class
}
