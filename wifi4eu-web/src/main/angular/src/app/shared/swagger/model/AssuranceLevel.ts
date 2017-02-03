import * as models from './models';
import {Type} from "class-transformer";

export interface AssuranceLevel {
    level?: number;

    name?: string;

}




/*default implementation one might extend from (or use as is) */


export class AssuranceLevelBase  implements AssuranceLevel{

    level?:  number ;


    name?:  string ;

}
