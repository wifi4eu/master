import {Component} from '@angular/core';
import {EntityService} from './entity.service';

@Component({selector: 'entity-component', template: require('./entity.component.html'), providers: [EntityService]})
export class EntityComponent {

  country : any;
  countries : any[];
  suggestions : any[];

  constructor(private entityService : EntityService) {}

  filterCountrySingle(event) {
    let query = event.query;
    this
      .entityService
      .getCountries()
      .subscribe(countries => {
        console.log(countries);
        this.suggestions = this.filterCountry(query, countries);
      });
  }

  filterCountry(query, countries : any[]) : any[] {
    // In a real application, make a request to a remote url with the query and
    // return filtered results, for demo we filter at client side
    let filtered : any[] = [];
    for (let i = 0; i < countries.length; i++) {
      let country = countries[i];
      if (country.name.toLowerCase().indexOf(query.toLowerCase()) == 0) {
        filtered.push(country);
      }
    }
    return filtered;
  }
}