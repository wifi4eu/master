import {Component, OnInit} from "@angular/core";
import {ForgotService} from "./forgot.service";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {ForgotDetails} from "./forgot-details.model";
import {ActivatedRoute} from "@angular/router";

@Component({
    templateUrl: 'forgot.component.html',
    providers: [ForgotService, UxService]
})
export class ForgotComponent implements OnInit {

    private token: string;
    private forgotDetails: ForgotDetails;

    constructor(private forgotService: ForgotService, private uxService: UxService, private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.forgotDetails = new ForgotDetails();
        this.route.params.subscribe(params => this.token = params['token']);
    }

    checkPassword() {
        return this.forgotDetails.password === this.forgotDetails.confirmPassword;
    }

    onSubmit() {
        this.forgotService.addNewPassword(this.forgotDetails).subscribe(
            data => {
                console.log(data)
            },
            error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not add new password, ignore this when' +
                    ' NG is working in offline mode'
                });
                console.log('WARNING: Could not add new password', error);
            }
        );
    }

}
