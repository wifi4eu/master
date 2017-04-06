import {Component, EventEmitter, Output} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {UserDTO, UserDTOBase} from "../shared/swagger/model/UserDTO";
import {Router} from "@angular/router";
import {UserApi} from "../shared/swagger/api/UserApi";
import {LocalStorageService} from 'angular-2-local-storage';
import {SharedService} from "../shared/shared.service";

@Component({
    selector: 'login-component',
    templateUrl: 'login.component.html',
    providers: [UserApi]
})
export class LoginComponent {

    private displayConfirmingData: boolean;
    private userDTO: UserDTO;

    @Output() onUpdateHeader: EventEmitter<boolean>;

    constructor(private userApi: UserApi, private uxService: UxService, private router: Router, private localStorage: LocalStorageService, private sharedService: SharedService) {
        this.displayConfirmingData = false;
        this.userDTO = new UserDTOBase();
    }

    onSubmit() {
        this.displayConfirmingData = true;

        this.userApi.login(this.userDTO).subscribe(
            response => {
                this.displayConfirmingData = false;
                if (response['success']) {
                    let user: UserDTO = response['data'];
                    this.localStorage.set('user', JSON.stringify(user));
                    this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                        detail: 'Login success'

                    });
                    console.log('SUCCESS: Login success');
                    this.sharedService.emitChange();
                    console.log(user.userType);
                    switch (user.userType) {
                        case 1:
                            this.router.navigateByUrl("supplier-portal");
                            break;
                        case 2:
                        case 3:
                            this.router.navigateByUrl("beneficiary-portal/voucher");
                            break;
                        case 5:
                            this.router.navigateByUrl("dgconn-portal");
                            break;
                        default:
                            this.router.navigateByUrl("home");
                            break;
                    }

                } else {
                    this.uxService.growl({
                        severity: 'error',
                        summary: 'ERROR',
                        detail: 'Could not login, with these user and password'
                    });
                    console.log('ERROR: Could not login, with these user password');

                }
            },
            error => {
                this.displayConfirmingData = false;
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not login, ignore this when NG is working in offline mode'
                });
                console.log('WARNING: Could not login', error);
            }
        );
    }
}