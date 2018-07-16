import * as models from './models';
import {Type} from "class-transformer";

export interface SuppliedRegionDTO {
    id?: number;

    supplierId?: number;

    regionId?: models.NutsDTO;

}




/*default implementation one might extend from (or use as is) */


export class SuppliedRegionDTOBase  implements SuppliedRegionDTO{

    id?:  number ;


    supplierId?:  number ;

    
    regionId?:  models.NutsDTOBase ;

}
