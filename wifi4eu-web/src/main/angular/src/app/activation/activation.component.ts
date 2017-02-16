import {Component, Input} from '@angular/core';
import {ActivationDetails} from "./activation-details.model";
import {ActivationService} from "./activation.service";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";

@Component({templateUrl: 'activation.component.html', providers: [ActivationService, UxService]})
export class ActivationComponent {

    @Input('activationDetails') activationDetails: ActivationDetails = new ActivationDetails();

    constructor(private activationService: ActivationService, private uxService: UxService){
    }

    checkPassword() {
       return this.activationDetails.newPassword === this.activationDetails.repeatNewPassword;
    }

    onSubmit (){
        this.activationService.addNewPassword(this.activationDetails).subscribe(
            data => {
                console.log(data)
            },
            error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get countries, ignore this when NG is working in offline mode'
                });
                console.log('WARNING: Could not get countries', error);
            }
        );
    }

}
