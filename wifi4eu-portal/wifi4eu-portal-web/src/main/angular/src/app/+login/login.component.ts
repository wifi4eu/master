import {Component} from "@angular/core";
import {Router} from "@angular/router";
import {UserDTOBase} from "../shared/swagger/model/UserDTO";
import {UserApi} from "../shared/swagger/api/UserApi";
import {ResponseDTOBase} from "../shared/swagger/model/ResponseDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {TranslateService} from "ng2-translate";
import {SharedService} from "../shared/shared.service";

@Component({
    selector: 'login-component', templateUrl: 'login.component.html', providers: [UserApi]
})

export class LoginComponent {
    private user: UserDTOBase = new UserDTOBase();
    private displayConfirmingData: boolean = false;

    constructor(private userApi: UserApi, private localStorageService: LocalStorageService, private uxService: UxService, private translateService: TranslateService, private sharedService: SharedService, private router: Router) {
    }

    login() {
        this.displayConfirmingData = true;
        this.userApi.login(this.user).subscribe(
            (response: ResponseDTOBase) => {
                this.displayConfirmingData = false;
                if (response.success) {
                    let translatedString = 'Login successful. Welcome to WiFi4EU!';
                    this.translateService.get('login.success').subscribe(
                        (translation: string) => {
                            translatedString = translation;
                        }
                    );
                    this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                        detail: translatedString
                    });
                    this.localStorageService.set('user', JSON.stringify(response.data));
                    this.sharedService.emitChange();
                    switch (this.user.type) {
                        case 1:
                            this.router.navigateByUrl('/supplier-portal/profile');
                            break;
                        case 2:
                        case 3:
                            this.router.navigateByUrl('/beneficiary-portal/profile');
                            break;
                        case 5:
                            this.router.navigateByUrl('/dgconn-portal');
                            break;
                        default:
                            this.router.navigateByUrl('/home');
                            break;
                    }
                } else {
                    let translatedString = 'Could not login with these credentials. Make sure you typed your password correctly.';
                    this.translateService.get('login.error.wrongcredentials').subscribe(
                        (translation: string) => {
                            translatedString = translation;
                        }
                    );
                    this.uxService.growl({
                        severity: 'warn',
                        summary: 'WARNING',
                        detail: translatedString
                    });
                }
            }, error => {
                this.displayConfirmingData = false;
                let translatedString = 'Could not login. Please, try again later.';
                this.translateService.get('login.error').subscribe(
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
        );
    }
}