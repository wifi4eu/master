import * as models from './models';
import {Type} from "class-transformer";

export interface HelpdeskCommentDTO {
    id?: number;

    issueId?: number;

    fromEmail?: string;

    comment?: string;

    createDate?: number;

}




/*default implementation one might extend from (or use as is) */


export class HelpdeskCommentDTOBase  implements HelpdeskCommentDTO{

    id?:  number ;


    issueId?:  number ;


    fromEmail?:  string ;


    comment?:  string ;


    createDate?:  number ;

}
