import {Component, Input, EventEmitter, Output, OnInit} from "@angular/core";
import {SelectItem} from 'primeng/primeng';
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {NutsDTO} from "../../shared/swagger/model/NutsDTO";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";

@Component({
    selector: 'supplier-registration-step2-component',
    templateUrl: 'supplier-registration-step2.component.html',
    providers: [NutsApi]
})
export class SupplierRegistrationComponentStep2 {
    @Input('supplierDTO') supplierDTO: SupplierDTOBase;
    @Input('nuts0') private nuts0: NutsDTO[];
    @Input('nuts3') private nuts3: NutsDTO[][];
    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;
    @Input('allCountries') private allCountries: SelectItem[];
    @Input('allRegions') private allRegions: SelectItem[][];
    private regionsSelected: boolean;

    constructor(private nutsApi: NutsApi) {
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
    }

    ngOnInit() {
        if (!this.allCountries) {
            this.nutsApi.getNutsByLevel(0).subscribe(
                (countries: NutsDTO[]) => {
                    for (let country of countries) {
                        let selectCountry = {
                            label: ' ' + country.label,
                            value: country
                        };
                        this.allCountries.push(selectCountry);
                    }
                    this.checkIfRegionsSelected();
                }
            );
        } else {
            this.checkIfRegionsSelected();
        }
    }

    checkIfRegionsSelected() {
        this.regionsSelected = false;
        for (let country of this.allCountries) {
            let countryFound = false;
            for (let selectedCountry of this.nuts0) {
                if (selectedCountry.countryCode == country.value.countryCode) {
                    if (this.nuts3[country.value.label].length > 0) {
                        this.regionsSelected = true;
                    }
                    countryFound = true;
                }
            }
            if (!countryFound) {
                this.nuts3[country.value.label] = [];
            }
        }
    }

    onSubmit(step: number) {
        this.onNext.emit(step);
    }

    stepBack(step: number) {
        this.onBack.emit(step);
    }
}