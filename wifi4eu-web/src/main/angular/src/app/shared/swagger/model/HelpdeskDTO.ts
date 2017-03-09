import * as models from './models';
import {Type} from "class-transformer";

export interface HelpdeskDTO {
    issueId?: number;

    portal: string;

    topic?: string;

    memberState?: string;

    date?: Date;

    assignedTo?: string;

    status?: string;

    from?: string;

    issueSummary?: string;

    memberStateComments?: string;

    dgConnectComments?: string;

}




/*default implementation one might extend from (or use as is) */


export class HelpdeskDTOBase  implements HelpdeskDTO{

    issueId?:  number ;


    portal:  string ;


    topic?:  string ;


    memberState?:  string ;

@Type(() => Date)
    date?:  Date ;


    assignedTo?:  string ;


    status?:  string ;


    from?:  string ;


    issueSummary?:  string ;


    memberStateComments?:  string ;


    dgConnectComments?:  string ;

}
