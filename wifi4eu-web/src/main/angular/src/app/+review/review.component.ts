import {Component, Input, Output, EventEmitter} from "@angular/core";
import {EntityDetails} from "../+entity/entity-details.model";
import {BeneficiaryDetails} from "../+beneficiary/beneficiary-details.model";
import {UserDetails} from "../shared/models/user-details.model";
import {UserService} from "../shared/services/user.service";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";

@Component({
    selector: 'review-component',
    templateUrl: 'review.component.html',
    providers: [UserService]
})
export class ReviewComponent {
    @Input('entityDetails') entityDetails: EntityDetails;
    @Input('beneficiaryDetails') beneficiaryDetails: BeneficiaryDetails;
    @Output() gotoStep = new EventEmitter<number>();
    @Output() onSuccess = new EventEmitter<boolean>();
    @Output() onFailure = new EventEmitter<boolean>();

    displayConfirmingData: boolean = false;
    confirmingData: boolean = true;

    private countryField;
    private municipalityField;
    private checkboxes: boolean[] = [false, false, false];
    private userDetails: UserDetails;

    constructor(private userService: UserService, private uxService: UxService) {
        this.userDetails = new UserDetails();
    }

    submitRegistration() {
        if (!this.entityDetails || !this.beneficiaryDetails) {
            this.onFailure.emit(true);
            return;
        }

        this.userDetails.entity = this.entityDetails;
        this.userDetails.beneficiary = this.beneficiaryDetails;

        this.displayConfirmingData = true;

        this.userService.addUser(this.userDetails).subscribe(
            user => console.log(user),
            error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get user, ignore this when NG is' + ' working in offline mode'
                });
                console.log('WARNING: Could not get user: ', error);
            }
        );

        setTimeout(() => {
            this.displayConfirmingData = false;
            this.onSuccess.emit(true);
        }, 2000);
    }

    editStep(step: number) {
        this.gotoStep.emit(step);
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
