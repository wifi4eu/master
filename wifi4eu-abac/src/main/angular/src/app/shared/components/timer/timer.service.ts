import {Injectable} from '@angular/core';
import {Response, Http} from "@angular/http";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {Observable} from "rxjs";

@Injectable()
export class TimerService {
    private voucherUrl: string;

    constructor(protected http: Http, protected uxService: UxService) {
        this.voucherUrl = '/api/timer/voucher';
    }

    getExpirationDateTime(): number {
        // TODO - Should call our internal REST API.
        return new Date(2017, 1, 24, 9, 30, 0, 250).getTime();
    }

    getExpirationDateTime2(): Observable <number> {
        // TODO - Should call our internal REST API.
        return this.http.get(this.voucherUrl).map(response => {
            return response.json();
        }).catch(this.uxService.handleError);
    }
}