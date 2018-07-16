import * as models from './models';
import {Type} from "class-transformer";

export interface SupplierDTO {
    id?: number;

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

    logo?: string;

    userId?: number;

    suppliedRegions?: Array<models.SuppliedRegionDTO>;

    legalCheck1?: boolean;

    legalCheck2?: boolean;

    legalFile1?: string;

    legalFile2?: string;

    status?: number;

    lang?: string;

}




/*default implementation one might extend from (or use as is) */


export class SupplierDTOBase  implements SupplierDTO{

    id?:  number ;


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


    logo?:  string ;


    userId?:  number ;

    @Type(() => models.SuppliedRegionDTOBase)
    suppliedRegions?:  models.SuppliedRegionDTOBase[] ;


    legalCheck1?:  boolean ;


    legalCheck2?:  boolean ;


    legalFile1?:  string ;


    legalFile2?:  string ;


    status?:  number ;


    lang?:  string ;

}
