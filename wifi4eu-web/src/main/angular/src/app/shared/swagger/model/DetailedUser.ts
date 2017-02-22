import * as models from './models';
import {Type} from "class-transformer";

export interface DetailedUser {
    name?: string;

    email?: string;

    domain?: string;

    locale?: string;

    timeZone?: string;

    uid?: string;

    assuranceLevel?: models.AssuranceLevel;

    orgId?: string;

    departmentNumber?: string;

    deviceName?: string;

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

    fromSingleSignOn?: boolean;

    authenticationStrengths?: Array<any>;

    authenticationTime?: Date;

}




/*default implementation one might extend from (or use as is) */


export class DetailedUserBase  implements DetailedUser{

    name?:  string ;


    email?:  string ;


    domain?:  string ;


    locale?:  string ;


    timeZone?:  string ;


    uid?:  string ;

    
    assuranceLevel?:  models.AssuranceLevelBase ;


    orgId?:  string ;


    departmentNumber?:  string ;


    deviceName?:  string ;


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


    fromSingleSignOn?:  boolean ;


    authenticationStrengths?:  Array<any> ;

@Type(() => Date)
    authenticationTime?:  Date ;

}
