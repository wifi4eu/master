import {Component} from "@angular/core";
import {EntityDetails} from "../+entity/entity-details.model";
import {BeneficiaryDetails} from "../+beneficiary/beneficiary-details.model";

@Component({templateUrl: 'registration.component.html'})
export class RegistrationComponent {
    private entityDetails: EntityDetails;
    private beneficiaryDetails: BeneficiaryDetails;
    private completedSteps: boolean[];
    private activeSteps: boolean[];
    private currentStep: number;

    private completed: boolean[];
    private active: boolean[];

    private successRegistration: boolean = false;

    constructor() {
        console.log("Constructor");
        this.entityDetails = new EntityDetails();
        this.beneficiaryDetails = new BeneficiaryDetails();
        this.completedSteps = [false, false, false];
        this.activeSteps = [false, false, false];
        this.currentStep = 1;
        this.completed = [false, false, false];
        this.active = [true, false, false];
    }

    onNext(step: number) {
        this.completed[step - 1] = true;
        this.active[step - 1] = false;
        this.active[step] = true;
        console.log("Completed", this.completed);
        console.log("Active", this.active);
    }
}