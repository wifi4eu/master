import * as models from './models';
import {Type} from "class-transformer";

export interface CorrectionRequestEmailDTO {
    id?: number;

    callId?: number;

    date?: number;

    buttonPressedCounter?: number;

}




/*default implementation one might extend from (or use as is) */


export class CorrectionRequestEmailDTOBase  implements CorrectionRequestEmailDTO{

    id?:  number ;


    callId?:  number ;


    date?:  number ;


    buttonPressedCounter?:  number ;

}
