import * as models from './models';
import {Type} from "class-transformer";

export interface ContactPersonDTO {
    contactId?: number;

    name?: string;

    surname?: string;

    phone?: string;

    email?: string;

}




/*default implementation one might extend from (or use as is) */


export class ContactPersonDTOBase  implements ContactPersonDTO{

    contactId?:  number ;


    name?:  string ;


    surname?:  string ;


    phone?:  string ;


    email?:  string ;

}
