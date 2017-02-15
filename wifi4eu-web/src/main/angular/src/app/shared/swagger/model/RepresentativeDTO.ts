import * as models from './models';
import {Type} from "class-transformer";

export interface RepresentativeDTO {
    representativeId?: number;

    treatment?: string;

    name?: string;

    surname?: string;

    municipalityRole?: string;

    email?: string;

    mayorRepeatEmail?: string;

    mayorId?: number;

}




/*default implementation one might extend from (or use as is) */


export class RepresentativeDTOBase  implements RepresentativeDTO{

    representativeId?:  number ;


    treatment?:  string ;


    name?:  string ;


    surname?:  string ;


    municipalityRole?:  string ;


    email?:  string ;


    mayorRepeatEmail?:  string ;


    mayorId?:  number ;

}
