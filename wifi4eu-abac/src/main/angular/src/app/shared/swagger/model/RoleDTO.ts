import * as models from './models';
import {Type} from "class-transformer";

export interface RoleDTO {
    roleId?: number;

    name?: string;

    rights?: Array<models.RightDTO>;

}




/*default implementation one might extend from (or use as is) */


export class RoleDTOBase  implements RoleDTO{

    roleId?:  number ;


    name?:  string ;

    @Type(() => models.RightDTOBase)
    rights?:  models.RightDTOBase[] ;

}
