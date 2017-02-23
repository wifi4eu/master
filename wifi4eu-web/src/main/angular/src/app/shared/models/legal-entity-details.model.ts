import {CountryDetails} from "./country-details.model";
import {MunicipalityDetails} from "./municipality-details.model";

export class EntityDetails {
    public country: CountryDetails;
    public municipality: MunicipalityDetails;
    public address: string;
    public number: string;
    public postalCode: string;

    public constructor() {
    }
}