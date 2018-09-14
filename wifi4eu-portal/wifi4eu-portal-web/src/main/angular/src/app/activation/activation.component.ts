import {Component, Input, OnInit} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {ActivatedRoute, Router} from "@angular/router";
import {UserApi} from "../shared/swagger/api/UserApi";
//import {ActivateAccountDTOBase} from "../shared/swagger/model/ActivateAccountDTO";
import {ResponseDTOBase} from "../shared/swagger/model/ResponseDTO";
import {TranslateService} from "ng2-translate";

@Component({templateUrl: 'activation.component.html', providers: [UserApi]})
export class ActivationComponent implements OnInit {

    //private activation: ActivateAccountDTOBase;

    constructor(private userApi: UserApi, private uxService: UxService, private route: ActivatedRoute, private router: Router, private translateService: TranslateService) {
        //this.activation = new ActivateAccountDTOBase();
    }

    ngOnInit() {
        this.route.params.subscribe(
            params => {
                //this.activation.token = params['token'];

                /*this.userApi.activateAccount(this.activation).subscribe(
                    (data: ResponseDTOBase) => {
                        if (data.success) {
                            let translatedString = 'User activation success.';
                            this.translateService.get('shared.useractivation.success').subscribe(
                                (translation: string) => {
                                    translatedString = translation;
                                }
                            );
                            this.uxService.growl({
                                severity: 'success',
                                summary: 'SUCCESS',
                                detail: translatedString
                            });
                            this.router.navigateByUrl('/beneficiary-portal');
                        } else {
                            let translatedString = 'Could not activate your account.';
                            this.translateService.get('shared.useractivation.failure').subscribe(
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
                        this.translateService.get('shared.useractivation.failure').subscribe(
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
                );*/
            }
        );
    }
}