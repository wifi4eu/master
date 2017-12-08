import {Component, Input, OnInit} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {ActivatedRoute, Router} from "@angular/router";
import {UserApi} from "../shared/swagger/api/UserApi";
import {ActivateAccountDTOBase} from "../shared/swagger/model/ActivateAccountDTO";
import {ResponseDTOBase} from "../shared/swagger/model/ResponseDTO";
import {TranslateService} from "ng2-translate";

@Component({templateUrl: 'activation.component.html', providers: [UserApi]})
export class ActivationComponent implements OnInit {
    private activation: ActivateAccountDTOBase = new ActivateAccountDTOBase();
    private passwordsMatch: boolean = false;

    constructor(private userApi: UserApi, private uxService: UxService, private route: ActivatedRoute, private router: Router, private translateService: TranslateService) {
    }

    ngOnInit() {
        this.route.params.subscribe(params => this.activation.token = params['token']);
    }

    private checkPasswordsMatch() {
        if (this.activation.password.length > 0 && this.activation.password == this.activation.confirmPassword) {
            this.passwordsMatch = true;
        } else {
            this.passwordsMatch = false;
        }
    }

    private submit() {
        this.userApi.activateAccount(this.activation).subscribe(
            (data: ResponseDTOBase) => {
                if (data.success) {
                    let translatedString = 'User activation success.';
                    this.translateService.get('useractivation.success').subscribe(
                        (translation: string) => {
                            translatedString = translation;
                        }
                    );
                    this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                        detail: translatedString
                    });
                    this.router.navigateByUrl('/home');
                } else {
                    let translatedString = 'Could not activate your account.';
                    this.translateService.get('useractivation.failure').subscribe(
                        (translation: string) => {
                            translatedString = translation;
                        }
                    );
                    this.uxService.growl({
                        severity: 'warn',
                        summary: 'WARNING',
                        detail: translatedString
                    });
                    this.router.navigateByUrl('/home');
                }
            }, error => {
                let translatedString = 'Could not activate your account.';
                this.translateService.get('useractivation.failure').subscribe(
                    (translation: string) => {
                        translatedString = translation;
                    }
                );
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: translatedString
                });
                this.router.navigateByUrl('/home');
            }
        );
    }

    private preventPaste(event: any) {
        return false;
    }
}