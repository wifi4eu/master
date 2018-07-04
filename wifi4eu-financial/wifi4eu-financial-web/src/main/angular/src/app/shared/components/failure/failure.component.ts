import {Component, Input, OnChanges} from '@angular/core';
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {TranslateService} from "ng2-translate";

@Component({selector: 'failure-component', templateUrl: 'failure.component.html'})

export class FailureComponent implements OnChanges {
    @Input() titleKey: string = 'shared.submitregistration.failure.title';
    @Input() textKeys: string[] = ['shared.submitregistration.failure.text.part1'];
    @Input() alreadyRegistered: boolean = false;

    constructor(private uxService: UxService, private translateService: TranslateService) {
    }

    ngOnChanges() {
        if (this.alreadyRegistered) {
            let translatedString = 'User already registered.';
            this.translateService.get('shared.already.registered.error').subscribe(
                (translation: string) => {
                    translatedString = translation;
                }
            );
            this.uxService.growl({
                severity: 'error',
                summary: 'ERROR',
                detail: translatedString
            });
        }
    }
}