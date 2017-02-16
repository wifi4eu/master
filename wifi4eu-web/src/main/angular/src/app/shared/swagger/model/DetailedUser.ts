import * as models from './models';
import {Type} from "class-transformer";

export interface DetailedUser {
    name?: string;

    domain?: string;

    email?: string;

    locale?: string;

    timeZone?: string;

    uid?: string;

    firstName?: string;

    lastName?: string;

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

    proxies?: Array<any>;

    pgtIou?: string;

    pgtId?: string;

    proxyGrantingProtocol?: models.ProxyGrantingProtocol;

    ticketType?: models.TicketType;

    extendedUserDetails?: models.ExtendedUserDetails;

    authenticationStrengths?: Array<any>;

    authenticationTime?: Date;

    fromSingleSignOn?: boolean;

}




/*default implementation one might extend from (or use as is) */


export class DetailedUserBase  implements DetailedUser{

    name?:  string ;


    domain?:  string ;


    email?:  string ;


    locale?:  string ;


    timeZone?:  string ;


    uid?:  string ;


    firstName?:  string ;


    lastName?:  string ;

    
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


    proxies?:  Array<any> ;


    pgtIou?:  string ;


    pgtId?:  string ;

    
    proxyGrantingProtocol?:  models.ProxyGrantingProtocolBase ;

    
    ticketType?:  models.TicketTypeBase ;

    
    extendedUserDetails?:  models.ExtendedUserDetailsBase ;


    authenticationStrengths?:  Array<any> ;

@Type(() => Date)
    authenticationTime?:  Date ;


    fromSingleSignOn?:  boolean ;

}
