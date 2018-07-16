import * as models from './models';
import {Type} from "class-transformer";

export interface VoucherDTO {
    voucherId?: number;

    userId?: number;

    legalEntityId?: number;

    createDate?: Date;

    countryCode?: string;

    nuts3?: string;

    lau1?: string;

    lau2?: string;

}




/*default implementation one might extend from (or use as is) */


export class VoucherDTOBase  implements VoucherDTO{

    voucherId?:  number ;


    userId?:  number ;


    legalEntityId?:  number ;

@Type(() => Date)
    createDate?:  Date ;


    countryCode?:  string ;


    nuts3?:  string ;


    lau1?:  string ;


    lau2?:  string ;

}
