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
            user => console.log(user),
            error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get countries, ignore this when NG is working in offline mode'
                });
                console.log('WARNING: Could not get countries', error);
            }
        );

        setTimeout(() => {
            this.displayConfirmingData = false;
        }, 2000);
    }
}