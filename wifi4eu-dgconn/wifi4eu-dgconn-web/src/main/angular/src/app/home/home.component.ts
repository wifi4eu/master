import { Component } from '@angular/core';
import { Router } from "@angular/router";
import { LocalStorageService } from "angular-2-local-storage";
import { SharedService } from "../shared/shared.service";

@Component({ selector: 'home-component', templateUrl: 'home.component.html' })
export class HomeComponent {
    constructor(private sharedService: SharedService, private router: Router, private localStorageService: LocalStorageService) {
        if (this.sharedService.user) {
            this.redirectUser();
        } else {
            this.sharedService.loginEmitter.map(() => {
                this.redirectUser();
            });
        }
    }

    private redirectUser() {
		// Only users of type '5' are accepted to access 'dgconn'
        switch (this.sharedService.user.type) {
            case 5:
                this.router.navigateByUrl('/dgconn-portal');
                break;
            default:
                this.router.navigateByUrl('/notfound');
                break;
        }
    }

}