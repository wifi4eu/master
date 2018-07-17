import { Injectable } from '@angular/core';
import { Response, Http } from '@angular/http';
import { UxService } from '@eui/ux-commons';
import { Observable } from 'rxjs/Observable';
import { UserDetails } from '../models/user-details.model';

@Injectable()
export class UserDetailsService {
    constructor(protected http: Http, protected uxService: UxService) {
    }

    getUserDetails(): Observable<UserDetails> {
        return this.http.get('api/user-details')
                                .map((response: Response) => response.json())
                                .catch(this.uxService.handleError);
    }
}
