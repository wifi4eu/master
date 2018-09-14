import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from "rxjs/Observable";
import { SharedService } from "./shared/shared.service";

@Injectable()
export class AppGuard implements CanActivate {

    constructor(private router: Router, private sharedService: SharedService) {
    }

    canActivate(route: ActivatedRouteSnapshot): Observable<boolean> | boolean {
        let allow = true;
        if (this.sharedService.user) {
            if (this.sharedService.user.userInvited){
                this.router.navigateByUrl('/invited-contact-details');
            }
            allow = this.allowAccess(route.url[0].path);
            if (!allow) {
                this.router.navigateByUrl('/notfound');
            }
            return allow;
        } else {
            return this.sharedService.loginEmitter.map(() => {
                allow = this.allowAccess(route.url[0].path);
                if (!allow) {
                    this.router.navigateByUrl('/notfound');
                }
                return allow;
            });
        }
    }

    private allowAccess(url: string): boolean {
        let allow = false;
        switch (url) {
            case 'home':
                allow = this.allowAccessToAnyone();
                break;
            case 'beneficiary-registration':
            case 'supplier-registration':
                allow = this.allowAccessToUnregistered();
                if(!allow){
                  if(this.allowAccessToSupplier() || this.allowAccessToBeneficiary()){
                    this.router.navigateByUrl('/');
                    allow = true;
                  }
                }
                break;
            case 'beneficiary-portal':
                allow = this.allowAccessToBeneficiary();
                break;
            case 'supplier-portal':
                allow = this.allowAccessToSupplier();
                break;
        }
        return allow;
    }

    private allowAccessToAnyone() {
        if (this.sharedService.user === null) {
            return false;
        } else {
            return true;
        }
    }

    private allowAccessToUnregistered() {
        if (this.sharedService.user === null) {
            return false;
        }
        return (this.sharedService.user.type == 0) ? true : false;
    }

    private allowAccessToSupplier() {
        if (this.sharedService.user === null) {
            return false;
        }
        return (this.sharedService.user.type == 1) ? true : false;
    }

    private allowAccessToBeneficiary() {
        if (this.sharedService.user === null) {
            return false;
        }
        return (this.sharedService.user.type == 3) ? true : false;
    }

    private allowAccessToDgConn() {
        if (this.sharedService.user === null) {
            return false;
        }
        return (this.sharedService.user.type == 5) ? true : false;
    }
}