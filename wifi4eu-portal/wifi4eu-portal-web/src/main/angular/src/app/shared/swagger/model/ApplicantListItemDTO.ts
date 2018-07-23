import * as models from './models';
import {Type} from "class-transformer";

export interface ApplicantListItemDTO {
    lauId?: number;

    countryCode?: string;

    name?: string;

    counter?: number;

    mediation?: boolean;

    status?: number;

    issueStatus?: Array<number>;

    applicationDate?: number;

    invalidateReason?: string;

    warning1?: boolean;

    warning2?: boolean;

    warning3?: boolean;

}




/*default implementation one might extend from (or use as is) */


export class ApplicantListItemDTOBase  implements ApplicantListItemDTO{

    lauId?:  number ;


    countryCode?:  string ;


    name?:  string ;


    counter?:  number ;


    mediation?:  boolean ;


    status?:  number ;


    issueStatus?:  Array<number> ;


    applicationDate?:  number ;


    invalidateReason?:  string ;


    warning1?:  boolean ;


    warning2?:  boolean ;


    warning3?:  boolean ;

}
