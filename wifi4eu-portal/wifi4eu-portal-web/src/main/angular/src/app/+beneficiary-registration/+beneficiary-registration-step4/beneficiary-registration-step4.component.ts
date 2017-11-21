import {Component, Input, Output, EventEmitter} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";


@Component({
    selector: 'beneficiary-registration-step4', templateUrl: 'beneficiary-registration-step4.component.html'
})

export class BeneficiaryRegistrationStep4Component {
    @Input('initialUser') private initialUser: UserDTOBase;
    @Input('country') private country: NutsDTOBase;
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Input('users') private users: UserDTOBase[];
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Input('userAddress') private userAddress: string;
    @Input('addressNum') private addressNum: string;
    @Input('postalCode') private postalCode: string;
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    @Output() private onEdit: EventEmitter<number>;
    private displayConfirmingData: boolean = false;
    private legalChecks: boolean[] = [false, false, false];

    constructor() {
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.onEdit = new EventEmitter<any>();
    }

    private submit() {
        if (this.legalChecks) {
            this.displayConfirmingData = true;
            this.onNext.emit();
        }
    }

    private back() {
        this.onBack.emit();
        this.legalChecks = [false, false, false];
    }

    private edit(step: number) {
        this.onEdit.emit(step);
        this.legalChecks = [false, false, false];
    }
}