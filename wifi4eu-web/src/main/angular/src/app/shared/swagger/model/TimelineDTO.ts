import * as models from './models';
import {Type} from "class-transformer";

export interface TimelineDTO {
    timelineId?: number;

    eventTitle: string;

    startDate?: Date;

    endDate?: Date;

}




/*default implementation one might extend from (or use as is) */


export class TimelineDTOBase  implements TimelineDTO{

    timelineId?:  number ;


    eventTitle:  string ;

@Type(() => Date)
    startDate?:  Date ;

@Type(() => Date)
    endDate?:  Date ;

}
