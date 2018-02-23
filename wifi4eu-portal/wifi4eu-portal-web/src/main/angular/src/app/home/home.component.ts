import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { LocalStorageService } from "angular-2-local-storage";
import { UserDTOBase } from "../shared/swagger/model/UserDTO";

@Component({selector: 'home-component', templateUrl: 'home.component.html'})

export class HomeComponent implements OnInit {
    private user: UserDTOBase;

    constructor(private localStorage: LocalStorageService, private router: Router) {
    }

    ngOnInit() {
        let publicRedirection = this.localStorage.get('public-redirection');
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        if (this.user != null) {
            switch (this.user.type) {
                case 0:
                    if (publicRedirection) {
                        this.router.navigateByUrl(String(publicRedirection));
                        this.localStorage.remove('public-redirection');
                    }
                    this.router.navigateByUrl('/beneficiary-registration');
                    break;
                case 1:
                    this.router.navigateByUrl('/supplier-portal/profile');
                    break;
                case 3:
                    this.router.navigateByUrl('/beneficiary-portal/profile');
                    break;
            }
        }
    }
}