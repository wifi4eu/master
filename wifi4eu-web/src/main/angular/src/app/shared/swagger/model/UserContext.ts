import * as models from './models';
import {Type} from "class-transformer";

export interface UserContext {
    roleList?: Array<models.RoleDTO>;

    username?: string;

    firstName?: string;

    lastName?: string;

    login?: string;

    perId?: number;

    domain?: string;

    email?: string;

    mainLanguage?: string;

    administrativePosition?: string;

    institution?: string;

    detailedUser?: models.DetailedUser;

    name?: string;

    password?: string;

    fullName?: string;

    enabled?: boolean;

    authorities?: Array<models.GrantedAuthority>;

    accountNonExpired?: boolean;

    accountNonLocked?: boolean;

    credentialsNonExpired?: boolean;

}




/*default implementation one might extend from (or use as is) */


export class UserContextBase  implements UserContext{
    @Type(() => models.RoleDTOBase)
    roleList?:  models.RoleDTOBase[] ;


    username?:  string ;


    firstName?:  string ;


    lastName?:  string ;


    login?:  string ;


    perId?:  number ;


    domain?:  string ;


    email?:  string ;


    mainLanguage?:  string ;


    administrativePosition?:  string ;


    institution?:  string ;

    
    detailedUser?:  models.DetailedUserBase ;


    name?:  string ;


    password?:  string ;


    fullName?:  string ;


    enabled?:  boolean ;

    @Type(() => models.GrantedAuthorityBase)
    authorities?:  models.GrantedAuthorityBase[] ;


    accountNonExpired?:  boolean ;


    accountNonLocked?:  boolean ;


    credentialsNonExpired?:  boolean ;

}
