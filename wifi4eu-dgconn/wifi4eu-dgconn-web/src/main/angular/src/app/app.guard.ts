import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { UserDTOBase } from "./shared/swagger/model/UserDTO";
import { LocalStorageService } from "angular-2-local-storage";

@Injectable()
export class AppGuard implements CanActivate {
    private user: UserDTOBase;

    constructor(private localStorage: LocalStorageService, private router: Router) {
    }

    canActivate(route: ActivatedRouteSnapshot) {
        let allow = false;
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        if (this.user != null) {
            if (this.user.type == 5) {
                allow = true;
            }
        }
        return allow;
    }
}