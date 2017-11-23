import {Component} from "@angular/core";
import {SelectItem} from 'primeng/primeng';
import {SupplierDTOBase} from "../shared/swagger/model/SupplierDTO";
import {NutsDTOBase} from "../shared/swagger/model/NutsDTO";
import {SuppliedRegionDTOBase} from "../shared/swagger/model/SuppliedRegionDTO";
import {NutsApi} from "../shared/swagger/api/NutsApi";
import {SupplierApi} from "../shared/swagger/api/SupplierApi";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {ResponseDTOBase} from "../shared/swagger/model/ResponseDTO";

@Component({
    selector: 'supplier-registration',
    templateUrl: 'supplier-registration.component.html',
    providers: [NutsApi, SupplierApi]
})

export class SupplierRegistrationComponent {
    private successRegistration: boolean = false;
    private failureRegistration: boolean = false;
    private completed: boolean[] = [false, false, false, false];
    private active: boolean[] = [true, false, false, false];
    private supplier: SupplierDTOBase = new SupplierDTOBase();
    private selectedCountriesNames: string[] = [];
    private selectedRegions: NutsDTOBase[][] = [];
    private allCountriesSelect: SelectItem[] = [];
    private allRegionsSelect: SelectItem[][] = [];
    private logoUrl: FileReader = new FileReader();

    constructor(private nutsApi: NutsApi, private supplierApi: SupplierApi, private uxService: UxService) {
        this.nutsApi.getNutsByLevel(0).subscribe(
            (countries: NutsDTOBase[]) => {
                for (let country of countries) {
                    let selectCountry = {
                        label: country.label,
                        value: country
                    };
                    this.allCountriesSelect.push(selectCountry);
                    this.allRegionsSelect[country.label] = [];
                    this.selectedRegions[country.label] = [];
                    this.nutsApi.getNutsByCountryCodeAndLevel(country.countryCode, 3).subscribe(
                        (regions: NutsDTOBase[]) => {
                            for (let region of regions) {
                                let selectRegion = {
                                    label: region.label,
                                    value: region
                                };
                                this.allRegionsSelect[country.label].push(selectRegion);
                            }
                        }, error => {
                            console.log(error);
                            // growl the error here
                        }
                    );
                }
            }, error => {
                console.log(error);
                // growl the error here
            }
        );
    }

    navigate(step: number) {
        switch (step) {
            case 1:
                this.completed = [false, false, false, false];
                this.active = [true, false, false, false];
                break;
            case 2:
                this.completed = [true, false, false, false];
                this.active = [false, true, false, false];
                break;
            case 3:
                this.completed = [true, true, false, false];
                this.active = [false, false, true, false];
                break;
            case 4:
                this.completed = [true, true, true, false];
                this.active = [false, false, false, true];
                break;
        }
    }

    submitRegistration() {
        this.supplier.suppliedRegions = [];
        for (let selectedCountry in this.selectedRegions) {
            for (let selectedRegion of this.selectedRegions[selectedCountry]) {
                let suppliedRegion = new SuppliedRegionDTOBase();
                suppliedRegion.regionId = selectedRegion.id;
                this.supplier.suppliedRegions.push(suppliedRegion);
            }
        }
        this.supplierApi.submitSupplierRegistration(this.supplier).subscribe(
            (data: ResponseDTOBase) => {
                if (data.success) {
                    this.successRegistration = true;
                } else {
                    this.failureRegistration = true;
                }
                console.log(data);
            }, error => {
                this.failureRegistration = true;
                console.log(error);
            }
        );
    }
}