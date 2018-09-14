import {Component, OnInit} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {ForgotDetails} from "./forgot-details.model";
import {ActivatedRoute, Router} from "@angular/router";
import {UserApi} from "../shared/swagger/api/UserApi";

@Component({
    templateUrl: 'forgot.component.html',
    providers: [UserApi]
})
export class ForgotComponent implements OnInit {
    private forgotDetails: ForgotDetails;
    private forgotUrl: string;
    private compareURls: boolean;
    private emailPattern = '^[a-zA-Z0-9](\\.?[a-zA-Z0-9_-]){0,}@[a-zA-Z0-9-]+\\.([a-zA-Z]{1,6}\\.)?[a-zA-Z]{2,6}$';

    constructor(private uxService: UxService, private route: ActivatedRoute, private router: Router, private userApi: UserApi) {
    }

    ngOnInit() {
        this.forgotDetails = new ForgotDetails();
        this.route.params.subscribe(params => this.forgotDetails.token = params['token']);
        this.forgotUrl = window.location.href;
        this.compareURls = this.forgotUrl.includes("forgot;token=");
    }

    private checkPassword() {
        return this.forgotDetails.password === this.forgotDetails.confirmPassword;
    }

    private onSendEmail() {
        /*this.userApi.forgotPassword(this.forgotDetails.email).subscribe(
            data => {
                if (data['success']) {
                    this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                        detail: 'An email has been sent to your account with the instructions.'
                    });
                    console.log('SUCCESS: Forgot password success');
                } else {
                    this.uxService.growl({
                        severity: 'warn',
                        summary: 'WARNING',
                        detail: 'The email could not be sent. Please, try again later.'
                    });
                    console.log('ERROR: Could not sent the email. ');
                }
            }, error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not add new password, ignore this when NG is working in offline mode.'
                });
                console.log('WARNING: Could not add new password', error);
            }
        );*/
    }

    private onNewPassword() {
        /*this.userApi.activateAccount(this.forgotDetails).subscribe(
            data => {
                if (data['success']) {
                    this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                        detail: 'Password changed succesfully! Now you can login with your new password.'
                    });
                    console.log('SUCCESS: Change password success');
                } else {
                    this.uxService.growl({
                        severity: 'warn',
                        summary: 'WARNING',
                        detail: 'The password could not be changed. Please, try again later.'
                    });
                    console.log('ERROR: Could not change password. ');
                }
            }, error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not add new password, ignore this when NG is working in offline mode.'
                });
                console.log('WARNING: Could not add new password', error);
            }
        );*/
    }

}
