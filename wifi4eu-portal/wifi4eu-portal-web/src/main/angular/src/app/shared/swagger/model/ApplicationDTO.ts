import * as models from './models';
import {Type} from "class-transformer";

export interface ApplicationDTO {
    id?: number;

    callId?: number;

    registrationId?: number;

    supplierId?: number;

    voucherAwarded?: boolean;

    date?: number;

    lefExport?: number;

    lefImport?: number;

    lefStatus?: number;

    bcExport?: number;

    bcImport?: number;

    bcStatus?: number;

    lcExport?: number;

    lcImport?: number;

    lcStatus?: number;

    status?: number;

    invalidateReason?: string;

    preSelectedFlag?: boolean;

    rejected?: boolean;

    authorizedPerson?: number;

}




/*default implementation one might extend from (or use as is) */


export class ApplicationDTOBase  implements ApplicationDTO{

    id?:  number ;


    callId?:  number ;


    registrationId?:  number ;


    supplierId?:  number ;


    voucherAwarded?:  boolean ;


    date?:  number ;


    lefExport?:  number ;


    lefImport?:  number ;


    lefStatus?:  number ;


    bcExport?:  number ;


    bcImport?:  number ;


    bcStatus?:  number ;


    lcExport?:  number ;


    lcImport?:  number ;


    lcStatus?:  number ;


    status?:  number ;


    invalidateReason?:  string ;


    preSelectedFlag?:  boolean ;


    rejected?:  boolean ;


    authorizedPerson?:  number ;

}
