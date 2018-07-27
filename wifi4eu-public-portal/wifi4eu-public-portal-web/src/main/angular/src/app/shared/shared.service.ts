import { Injectable } from '@angular/core';
import { Subject } from "rxjs";
import { TranslateService } from "ng2-translate";
import { UxService } from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";

@Injectable()
export class SharedService {
    private emitUpdate = new Subject<any>();
    private emitLogout = new Subject<any>();
    private emitClean = new Subject<any>();
    private emitLanguage = new Subject<any>();

    updateEmitter = this.emitUpdate.asObservable();
    logoutEmitter = this.emitLogout.asObservable();
    cleanEmitter = this.emitClean.asObservable();
    languageEmitter = this.emitLanguage.asObservable();

    constructor(private translateService: TranslateService, private uxService: UxService) {
    }

    update() {
        this.emitUpdate.next();
    }

    login() {
    }

    logout() {
        this.emitLogout.next();
    }

    clean() {
        this.emitClean.next();
    }

    changeLanguage() {
        this.emitLanguage.next();
    }

    growlTranslation(translatedString: string, keyToTranslate: string, type: string) {
        this.translateService.get(keyToTranslate).subscribe(
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