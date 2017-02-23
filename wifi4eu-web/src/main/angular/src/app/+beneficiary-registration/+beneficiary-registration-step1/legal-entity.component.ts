import {Component, Input, Output, EventEmitter} from "@angular/core";
import {Http} from "@angular/http";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {EntityService} from "./legal-entity.service";
import {EntityDetails} from "../../shared/models/legal-entity-details.model";
import {CountryDetails} from "../../shared/models/country-details.model";
import {MunicipalityDetails} from "../../shared/models/municipality-details.model";

@Component({
    selector: 'legal-entity-component',
    templateUrl: 'legal-entity.component.html',
    providers: [EntityService]
})
export class EntityComponent {

    countries: CountryDetails[];

    countrySuggestions: CountryDetails[];
    municipalitySuggestions: MunicipalityDetails[];

    @Input('entityDetails') entityDetails: EntityDetails;
    @Output() onNext = new EventEmitter<number>();


    constructor(private http: Http, private entityService: EntityService, private uxService: UxService) {
    }

    checkCountry() {
        if (typeof this.entityDetails.country === "string") {
            let countryName: string = this.entityDetails.country;
            let countries: CountryDetails[] = this.countries;

            for (let i in countries) {
                if (countries[i].name.toLowerCase() == countryName.toLowerCase()) {
                    this.entityDetails.country = countries[i];
                    break;
                }
            }
        }
    }

    onSubmit(step: number) {
        this.onNext.emit(step);
    }

    filterCountry(event) {
        // TODO - In a real application, make a request to a remote url with the query
        // and return results, for demo we get it at client side.
        this.entityService.getCountries().subscribe(countries => {
            this.countries = countries;
            this.countrySuggestions = this.filterCountries(event.query, countries);
        }, error => {
            this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not get countries, ignore this when NG is working in offline mode'
            });
            console.log('WARNING: Could not get countries');
        });
        /*this.entityService
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
        this.getMunicipalities(query);
        /*this.http.get('lau.json').map(function(res:Response){
         municipalityList = res.data;
         });*/
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