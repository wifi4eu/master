import {Component} from '@angular/core';
import {Http, Response } from '@angular/http';
import {EntityService} from './entity.service';
import {CountryList} from './country-list.model';
import {CountryDetails} from './country-details.model';
import {MunicipalityDetails} from './municipality-details.model';

@Component({selector: 'entity-component', templateUrl: 'entity.component.html', providers: [EntityService]})
export class EntityComponent {
    @Input('entityDetails') entityDetails: EntityDetails;
    @Input('completedSteps') completedSteps: boolean[];
    @Input('activeSteps') activeSteps: boolean[];
    @Input('currentStep') currentStep: number;
    wrongDetails: string [];
    countrySuggestions: any[];
    municipalitySuggestions: any[];

  country : CountryDetails;
  countries : any[];
  countrySuggestions : any[];

  municipality : any;
  municipalities : MunicipalityDetails[];
  municipalitySuggestions : any[];
    @Output() onNext = new EventEmitter<number>();

  constructor(private entityService : EntityService,private http:Http) {}

    nextStep(step: number) {
        this.onNext.emit(step);
    }
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

  getMunicipalities(query){
    let that = this;
    if(this.country != null){
    this.entityService.getMunicipalities(this.country.code).subscribe(function(res){
        that.municipalities = res;
        if(that.municipalities != null){
          that.municipalitySuggestions = that.filterMunicipalities(query,res);;
        }
      }); 
    }
  }

  filterMunicipality(event) {
    let query = event.query;

/*    this.http.get('lau.json').map(function(res:Response){
          municipalityList = res.data;        
        });

    this.municipalitySuggestions = this.filterMunicipalities(query, municipalityList);*/
    // TODO - In a real application, make a request to a remote url with the query
    // and return results, for demo we get it at client side.

    this.getMunicipalities(query);

  }

  filterMunicipalities(query, municipalities : MunicipalityDetails[]) : MunicipalityDetails[] {
    // TODO - In a real application, make a request to a remote url with the query
    // and return filtered results, for demo we filter at client side.

    let filtered : any[] = [];
    for (let i = 0; i < municipalities.length; i++) {
      let municipality = municipalities[i];
      if (municipality.NAME_1 != null){
        if(municipality.NAME_1.toLowerCase().indexOf(query.toLowerCase()) == 0) {
          filtered.push(municipality);
        }
      }
    }
    return filtered;
  }
}