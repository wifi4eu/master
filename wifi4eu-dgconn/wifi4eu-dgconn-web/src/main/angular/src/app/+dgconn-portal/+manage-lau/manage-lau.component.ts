import {Component} from "@angular/core";
import {LauDTO, LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {NutsDTO,NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";

@Component({
    templateUrl: 'manage-lau.component.html',
    providers: [NutsApi, LauApi]
})

export class DgConnManageLauComponent {

    private address: string;
    private selectedLau: LauDTO;
    private laus: LauDTO[];
    private countries: NutsDTO[];
    private country: NutsDTO;
    private display: boolean;
    private rowIndex: number;
    private keyword: string="";

    constructor(private nutsApi: NutsApi, private lauApi: LauApi) {
        this.display = false;
        this.address = '';
        this.countries = [];
        this.selectedLau = new LauDTOBase();
        this.nutsApi.getNutsByLevel(0).subscribe(
            nutsIndex => this.countries = nutsIndex,
            error => console.log(error)
        );

    }

    submit() {

        let modifiedLau = this.laus[this.rowIndex];
        modifiedLau.physicalAddress = this.address;
        this.lauApi.updatePhysicalAddress(modifiedLau).subscribe(
            data => {
                console.log();
            },
            error => {
                console.log(error);
            }
        );
        this.display = false;

    }

    selectCountry(event: any) {
        if (this.country != null && this.keyword != null && this.keyword != "") {
            this.lauApi.getLausByCountryCodeAndName1ContainingIgnoreCase(this.country.countryCode, this.keyword).subscribe(
                (laus: LauDTOBase[]) => {
                    this.laus = laus;
                }
            );
        }
    }

    edit(index: number) {
        this.rowIndex = index;
        console.log(this.rowIndex);
        this.selectedLau = this.laus[index];
        this.address = this.selectedLau.physicalAddress;
        this.display = true;
    }

    closeModal() {

    }

}