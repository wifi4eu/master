import { Component, Input, IterableDifferFactory } from "@angular/core";
import { DgConnDetails } from "../dgconnportal-details.model";
import { LauDTO, LauDTOBase } from "../../shared/swagger/model/LauDTO";
import { MayorDTO, MayorDTOBase } from "../../shared/swagger/model/MayorDTO";
import { MayorApi } from "../../shared/swagger/api/MayorApi";
import { BeneficiaryApi } from "../../shared/swagger/api/BeneficiaryApi";
import { LauApi } from "../../shared/swagger/api/LauApi";
import { UserDTO, UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { UserApi } from "../../shared/swagger/api/UserApi";
import { RegistrationApi } from "../../shared/swagger/api/RegistrationApi";
import { RegistrationDTO, RegistrationDTOBase } from "../../shared/swagger/model/RegistrationDTO";

import Any = jasmine.Any;
import { SelectItem, DataTable } from "primeng/primeng";
import { MunicipalityApi } from "app/shared/swagger";
import { ViewChild } from "@angular/core";

@Component({
  templateUrl: 'beneficiary-registrations.component.html', providers: [BeneficiaryApi, LauApi, MayorApi, UserApi, MunicipalityApi]
})

export class DgConnBeneficiaryRegistrationsComponent {

  @ViewChild('tableBeneficiary') tableBeneficiary: DataTable;
  
  registrationListOriginal: any[] = [];
  rowsPerPageOptions = [5, 10, 20];
  numberRowsTable = this.rowsPerPageOptions[1];
  inputSearch = "";

  registrationList: any[] = [];

  constructor(private registrationApi: RegistrationApi, private beneficiaryApi: BeneficiaryApi, private userApi: UserApi, private lauApi: LauApi, private mayorApi: MayorApi, private municipalityApi: MunicipalityApi) {
   
    this.beneficiaryApi.getBeneficiaryRegistrations().subscribe(
      data => {
        this.registrationList = data;
        this.registrationListOriginal = data;
      }
    )
  }

  filterData(stringSearch: string) {
    if(typeof stringSearch != "undefined" && stringSearch != ""){
      stringSearch = stringSearch.toLocaleLowerCase();
      let registrations =  this.registrationListOriginal.map(
        (registration) => {
          registration.lau.name1 = registration.lau.name1 || "";
          registration.lau.countryCode = registration.lau.countryCode || "";
          return registration;
        }
      ).filter(element => { 
        return (element.lau.name1.toLocaleLowerCase().match(stringSearch) || element.lau.countryCode.toLocaleLowerCase().match(stringSearch))
      });
      this.registrationList = [...registrations];
    }
    else{
      this.registrationList = [...this.registrationListOriginal];
    }
  }

}