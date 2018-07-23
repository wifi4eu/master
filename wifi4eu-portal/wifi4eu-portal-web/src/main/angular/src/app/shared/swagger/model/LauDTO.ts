import * as models from './models';
import {Type} from "class-transformer";

export interface LauDTO {
    id?: number;

    countryCode?: string;

    nuts3?: string;

    lau1?: string;

    lau2?: string;

    change?: string;

    name1?: string;

    name2?: string;

    pop?: number;

    area?: number;

    physicalAddress?: string;

}




/*default implementation one might extend from (or use as is) */


export class LauDTOBase  implements LauDTO{

    id?:  number ;


    countryCode?:  string ;


    nuts3?:  string ;


    lau1?:  string ;


    lau2?:  string ;


    change?:  string ;


    name1?:  string ;


    name2?:  string ;


    pop?:  number ;


    area?:  number ;


    physicalAddress?:  string ;

}
