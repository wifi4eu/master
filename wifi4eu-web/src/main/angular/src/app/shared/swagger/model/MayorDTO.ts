import * as models from './models';
import {Type} from "class-transformer";

export interface MayorDTO {
    mayorId?: number;

    treatment?: string;

    name?: string;

    surname?: string;

    email?: string;

    repeatEmail?: string;

    legalEntityId?: number;

}




/*default implementation one might extend from (or use as is) */


export class MayorDTOBase  implements MayorDTO{

    mayorId?:  number ;


    treatment?:  string ;


    name?:  string ;


    surname?:  string ;


    email?:  string ;


    repeatEmail?:  string ;


    legalEntityId?:  number ;

}
