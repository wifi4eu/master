import {Component} from '@angular/core';
import {EntityService} from './entity.service';
import {CountryList} from './country-list.model';
import {CountryDetails} from './country-details.model';

@Component({selector: 'entity-component', templateUrl: 'entity.component.html', providers: [EntityService]})
export class EntityComponent {

  country : any;
  countries : any[];
  countrySuggestions : any[];

  municipality : any;
  municipalities : any[];
  municipalitySuggestions : any[];

  constructor(private entityService : EntityService) {}

  filterCountry(event) {
    let query = event.query;
    let countryList = new CountryList()
    this.countrySuggestions = this.filterCountries(query, countryList.getAll());
    // TODO - In a real application, make a request to a remote url with the query
    // and return results, for demo we get it at client side.
    /*
    this
      .entityService
      .getCountries()
      .subscribe(countries => {
        console.log(countries);
        this.suggestions = this.filterCountries(query, countries);
      });
    */
  }

  filterCountries(query, countries : CountryDetails[]) : CountryDetails[] {
    // TODO - In a real application, make a request to a remote url with the query
    // and return filtered results, for demo we filter at client side.
    let filtered : CountryDetails[] = [];
    for (let i = 0; i < countries.length; i++) {
      let country = countries[i];
      if (country.name.toLowerCase().indexOf(query.toLowerCase()) == 0) {
        filtered.push(country);
      }
    }
    return filtered;
  }

  filterMunicipality(event) {
    let query = event.query;
    let municipalityList = [
      {
        name: "Brussels"
      }, {
        name: "Flanders"
      }, {
        name: "Wallonia"
      }
    ];
    this.municipalitySuggestions = this.filterMunicipalities(query, municipalityList);
    // TODO - In a real application, make a request to a remote url with the query
    // and return results, for demo we get it at client side.
    /*
    this
      .entityService
      .getCountries()
      .subscribe(countries => {
        console.log(countries);
        this.suggestions = this.filterCountries(query, countries);
      });
    */
  }

  filterMunicipalities(query, municipalities : any[]) : any[] {
    // TODO - In a real application, make a request to a remote url with the query
    // and return filtered results, for demo we filter at client side.
    let filtered : any[] = [];
    for (let i = 0; i < municipalities.length; i++) {
      let municipality = municipalities[i];
      if (municipality.name.toLowerCase().indexOf(query.toLowerCase()) == 0) {
        filtered.push(municipality);
      }
    }
    return filtered;
  }
}