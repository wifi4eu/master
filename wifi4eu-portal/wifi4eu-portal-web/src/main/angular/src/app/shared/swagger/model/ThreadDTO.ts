import * as models from './models';
import {Type} from "class-transformer";

export interface ThreadDTO {
    id?: number;

    title?: string;

    reason?: string;

    type?: number;

    mediation?: boolean;

    messages?: Array<models.ThreadMessageDTO>;

}




/*default implementation one might extend from (or use as is) */


export class ThreadDTOBase  implements ThreadDTO{

    id?:  number ;


    title?:  string ;


    reason?:  string ;


    type?:  number ;


    mediation?:  boolean ;

    @Type(() => models.ThreadMessageDTOBase)
    messages?:  models.ThreadMessageDTOBase[] ;

}
