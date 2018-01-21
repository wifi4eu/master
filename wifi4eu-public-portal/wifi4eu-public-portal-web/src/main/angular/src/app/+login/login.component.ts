import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { UserDTOBase } from "../shared/swagger/model/UserDTO";
import { UserApi } from "../shared/swagger/api/UserApi";
import { ResponseDTOBase } from "../shared/swagger/model/ResponseDTO";
import { LocalStorageService } from "angular-2-local-storage";
import { SharedService } from "../shared/shared.service";

@Component({
    selector: 'login-component', templateUrl: 'login.component.html', providers: [UserApi]
})

export class LoginComponent {
    private user: UserDTOBase = new UserDTOBase();
    private displayConfirmingData: boolean = false;
    private isEcasUser: boolean = false;

    constructor(private userApi: UserApi, private localStorageService: LocalStorageService, private sharedService: SharedService, private router: Router) {
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user.ecasEmail != null) {
            this.isEcasUser = true;
        }else{
            this.user = new UserDTOBase();
        }
    }

    login() {
        this.displayConfirmingData = true;
        this.userApi.login(this.user).subscribe(
            (response: ResponseDTOBase) => {
                this.displayConfirmingData = false;
                if (response.success) {
                    this.sharedService.growlTranslation('Login successful. Welcome to WiFi4EU!', 'shared.login.success', 'success');
                    this.localStorageService.set('user', JSON.stringify(response.data));
                    this.sharedService.update();
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
                    this.sharedService.growlTranslation('Could not login with these credentials. Make sure you typed your password correctly.', 'shared.login.error.wrongcredentials', 'warn');
                }
            }, error => {
                this.displayConfirmingData = false;
                this.sharedService.growlTranslation('Could not login. Please, try again later.', 'shared.login.error', 'error');
            }
        );
    }
}