import * as models from './models';
import {Type} from "class-transformer";

export interface LegalEntityDTO {
    legalEntityId?: number;

    countryCode?: string;

    municipalityCode?: string;

    address?: string;

    addressNum?: string;

    postalCode?: string;

    legalCheckbox1?: boolean;

    legalCheckbox2?: boolean;

    legalCheckbox3?: boolean;

}




/*default implementation one might extend from (or use as is) */


export class LegalEntityDTOBase  implements LegalEntityDTO{

    legalEntityId?:  number ;


    countryCode?:  string ;


    municipalityCode?:  string ;


    address?:  string ;


    addressNum?:  string ;


    postalCode?:  string ;


    legalCheckbox1?:  boolean ;


    legalCheckbox2?:  boolean ;


    legalCheckbox3?:  boolean ;

}
