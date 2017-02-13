import * as models from './models';
import {Type} from "class-transformer";

export interface DetailedUser {
    name?: string;

    teleworkingPriority?: boolean;

    employeeType?: string;

    storkId?: string;

    telephoneNumber?: string;

    tokenId?: string;

    tokenCramId?: string;

    domainUsername?: string;

    deviceName?: string;

    employeeNumber?: string;

    assuranceLevel?: models.AssuranceLevel;

    registrationLevelVersions?: { [key: string]: any; };

    orgId?: string;

    userManager?: string;

    uid?: string;

    mobilePhoneNumber?: string;

    unversionedUid?: string;

    departmentNumber?: string;

    domain?: string;

    email?: string;

    locale?: string;

    timeZone?: string;

    firstName?: string;

    lastName?: string;

    extendedAttributes?: { [key: string]: any; };

    proxies?: Array<any>;

    proxyGrantingProtocol?: models.ProxyGrantingProtocol;

    pgtId?: string;

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


    teleworkingPriority?:  boolean ;


    employeeType?:  string ;


    storkId?:  string ;


    telephoneNumber?:  string ;


    tokenId?:  string ;


    tokenCramId?:  string ;


    domainUsername?:  string ;


    deviceName?:  string ;


    employeeNumber?:  string ;

    
    assuranceLevel?:  models.AssuranceLevelBase ;


    registrationLevelVersions?:  { [key: string]: any; } ;


    orgId?:  string ;


    userManager?:  string ;


    uid?:  string ;


    mobilePhoneNumber?:  string ;


    unversionedUid?:  string ;


    departmentNumber?:  string ;


    domain?:  string ;


    email?:  string ;


    locale?:  string ;


    timeZone?:  string ;


    firstName?:  string ;


    lastName?:  string ;


    extendedAttributes?:  { [key: string]: any; } ;


    proxies?:  Array<any> ;

    
    proxyGrantingProtocol?:  models.ProxyGrantingProtocolBase ;


    pgtId?:  string ;


    pgtIou?:  string ;

    
    ticketType?:  models.TicketTypeBase ;

    
    extendedUserDetails?:  models.ExtendedUserDetailsBase ;


    authenticationStrengths?:  Array<any> ;

@Type(() => Date)
    authenticationTime?:  Date ;


    fromSingleSignOn?:  boolean ;

}
