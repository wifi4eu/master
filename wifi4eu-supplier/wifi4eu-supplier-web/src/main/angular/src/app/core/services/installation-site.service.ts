import { Injectable } from '@angular/core';
import { Resolve, Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { InstallationsiteApi } from '../../shared/swagger/api/InstallationsiteApi';
import { InstallationSiteBase } from '../../shared/swagger/model/InstallationSite';
import { ResponseDTOBase } from '../../shared/swagger';
import { ErrorHandlingService } from './error.service';

@Injectable()
export class InstallationSiteDetailResolver implements Resolve<InstallationSiteBase[]> {

    constructor(private installationSiteApi: InstallationsiteApi, private router: Router,
        private errorHandlingService: ErrorHandlingService) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> | Promise<any> | any {
        let id: number = +route.paramMap.get('id');
        if (id != null) {
            return this.installationSiteApi.getInstallationSite(id).map((response: ResponseDTOBase) => {
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