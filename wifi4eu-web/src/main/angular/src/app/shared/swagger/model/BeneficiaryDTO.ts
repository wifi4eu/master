import * as models from './models';
import {Type} from "class-transformer";

export interface BeneficiaryDTO {
    mayorDTO?: models.MayorDTO;

    representativeDTO?: models.RepresentativeDTO;

    legalEntityDTO?: models.LegalEntityDTO;

    represented?: boolean;

}




/*default implementation one might extend from (or use as is) */


export class BeneficiaryDTOBase  implements BeneficiaryDTO{
    
    mayorDTO?:  models.MayorDTOBase ;

    
    representativeDTO?:  models.RepresentativeDTOBase ;

    
    legalEntityDTO?:  models.LegalEntityDTOBase ;


    represented?:  boolean ;

}
