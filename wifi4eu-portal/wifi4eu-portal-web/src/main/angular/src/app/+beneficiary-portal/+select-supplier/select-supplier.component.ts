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

import { SupplierApi, ResponseDTO } from '../../shared/swagger';
import { SupplierDTOBase } from "../../shared/swagger/model/SupplierDTO";

import { Paginator, DataGrid } from 'primeng/primeng';


@Component({
  selector: 'app-+select-supplier',
  templateUrl: './select-supplier.component.html',
  providers: [CallApi, SupplierApi, MunicipalityApi, LauApi, NutsApi]
})
export class selectSupplierComponent {
  private supplier: SupplierDTOBase;
  private currentCall: CallDTOBase = new CallDTOBase();
  private user: UserDTOBase;
  private storedRegistrationQueues = [];
  private municipalities: MunicipalityDTOBase[] = [];

  private suppliers: SupplierDTOBase[] = [];
  private searchSuppliersInput: string = '';
  private displayedSuppliers: SupplierDTOBase[] = [];
  private suppliersCopy: SupplierDTOBase[] = [];

  selectedSupplier: SupplierDTOBase;

  // region: NutsDTOBase = null;
  region: any = {};
  page: any = 0;
  itemsPerPageSelector = [10, 20, 50, 100];
  itemsPerPage: any = this.itemsPerPageSelector[1];

  
  suppliersData: Array<Object> = [
    {
      logo: null,
      companyName: "VODAFONE",
      address: "Rue Royale 15, 123456, Paris, France",
      companyWebsite: "vodafone.com",
      vatNumber: "AB123456789"
    }, {
      logo: null,
      companyName: "VODAFONE",
      address: "Rue Royale 15, 123456, Paris, France",
      companyWebsite: "vodafone.com",
      vatNumber: "AB123456789"
    },     {
      logo: null,
      companyName: "VODAFONE",
      address: "Rue Royale 15, 123456, Paris, France",
      companyWebsite: "vodafone.com",
      vatNumber: "AB123456789"
    },    {
      logo: null,
      companyName: "VODAFONE",
      address: "Rue Royale 15, 123456, Paris, France",
      companyWebsite: "vodafone.com",
      vatNumber: "AB123456789"
    },
  ]
  municipality: object;

  @ViewChild("gridSuppliers") gridSuppliers: DataGrid;
  @ViewChild("paginator") paginator: Paginator;

  constructor(private supplierApi: SupplierApi, private callApi: CallApi, private localStorage: LocalStorageService, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private lauApi: LauApi, private nutsApi: NutsApi) { 
    let storedUser = this.localStorage.get('user');
    this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
    let storedRegistrations = this.localStorage.get('registrationQueue') ? JSON.parse(this.localStorage.get('registrationQueue').toString()) : null;
    this.storedRegistrationQueues = storedRegistrations ? storedRegistrations : [];
    // Check if there are Calls
    if (this.user != null) {
        this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
            (registrations: RegistrationDTOBase[]) => {
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

}
