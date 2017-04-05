import {Component} from '@angular/core';
import {UserApi} from "../../swagger/api/UserApi";
import {UserDTO, UserDTOBase} from "../../swagger/model/UserDTO";

@Component({selector: 'success-component', templateUrl: 'success.component.html', providers: [UserApi]})
export class SuccessComponent {
    userDTO: UserDTO = new UserDTOBase();

    constructor(private userApi: UserApi) {
    }

    onClick() {
        this.userApi.resendEmail(this.userDTO).subscribe(
            data => {
                console.log(data);
            },
            error => {
                console.log(error);
            }
        );
    }
}