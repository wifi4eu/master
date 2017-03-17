import * as models from './models';
import {Type} from "class-transformer";

export interface InstallationDTO {
    installationId?: number;

    nutsDTO?: models.NutsDTO;

    installationDetailDTOs?: Array<models.InstallationDetailDTO>;

}




/*default implementation one might extend from (or use as is) */


export class InstallationDTOBase  implements InstallationDTO{

    installationId?:  number ;

    
    nutsDTO?:  models.NutsDTOBase ;

    @Type(() => models.InstallationDetailDTOBase)
    installationDetailDTOs?:  models.InstallationDetailDTOBase[] ;

}
