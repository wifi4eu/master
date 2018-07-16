import * as models from './models';
import {Type} from "class-transformer";

export interface RightDTO {
    id?: number;

    userId?: number;

    rightdesc?: string;

    type?: number;

}




/*default implementation one might extend from (or use as is) */


export class RightDTOBase  implements RightDTO{

    id?:  number ;


    userId?:  number ;


    rightdesc?:  string ;


    type?:  number ;

}
