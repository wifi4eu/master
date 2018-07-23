import * as models from './models';
import {Type} from "class-transformer";

export interface VoucherAssignmentDTO {
    id?: number;

    user?: models.UserDTO;

    executionDate?: number;

    status?: number;

    call?: models.CallDTO;

    notifiedDate?: number;

    voucherSimulations?: Array<models.VoucherSimulationDTO>;

}




/*default implementation one might extend from (or use as is) */


export class VoucherAssignmentDTOBase  implements VoucherAssignmentDTO{

    id?:  number ;

    
    user?:  models.UserDTOBase ;


    executionDate?:  number ;


    status?:  number ;

    
    call?:  models.CallDTOBase ;


    notifiedDate?:  number ;

    @Type(() => models.VoucherSimulationDTOBase)
    voucherSimulations?:  models.VoucherSimulationDTOBase[] ;

}
