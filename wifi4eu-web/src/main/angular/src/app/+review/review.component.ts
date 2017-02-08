import {Component, Input, Output, EventEmitter} from "@angular/core";
import {EntityDetails} from "../+entity/entity-details.model";
import {BeneficiaryDetails} from "../+beneficiary/beneficiary-details.model";

@Component({selector: 'review-component', templateUrl: 'review.component.html'})
export class ReviewComponent {
    @Input('entityDetails') entityDetails: EntityDetails;
    @Input('beneficiaryDetails') beneficiaryDetails: BeneficiaryDetails;
    @Output() onNext = new EventEmitter<number>();
    @Output() onBack = new EventEmitter<number>();

    displayConfirmingData: boolean = false;
    confirmingData: boolean = true;

    constructor() {
    }

    submitRegistration() {
        this.displayConfirmingData = true;
    }

    editStep(step: number) {
        this.onBack.emit(step);
    }

}
