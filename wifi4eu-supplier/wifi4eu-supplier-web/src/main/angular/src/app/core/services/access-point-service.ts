import { Injectable } from "@angular/core";
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from "@angular/router";
import { Observable } from 'rxjs/Observable';
import { AccessPointBase } from "../../shared/swagger/model/AccessPoint";
import { AccesspointsApi } from "../../shared/swagger/api/AccesspointsApi";
import { ResponseDTOBase } from "../../shared/swagger";
import { ErrorHandlingService } from "./error.service";

@Injectable()
export class AccessPointDetailsResolver implements Resolve<AccessPointBase[]> {

    constructor(private accessPointApi: AccesspointsApi, private router: Router,
        private errorHandlingService: ErrorHandlingService) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> | Promise<any> | any {
        let apId: number = +route.paramMap.get('ap');
        if (apId != null) {
            return this.accessPointApi.getAccessPointById(apId).map((response: ResponseDTOBase) => {
                if (response.success) {
                    return response.data;
                }
            }).catch(error => {
                console.log(error);
                return this.errorHandlingService.handleError(error);
            });
        }
    }

}