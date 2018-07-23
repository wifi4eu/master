import * as models from './models';
import {Type} from "class-transformer";

export interface MunicipalityDTO {
    id?: number;

    name?: string;

    address?: string;

    addressNum?: string;

    postalCode?: string;

    country?: string;

    lauId?: number;

    registrations?: Array<models.RegistrationDTO>;

}




/*default implementation one might extend from (or use as is) */


export class MunicipalityDTOBase  implements MunicipalityDTO{

    id?:  number ;


    name?:  string ;


    address?:  string ;


    addressNum?:  string ;


    postalCode?:  string ;


    country?:  string ;


    lauId?:  number ;

    @Type(() => models.RegistrationDTOBase)
    registrations?:  models.RegistrationDTOBase[] ;

}
