import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {Observable} from "rxjs";

@Injectable()
export class ProfileService {

    private profileUrl = '/api/forgot';

    constructor(private http: Http, private uxService: UxService) {
    }

    private extractData(response: Response) {
        let body = response.json();
        return body.data || {};
    }

    changePassword(body: Object): Observable <Object> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.put(this.profileUrl, body, options)
            .map(this.extractData)
            .catch(this.uxService.handleError);
    }


}