import {Component} from '@angular/core';
import {EntityDetails} from '../+entity/entity-details.model';
import {BeneficiaryDetails} from '../+beneficiary/beneficiary-details.model';

@Component({templateUrl: 'registration.component.html'})
 export class RegistrationComponent {
    private entityDetails: EntityDetails;
    private beneficiaryDetails : BeneficiaryDetails;
    private completedSteps : boolean[];
    private activeSteps : boolean[];
    private currentStep : number;

    constructor() {
        this.entityDetails = new EntityDetails();
        this.beneficiaryDetails = new BeneficiaryDetails();
        this.completedSteps = [false, false, false];
        this.activeSteps = [false, false, false];
        this.currentStep = 1;
    }
 }