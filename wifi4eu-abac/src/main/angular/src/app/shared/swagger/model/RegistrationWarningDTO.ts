import * as models from './models';
import {Type} from "class-transformer";

export interface RegistrationWarningDTO {
    id?: number;

    registrationId?: number;

    warning?: number;

}




/*default implementation one might extend from (or use as is) */


export class RegistrationWarningDTOBase  implements RegistrationWarningDTO{

    id?:  number ;


    registrationId?:  number ;


    warning?:  number ;

}
