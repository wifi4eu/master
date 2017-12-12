import {Component} from "@angular/core";
import {MunicipalityDTOBase} from "../shared/swagger/model/MunicipalityDTO";
import {MunicipalityApi} from "../shared/swagger/api/MunicipalityApi";
import {SupplierApi} from "../shared/swagger/api/SupplierApi";
import {SuppliedRegionApi} from "../shared/swagger/api/SuppliedRegionApi";

@Component({selector: 'app-home', templateUrl: 'home.component.html', providers: [MunicipalityApi, SuppliedRegionApi]})
export class HomeComponent {
    // private municipalities: MunicipalityDTOBase[] = [];
    private municipalitiesCounter: number;
    private suppliersCounter: number;

    constructor(private municipalityApi: MunicipalityApi, private suppliedRegionApi: SuppliedRegionApi) {
        this.municipalityApi.getMunicipalitiesGroupedByLauId().subscribe(
            municipalities => {
                this.municipalitiesCounter = municipalities.length;
                console.log(this.municipalitiesCounter);
            }, error => {
                console.log(error);
            }
        );


        this.suppliedRegionApi.getSuppliedRegionsGroupedByRegionId().subscribe(
            suppliers => {
                this.suppliersCounter = suppliers.length;
                console.log(this.suppliersCounter);
            }, error => {
                console.log(error);
            }
        );

    }
}