import {Component, Input} from '@angular/core';
import {UserApi} from "../../swagger/api/UserApi";
import {BeneficiaryDTO} from "../../../+beneficiary-registration/+beneficiary-registration-step3/beneficiaryDTO.model";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";

@Component({selector: 'success-component', templateUrl: 'success.component.html', providers: [UserApi]})
export class SuccessComponent {

    @Input('beneficiaryDTO') beneficiaryDTO: BeneficiaryDTO;

    constructor(private uxService: UxService, private userApi: UserApi) {
    }

    onClick() {
        this.userApi.resendEmail(this.beneficiaryDTO).subscribe(
            data => {
                if (data['success']) {
                    this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                        detail: 'Resend activation email success'

                    });
                    console.log('SUCCESS: Resend activation email success');
                } else {
                    this.uxService.growl({
                        severity: 'error',
                        summary: 'ERROR',
                        detail: 'Could not resend activation email'
                    });
                    console.log('ERROR: Could not resend activation email');

                }
            },
            error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not resend activation email, ignore this when NG is working in offline mode'
                });
                console.log('WARNING: Could not resend activation email', error);
            }
        );
    }
}