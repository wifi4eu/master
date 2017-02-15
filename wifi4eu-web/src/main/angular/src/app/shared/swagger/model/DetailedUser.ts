import * as models from './models';
import {Type} from "class-transformer";

export interface DetailedUser {
    name?: string;

    domain?: string;

    mobilePhoneNumber?: string;

    registrationLevelVersions?: { [key: string]: any; };

    storkId?: string;

    email?: string;

    locale?: string;

    timeZone?: string;

    assuranceLevel?: models.AssuranceLevel;

    employeeType?: string;

    orgId?: string;

    deviceName?: string;

    departmentNumber?: string;

    employeeNumber?: string;

    telephoneNumber?: string;

    teleworkingPriority?: boolean;

    tokenCramId?: string;

    tokenId?: string;

    unversionedUid?: string;

    userManager?: string;

    extendedAttributes?: { [key: string]: any; };

    domainUsername?: string;

    firstName?: string;

    lastName?: string;

    uid?: string;

    proxies?: Array<any>;

    pgtIou?: string;

    pgtId?: string;

    proxyGrantingProtocol?: models.ProxyGrantingProtocol;

    ticketType?: models.TicketType;

    extendedUserDetails?: models.ExtendedUserDetails;

    authenticationTime?: Date;

    authenticationStrengths?: Array<any>;

    fromSingleSignOn?: boolean;

}




/*default implementation one might extend from (or use as is) */


export class DetailedUserBase  implements DetailedUser{

    name?:  string ;


    domain?:  string ;


    mobilePhoneNumber?:  string ;


    registrationLevelVersions?:  { [key: string]: any; } ;


    storkId?:  string ;


    email?:  string ;


    locale?:  string ;


    timeZone?:  string ;

    
    assuranceLevel?:  models.AssuranceLevelBase ;


    employeeType?:  string ;


    orgId?:  string ;


    deviceName?:  string ;


    departmentNumber?:  string ;


    employeeNumber?:  string ;


    telephoneNumber?:  string ;


    teleworkingPriority?:  boolean ;


    tokenCramId?:  string ;


    tokenId?:  string ;


    unversionedUid?:  string ;


    userManager?:  string ;


    extendedAttributes?:  { [key: string]: any; } ;


    domainUsername?:  string ;


    firstName?:  string ;


    lastName?:  string ;


    uid?:  string ;


    proxies?:  Array<any> ;


    pgtIou?:  string ;


    pgtId?:  string ;

    
    proxyGrantingProtocol?:  models.ProxyGrantingProtocolBase ;

    
    ticketType?:  models.TicketTypeBase ;

    
    extendedUserDetails?:  models.ExtendedUserDetailsBase ;

@Type(() => Date)
    authenticationTime?:  Date ;


    authenticationStrengths?:  Array<any> ;


    fromSingleSignOn?:  boolean ;

}
