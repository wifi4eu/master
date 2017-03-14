import * as models from './models';
import {Type} from "class-transformer";

export interface CallDTO {
    callId?: number;

    startDate: number;

    endDate?: number;

    event?: string;

}




/*default implementation one might extend from (or use as is) */


export class CallDTOBase  implements CallDTO{

    callId?:  number ;


    startDate:  number ;


    endDate?:  number ;


    event?:  string ;

}
