import * as models from './models';
import {Type} from "class-transformer";

export interface BeneficiaryDisplayedListDTO {
    name?: string;

    id?: number;

    installationSiteSubmission?: Date;

    installationSiteRejection?: Date;

    installationSiteConfirmation?: Date;

}




/*default implementation one might extend from (or use as is) */


export class BeneficiaryDisplayedListDTOBase  implements BeneficiaryDisplayedListDTO{

    name?:  string ;


    id?:  number ;

@Type(() => Date)
    installationSiteSubmission?:  Date ;

@Type(() => Date)
    installationSiteRejection?:  Date ;

@Type(() => Date)
    installationSiteConfirmation?:  Date ;

}
