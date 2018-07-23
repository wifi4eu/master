import * as models from './models';
import {Type} from "class-transformer";

export interface UserDTO {
    id?: number;

    ecasUsername?: string;

    ecasEmail?: string;

    treatment?: string;

    name?: string;

    surname?: string;

    address?: string;

    addressNum?: string;

    postalCode?: string;

    email?: string;

    password?: string;

    lang?: string;

    createDate?: number;

    accessDate?: number;

    type?: number;

    verified?: boolean;

    csrfToken?: string;

}




/*default implementation one might extend from (or use as is) */


export class UserDTOBase  implements UserDTO{

    id?:  number ;


    ecasUsername?:  string ;


    ecasEmail?:  string ;


    treatment?:  string ;


    name?:  string ;


    surname?:  string ;


    address?:  string ;


    addressNum?:  string ;


    postalCode?:  string ;


    email?:  string ;


    password?:  string ;


    lang?:  string ;


    createDate?:  number ;


    accessDate?:  number ;


    type?:  number ;


    verified?:  boolean ;


    csrfToken?:  string ;

}
