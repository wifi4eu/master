import * as models from './models';
import {Type} from "class-transformer";

export interface PagingSortingDTO {
    offset?: number;

    count?: number;

    orderField?: string;

    orderType?: number;

}




/*default implementation one might extend from (or use as is) */


export class PagingSortingDTOBase  implements PagingSortingDTO{

    offset?:  number ;


    count?:  number ;


    orderField?:  string ;


    orderType?:  number ;

}
