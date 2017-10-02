import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {Observable} from "rxjs";

@Injectable()
export class ForgotService {

    private activationUrl: string;
    private forgotUrl: string;

    constructor(private http: Http, private uxService: UxService) {
        this.activationUrl = 'api/user/activateaccount';
        this.forgotUrl = 'api/user/forgotpassword';
    }

    private extractData(response: Response) {
        let body = response.json();
        return body.data || {};
    }

    sendEmail(body: string): Observable <Object> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        // TODO - Need to use SHA512 password encryption.
        return this.http.post(this.forgotUrl, body, options)
            .map(this.extractData)
            .catch(this.uxService.handleError);
    }

    addNewPassword(body: Object): Observable <Object> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        // TODO - Need to use SHA512 password encryption.
        return this.http.post(this.activationUrl, body, options)
            .map(this.extractData)
            .catch(this.uxService.handleError);
    }


}