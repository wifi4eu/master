import * as models from './models';
import {Type} from "class-transformer";

export interface DetailedUser {
    name?: string;

    email?: string;

    domain?: string;

    timeZone?: string;

    locale?: string;

    uid?: string;

    departmentNumber?: string;

    assuranceLevel?: models.AssuranceLevel;

    deviceName?: string;

    orgId?: string;

    domainUsername?: string;

    employeeNumber?: string;

    employeeType?: string;

    mobilePhoneNumber?: string;

    registrationLevelVersions?: { [key: string]: any; };

    storkId?: string;

    telephoneNumber?: string;

    teleworkingPriority?: boolean;

    tokenCramId?: string;

    tokenId?: string;

    unversionedUid?: string;

    userManager?: string;

    extendedAttributes?: { [key: string]: any; };

    firstName?: string;

    lastName?: string;

    proxies?: Array<any>;

    pgtId?: string;

    proxyGrantingProtocol?: models.ProxyGrantingProtocol;

    pgtIou?: string;

    ticketType?: models.TicketType;

    extendedUserDetails?: models.ExtendedUserDetails;

    authenticationStrengths?: Array<any>;

    authenticationTime?: Date;

    fromSingleSignOn?: boolean;

}




/*default implementation one might extend from (or use as is) */


export class DetailedUserBase  implements DetailedUser{

    name?:  string ;


    email?:  string ;


    domain?:  string ;


    timeZone?:  string ;


    locale?:  string ;


    uid?:  string ;


    departmentNumber?:  string ;

    
    assuranceLevel?:  models.AssuranceLevelBase ;


    deviceName?:  string ;


    orgId?:  string ;


    domainUsername?:  string ;


    employeeNumber?:  string ;


    employeeType?:  string ;


    mobilePhoneNumber?:  string ;


    registrationLevelVersions?:  { [key: string]: any; } ;


    storkId?:  string ;


    telephoneNumber?:  string ;


    teleworkingPriority?:  boolean ;


    tokenCramId?:  string ;


    tokenId?:  string ;


    unversionedUid?:  string ;


    userManager?:  string ;


    extendedAttributes?:  { [key: string]: any; } ;


    firstName?:  string ;


    lastName?:  string ;


    proxies?:  Array<any> ;


    pgtId?:  string ;

    
    proxyGrantingProtocol?:  models.ProxyGrantingProtocolBase ;


    pgtIou?:  string ;

    
    ticketType?:  models.TicketTypeBase ;

    
    extendedUserDetails?:  models.ExtendedUserDetailsBase ;


    authenticationStrengths?:  Array<any> ;

@Type(() => Date)
    authenticationTime?:  Date ;


    fromSingleSignOn?:  boolean ;

}
