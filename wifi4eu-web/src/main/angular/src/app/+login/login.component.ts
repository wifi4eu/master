import {Component, Input} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {UserDetails} from "../shared/models/user-details.model";
import {UserService} from "../shared/services/user.service";

@Component({
    selector: 'login-component',
    templateUrl: 'login.component.html',
    providers: [UserService]
})
export class LoginComponent {

    displayConfirmingData: boolean = false;

    @Input('userDetails') userDetails: UserDetails = new UserDetails();

    constructor(private userService: UserService, private uxService: UxService) {
    }

    onSubmit() {
        this.displayConfirmingData = true;

        this.userService.getUser(this.userDetails).subscribe(
            data => {
                this.displayConfirmingData = false;
                if(data == "error"){
                    this.uxService.growl({
                        severity: 'error',
                        summary: 'ERROR',
                        detail: 'Could not login, with these user password'
                    });
                    console.log('ERROR: Could not login, with these user password');
                }else if(data == "success"){
                    this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                        detail: 'Login success'
                    });
                    console.log('SUCCESS: Login success');
                }
            },
            error => {
                this.displayConfirmingData = false;
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get countries, ignore this when NG is working in offline mode'
                });
                console.log('WARNING: Could not get countries', error);
            }
        );
    }
}