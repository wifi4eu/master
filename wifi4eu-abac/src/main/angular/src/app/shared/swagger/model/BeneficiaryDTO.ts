import * as models from './models';
import {Type} from "class-transformer";

export interface BeneficiaryDTO {
    user?: models.UserDTO;

    mayors?: Array<models.MayorDTO>;

    municipalities?: Array<models.MunicipalityDTO>;

    representsMultipleMunicipalities?: boolean;

    associationName?: string;

    organisationId?: number;

    lang?: string;

}




/*default implementation one might extend from (or use as is) */


export class BeneficiaryDTOBase  implements BeneficiaryDTO{
    
    user?:  models.UserDTOBase ;

    @Type(() => models.MayorDTOBase)
    mayors?:  models.MayorDTOBase[] ;

    @Type(() => models.MunicipalityDTOBase)
    municipalities?:  models.MunicipalityDTOBase[] ;


    representsMultipleMunicipalities?:  boolean ;


    associationName?:  string ;


    organisationId?:  number ;


    lang?:  string ;

}
