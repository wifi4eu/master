import * as models from './models';
import {Type} from "class-transformer";

export interface VoucherSimulationDTO {
    id?: number;

    euRank?: number;

    countryRank?: number;

    country?: string;

    municipality?: number;

    numApplications?: number;

    rejected?: number;

    voucherAssignment?: number;

    selectionStatus?: number;

    application?: models.ApplicationDTO;

    lau?: number;

    municipalityName?: string;

    registrationWarningDTO?: Array<models.RegistrationWarningDTO>;

}




/*default implementation one might extend from (or use as is) */


export class VoucherSimulationDTOBase  implements VoucherSimulationDTO{

    id?:  number ;


    euRank?:  number ;


    countryRank?:  number ;


    country?:  string ;


    municipality?:  number ;


    numApplications?:  number ;


    rejected?:  number ;


    voucherAssignment?:  number ;


    selectionStatus?:  number ;

    
    application?:  models.ApplicationDTOBase ;


    lau?:  number ;


    municipalityName?:  string ;

    @Type(() => models.RegistrationWarningDTOBase)
    registrationWarningDTO?:  models.RegistrationWarningDTOBase[] ;

}
