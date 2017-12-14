import {Component, Input, IterableDifferFactory} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {LauDTO, LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {MayorDTO,MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {MayorApi} from "../../shared/swagger/api/MayorApi";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {UserDTO,UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {UserApi} from "../../shared/swagger/api/UserApi";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {RegistrationDTO,RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";

import Any = jasmine.Any;
import {SelectItem} from "primeng/primeng";


@Component({
    templateUrl: 'beneficiary-registrations.component.html', providers: [BeneficiaryApi, LauApi]
})

export class DgConnBeneficiaryRegistrationsComponent {
    private mayors: MayorDTO[];
    private users: Array<Object>;
    private status: SelectItem[];
    private selectStatus: any[];
    private finalStatus: Array<String> = new Array<String>();


    constructor(private registrationApi:RegistrationApi, private userApi: UserApi, private beneficiaryApi: BeneficiaryApi, private lauApi: LauApi, private mayorApi:MayorApi) {

        this.selectStatus = [];
        this.status = [];
        this.status.push({label: 'Undefined', value: {id: 1, name: 'Undefined', code: 'UF'}});
        this.status.push({label: 'Active', value: {id: 2, name: 'Active', code: 'OK'}});
        this.status.push({label: 'Declined', value: {id: 3, name: 'Declined', code: 'KO'}});
        this.users = [];

        this.registrationApi.allRegistrations().subscribe(
            registrations =>{
                registrations.pop()
                
            },
            error => console.log(error)
        );

        this.userApi.getUsersByType(0).subscribe(
            users => {

            },
            error => {

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