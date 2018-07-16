import * as models from './models';
import {Type} from "class-transformer";

export interface TimelineDTO {
    id?: number;

    callId?: number;

    description?: string;

    startDate?: number;

    endDate?: number;

}




/*default implementation one might extend from (or use as is) */


export class TimelineDTOBase  implements TimelineDTO{

    id?:  number ;


    callId?:  number ;


    description?:  string ;


    startDate?:  number ;


    endDate?:  number ;

}
