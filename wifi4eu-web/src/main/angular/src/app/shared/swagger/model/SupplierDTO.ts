import * as models from './models';
import {Type} from "class-transformer";

export interface SupplierDTO {
    supplierId?: number;

    name?: string;

    address?: string;

    vat?: string;

    bic?: string;

    accountNumber?: string;

    website?: string;

    contactName?: string;

    contactSurname?: string;

    contactPhonePrefix?: string;

    contactPhoneNumber?: string;

    contactEmail?: string;

    legalCheck1?: boolean;

    legalCheck2?: boolean;

    createDate?: number;

    nutsIds?: string;

}




/*default implementation one might extend from (or use as is) */


export class SupplierDTOBase  implements SupplierDTO{

    supplierId?:  number ;


    name?:  string ;


    address?:  string ;


    vat?:  string ;


    bic?:  string ;


    accountNumber?:  string ;


    website?:  string ;


    contactName?:  string ;


    contactSurname?:  string ;


    contactPhonePrefix?:  string ;


    contactPhoneNumber?:  string ;


    contactEmail?:  string ;


    legalCheck1?:  boolean ;


    legalCheck2?:  boolean ;


    createDate?:  number ;


    nutsIds?:  string ;

}
