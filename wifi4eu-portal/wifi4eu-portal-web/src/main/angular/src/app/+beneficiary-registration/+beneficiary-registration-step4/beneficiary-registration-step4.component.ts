import {Component, Input, Output, EventEmitter} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";


@Component({
    selector: 'beneficiary-registration-step4', templateUrl: 'beneficiary-registration-step4.component.html'
})

export class BeneficiaryRegistrationStep4Component {
    @Input('initialUser') private initialUser: UserDTOBase;
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Input('users') private users: UserDTOBase[];
    @Input('representing') private representing: boolean;
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    @Output() private onEdit: EventEmitter<number>;

    private displayModal: boolean;
    private successCaptcha: boolean = false;
    private legalChecks: boolean[] = [false, false, false];

    constructor() {
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.onEdit = new EventEmitter<any>();

        this.displayModal = false;
    }

    completeCaptcha(response: any) {
        this.successCaptcha = response.success;
    }

    openModal() {
        this.displayModal = true;
    }

    submit() {
        if (this.legalChecks && this.successCaptcha) {
            this.onNext.emit();
        }
    }

    back() {
        this.onBack.emit();
    }

    edit(step: number) {
        this.onEdit.emit(step);
    }
}