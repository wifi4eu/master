import * as models from './models';
import {Type} from "class-transformer";

export interface HelpdeskIssueDTO {
    id?: number;

    fromEmail?: string;

    assignedTo?: string;

    topic?: string;

    portal?: string;

    memberState?: string;

    summary?: string;

    createDate?: number;

    status?: number;

    ticket?: boolean;

    lang?: string;

    comments?: Array<models.HelpdeskCommentDTO>;

}




/*default implementation one might extend from (or use as is) */


export class HelpdeskIssueDTOBase  implements HelpdeskIssueDTO{

    id?:  number ;


    fromEmail?:  string ;


    assignedTo?:  string ;


    topic?:  string ;


    portal?:  string ;


    memberState?:  string ;


    summary?:  string ;


    createDate?:  number ;


    status?:  number ;


    ticket?:  boolean ;


    lang?:  string ;

    @Type(() => models.HelpdeskCommentDTOBase)
    comments?:  models.HelpdeskCommentDTOBase[] ;

}
