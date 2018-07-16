import * as models from './models';
import {Type} from "class-transformer";

export interface VoucherManagementDTO {
    id?: number;

    callId?: number;

    memberState?: string;

    countryCode?: string;

    minimum?: number;

    maximum?: number;

    reserve?: number;

}




/*default implementation one might extend from (or use as is) */


export class VoucherManagementDTOBase  implements VoucherManagementDTO{

    id?:  number ;


    callId?:  number ;


    memberState?:  string ;


    countryCode?:  string ;


    minimum?:  number ;


    maximum?:  number ;


    reserve?:  number ;

}
