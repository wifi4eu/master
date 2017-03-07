import * as models from './models';
import {Type} from "class-transformer";

export interface NutsDTO {
    nutsId?: number;

    code?: string;

    name?: string;

    level?: number;

    countryCode?: string;

    order?: number;

    sorting?: number;

}




/*default implementation one might extend from (or use as is) */


export class NutsDTOBase  implements NutsDTO{

    nutsId?:  number ;


    code?:  string ;


    name?:  string ;


    level?:  number ;


    countryCode?:  string ;


    order?:  number ;


    sorting?:  number ;

}
