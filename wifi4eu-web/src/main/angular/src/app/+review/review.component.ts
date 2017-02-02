import {Component, Input} from "@angular/core";
import {EntityDetails} from "../+entity/entity-details.model";
import {BeneficiaryDetails} from "../+beneficiary/beneficiary-details.model";

@Component({selector: 'review-component', templateUrl: 'review.component.html'})
export class ReviewComponent {
    @Input('entityDetails') entityDetails: EntityDetails;
    @Input('beneficiaryDetails') beneficiaryDetails: BeneficiaryDetails;

    constructor() {
    }

}
