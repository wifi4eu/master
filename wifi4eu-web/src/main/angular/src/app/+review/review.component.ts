import {Component, Input, Output, EventEmitter} from "@angular/core";
import {EntityDetails} from "../+entity/entity-details.model";
import {BeneficiaryDetails} from "../+beneficiary/beneficiary-details.model";

@Component({selector: 'review-component', templateUrl: 'review.component.html'})
export class ReviewComponent {
    @Input('entityDetails') entityDetails: EntityDetails;
    @Input('beneficiaryDetails') beneficiaryDetails: BeneficiaryDetails;
    @Output() gotoStep = new EventEmitter<number>();

    displayConfirmingData: boolean = false;
    confirmingData: boolean = true;

    private countryField;
    private municipalityField;
    private checkboxes: boolean[] = [false, false, false];

    constructor() {
    }

    submitRegistration() {
        this.displayConfirmingData = true;
    }

    editStep(step: number) {
        this.gotoStep.emit(step);
    }
}
    checkObjects() {
        this.countryField = this.entityDetails.country;
        this.municipalityField = this.entityDetails.municipality;
        if (typeof this.entityDetails.country != "string") {
            this.countryField = this.entityDetails.country.name;
            this.municipalityField = this.entityDetails.municipality.NAME_1;
        }
    }

}
