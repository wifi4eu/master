import * as models from './models';
import {Type} from "class-transformer";

export interface ResponseDTO {
    success?: boolean;

    data?: any;

    error?: models.ErrorDTO;

    xtotalCount?: number;

}




/*default implementation one might extend from (or use as is) */


export class ResponseDTOBase  implements ResponseDTO{

    success?:  boolean ;


    data?:  any ;

    
    error?:  models.ErrorDTOBase ;


    xtotalCount?:  number ;

}
