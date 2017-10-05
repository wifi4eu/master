import {Component, EventEmitter, Input, Output} from "@angular/core";
import {BeneficiaryDTOBase} from "../../shared/swagger/model/BeneficiaryDTO";

@Component({
    selector: 'beneficiary-component', templateUrl: 'beneficiary.component.html'
})
export class BeneficiaryComponent {
    @Input('allBeneficiaries') allBeneficiaries: BeneficiaryDTOBase[];
    @Input('selection') selection: boolean[];

    @Output() onNext: EventEmitter<number>;

    private mayorEmailMatches: boolean;
    private representativeEmailMatches: boolean;
    private emailsAreNotRepeated: boolean;

    constructor() {
        this.onNext = new EventEmitter<number>();
    }

    ngOnInit() {
        this.checkIfMayorEmailMatches();
        this.checkIfRepresentativeEmailMatches();
    }

    onToggleRadio() {
        this.selection[0] = [this.selection[1], this.selection[1] = this.selection[0]][0];
        if(this.selection[1]){
            this.allBeneficiaries[0].represented = true;
        }
        else{
            this.allBeneficiaries[0].represented = false;
        }
    }

    onSubmit(step: number) {
        this.onNext.emit(step);
    }
    checkIfMayorEmailMatches() {
        this.mayorEmailMatches = false;
        if (this.allBeneficiaries[0].mayorDTO.email === this.allBeneficiaries[0].mayorDTO.repeatEmail) {
            this.mayorEmailMatches = true;
        }
    }

    checkIfRepresentativeEmailMatches() {
        this.representativeEmailMatches = false;
        this.emailsAreNotRepeated = true;
        if (this.allBeneficiaries[0].representativeDTO.email === this.allBeneficiaries[0].representativeDTO.mayorRepeatEmail) {
            this.representativeEmailMatches = true;
            if (this.allBeneficiaries[0].mayorDTO.email === this.allBeneficiaries[0].representativeDTO.email) {
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
