import {Injectable} from "@angular/core";
import {Response, Http} from "@angular/http";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {Observable} from "rxjs";

// @Injectable()
// export class VoucherService {
//     constructor(protected http: Http, protected uxService: UxService,protected defaultApi:DefaultApi) {
//     }

//     getVoucher(userId:number, callId:number): Observable <VoucherDTO[]> {
//         //call api

//         return this.http.get('voucher').map(function (response: Response) {
//             return response.json();
//         }).catch(this.uxService.handleError);
//     }

//     getMunicipalities(countryCode: string): Observable <MunicipalityDetails[]> {
//         // TODO - Should call our internal REST API.
//         return this.http.get(countryCode + '.json').map(function (response: Response) {
//             return response.json();
//         }).catch(this.uxService.handleError);
//     }
// }