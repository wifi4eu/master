import {Component} from "@angular/core";
import {SelectItem} from 'primeng/primeng';
import {NutsApi} from "../shared/swagger/api/NutsApi";
import {SupplierDTOBase} from "../shared/swagger/model/SupplierDTO";
import {NutsDTOBase, NutsDTO} from "../shared/swagger/model/NutsDTO";

@Component({templateUrl: 'supplier-registration.component.html', providers: [NutsApi]})
export class SupplierRegistrationComponent {

    private supplierDTO: SupplierDTOBase;

    private selection: boolean[];
    private completed: boolean[];
    private active: boolean[];
    private successRegistration: boolean;
    private failureRegistration: boolean;
    
    private nuts0: NutsDTO[];
    private nuts3: NutsDTO[][];
    private allCountries: SelectItem[];
    private allRegions: SelectItem[][];

    private supplierTempLogo: any;

    constructor(private nutsApi: NutsApi) {
        this.supplierDTO = new SupplierDTOBase();
        this.supplierDTO.nutsIds = '';

        this.selection = [true, false];
        this.completed = [false, false, false, false];
        this.active = [true, false, false, false];
        this.successRegistration = false;
        this.failureRegistration = false;

        this.nuts0 = [];
        this.nuts3 = [];
        this.allCountries = [];
        this.allRegions = [];

        this.nutsApi.findNutsByLevel(0).subscribe(
            (countries: NutsDTO[]) => {
                for (let country of countries) {
                    let selectCountry = {
                        label: ' ' + country.name,
                        value: country
                    };
                    this.allCountries.push(selectCountry);
                    if (!this.nuts3[country.name]) {
                        this.nuts3[country.name] = [];
                    }
                    this.allRegions[country.name] = [];
                    this.nutsApi.findCountryRegions(country.countryCode).subscribe(
                        (regions: NutsDTO[]) => {
                            for (let region of regions) {
                                let selectRegion = {
                                    label: ' ' + region.name,
                                    value: region
                                }
                                this.allRegions[country.name].push(selectRegion);
                            }
                        }
                    );
                }
            }
        );
    }

    onNext(step: number) {
        this.completed[step - 1] = true;
        this.active[step - 1] = false;
        this.active[step] = true;
    }

    gotoStep(step: number) {
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

    onBack(step: number) {
        this.completed[step - 1] = false;
        this.active[step - 1] = true;
        this.active[step] = false;
    }

    onSuccess(value: boolean) {
        this.successRegistration = value;
    }

    onFailure(value: boolean) {
        this.failureRegistration = value;
    }

    onLogoSubmit(event: any) {
        if (event) {
            this.supplierTempLogo = event;
            let reader = new FileReader();
            reader.onload = (e) => {
                this.supplierDTO.logo = reader.result;
            };
            reader.readAsDataURL(event);
        } else {
            this.supplierTempLogo = null;
        }
    }
}