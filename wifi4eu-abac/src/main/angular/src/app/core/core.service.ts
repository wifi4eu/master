import { Injectable } from '@angular/core';
import { Response, Http } from '@angular/http';
import { UxService } from '@ec-digit-uxatec/eui-angular2-ux-commons';
import { Observable } from 'rxjs';
import { UserDetails } from './user-details.model';

@Injectable()
export class CoreService {
    constructor(protected http: Http, protected uxService: UxService) {
    }

    getUserDetails(): Observable<UserDetails> {
        return this.http.get('api/user-details').map((response: Response) => response.json()).catch(this.uxService.handleError);
    }
}

