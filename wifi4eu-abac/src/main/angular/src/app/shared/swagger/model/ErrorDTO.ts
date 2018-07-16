import * as models from './models';
import {Type} from "class-transformer";

export interface ErrorDTO {
    errorCode?: number;

    errorMessage?: string;

}




/*default implementation one might extend from (or use as is) */


export class ErrorDTOBase  implements ErrorDTO{

    errorCode?:  number ;


    errorMessage?:  string ;

}
