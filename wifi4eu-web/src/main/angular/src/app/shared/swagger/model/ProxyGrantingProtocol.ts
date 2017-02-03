import * as models from './models';
import {Type} from "class-transformer";

export interface ProxyGrantingProtocol {
    name?: string;

}




/*default implementation one might extend from (or use as is) */


export class ProxyGrantingProtocolBase  implements ProxyGrantingProtocol{

    name?:  string ;

}
