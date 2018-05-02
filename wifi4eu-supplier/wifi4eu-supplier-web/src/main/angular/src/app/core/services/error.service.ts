import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { UxService } from '@eui/ux-commons';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Injectable()
export class ErrorHandlingService {
    httpErrors = {
        0: { 'msg': 'error.0' },
        404: { 'msg': 'error.404' },
        401: { 'msg': 'error.401' },
        500: { 'msg': 'error.500' }
    }

    constructor(private uxService: UxService, private translateService: TranslateService) {
        this.getHttpErrorsTranslated();
    }

    private getHttpErrorsTranslated(){
        this.translateService.get(this.httpErrors["0"].msg).subscribe(
            (translatedString: string) => {
                this.httpErrors["0"].msg = translatedString;
            }
        );
        this.translateService.get(this.httpErrors["404"].msg).subscribe(
            (translatedString: string) => {
                this.httpErrors["404"].msg = translatedString;
            }
        );
        this.translateService.get(this.httpErrors["401"].msg).subscribe(
            (translatedString: string) => {
                this.httpErrors["401"].msg = translatedString;
            }
        );
    }

    handleError(err: any) {
        let errorMessage = '';
        if (err.hasOwnProperty('errorCode')) {
            if (this.httpErrors.hasOwnProperty(err.errorCode)) {
                errorMessage = this.httpErrors[err.errorCode].msg;
            } else {
                errorMessage = `Error status: ${err.errorCode}`;
                if (err.hasOwnProperty('errorMessage')) {
                    this.translateService.get(err.errorMessage).subscribe(
                        (translation: string) => {
                            errorMessage += ' ' + translation;
                        }, error => {
                            errorMessage += ' ' + err.errorMessage;
                        });
                }
            }
        }
        if (errorMessage === '') {
            if (err.hasOwnProperty('error') && err.error.hasOwnProperty('message')) {
                errorMessage = `Error: ${err.error.message}`;
            }
        }
        if (errorMessage === '') {
            if (err.hasOwnProperty('errorMessage')) {
                errorMessage = `${err.errorMessage}`;
            }
        }
        if (errorMessage === '') errorMessage = this.httpErrors[0].msg;
        this.uxService.growl({ severity: 'danger', summary: 'DANGER', detail: errorMessage }, false, false, 7000);
        return Observable.throw(errorMessage);
    }

}
