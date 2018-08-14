import {Injectable} from '@angular/core';
import {Subject} from "rxjs";
import {TranslateService} from "ng2-translate";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {Resolve} from '@angular/router/src/interfaces';
import {LocalStorageService} from 'angular-2-local-storage';
import {Observable} from 'rxjs/Observable';
import {UserDTOBase} from "./swagger/model/UserDTO";
import {BaseRequestOptions, Headers} from '@angular/http';

@Injectable()
export class SharedService {

    private emitUpdate = new Subject<any>();
    private emitLogin = new Subject<any>();
    private emitLogout = new Subject<any>();
    private emitClean = new Subject<any>();
    emitLanguage = new Subject<any>();

    updateEmitter = this.emitUpdate.asObservable();
    loginEmitter = this.emitLogin.asObservable();
    logoutEmitter = this.emitLogout.asObservable();
    cleanEmitter = this.emitClean.asObservable();
    languageEmitter = this.emitLanguage.asObservable();

    user: UserDTOBase = null;

    constructor(private translateService: TranslateService, private uxService: UxService) {
    }

    update() {
        this.user = null;
        this.emitUpdate.next();
    }

    login(user: UserDTOBase) {
        this.user = user;
        this.emitLogin.next();
    }

    logout() {
        this.user = null;
        this.emitLogout.next();
    }

    clean() {
        this.emitClean.next();
    }

    growlTranslation(translatedString: string, keyToTranslate: any, type: string, params?: any, life?: number) {
        if (life === undefined || !life) {
            life = 10000;
        }
        this.translateService.get(keyToTranslate, params).subscribe(
            (translation: any) => {
                if (translation) {
                    translatedString = translation;
                }
                
                let successSummary = this.translateService.instant('summary.success');
                switch (type) {
                    case 'success':
                    this.uxService.growl({
                        severity: 'success',
                        summary: successSummary,
                        detail: translatedString
                    }, false, false, life);
                    break;
                    case 'error':
                        this.uxService.growl({
                            severity: 'error',
                            summary: 'ERROR',
                            detail: translatedString
                        }, false, false, life);
                        break;
                    case 'warn':
                        this.uxService.growl({
                            severity: 'warn',
                            summary: 'WARNING',
                            detail: translatedString
                        }, false, false, life);
                        break;
                    case 'info':
                        this.uxService.growl({
                            severity: 'info',
                            summary: 'INFO',
                            detail: translatedString
                        }, false, false, life);
                        break;
                }
            }, error => {
                switch (type) {
                    case 'success':
                        this.uxService.growl({
                            severity: 'success',
                            summary: 'SUCCESS',
                            detail: translatedString
                        }, false, false, life);
                        break;
                    case 'error':
                        this.uxService.growl({
                            severity: 'error',
                            summary: 'ERROR',
                            detail: translatedString
                        }, false, false, life);
                        break;
                    case 'warn':
                        this.uxService.growl({
                            severity: 'warn',
                            summary: 'WARNING',
                            detail: translatedString
                        }, false, false, life);
                        break;
                    case 'info':
                        this.uxService.growl({
                            severity: 'info',
                            summary: 'INFO',
                            detail: translatedString
                        }, false, false, life);
                        break;
                }
            }
        );
    }

    getMimeType(base64string: string) {
        let mimeType = null;
        if (base64string != null) {
            if (base64string.startsWith('data:') && base64string.indexOf(';base64') != -1) {
                mimeType = base64string.substr(5, (base64string.indexOf(';base64') - 5));
            }
        }
        return mimeType;
    }

    getFileExtension(base64string: string) {
        let fileExtension = null;
        if (base64string != null) {
            let mimeType = this.getMimeType(base64string);
            switch (mimeType) {
                case 'text/plain':
                    fileExtension = '.txt';
                    break;
                case 'text/csv':
                    fileExtension = '.csv';
                    break;
                case 'application/msword':
                    fileExtension = '.doc';
                    break;
                case 'application/vnd.openxmlformats-officedocument.wordprocessingml.document':
                    fileExtension = '.docx';
                    break;
                case 'application/vnd.ms-excel':
                    fileExtension = '.xls';
                    break;
                case 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet':
                    fileExtension = '.xlsx';
                    break;
                case 'application/pdf':
                    fileExtension = '.pdf';
                    break;
                case 'image/png':
                    fileExtension = '.png';
                    break;
                case 'image/jpg':
                    fileExtension = '.jpg';
                    break;
                case 'image/jpeg':
                    fileExtension = '.jpeg';
                    break;
            }
        }
        return fileExtension;
    }

    getBase64Data(base64string: string) {
        let base64Data = null;
        if (base64string != null) {
            if (base64string.startsWith('data:') && base64string.indexOf(';base64,') != -1) {
                base64Data = base64string.substr(base64string.indexOf(';base64,') + 8);
            }
        }
        return base64Data;
    }
}

@Injectable()
export class EcasLoginResolver implements Resolve<any> {
    constructor(private localStorage: LocalStorageService) {
    }

    resolve() {
        return Observable.of(this.localStorage.get('user'));
    }
}

@Injectable()
export class CustomRequestOptions extends BaseRequestOptions {
    headers = new Headers({
        'Cache-Control': 'no-cache',
        'Pragma': 'no-cache',
        'Expires': 'Sat, 01 Jan 2000 00:00:00 GMT'
    });
}