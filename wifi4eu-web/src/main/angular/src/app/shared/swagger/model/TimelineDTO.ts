import * as models from './models';
import {Type} from "class-transformer";

export interface TimelineDTO {
    timelineId?: number;

    startDate: number;

    endDate?: number;

    event?: string;

}




/*default implementation one might extend from (or use as is) */


export class TimelineDTOBase  implements TimelineDTO{

    timelineId?:  number ;


    startDate:  number ;


    endDate?:  number ;


    event?:  string ;

}
