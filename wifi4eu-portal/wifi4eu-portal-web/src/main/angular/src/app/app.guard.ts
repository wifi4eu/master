import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { UserDTO } from "./shared/swagger/model/UserDTO";
import { LocalStorageService } from "angular-2-local-storage";

@Injectable()
export class AppGuard implements CanActivate {
    private user: UserDTO;

    constructor(private localStorage: LocalStorageService, private router: Router) {
    }

    canActivate(route: ActivatedRouteSnapshot) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        let allow = false;
        switch (route.url[0].path) {
            case "map":
                allow = this.canActivateDgConn();
                break;
            case "beneficiary-portal":
                allow = this.canActivateBeneficiary();
                break;
            case "beneficiary-registration":
                allow = this.canActivateBeneficiaryRegistration();
                break;
            case "supplier-registration":
                allow = this.canActivateSupplierRegistration();
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
        return (this.user.type == 2 || this.user.type == 3 || this.user.type == 0) ? true : false;
    }

    canActivateBeneficiaryRegistration() {
        if (this.user === null) {
            return true;
        } else if (this.user != null && (this.user.type == 2 || this.user.type == 3)) {
            this.router.navigateByUrl("beneficiary-portal");
        } else if (this.user != null && (this.user.type == 1)) {
            this.router.navigateByUrl("supplier-portal");
        }

        return (this.user.type == 0) ? true : false;
    }

    canActivateSupplierRegistration() {
        if (this.user === null) {
            return true;
        } else if (this.user != null && (this.user.type == 2 || this.user.type == 3)) {
            this.router.navigateByUrl("beneficiary-portal");
        } else if (this.user != null && (this.user.type == 1)) {
            this.router.navigateByUrl("supplier-portal");
        }

        return (this.user.type == 0) ? true : false;
    }

    canActivateSupplier() {
        if (this.user === null) {
            return false;
        }
        return (this.user.type == 1) ? true : false;
    }

    canActivateMemberState() {
        if (this.user === null) {
            return false;
        }
        return (this.user.type == 4) ? true : false;
    }

    canActivateDgConn() {
        if (this.user === null) {
            return false;
        }
        return (this.user.type == 5) ? true : false;
    }
}