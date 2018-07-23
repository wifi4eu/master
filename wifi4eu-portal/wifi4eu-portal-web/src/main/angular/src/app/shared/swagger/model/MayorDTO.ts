import * as models from './models';
import {Type} from "class-transformer";

export interface MayorDTO {
    id?: number;

    name?: string;

    surname?: string;

    email?: string;

    municipalityId?: number;

}




/*default implementation one might extend from (or use as is) */


export class MayorDTOBase  implements MayorDTO{

    id?:  number ;


    name?:  string ;


    surname?:  string ;


    email?:  string ;


    municipalityId?:  number ;

}
