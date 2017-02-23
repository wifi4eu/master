import * as models from './models';
import {Type} from "class-transformer";

export interface LauDTO {
    lauId?: number;

    nuts3?: string;

    lau1?: string;

    lau2?: string;

    change?: string;

    name1?: string;

    name2?: string;

    pop?: number;

    area?: number;

}




/*default implementation one might extend from (or use as is) */


export class LauDTOBase  implements LauDTO{

    lauId?:  number ;


    nuts3?:  string ;


    lau1?:  string ;


    lau2?:  string ;


    change?:  string ;


    name1?:  string ;


    name2?:  string ;


    pop?:  number ;


    area?:  number ;

}
