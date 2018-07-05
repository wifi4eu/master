
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

    private emitChangeSource = new Subject<any>();
    private emitUpdate = new Subject<any>();
    private emitLogin = new Subject<any>();
    private emitLogout = new Subject<any>();
    private emitClean = new Subject<any>();

    changeEmitted = this.emitChangeSource.asObservable();
    updateEmitter = this.emitUpdate.asObservable();
    loginEmitter = this.emitLogin.asObservable();
    logoutEmitter = this.emitLogout.asObservable();
    cleanEmitter = this.emitClean.asObservable();

    user: UserDTOBase = null;

    constructor(private translateService: TranslateService, private uxService: UxService) {
    }

    emitChange() {
        this.emitChangeSource.next();
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

    growlTranslation(translatedString: string, keyToTranslate: string, type: string, params?: any) {
        this.translateService.get(keyToTranslate, params).subscribe(
            (translation: string) => {
                if (translation) {
                    translatedString = translation;
                }
                switch (type) {
                    case 'success':
                        this.uxService.growl({
                            severity: 'success',
                            summary: 'SUCCESS',
                            detail: translatedString
                        });
                        break;
                    case 'error':
                        this.uxService.growl({
                            severity: 'error',
                            summary: 'ERROR',
                            detail: translatedString
                        });
                        break;
                    case 'warn':
                        this.uxService.growl({
                            severity: 'warn',
                            summary: 'WARNING',
                            detail: translatedString
                        });
                        break;
                    case 'info':
                        this.uxService.growl({
                            severity: 'info',
                            summary: 'INFO',
                            detail: translatedString
                        });
                        break;
                }
            }, error => {
                switch (type) {
                    case 'success':
                        this.uxService.growl({
                            severity: 'success',
                            summary: 'SUCCESS',
                            detail: translatedString
                        });
                        break;
                    case 'error':
                        this.uxService.growl({
                            severity: 'error',
                            summary: 'ERROR',
                            detail: translatedString
                        });
                        break;
                    case 'warn':
                        this.uxService.growl({
                            severity: 'warn',
                            summary: 'WARNING',
                            detail: translatedString
                        });
                        break;
                    case 'info':
                        this.uxService.growl({
                            severity: 'info',
                            summary: 'INFO',
                            detail: translatedString
                        });
                        break;
                }
            }
        );
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