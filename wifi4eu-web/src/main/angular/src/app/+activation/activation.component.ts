import {Component, Input, OnInit} from "@angular/core";
import {ActivationDetails} from "./activation-details.model";
import {ActivationService} from "./activation.service";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {ActivatedRoute} from "@angular/router";

@Component({templateUrl: 'activation.component.html', providers: [ActivationService]})
export class ActivationComponent implements OnInit {

    @Input('activationDetails') activationDetails: ActivationDetails;

    constructor(private activationService: ActivationService, private uxService: UxService, private route: ActivatedRoute) {
        this.activationDetails = new ActivationDetails();

    }

    ngOnInit() {
        this.route.params.subscribe(params => this.activationDetails.token = params['token']);
    }

    checkPassword() {
        return this.activationDetails.password === this.activationDetails.confirmPassword;
    }

    onSubmit() {
        this.activationService.addNewPassword(this.activationDetails).subscribe(
            data => {
                this.uxService.growl({
                    severity: 'success',
                    summary: 'SUCCESS',
                    detail: 'User activation success'
                });
                console.log('SUCCESS: User activation success');
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
