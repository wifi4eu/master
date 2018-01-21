import { Component, Input } from '@angular/core';
import { UserApi } from "../../swagger/api/UserApi";
import { ResponseDTOBase } from "../../swagger/model/ResponseDTO";
import { SharedService } from "app/shared/shared.service";

@Component({selector: 'success-component', templateUrl: 'success.component.html', providers: [UserApi]})

export class SuccessComponent {
    @Input() titleKey: string = 'shared.submitregistration.success.title';
    @Input() textKeys: string[] = ['shared.submitregistration.success.text.part1', 'benefRegistration.submitregistration.success.text.part2'];
    @Input() emailConfirmation: boolean = false;
    @Input() email: string = null;

    constructor(private userApi: UserApi, private sharedService: SharedService) {
    }

    resendEmail() {
        this.userApi.resendEmail(this.email).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.sharedService.growlTranslation('The confirmation email has been resent successfully.', 'shared.registration.emailResend.success', 'info');
                } else {
                    this.sharedService.growlTranslation('An error occurred when trying to resend the confirmation email.', 'shared.registration.emailResend.failure', 'error');
                }
            }, error => {
                this.sharedService.growlTranslation('An error occurred when trying to resend the confirmation email.', 'shared.registration.emailResend.failure', 'error');
            }
        );
    }
}