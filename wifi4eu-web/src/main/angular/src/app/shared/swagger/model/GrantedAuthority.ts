import * as models from './models';
import {Type} from "class-transformer";

export interface GrantedAuthority {
    authority?: string;

}




/*default implementation one might extend from (or use as is) */


export class GrantedAuthorityBase  implements GrantedAuthority{

    authority?:  string ;

}
