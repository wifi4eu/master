import {Component, Input, EventEmitter, Output, OnInit} from "@angular/core";
import {SelectItem} from 'primeng/primeng';
import {SupplierRegistration} from "../supplier-registration.model";
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

    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;

    @Input('nuts0') nuts0: NutsDTO[];
    @Input('nuts3') nuts3: NutsDTO[];

    private allCountries: SelectItem[];
    private selectedCountries: SelectItem[];
    private provinces: NutsDTO[][];
    

    constructor(private nutsApi: NutsApi) {
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();

        this.allCountries = [];
        this.selectedCountries = [];
        this.provinces = [];
    }

    ngOnInit() {
        //load all countries
        this.nutsApi.findNutsByLevel(0).subscribe(
            (nuts: NutsDTO[]) => {
                for (let nut of nuts) {
                    this.allCountries.push({
                        label: ' ' + nut.name,
                        value: nut
                    });
                }
            }
        );
        //load selected countries
        for (let nut of this.nuts0) {
            this.selectedCountries.push({
                label: ' ' + nut.name,
                value: nut
            });
        }
    }

    onMultiSelectChange(event) {
        if (event.value.length > 0) {
            this.nuts0 = [];
            for(let nut of event.value){
                this.nuts0.push(nut);
            }
            let country: NutsDTO = event.value[event.value.length - 1];
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