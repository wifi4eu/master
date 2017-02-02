import {Component, EventEmitter, Input, Output} from "@angular/core";
import {EntityService} from "./entity.service";
import {CountryList} from "./country-list.model";
import {CountryDetails} from "./country-details.model";
import {EntityDetails} from "./entity-details.model";

@Component({selector: 'entity-component', templateUrl: 'entity.component.html', providers: [EntityService]})
export class EntityComponent {
    @Input('entityDetails') entityDetails: EntityDetails;
    @Input('completedSteps') completedSteps: boolean[];
    @Input('activeSteps') activeSteps: boolean[];
    @Input('currentStep') currentStep: number;
    wrongDetails: string [];
    countrySuggestions: any[];
    municipalitySuggestions: any[];

    constructor(private entityService: EntityService) {
        this.wrongDetails = [];
    }

    @Output() onNext = new EventEmitter<number>();

    doStuff() {
    }

    nextStep(step: number) {
        this.onNext.emit(step);
    }

    checkEntityDetails() {
        if (this.entityDetails.country == null || this.entityDetails.country.name == "" || this.entityDetails.country.code == "") {
            this.wrongDetails.push("country");
            //console.log("country is empty!");
        }
        if (this.entityDetails.municipality == null || this.entityDetails.municipality == "") {
            this.wrongDetails.push("municipality");
            //console.log("municipality is empty!");
        }
        if (typeof this.entityDetails.municipality != "string") {
            //console.log("the municipality is an object, not a string!");
        }
        if (this.entityDetails.address == null || this.entityDetails.address == "") {
            this.wrongDetails.push("address");
            //console.log("address is empty!");
        }
        if (this.entityDetails.number == null || this.entityDetails.number == "") {
            this.wrongDetails.push("number");
            //console.log("number is empty!");
        }
        if (this.entityDetails.postalCode == null || this.entityDetails.postalCode == "") {
            this.wrongDetails.push("postalCode");
            //console.log("postalCode is empty!");
        }
    }

    checkIfWrong(detail: string) {
        if (this.wrongDetails.indexOf(detail) > -1) {
            return true;
        } else {
            return false;
        }
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
         //console.log(countries);
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
         //console.log(countries);
         this.suggestions = this.filterCountries(query, countries);
         });
         */
    }

    filterMunicipalities(query, municipalities: any[]): any[] {
        // TODO - In a real application, make a request to a remote url with the query
        // and return filtered results, for demo we filter at client side.
        let filtered: any[] = [];
        for (let i = 0; i < municipalities.length; i++) {
            let municipality = municipalities[i];
            if (municipality.name.toLowerCase().indexOf(query.toLowerCase()) == 0) {
                filtered.push(municipality);
            }
        }
        return filtered;
    }
}