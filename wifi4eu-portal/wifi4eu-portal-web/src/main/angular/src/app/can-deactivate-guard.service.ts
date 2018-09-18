import { Observable, Subject, Observer } from "rxjs";
import { CanDeactivate, ActivatedRouteSnapshot, RouterStateSnapshot } from "@angular/router";
import { Injectable } from "@angular/core";
import { FormGroup } from "@angular/forms";
import { AdditionalInfoComponent } from "./+beneficiary-portal/+additional-info/additional-info.component";
import { ConfirmationService } from "primeng/primeng";

export interface CanComponentDeactivate {
    canDeactivate: () => Observable<boolean> | Promise<boolean> | boolean;
}

@Injectable()
export class CanDeactivateGuard implements CanDeactivate<AdditionalInfoComponent>{

    constructor(private confirmationService: ConfirmationService) {

    }

    canDeactivate(component: AdditionalInfoComponent) {
        if (!component.fileForm.dirty) {
            return true;
        }
        return Observable.create((observer: Observer<boolean>) => {
            this.confirmationService.confirm({
                message: 'potato',
                accept: () => {
                    observer.next(true);
                    observer.complete();
                },
                reject: () => {
                    observer.next(false);
                    observer.complete();
                }
            });
        });
    }
}