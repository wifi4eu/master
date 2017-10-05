import {Component} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {MayorDTO, MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {LauDTO, LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {RepresentativeDTO, RepresentativeDTOBase} from "../../shared/swagger/model/RepresentativeDTO";
import {LegalEntityDTO, LegalEntityDTOBase} from "../../shared/swagger/model/LegalEntityDTO";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {LauApi} from "../../shared/swagger/api/LauApi";

@Component({
    templateUrl: 'mayors-list.component.html', providers: [BeneficiaryApi, LauApi]
})

export class DgConnListMayorComponent {
    private mayors: MayorDTO[];
    private representatives: RepresentativeDTO[];
    private users: Array<Object>;
    private address: string;
    private laus: LauDTO[];
    private display: boolean;
    private rowIndex: number

    constructor(private lauApi: LauApi) {
        this.display = false;
        this.users = [];
        this.address = '';
        this.lauApi.getAllLaus().subscribe(
            lauIndex => this.laus = lauIndex,
            error => console.log(error)
        );
    }

    submit() {
        let modifiedLau = this.laus[this.rowIndex];
        modifiedLau.physicalAddress = this.address;
        this.lauApi.save(modifiedLau).subscribe(
            lau => {
                modifiedLau = lau;
            }
        );
        this.display = false;
    }

    edit(index: number) {
        this.rowIndex = index;
        console.log(this.rowIndex);
        this.display = true;
        this.address = this.laus[index].physicalAddress;
    }

    closeModal() {

    }

}
