import {Component, Input, Output, EventEmitter} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";

@Component({
    selector: 'beneficiary-registration-step3', templateUrl: 'beneficiary-registration-step3.component.html'
})

export class BeneficiaryRegistrationStep3Component {
    @Input('initialUser') private initialUser: UserDTOBase;
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Input('users') private users: UserDTOBase[];
    @Input('representing') private representing: boolean;
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    @Output() private onEdit: EventEmitter<number>;

    constructor() {
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.onEdit = new EventEmitter<any>();
    }

    submit() {
        this.onNext.emit();
    }

    back() {
        this.onBack.emit();
    }
}