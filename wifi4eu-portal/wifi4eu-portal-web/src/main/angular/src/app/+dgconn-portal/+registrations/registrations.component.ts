import {Component, Input, IterableDifferFactory} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {MayorDTO, MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {LauDTO, LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {RepresentativeDTO, RepresentativeDTOBase} from "../../shared/swagger/model/RepresentativeDTO";
import {LegalEntityDTO, LegalEntityDTOBase} from "../../shared/swagger/model/LegalEntityDTO";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {LauApi} from "../../shared/swagger/api/LauApi";


import Any = jasmine.Any;
import {SelectItem} from "primeng/primeng";


@Component({
    templateUrl: 'registrations.component.html', providers: [BeneficiaryApi, LauApi]
})

export class DgConnRegistrationsComponent {
    private mayors: MayorDTO[];
    private representatives: RepresentativeDTO[];
    private users: Array<Object>;
    status: SelectItem[];
    selectStatus: any[];
    private finalStatus: String;
    private mayorId: number;


    constructor(private beneficiaryApi: BeneficiaryApi, private lauApi: LauApi) {
        this.selectStatus = [];
        this.status = [];
        this.status.push({label: 'Undefined', value: {id: 1, name: 'Undefined', code: 'UF'}});
        this.status.push({label: 'Active', value: {id: 2, name: 'Active', code: 'OK'}});
        this.status.push({label: 'Declined', value: {id: 3, name: 'London', code: 'KO'}});
        this.users = [];


        this.beneficiaryApi.getMayors().subscribe(
            mayors => {
                this.mayors = mayors;
                for (let mayor of this.mayors) {
                    this.beneficiaryApi.getLegalEntity(mayor.legalEntityId).subscribe(
                        (entity: LegalEntityDTO) => {
                            this.lauApi.findLauByLau2AndCountryCode(entity.municipalityCode, entity.countryCode).subscribe(
                                (lauResult: LauDTO) => {
                                    let tableRow = {
                                        name: mayor.name + ' ' + mayor.surname,
                                        nuts: lauResult.nuts3,
                                        address: entity.address,
                                        status: this.status,
                                        duplicated: false,
                                        type: 2,
                                        mayor: mayor
                                    };
                                    for (let i = 0; i < this.users.length; i++) {
                                        if (this.users[i]['nuts'] == tableRow['nuts']) {
                                            let editedRow = this.users[i];
                                            tableRow['duplicated'] = true;
                                            editedRow['duplicated'] = true;
                                            this.users[i] = editedRow;
                                        }
                                    }
                                    this.users.push(tableRow);
                                }
                            );
                        }
                    );
                }
            }

            ,
            error => console.log(error)
        )
        ;

        this.beneficiaryApi.getRepresentatives().subscribe(
            representatives => {
                this.representatives = representatives;
                for (let representatives of this.representatives) {
                    this.beneficiaryApi.getMayorById(representatives.mayorId).subscribe(
                        (entity: MayorDTO) => {
                            this.beneficiaryApi.getLegalEntity(entity.legalEntityId).subscribe(
                                (legalEntity: LegalEntityDTO) => {
                                    this.lauApi.findLauByLau2AndCountryCode(legalEntity.municipalityCode, legalEntity.countryCode).subscribe(
                                        (lauResult: LauDTO) => {
                                            let tableRow = {
                                                name: representatives.name + ' ' + representatives.surname,
                                                nuts: lauResult.nuts3,
                                                address: legalEntity.address,
                                                status: this.status,
                                                duplicated: false,
                                                type: 3,
                                                representative: representatives
                                            };
                                            for (let i = 0; i < this.users.length; i++) {
                                                if (this.users[i]['nuts'] == tableRow['nuts']) {
                                                    let editedRow = this.users[i];
                                                    tableRow['duplicated'] = true;
                                                    editedRow['duplicated'] = true;
                                                    this.users[i] = editedRow;

                                                }
                                            }
                                            this.users.push(tableRow);
                                        }
                                    );
                                }
                            );
                        }
                    );
                }
            },

            error => console.log(error)
        );

    }

    uploadData(user: any, index: number) {
        if (user['type'] == 2) {
            let updatedMayor: MayorDTO = user['mayor'];
            updatedMayor.status = this.selectStatus[index]['code'];
            this.beneficiaryApi.saveMayor(updatedMayor).subscribe(
                result => {
                    console.log("ok");
                }
            ), error => {
                console.log(error);

            }
        } else if (user['type'] == 3) {
            let updatedRepresentative: RepresentativeDTO = user['representative'];
            updatedRepresentative.status = this.selectStatus[index]['code'];
            this.beneficiaryApi.saveRepresentative(updatedRepresentative).subscribe(
                result => {
                    console.log("ok");
                }
            ), error => {
                console.log(error);

            }
        }
    }

}