import * as models from './models';
import {Type} from "class-transformer";

export interface PublicationCallDTO {
    callId?: number;

    url: string;

    name?: string;

    callDate: Date;

    competitionDate: Date;

    closingDate: Date;

}




/*default implementation one might extend from (or use as is) */


export class PublicationCallDTOBase  implements PublicationCallDTO{

    callId?:  number ;


    url:  string ;


    name?:  string ;

@Type(() => Date)
    callDate:  Date ;

@Type(() => Date)
    competitionDate:  Date ;

@Type(() => Date)
    closingDate:  Date ;

}
