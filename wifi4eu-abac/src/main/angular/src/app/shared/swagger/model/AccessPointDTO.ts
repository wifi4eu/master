import * as models from './models';
import {Type} from "class-transformer";

export interface AccessPointDTO {
    accessPointId?: number;

    name?: string;

    serialNumber?: string;

    productName?: string;

    modelNumber?: string;

    installationId?: number;

    indoor?: boolean;

}




/*default implementation one might extend from (or use as is) */


export class AccessPointDTOBase  implements AccessPointDTO{

    accessPointId?:  number ;


    name?:  string ;


    serialNumber?:  string ;


    productName?:  string ;


    modelNumber?:  string ;


    installationId?:  number ;


    indoor?:  boolean ;

}
