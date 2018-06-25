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
        switch (this.sharedService.user.type) {
            case 1:
                this.router.navigateByUrl('/supplier-portal/profile');
                break;
            case 3:
                this.router.navigateByUrl('/beneficiary-portal/profile');
                break;
            case 5:
                this.router.navigateByUrl('/notfound');
                break;
            default:
                let publicRedirection = this.localStorageService.get('public-redirection');
                if (publicRedirection) {
                    this.router.navigateByUrl(String(publicRedirection));
                } else {
                    this.router.navigateByUrl('/beneficiary-registration');
                }
                break;
        }
    }

}