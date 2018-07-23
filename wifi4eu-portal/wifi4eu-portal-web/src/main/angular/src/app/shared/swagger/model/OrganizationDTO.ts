import * as models from './models';
import {Type} from "class-transformer";

export interface OrganizationDTO {
    id?: number;

    name?: string;

    type?: string;

    country?: string;

}




/*default implementation one might extend from (or use as is) */


export class OrganizationDTOBase  implements OrganizationDTO{

    id?:  number ;


    name?:  string ;


    type?:  string ;


    country?:  string ;

}
