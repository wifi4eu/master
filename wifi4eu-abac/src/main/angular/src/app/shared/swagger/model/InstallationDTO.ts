import * as models from './models';
import {Type} from "class-transformer";

export interface InstallationDTO {
    installationId?: number;

    nip?: string;

    accessPoints?: Array<models.AccessPointDTO>;

}




/*default implementation one might extend from (or use as is) */


export class InstallationDTOBase  implements InstallationDTO{

    installationId?:  number ;


    nip?:  string ;

    @Type(() => models.AccessPointDTOBase)
    accessPoints?:  models.AccessPointDTOBase[] ;

}
