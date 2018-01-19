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

  /* private mayors: MayorDTO[];
  private users: Array<Object>;
  private status: SelectItem[];
  private selectStatus: any[];
  private finalStatus: Array<String> = new Array<String>(); */

  customRegistrationList: any[] = [];
  registrationListOriginal: any[] = [];
  rowsPerPageOptions = [5, 10, 20];
  numberRowsTable = this.rowsPerPageOptions[1];
  inputSearch = "";

  constructor(private registrationApi: RegistrationApi, private userApi: UserApi, private lauApi: LauApi, private mayorApi: MayorApi, private municipalityApi: MunicipalityApi) {

   /*  this.selectStatus = [];
    this.status = [];
    this.status.push({ label: 'Undefined', value: { id: 1, name: 'Undefined', code: 'UF' } });
    this.status.push({ label: 'Active', value: { id: 2, name: 'Active', code: 'OK' } });
    this.status.push({ label: 'Declined', value: { id: 3, name: 'Declined', code: 'KO' } });
    this.users = []; */

    this.registrationApi.allRegistrations().subscribe(
      registrations => {
        registrations.forEach((registration: RegistrationDTOBase) => {
          var _registration = {
            'registration': registration,
            'user': null,
            'municipality': null
          };
          _registration.registration = registration;
          userApi.getUserById(registration.userId).subscribe(
            user => {
              _registration.user = user;
              municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                municipality => {
                  municipality['addressFull'] = `${municipality['address']} - ${municipality['addressNum']}`
                  user['userFull'] = `${user['name']} - ${user['surname']}`
                  _registration.municipality = municipality;
                  this.registrationListOriginal.push(_registration);
                  this.customRegistrationList.push(_registration);
                }
              )
            }
          );
        });
      }
    );

    // this.mayorApi.allMayors().subscribe(
    //     mayors => {
    //         this.mayors = mayors;
    //         for (let mayor of this.mayors) {
    //             this.beneficiaryApi.getLegalEntity(mayor.legalEntityId).subscribe(
    //                 (entity: LegalEntityDTO) => {
    //                     this.lauApi.findLauByLau2AndCountryCode(entity.municipalityCode, entity.countryCode).subscribe(
    //                         (lauResult: LauDTO) => {
    //                             let tableRow = {
    //                                 name: mayor.name + ' ' + mayor.surname,
    //                                 nuts: lauResult.nuts3,
    //                                 address: entity.address,
    //                                 status: this.status,
    //                                 duplicated: false,
    //                                 type: 2,
    //                                 mayor: mayor
    //                             };

    //                             this.finalStatus.push(mayor.status);

    //                             for (let i = 0; i < this.users.length; i++) {
    //                                 if (this.users[i]['nuts'] == tableRow['nuts']) {
    //                                     let editedRow = this.users[i];
    //                                     tableRow['duplicated'] = true;
    //                                     editedRow['duplicated'] = true;
    //                                     this.users[i] = editedRow;
    //                                 }
    //                             }
    //                             this.users.push(tableRow);
    //                         }
    //                     );
    //                 }
    //             );
    //         }
    //     }

    //     ,
    //     error => console.log(error)
    // )
    // ;

    // this.beneficiaryApi.getRepresentatives().subscribe(
    //     representatives => {
    //         this.representatives = representatives;
    //         for (let representatives of this.representatives) {
    //             this.beneficiaryApi.getMayorById(representatives.mayorId).subscribe(
    //                 (entity: MayorDTO) => {
    //                     this.beneficiaryApi.getLegalEntity(entity.legalEntityId).subscribe(
    //                         (legalEntity: LegalEntityDTO) => {
    //                             this.lauApi.findLauByLau2AndCountryCode(legalEntity.municipalityCode, legalEntity.countryCode).subscribe(
    //                                 (lauResult: LauDTO) => {
    //                                     let tableRow = {
    //                                         name: representatives.name + ' ' + representatives.surname,
    //                                         nuts: lauResult.nuts3,
    //                                         address: legalEntity.address,
    //                                         status: this.status,
    //                                         duplicated: false,
    //                                         type: 3,
    //                                         representative: representatives
    //                                     };

    //                                     this.finalStatus.push(representatives.status);

    //                                     for (let i = 0; i < this.users.length; i++) {
    //                                         if (this.users[i]['nuts'] == tableRow['nuts']) {
    //                                             let editedRow = this.users[i];
    //                                             tableRow['duplicated'] = true;
    //                                             editedRow['duplicated'] = true;
    //                                             this.users[i] = editedRow;

    //                                         }
    //                                     }
    //                                     this.users.push(tableRow);
    //                                 }
    //                             );
    //                         }
    //                     );
    //                 }
    //             );
    //         }
    //     },

    //     error => console.log(error)
    // );

  }

  /* paginate(event) {
    var localList = this.registrationListOriginal;
    if (this.tableBeneficiary) {
      localList = localList.slice(event.first, (event.first + event.rows));
      this.customRegistrationList = [...localList];
    }
  }
 */
  filterData(stringSearch: string) {
    if(typeof stringSearch != "undefined" && stringSearch != ""){
      stringSearch = stringSearch.toLocaleLowerCase();
      let registrations =  this.registrationListOriginal.map(
        (registration) => {
          registration.municipality.name = registration.municipality.name || "";
          registration.municipality.country = registration.municipality.country || "";
          return registration;
        }
      ).filter(element => { 
        return (element.municipality.name.toLocaleLowerCase().match(stringSearch) || element.municipality.country.toLocaleLowerCase().match(stringSearch))
      });
      this.customRegistrationList = [...registrations];
    }
    else{
      this.customRegistrationList = [...this.registrationListOriginal];
    }
  }

  // uploadData(user: any, index: number) {
  //     if (user['type'] == 2) {
  //         let updatedMayor: MayorDTO = user['mayor'];
  //         updatedMayor.status = this.selectStatus[index]['code'];
  //         this.beneficiaryApi.saveMayor(updatedMayor).subscribe(
  //             result => {

  //             }
  //         ), error => {
  //             console.log(error);

  //         }
  //     } else if (user['type'] == 3) {
  //         let updatedRepresentative: RepresentativeDTO = user['representative'];
  //         updatedRepresentative.status = this.selectStatus[index]['code'];
  //         this.beneficiaryApi.saveRepresentative(updatedRepresentative).subscribe(
  //             result => {

  //             }
  //         ), error => {
  //             console.log(error);

  //         }
  //     }
  // }

}