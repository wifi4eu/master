import * as models from './models';
import {Type} from "class-transformer";

export interface VoucherAssignmentAuxiliarDTO {
    id?: number;

    executionDate?: number;

    status?: number;

    hasPreListSaved?: boolean;

    preListExecutionDate?: number;

    hasFreezeListSaved?: boolean;

    freezeLisExecutionDate?: number;

    notifiedDate?: number;

}




/*default implementation one might extend from (or use as is) */


export class VoucherAssignmentAuxiliarDTOBase  implements VoucherAssignmentAuxiliarDTO{

    id?:  number ;


    executionDate?:  number ;


    status?:  number ;


    hasPreListSaved?:  boolean ;


    preListExecutionDate?:  number ;


    hasFreezeListSaved?:  boolean ;


    freezeLisExecutionDate?:  number ;


    notifiedDate?:  number ;

}
