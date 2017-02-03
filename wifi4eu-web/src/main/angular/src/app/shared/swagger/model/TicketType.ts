import * as models from './models';
import {Type} from "class-transformer";

export interface TicketType {
    name?: string;

}




/*default implementation one might extend from (or use as is) */


export class TicketTypeBase  implements TicketType{

    name?:  string ;

}
