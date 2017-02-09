import * as models from './models';
import {Type} from "class-transformer";

export interface DetailedUser {
    name?: string;

    domain?: string;

    email?: string;

    timeZone?: string;

    locale?: string;

    uid?: string;

    firstName?: string;

    lastName?: string;

    assuranceLevel?: models.AssuranceLevel;

    departmentNumber?: string;

    orgId?: string;

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

    proxies?: Array<any>;

    pgtId?: string;

    pgtIou?: string;

    proxyGrantingProtocol?: models.ProxyGrantingProtocol;

    ticketType?: models.TicketType;

    extendedUserDetails?: models.ExtendedUserDetails;

    fromSingleSignOn?: boolean;

    authenticationTime?: Date;

    authenticationStrengths?: Array<any>;

}




/*default implementation one might extend from (or use as is) */


export class DetailedUserBase  implements DetailedUser{

    name?:  string ;


    domain?:  string ;


    email?:  string ;


    timeZone?:  string ;


    locale?:  string ;


    uid?:  string ;


    firstName?:  string ;


    lastName?:  string ;

    
    assuranceLevel?:  models.AssuranceLevelBase ;


    departmentNumber?:  string ;


    orgId?:  string ;


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


    proxies?:  Array<any> ;


    pgtId?:  string ;


    pgtIou?:  string ;

    
    proxyGrantingProtocol?:  models.ProxyGrantingProtocolBase ;

    
    ticketType?:  models.TicketTypeBase ;

    
    extendedUserDetails?:  models.ExtendedUserDetailsBase ;


    fromSingleSignOn?:  boolean ;

@Type(() => Date)
    authenticationTime?:  Date ;


    authenticationStrengths?:  Array<any> ;

}
