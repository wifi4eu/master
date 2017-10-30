import {Component, Input, Output, EventEmitter} from "@angular/core";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";

@Component({
    selector: 'supplier-registration-step4', templateUrl: 'supplier-registration-step4.component.html'
})

export class SupplierRegistrationStep4Component {
    @Input('supplier') private supplier: SupplierDTOBase;
    @Input('selectedCountriesNames') private selectedCountriesNames: string[];
    @Input('selectedRegions') private selectedRegions: NutsDTOBase[][];
    @Input('logoUrl') private logoUrl: FileReader;
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    @Output() private onEdit: EventEmitter<any>;
    private legalChecks: boolean[] = [false, false];
    private successCaptcha: boolean = false;

    constructor() {
        this.legalChecks = [false, false];
        this.successCaptcha = false;
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.onEdit = new EventEmitter<any>();
    }

    edit(step: number) {
        console.log(this.selectedCountriesNames);
        this.onEdit.emit(step);
    }
    //
    // openModal() {
    //     this.display = true;
    // }
    //
    //
    // private onCaptchaComplete(response: any) {
    //     this.successCaptcha = response.success;
    // }
    //
}