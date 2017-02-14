import {Component, Input} from '@angular/core';
import {ActivationDetails} from "./activation-details.model";
import {print} from "util";

@Component({templateUrl: 'activation.component.html'})
export class ActivationComponent {
    @Input('activationDetails') activationDetails: ActivationDetails=new ActivationDetails();

    activationEmailMatches: boolean = false;

    constructor(){
    }

    checkIfPasswordActivationMatches() {
        if (this.activationDetails.newPsswd === this.activationDetails.newPsswd) {
            this.activationEmailMatches = true;
        } else {
            this.activationEmailMatches = false;
        }
    }

    onSubmit(){
       console.log(this.activationDetails.email);
        console.log(this.activationDetails.code);
        console.log(this.activationDetails.psswd);
        console.log(this.activationDetails.newPsswd);
    }

}
