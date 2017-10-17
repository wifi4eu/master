import {Component, Input} from '@angular/core';
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";

@Component({selector: 'success-component', templateUrl: 'success.component.html'})

export class SuccessComponent {
    @Input() titleKey: string = 'submitregistration.success.title';
    @Input() textKeys: string[] = ['submitregistration.success.text.part1', 'submitregistration.success.text.part2'];
    @Input() emailConfirmation: boolean = true;

    constructor(private uxService: UxService) {
    }

    resendEmail() {
        this.uxService.growl({
            severity: 'success',
            summary: 'SUCCESS',
            detail: 'Resend activation email success'
        });
    }
}