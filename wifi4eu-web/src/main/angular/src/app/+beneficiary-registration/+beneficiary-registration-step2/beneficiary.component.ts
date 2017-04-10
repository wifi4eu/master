import {Component, EventEmitter, Input, Output} from "@angular/core";
import {BeneficiaryDTOBase} from "../../shared/swagger/model/BeneficiaryDTO";

@Component({
    selector: 'beneficiary-component', templateUrl: 'beneficiary.component.html'
})
export class BeneficiaryComponent {
    @Input('beneficiaryDTO') beneficiaryDTO: BeneficiaryDTOBase;
    @Input('selection') selection: boolean[];

    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;

    private mayorEmailMatches: boolean = false;
    private representativeEmailMatches: boolean = false;

    constructor() {
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
    }

    onToggleRadio() {
        this.selection[0] = [this.selection[1], this.selection[1] = this.selection[0]][0]
    }

    onSubmit(step: number) {
        this.onNext.emit(step);
    }

    stepBack(step: number) {
        this.onBack.emit(step);
    }

    checkIfMayorEmailMatches() {
        this.mayorEmailMatches = false;
        if (this.beneficiaryDTO.mayorDTO.email === this.beneficiaryDTO.mayorDTO.repeatEmail) {
            this.mayorEmailMatches = true;
        }
    }

    checkIfRepresentativeEmailMatches() {
        this.representativeEmailMatches = false;
        if (this.beneficiaryDTO.representativeDTO.email === this.beneficiaryDTO.representativeDTO.mayorRepeatEmail) {
            this.representativeEmailMatches = true;
        }
    }

    allEmailsMatch() {
        if (this.selection[0]) {
            return this.mayorEmailMatches;
        } else {
            return this.representativeEmailMatches && this.mayorEmailMatches;
        }
    }
}
