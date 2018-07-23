import * as models from './models';
import {Type} from "class-transformer";

export interface InstallationSite {
    id?: number;

    municipality?: number;

    idNetworkSnippet?: string;

    name?: string;

    dateRegistered?: Date;

    domainName?: string;

    url?: string;

    number?: number;

}




/*default implementation one might extend from (or use as is) */


export class InstallationSiteBase  implements InstallationSite{

    id?:  number ;


    municipality?:  number ;


    idNetworkSnippet?:  string ;


    name?:  string ;

@Type(() => Date)
    dateRegistered?:  Date ;


    domainName?:  string ;


    url?:  string ;


    number?:  number ;

}
