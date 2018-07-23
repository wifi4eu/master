import * as models from './models';
import {Type} from "class-transformer";

export interface SupplierListItemDTO {
    id?: number;

    name?: string;

    website?: string;

    vat?: string;

    accountNumber?: string;

    status?: number;

    numberRegistrations?: number;

}




/*default implementation one might extend from (or use as is) */


export class SupplierListItemDTOBase  implements SupplierListItemDTO{

    id?:  number ;


    name?:  string ;


    website?:  string ;


    vat?:  string ;


    accountNumber?:  string ;


    status?:  number ;


    numberRegistrations?:  number ;

}
