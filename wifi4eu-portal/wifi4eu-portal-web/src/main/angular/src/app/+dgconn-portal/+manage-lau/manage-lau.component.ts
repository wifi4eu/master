import {Component} from "@angular/core";
import {LauDTO, LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {NutsDTO,NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {NutsApi} from "../../shared/swagger/api/NutsApi";

@Component({
    templateUrl: 'manage-lau.component.html'
})

export class DgConnManageLauComponent {

    private address: string;
    private laus: LauDTO[];
    private nuts: NutsDTO[];
    private display: boolean;
    private rowIndex: number;
    private nuts3Id = "BE";

    constructor(private lauApi: LauApi, private nutsApi: NutsApi) {
        this.display = false;
        this.address = '';
        this.nutsApi.getNutsByLevel(0).subscribe(
            nutsIndex => this.nuts = nutsIndex,
            error => console.log(error)
        );
        this.lauApi.getLausByCountryCodeAndName1StartingWithIgnoreCase(this.nuts3Id,"").subscribe(
            lauIndex => this.laus = lauIndex,
            error => console.log(error)
        );
    }

    submit() {
    /*
        let modifiedLau = this.laus[this.rowIndex];
        modifiedLau.physicalAddress = this.address;
        this.lauApi.save(modifiedLau).subscribe(
            lau => {
                modifiedLau = lau;
            }
        );
        this.display = false;
    */
    }

    selectCountry(){

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