import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, Router } from '@angular/router';
import { LocalStorageService } from "angular-2-local-storage";
import { UserDTOBase } from "./shared/swagger/model/UserDTO";

@Injectable()
export class AppGuard implements CanActivate {
    private user: UserDTOBase;

    constructor(private localStorage: LocalStorageService, private router: Router) {
    }

    canActivate(route: ActivatedRouteSnapshot) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        let allow = false;
        switch (route.url[0].path) {
            case "beneficiary-registration":
                allow = this.canActivateUnregistered();
                break;
            case "supplier-registration":
                allow = this.canActivateUnregistered();
                break;
            case "beneficiary-portal":
                allow = this.canActivateBeneficiary();
                break;
            case "supplier-portal":
                allow = this.canActivateSupplier();
                break;
        }
        if (!allow) {
            this.router.navigateByUrl('/notfound');
        }
        return allow;
    }

    canActivateUnregistered() {
        if (this.user === null) {
            return false;
        }
        return (this.user.type == 0) ? true : false;
    }

    canActivateBeneficiary() {
        if (this.user === null) {
            return false;
        }
        return (this.user.type == 3) ? true : false;
    }

    canActivateSupplier() {
        if (this.user === null) {
            return false;
        }
        return (this.user.type == 1) ? true : false;
    }

    canActivateDgConn() {
        if (this.user === null) {
            return false;
        }
        return (this.user.type == 5) ? true : false;
    }
}