import * as models from './models';
import {Type} from "class-transformer";

export interface PublicationCallDTO {
    callId?: number;

    url: string;

    startDate: Date;

    endDate: Date;

}




/*default implementation one might extend from (or use as is) */


export class PublicationCallDTOBase  implements PublicationCallDTO{

    callId?:  number ;


    url:  string ;

@Type(() => Date)
    startDate:  Date ;

@Type(() => Date)
    endDate:  Date ;

}
