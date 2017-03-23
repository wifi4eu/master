import * as models from './models';
import {Type} from "class-transformer";

export interface BidDTO {
    bidId?: number;

    nip?: number;

    outdoorNumber?: number;

    indoorNumber?: number;

}




/*default implementation one might extend from (or use as is) */


export class BidDTOBase  implements BidDTO{

    bidId?:  number ;


    nip?:  number ;


    outdoorNumber?:  number ;


    indoorNumber?:  number ;

}
