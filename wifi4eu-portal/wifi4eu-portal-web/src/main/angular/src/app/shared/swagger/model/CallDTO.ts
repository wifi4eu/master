import * as models from './models';
import {Type} from "class-transformer";

export interface CallDTO {
    id?: number;

    event?: string;

    startDate?: number;

    endDate?: number;

    voucherValue?: number;

    numberVouchers?: number;

    reserve?: number;

    maxPercentCountry?: number;

    timelines?: Array<models.TimelineDTO>;

    voucherManagements?: Array<models.VoucherManagementDTO>;

}




/*default implementation one might extend from (or use as is) */


export class CallDTOBase  implements CallDTO{

    id?:  number ;


    event?:  string ;


    startDate?:  number ;


    endDate?:  number ;


    voucherValue?:  number ;


    numberVouchers?:  number ;


    reserve?:  number ;


    maxPercentCountry?:  number ;

    @Type(() => models.TimelineDTOBase)
    timelines?:  models.TimelineDTOBase[] ;

    @Type(() => models.VoucherManagementDTOBase)
    voucherManagements?:  models.VoucherManagementDTOBase[] ;

}
