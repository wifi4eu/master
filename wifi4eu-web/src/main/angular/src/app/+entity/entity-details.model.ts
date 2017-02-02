import {CountryDetails} from "./country-details.model";

export class EntityDetails {
    public country: CountryDetails;
    public municipality: string;
    public address: string;
    public number: string;
    public postalCode: string;

    public constructor() {
    }
}