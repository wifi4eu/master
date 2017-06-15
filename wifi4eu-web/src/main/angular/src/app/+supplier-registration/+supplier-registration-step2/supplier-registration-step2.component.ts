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
export class SupplierRegistrationComponentStep2 implements OnInit {
    @Input('supplierDTO') supplierDTO: SupplierDTOBase;
    @Input('selection') selection: boolean[];
    @Input('nuts0') nuts0: NutsDTO[];
    @Input('nuts3') nuts3: NutsDTO[];
    @Input('provinces') provinces: NutsDTO[][];

    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;

    private allCountries: SelectItem[];
    private selectedCountries: NutsDTO[];

    private regionsSelected: boolean;

    constructor(private nutsApi: NutsApi) {
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();

        this.allCountries = [];
        this.selectedCountries = [];

        this.regionsSelected = false;
    }

    ngOnInit() {
        this.nutsApi.findNutsByLevel(0).subscribe(
            (nuts: NutsDTO[]) => {
                for (let nut of nuts) {
                    let selectedItem = {
                        label: ' ' + nut.name,
                        value: nut
                    };
                    this.allCountries.push(selectedItem);
                    if(this.nuts0.some(function(e) {return e.name == nut.name;})){
                        this.selectedCountries.push(selectedItem.value);
                    }
                }
            }
        );
    }

    onMultiSelectChange(event) {
        this.nuts0.splice(0,this.nuts0.length);
        for (let country of event.value) {
            this.nuts0.push(country);
            if (!this.provinces[country.name.toUpperCase()]) {
                this.provinces[country.name.toUpperCase()] = [];
                this.nutsApi.findNutsByLevel(3).subscribe(
                    (nuts: NutsDTO[]) => {
                        for (let nut of nuts) {
                            if (country.countryCode === nut.countryCode) {
                                this.provinces[country.name.toUpperCase()].push(nut);
                            }
                        }
                    }
                );
            }
        }
        this.checkIfRegionsSelected();
    }

    checkIfRegionsSelected() {
        this.regionsSelected = false;
        for (let region of this.nuts3) {
            let regionCountrySelected = false;
            for (let country of this.nuts0) {
                if (region.countryCode == country.countryCode) {
                    this.regionsSelected = true;
                    regionCountrySelected = true;
                }
            }
            if (!regionCountrySelected) {
                this.nuts3.splice(this.nuts3.indexOf(region), 1);
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