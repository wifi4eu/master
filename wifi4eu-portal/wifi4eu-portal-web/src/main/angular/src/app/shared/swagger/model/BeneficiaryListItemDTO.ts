import * as models from './models';
import {Type} from "class-transformer";

export interface BeneficiaryListItemDTO {
    name?: string;

    lauId?: number;

    countryCode?: string;

    counter?: number;

    status?: boolean;

    mediation?: boolean;

    issueStatus?: number;

}




/*default implementation one might extend from (or use as is) */


export class BeneficiaryListItemDTOBase  implements BeneficiaryListItemDTO{

    name?:  string ;


    lauId?:  number ;


    countryCode?:  string ;


    counter?:  number ;


    status?:  boolean ;


    mediation?:  boolean ;


    issueStatus?:  number ;

}
