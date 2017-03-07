import {Injectable} from "@angular/core";
import {Response, Http} from "@angular/http";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {Observable} from "rxjs";
import {MunicipalityDetails} from "../../shared/models/municipality-details.model";
import {CountryDetails} from "../../shared/models/country-details.model";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {NutsApi} from "../../shared/swagger/api/NutsApi";

@Injectable()
export class EntityService {
    constructor(protected http: Http, protected uxService: UxService,
     protected lauApi: LauApi, protected nutsApi: NutsApi) {
    }

    getCountries(): Observable <CountryDetails[]> {

        return this.nutsApi.findNutsByLevel(3);

        // TODO - Should call our internal REST API.
/*        return this.http.get('countries.json').map(function (response: Response) {
            return response.json();
        }).catch(this.uxService.handleError);*/
    }

    getMunicipalities(countryCode: string): Observable <MunicipalityDetails[]> {

        return this.lauApi.findLauByCountryCode(countryCode);

        // TODO - Should call our internal REST API.
/*        return this.http.get(countryCode + '.json').map(function (response: Response) {
            return response.json();
        }).catch(this.uxService.handleError);
*/
    }
}