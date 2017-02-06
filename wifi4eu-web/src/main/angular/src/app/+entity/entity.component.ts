import {Component, Input, Output, EventEmitter} from "@angular/core";
import {Http} from "@angular/http";
import {EntityService} from "./entity.service";
import {CountryList} from "./country-list.model";
import {EntityDetails} from "./entity-details.model";
import {CountryDetails} from "./country-details.model";
import {MunicipalityDetails} from "./municipality-details.model";

@Component({selector: 'entity-component', templateUrl: 'entity.component.html', providers: [EntityService]})
export class EntityComponent {

    countrySuggestions: any[];
    municipalitySuggestions: any[];

    @Input('entityDetails') entityDetails: EntityDetails;
    @Output() onNext = new EventEmitter<number>();


    constructor(private entityService: EntityService, private http: Http) {
    }

    onSubmit(step: number) {
        this.onNext.emit(step);
    }

    filterCountry(event) {
        // TODO - In a real application, make a request to a remote url with the query
        // and return results, for demo we get it at client side.
        let query = event.query;
        let countryList = new CountryList();

        this.countrySuggestions = this.filterCountries(query, countryList.getAll());
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

    filterCountries(query, countries: CountryDetails[]): CountryDetails[] {
        // TODO - In a real application, make a request to a remote url with the query
        // and return filtered results, for demo we filter at client side.
        let filtered: CountryDetails[] = [];
        for (let i = 0; i < countries.length; i++) {
            let country = countries[i];
            if (country.name.toLowerCase().indexOf(query.toLowerCase()) == 0) {
                filtered.push(country);
            }
        }
        return filtered;
    }

    filterMunicipality(event) {
        // TODO - In a real application, make a request to a remote url with the query
        // and return filtered results, for demo we filter at client side.
        let query = event.query;

        /*this.http.get('lau.json').map(function(res:Response){
         municipalityList = res.data;
         });*/

        this.getMunicipalities(query);

    }

    getMunicipalities(query) {
        if (this.entityDetails.country != null) {
            this.entityService.getMunicipalities(this.entityDetails.country.code).subscribe(municipalities => {
                if (municipalities != null) {
                    this.municipalitySuggestions = this.filterMunicipalities(query, municipalities);
                }
            });
        }
    }

    filterMunicipalities(query, municipalities: MunicipalityDetails[]): MunicipalityDetails[] {
        // TODO - In a real application, make a request to a remote url with the query
        // and return filtered results, for demo we filter at client side.
        let filtered: any[] = [];

        for (let i = 0; i < municipalities.length; i++) {
            let municipality = municipalities[i];
            if (municipality.NAME_1 != null) {
                if (municipality.NAME_1.toLowerCase().indexOf(query.toLowerCase()) == 0) {
                    filtered.push(municipality);
                }
            }
        }
        return filtered;
    }


}