import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response} from "@angular/http";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {Observable} from "rxjs";
import {UserDetails} from "../models/user-details.model";
import {BeneficiaryDTO} from "../swagger/model/BeneficiaryDTO";
import * as CryptoJS from "crypto-js";

@Injectable()
export class UserService {

    private addBeneficiaryUrl: string;
    private loginUrl: string;

    constructor(protected http: Http, protected uxService: UxService) {
        this.addBeneficiaryUrl = 'api/beneficiary';
        this.loginUrl = 'api/user/login';
    }

    private extractData(response: Response): Object {
        let body = response.json();
        return body.data || body.error || {};
    }

    addBeneficiary(beneficiary: BeneficiaryDTO): Observable<BeneficiaryDTO> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        console.log(beneficiary);

        return this.http.post(this.addBeneficiaryUrl, beneficiary, options)
            .map(this.extractData)
            .catch(this.uxService.handleError);
    }

    getUser(user: UserDetails): Observable<Object> {
        let email512 = CryptoJS.SHA512(user.beneficiary.email);
        let password512 = CryptoJS.SHA512(user.beneficiary.password);
        let token = CryptoJS.SHA512(email512.toString() + password512.toString() + 'Wifi4EU').toString();

        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.post(this.loginUrl, {
            "email": user.beneficiary.email,
            "password": user.beneficiary.password,
        }, options)
            .map(this.extractData)
            .catch(this.uxService.handleError);
    }
}