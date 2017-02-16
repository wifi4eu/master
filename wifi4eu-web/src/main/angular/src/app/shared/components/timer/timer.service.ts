import {Injectable} from '@angular/core';
import {Response, Http} from "@angular/http";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {Observable} from "rxjs";

@Injectable()
export class TimerService {
    constructor(protected http: Http, protected uxService: UxService) {
    }

    getExpirationDateTime(): number {
        // TODO - Should call our internal REST API.
        return new Date(2017, 1, 16, 15, 5, 25, 250).getTime();
    }

    getExpirationDateTime2(): Observable <number> {
        // TODO - Should call our internal REST API.
        return this.http.get('/api/timer/expiration-dates.json').map(function (response: Response) {
            console.log("expirationDate", response.json());
            return response.json();
        }).catch(this.uxService.handleError);
    }
}