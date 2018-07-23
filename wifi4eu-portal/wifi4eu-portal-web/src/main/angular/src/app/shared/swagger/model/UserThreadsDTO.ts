import * as models from './models';
import {Type} from "class-transformer";

export interface UserThreadsDTO {
    id?: number;

    userId?: number;

    threadId?: number;

}




/*default implementation one might extend from (or use as is) */


export class UserThreadsDTOBase  implements UserThreadsDTO{

    id?:  number ;


    userId?:  number ;


    threadId?:  number ;

}
