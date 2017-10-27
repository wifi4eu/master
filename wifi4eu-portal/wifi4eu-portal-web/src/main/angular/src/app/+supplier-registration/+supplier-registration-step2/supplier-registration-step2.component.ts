import {Component, Input, Output, EventEmitter} from "@angular/core";
import {SelectItem} from "primeng/primeng";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";

@Component({
    selector: 'supplier-registration-step2', templateUrl: 'supplier-registration-step2.component.html'
})

export class SupplierRegistrationStep2Component {
    @Input('selectedCountriesNames') private selectedCountriesNames: string[];
    @Output() private selectedCountriesNamesChange: EventEmitter<string[]>;
    @Input('selectedRegions') private selectedRegions: NutsDTOBase[][];
    @Output() private selectedRegionsChange: EventEmitter<NutsDTOBase[][]>;
    @Input('allCountriesSelect') private allCountriesSelect: SelectItem[];
    @Input('allRegionsSelect') private allRegionsSelect: SelectItem[][];
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    private selectedCountries: NutsDTOBase[] = [];
    private areRegionsSelected: boolean = false;

    constructor() {
        this.selectedRegionsChange = new EventEmitter<NutsDTOBase[][]>();
        this.selectedCountriesNamesChange = new EventEmitter<string[]>();
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
    }

    checkIfRegionsSelected() {
        this.areRegionsSelected = false;
        for (let country of this.allCountriesSelect) {
            let countryFound = false;
            for (let selectedCountry of this.selectedCountries) {
                if (selectedCountry.countryCode == country.value.countryCode) {
                    if (this.selectedRegions[country.value.label].length > 0) {
                        this.areRegionsSelected = true;
                    }
                    countryFound = true;
                }
            }
            if (!countryFound) {
                this.selectedRegions[country.value.label] = [];
            }
        }
    }

    cleanEmptyRegions() {
        this.selectedCountriesNames = [];
        let countriesToRemove: number[] = [];
        let removedCount = 0;
        for (let selectedCountry of this.selectedCountries) {
            if (this.selectedRegions[selectedCountry.label].length == 0) {
                countriesToRemove.push(this.selectedCountries.indexOf(selectedCountry));
            } else {
                this.selectedCountriesNames.push(selectedCountry.label);
            }
        }
        for (let index of countriesToRemove) {
            console.log(this.selectedCountries);
            this.selectedCountries.splice(index - removedCount, 1);
            removedCount++;
        }
    }

    submit() {
        this.cleanEmptyRegions();
        this.selectedCountriesNamesChange.emit(this.selectedCountriesNames);
        this.selectedRegionsChange.emit(this.selectedRegions);
        this.onNext.emit();
    }

    back() {
        this.cleanEmptyRegions();
        this.selectedCountriesNamesChange.emit(this.selectedCountriesNames);
        this.selectedRegionsChange.emit(this.selectedRegions);
        this.onBack.emit();
    }
}