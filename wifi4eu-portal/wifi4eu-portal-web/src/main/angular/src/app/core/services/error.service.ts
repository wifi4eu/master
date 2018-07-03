import { Injectable } from '@angular/core';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";

@Injectable()
export class ErrorHandlingService {
    constructor(private uxService: UxService) {
    }

    httpErrors = {
        0: { 'msg': 'Server is not available' },
        404: { 'msg': 'Page not Found' },
        401: { 'msg': 'Not Authorized' }
    }

    handleError(err: any) {
        let errorMessage = '';
        if (err.hasOwnProperty('status')) {
            if (this.httpErrors.hasOwnProperty(err.status)) {
                errorMessage = this.httpErrors[err.status].msg;
            } else {
                errorMessage = `Error status: ${err.status}`;
                if (err.hasOwnProperty('message')) {
                    errorMessage += err.message;
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
