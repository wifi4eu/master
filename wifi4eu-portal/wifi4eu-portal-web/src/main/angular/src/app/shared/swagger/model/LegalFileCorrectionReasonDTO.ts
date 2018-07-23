import * as models from './models';
import {Type} from "class-transformer";

export interface LegalFileCorrectionReasonDTO {
    id?: number;

    registrationId?: number;

    type?: number;

    uploadTime?: number;

    requestCorrection?: boolean;

    correctionReason?: number;

}




/*default implementation one might extend from (or use as is) */


export class LegalFileCorrectionReasonDTOBase  implements LegalFileCorrectionReasonDTO{

    id?:  number ;


    registrationId?:  number ;


    type?:  number ;


    uploadTime?:  number ;


    requestCorrection?:  boolean ;


    correctionReason?:  number ;

}
