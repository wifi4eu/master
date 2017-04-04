import * as models from './models';
import {Type} from "class-transformer";

export interface RightDTO {
    rightId?: number;

    name?: string;

    roles?: Array<models.RoleDTO>;

}




/*default implementation one might extend from (or use as is) */


export class RightDTOBase  implements RightDTO{

    rightId?:  number ;


    name?:  string ;

    @Type(() => models.RoleDTOBase)
    roles?:  models.RoleDTOBase[] ;

}
