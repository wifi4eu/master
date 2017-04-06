import {Injectable} from '@angular/core';
import {Router, CanActivate, ActivatedRouteSnapshot} from '@angular/router';
import {UserDTO} from "./shared/swagger/model/UserDTO";
import {LocalStorageService} from "angular-2-local-storage";

@Injectable()
export class AppGuard implements CanActivate {
    private user: UserDTO;

    constructor(private localStorage: LocalStorageService) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
    }

    canActivate(route: ActivatedRouteSnapshot) {
        let allow = false;
        switch (route.url[0].path) {
            case "map":
                allow = this.canActivateDgConn();
                break;
            case "beneficiary-portal":
                allow = this.canActivateBeneficiary();
                break;
            case "helpdesk":
                allow = this.canActivateMemberState() || this.canActivateDgConn();
                break;
            case "dgconn-portal":
                allow = this.canActivateDgConn();
                break;
            case "supplier-portal":
                allow = this.canActivateSupplier();
                break;
        }
        return allow;
    }

    canActivateBeneficiary() {
        if (this.user === null) {
            return false;
        }
        return (this.user.userType == 2 || this.user.userType == 3) ? true : false;
    }

    canActivateSupplier() {
        if (this.user === null) {
            return false;
        }
        return (this.user.userType == 1) ? true : false;
    }

    canActivateMemberState() {
        if (this.user === null) {
            return false;
        }
        return (this.user.userType == 4) ? true : false;
    }

    canActivateDgConn() {
        if (this.user === null) {
            return false;
        }
        return (this.user.userType == 5) ? true : false;
    }
}