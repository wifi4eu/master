import {Component, OnInit} from "@angular/core";
import {ForgotService} from "./forgot.service";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {ForgotDetails} from "./forgot-details.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
    templateUrl: 'forgot.component.html',
    providers: [ForgotService]
})
export class ForgotComponent implements OnInit {

    private forgotDetails: ForgotDetails;

    constructor(private forgotService: ForgotService, private uxService: UxService, private route: ActivatedRoute, private router: Router) {
    }

    ngOnInit() {
        this.forgotDetails = new ForgotDetails();
        this.route.params.subscribe(params => this.forgotDetails.token = params['token']);
    }

    checkPassword() {
        return this.forgotDetails.password === this.forgotDetails.confirmPassword;
    }

    onSendEmail() {
        this.forgotService.sendEmail(this.forgotDetails.email).subscribe(
            data => {
                this.uxService.growl({
                    severity: 'success',
                    summary: 'SUCCESS',
                    detail: 'forgot password success'
                });
                console.log('SUCCESS: User activation success');
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

    onNewPassword() {
        this.forgotService.addNewPassword(this.forgotDetails).subscribe(
            data => {
                console.log(data);
                if (data != null) {
                    this.uxService.growl({
                        severity: 'error',
                        summary: 'ERROR',
                        detail: 'Could not change user password'
                    });
                    console.log('ERROR: Could not change user password');
                } else {
                    this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                        detail: 'User has changed password'
                    });
                    console.log('SUCCESS: User has changed password');
                    this.router.navigateByUrl("/login")
                }
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
