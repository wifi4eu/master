import * as models from './models';
import {Type} from "class-transformer";

export interface ThreadMessageDTO {
    id?: number;

    threadId?: number;

    authorId?: number;

    message?: string;

    createDate?: number;

}




/*default implementation one might extend from (or use as is) */


export class ThreadMessageDTOBase  implements ThreadMessageDTO{

    id?:  number ;


    threadId?:  number ;


    authorId?:  number ;


    message?:  string ;


    createDate?:  number ;

}
