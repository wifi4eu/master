import { Injectable } from '@angular/core';
import { Resolve } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable()
export class InstallationSiteService {

    installationSiteSelected: string

    constructor() { }

}


@Injectable()
export class InstallationSiteDetailResolver implements Resolve<string> {

    constructor() { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> | Promise<any> | any {
        let id: string = route.paramMap.get('id');
        if (id != null) {
            return id;
            // return this.swaggerApi.getBeneficiaryById(parseInt(id, 10)).map((res: Response) => {
            //     if (res['succeeded']) {
            //         return res['body'];
            //     }
            // }).catch(error => {
            // error handling
            // });
        }
    }
}