import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response} from "@angular/http";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {Observable} from "rxjs";
import {UserDetails} from "../models/user-details.model";
import * as CryptoJS from "crypto-js";

@Injectable()
export class UserService {

    private userUrl: string;

    constructor(protected http: Http, protected uxService: UxService) {
        this.userUrl = '/api/user';
    }

    private extractData(response: Response): Object {
        let body = response.json();
        return body.data || {};
    }

    addUser(user: UserDetails): Observable<UserDetails> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        console.log(user);

        return this.http.post(this.userUrl, user, options)
            .map(this.extractData)
            .catch(this.uxService.handleError);
    }

    getUser(user: UserDetails): Observable<UserDetails> {
        let email512 = CryptoJS.SHA512(user.beneficiary.email);
        let password512 = CryptoJS.SHA512(user.beneficiary.password);
        let token = CryptoJS.SHA512(email512 + password512 + 'Wifi4EU').toString();

        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.post(this.userUrl, {
            "email": user.beneficiary.email,
            "password": token,
        }, options)
            .map(this.extractData)
            .catch(this.uxService.handleError);
    }
}