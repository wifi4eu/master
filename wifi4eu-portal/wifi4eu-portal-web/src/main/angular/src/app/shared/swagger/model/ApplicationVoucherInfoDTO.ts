import * as models from './models';
import {Type} from "class-transformer";

export interface ApplicationVoucherInfoDTO {
    callId?: number;

    applicationId?: number;

    municipalityName?: string;

    countryName?: string;

    voucherAwarded?: boolean;

    rankingInCountry?: number;

}




/*default implementation one might extend from (or use as is) */


export class ApplicationVoucherInfoDTOBase  implements ApplicationVoucherInfoDTO{

    callId?:  number ;


    applicationId?:  number ;


    municipalityName?:  string ;


    countryName?:  string ;


    voucherAwarded?:  boolean ;


    rankingInCountry?:  number ;

}
