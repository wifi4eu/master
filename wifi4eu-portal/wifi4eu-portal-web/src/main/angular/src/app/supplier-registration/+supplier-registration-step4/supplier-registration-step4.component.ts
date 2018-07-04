import {Component, Input, Output, EventEmitter} from "@angular/core";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import { SharedService } from "../../shared/shared.service";

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
    private legalChecks: boolean[] = [false, false, false, false];
    private successCaptcha: boolean = true;
    private displayModal: boolean = false;
    private displayConfirmingData: boolean = false;

    constructor(private sharedService: SharedService) {
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.onEdit = new EventEmitter<any>();
    }

    completeCaptcha(response: any) {
        this.successCaptcha = response.success;
    }

    openModal() {
        this.displayModal = true;
    }

    submit() {
        if (this.check(this.legalChecks) && this.successCaptcha) {
            this.displayConfirmingData = true;
            this.onNext.emit();
        } else{
            this.sharedService.growlTranslation('You must accept all the conditions before submit this registration.', 'shared.condition.avoid', 'warn');
        }
    }

    check(legalChecks: boolean[]){
        if(!legalChecks[1]|| !legalChecks[2] || !legalChecks[3] || !legalChecks[4]){
            return false;
        }else{
            return true;
        }
    }

    back() {
        this.onBack.emit();
    }

    edit(step: number) {
        this.onEdit.emit(step);
        this.legalChecks = [false, false];
    }
}