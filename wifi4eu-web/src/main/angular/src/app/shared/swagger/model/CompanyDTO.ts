import * as models from './models';
import {Type} from "class-transformer";

export interface CompanyDTO {
    companyId?: number;

    name?: string;

    address?: string;

    vat?: string;

    bic?: string;

    accountNumber?: string;

    website?: string;

}




/*default implementation one might extend from (or use as is) */


export class CompanyDTOBase  implements CompanyDTO{

    companyId?:  number ;


    name?:  string ;


    address?:  string ;


    vat?:  string ;


    bic?:  string ;


    accountNumber?:  string ;


    website?:  string ;

}
