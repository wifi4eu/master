import * as models from './models';
import {Type} from "class-transformer";

export interface ActivateAccountDTO {
    token?: string;

    email?: string;

    password?: string;

    confirmPassword?: string;

}




/*default implementation one might extend from (or use as is) */


export class ActivateAccountDTOBase  implements ActivateAccountDTO{

    token?:  string ;


    email?:  string ;


    password?:  string ;


    confirmPassword?:  string ;

}
