import {Component} from "@angular/core";
import {SelectItem} from 'primeng/primeng';
import {SupplierDTOBase} from "../shared/swagger/model/SupplierDTO";
import {NutsDTOBase} from "../shared/swagger/model/NutsDTO";
import {SuppliedRegionDTOBase} from "../shared/swagger/model/SuppliedRegionDTO";
import {NutsApi} from "../shared/swagger/api/NutsApi";
import {SupplierApi} from "../shared/swagger/api/SupplierApi";
import {SharedService} from "../shared/shared.service";
import {ResponseDTOBase} from "../shared/swagger/model/ResponseDTO";
import {TranslateService} from "ng2-translate";
import { LocalStorageService } from "angular-2-local-storage";
import { UserDTOBase } from "../shared/swagger";


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
    private user: UserDTOBase;
    // private officialAddress: any = {};

    constructor(private localStorageService: LocalStorageService, private nutsApi: NutsApi, private supplierApi: SupplierApi, private sharedService: SharedService, private translateService: TranslateService) {
        this.nutsApi.getNutsByLevel(0).subscribe(
            (countries: NutsDTOBase[]) => {
                for (let country of countries) {
                    let countryName = country.label.substring(0, 1).toUpperCase() + country.label.substring(1, country.label.length).toLowerCase();
                    let selectCountry = {
                        label: countryName,
                        value: country
                    };
                    this.allCountriesSelect.push(selectCountry);
                    this.allRegionsSelect[country.label] = [];
                    this.selectedRegions[country.label] = [];
                    this.nutsApi.getNutsByCountryCodeAndLevelOrderByLabelAsc(country.countryCode, 3).subscribe(
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
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;

        this.supplier.suppliedRegions = [];
        for (let selectedCountry in this.selectedRegions) {
            for (let selectedRegion of this.selectedRegions[selectedCountry]) {
                let suppliedRegion = new SuppliedRegionDTOBase();
                suppliedRegion.regionId = selectedRegion;
                this.supplier.suppliedRegions.push(suppliedRegion);
            }
        }
        let language = this.translateService.currentLang;
        if (!language) {
            language = 'en';
        }
        this.supplier.lang = language;
        // this.supplier.address = this.officialAddress.streetName.trim() + " " + this.officialAddress.streetNumber.trim() + " " + this.officialAddress.postalCode.trim() + " " +  this.officialAddress.city.trim() + " " + this.officialAddress.country.trim();
        this.supplierApi.submitSupplierRegistration(this.supplier).subscribe(
            (data: ResponseDTOBase) => {
                if (data.success) {
                    this.sharedService.update();
                    this.successRegistration = true;
                } else {
                    this.failureRegistration = true;
                }
            }, error => {
                this.failureRegistration = true;
                console.log(error);
            }
        );
    }
}