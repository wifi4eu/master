import {Component, Input} from '@angular/core';
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {UserApi} from "../../swagger/api/UserApi";
import {ResponseDTOBase} from "../../swagger/model/ResponseDTO";
import {TranslateService} from "ng2-translate";

@Component({selector: 'success-component', templateUrl: 'success.component.html', providers: [UserApi]})

export class SuccessComponent {
    @Input() titleKey: string = 'submitregistration.success.title';
    @Input() textKeys: string[] = ['submitregistration.success.text.part1', 'benefRegistration.submitregistration.success.text.part2'];
    @Input() emailConfirmation: boolean = false;
    @Input() email: string = null;

    constructor(private uxService: UxService, private translateService: TranslateService, private userApi: UserApi) {
    }

    resendEmail() {
        this.userApi.resendEmail(this.email).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    let translatedString = 'The confirmation email has been resent successfully.';
                    this.translateService.get('shared.registration.emailResend.success').subscribe(
                        (translation: string) => {
                            translatedString = translation;
                        }
                    );
                    this.uxService.growl({
                        severity: 'info',
                        summary: 'INFO',
                        detail: translatedString
                    });
                } else {
                    let translatedString = 'An error occurred when trying to resend the confirmation email.';
                    this.translateService.get('shared.registration.emailResend.failure').subscribe(
                        (translation: string) => {
                            translatedString = translation;
                        }
                    );
                    this.uxService.growl({
                        severity: 'error',
                        summary: 'error',
                        detail: translatedString
                    });
                }
            }, error => {
                let translatedString = 'An error occurred when trying to resend the confirmation email.';
                this.translateService.get('shared.registration.emailResend.failure').subscribe(
                    (translation: string) => {
                        translatedString = translation;
                    }
                );
                this.uxService.growl({
                    severity: 'error',
                    summary: 'error',
                    detail: translatedString
                });
            }
        );
    }
}