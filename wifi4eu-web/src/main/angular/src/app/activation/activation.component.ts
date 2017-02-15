import {Component, Input} from '@angular/core';
import {ActivationDetails} from "./activation-details.model";
import {print} from "util";

@Component({templateUrl: 'activation.component.html'})
export class ActivationComponent {
    @Input('activationDetails') activationDetails: ActivationDetails=new ActivationDetails();

    constructor(){

    }
    activationEmailMatches: boolean = false;

    actiavtionEmailMatches() {
        if (this.activationDetails.psswd === this.activationDetails.newPsswd) {
            return true;
        } else {
            return false;
        }
    }

    // onSubmit (){
    //     console.log(
    //         this.actiavtionEmailMatches()
    //     )
    // }

}
