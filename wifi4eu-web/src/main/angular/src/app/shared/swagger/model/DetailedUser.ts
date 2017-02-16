import * as models from './models';
import {Type} from "class-transformer";

export interface DetailedUser {
    name?: string;

    locale?: string;

    timeZone?: string;

    tokenCramId?: string;

    tokenId?: string;

    email?: string;

    domain?: string;

    uid?: string;

    assuranceLevel?: models.AssuranceLevel;

    departmentNumber?: string;

    domainUsername?: string;

    employeeNumber?: string;

    employeeType?: string;

    mobilePhoneNumber?: string;

    orgId?: string;

    registrationLevelVersions?: { [key: string]: any; };

    storkId?: string;

    telephoneNumber?: string;

    teleworkingPriority?: boolean;

    unversionedUid?: string;

    userManager?: string;

    deviceName?: string;

    firstName?: string;

    lastName?: string;

    extendedAttributes?: { [key: string]: any; };

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


    locale?:  string ;


    timeZone?:  string ;


    tokenCramId?:  string ;


    tokenId?:  string ;


    email?:  string ;


    domain?:  string ;


    uid?:  string ;

    
    assuranceLevel?:  models.AssuranceLevelBase ;


    departmentNumber?:  string ;


    domainUsername?:  string ;


    employeeNumber?:  string ;


    employeeType?:  string ;


    mobilePhoneNumber?:  string ;


    orgId?:  string ;


    registrationLevelVersions?:  { [key: string]: any; } ;


    storkId?:  string ;


    telephoneNumber?:  string ;


    teleworkingPriority?:  boolean ;


    unversionedUid?:  string ;


    userManager?:  string ;


    deviceName?:  string ;


    firstName?:  string ;


    lastName?:  string ;


    extendedAttributes?:  { [key: string]: any; } ;


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
