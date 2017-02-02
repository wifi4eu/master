import {Injectable} from '@angular/core';
import {Response, Http} from '@angular/http';
import {UxService} from '@ec-digit-uxatec/eui-angular2-ux-commons';
import {Observable} from 'rxjs';
import {CountryDetails} from './country-details.model';

@Injectable()
export class EntityService {
  constructor(protected http : Http, protected uxService : UxService) {}

  /*getCountries() : Observable < CountryDetails[] > {
    // TODO - Should call our internal REST API.
    return this
      .http
      .get('http://www.primefaces.org/primeng/showcase/resources/data/countries.json')
      .map((response : Response) => response.json().data)
      .catch(this.uxService.handleError);
  }*/
}