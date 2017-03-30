import * as models from './models';
import {Type} from "class-transformer";

export interface UserDTO {
    userId?: number;

    email?: string;

    password?: string;

    createDate?: Date;

    accessDate?: Date;

    roles?: Array<models.RoleDTO>;

    userType?: number;

    userTypeId?: number;

}




/*default implementation one might extend from (or use as is) */


export class UserDTOBase  implements UserDTO{

    userId?:  number ;


    email?:  string ;


    password?:  string ;

@Type(() => Date)
    createDate?:  Date ;

@Type(() => Date)
    accessDate?:  Date ;

    @Type(() => models.RoleDTOBase)
    roles?:  models.RoleDTOBase[] ;


    userType?:  number ;


    userTypeId?:  number ;

}
