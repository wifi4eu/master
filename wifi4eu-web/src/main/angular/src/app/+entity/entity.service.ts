import {Injectable} from '@angular/core';
import {Response, Http} from '@angular/http';
import {UxService} from '@ec-digit-uxatec/eui-angular2-ux-commons';
import {Observable} from 'rxjs';
import {MunicipalityDetails} from './municipality-details.model';

@Injectable()
export class EntityService {
  constructor(protected http : Http, protected uxService : UxService) {}

  getMunicipalities(countryCode:string) : Observable < MunicipalityDetails[] > {
    // TODO - Should call our internal REST API.
    return this
      .http
      .get('/lau/'+countryCode+'.json')
      .map(function(response: Response){
        return response.json();
      })
      .catch(this.uxService.handleError);
  }
}