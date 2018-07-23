import * as models from './models';
import {Type} from "class-transformer";

export interface AccessPoint {
    id?: number;

    idInstallationSite?: number;

    modelNumber?: string;

    serialNumber?: string;

    deviceBrand?: string;

    location?: string;

    locationType?: string;

    latitude?: string;

    longitude?: string;

    macAddress?: string;

    number?: number;

    indoor?: boolean;

    installationSite?: number;

}




/*default implementation one might extend from (or use as is) */


export class AccessPointBase  implements AccessPoint{

    id?:  number ;


    idInstallationSite?:  number ;


    modelNumber?:  string ;


    serialNumber?:  string ;


    deviceBrand?:  string ;


    location?:  string ;


    locationType?:  string ;


    latitude?:  string ;


    longitude?:  string ;


    macAddress?:  string ;


    number?:  number ;


    indoor?:  boolean ;


    installationSite?:  number ;

}
