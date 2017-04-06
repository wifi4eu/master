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

    constructor(private nutsApi: NutsApi) {
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();

        this.allCountries = [];
        this.selectedCountries = [];
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
/*
        for(let country of this.nuts0){
            this.selectedCountries.push({
                        label: ' ' + country.name,
                        value: country
                    });
        }
*/
        console.log(this.allCountries, this.nuts0, this.selectedCountries);
    }

    onMultiSelectChange(event) {
        if (event.value.length > 0) {
            let country: NutsDTO = event.value[event.value.length - 1];
            //update this.nuts0 values with the selected countries in multiselect input
            if(this.nuts0.length>0){
                this.nuts0.splice(0,this.nuts0.length);
            }
            for(let country of event.value){
                this.nuts0.push(country);
            }
            //retrieve nuts3 (Communes) level for selected nuts0 (Countries)
            this.nutsApi.findNutsByLevel(3).subscribe(
                (nuts: NutsDTO[]) => {
                    this.provinces[country.name.toUpperCase()] = [];
                    for (let nut of nuts) {
                        if (country.countryCode === nut.countryCode) {
                            this.provinces[country.name.toUpperCase()].push(nut);
                        }
                    }
                }
            );
        }
    }

    onSubmit(step: number) {
        this.onNext.emit(step);
    }

    stepBack(step: number) {
        this.onBack.emit(step);
    }
}