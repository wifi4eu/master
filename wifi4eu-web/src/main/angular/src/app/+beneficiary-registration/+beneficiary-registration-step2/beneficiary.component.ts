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

    private mayorEmailMatches: boolean;
    private representativeEmailMatches: boolean;
    private emailsAreNotRepeated: boolean;

    constructor() {
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
    }

    ngOnInit() {
        this.checkIfMayorEmailMatches();
        this.checkIfRepresentativeEmailMatches();
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
        this.emailsAreNotRepeated = true;
        if (this.beneficiaryDTO.representativeDTO.email === this.beneficiaryDTO.representativeDTO.mayorRepeatEmail) {
            this.representativeEmailMatches = true;
            if (this.beneficiaryDTO.mayorDTO.email === this.beneficiaryDTO.representativeDTO.email) {
                this.emailsAreNotRepeated = false;
            }
        }
    }

    allEmailsMatch() {
        if (this.selection[0]) {
            return this.mayorEmailMatches;
        } else {
            return this.representativeEmailMatches && this.mayorEmailMatches && this.emailsAreNotRepeated;
        }
    }
}
