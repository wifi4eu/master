import * as models from './models';
import {Type} from "class-transformer";

export interface SupplierDTO {
    supplierId?: number;

    companyDTO?: models.CompanyDTO;

    supportedRegions?: Array<models.NutsDTO>;

    contactPersonDTO?: models.ContactPersonDTO;

    installationDTOs?: Array<models.InstallationDTO>;

    legalCheck1?: boolean;

    legalCheck2?: boolean;

    createDate?: number;

}




/*default implementation one might extend from (or use as is) */


export class SupplierDTOBase  implements SupplierDTO{

    supplierId?:  number ;

    
    companyDTO?:  models.CompanyDTOBase ;

    @Type(() => models.NutsDTOBase)
    supportedRegions?:  models.NutsDTOBase[] ;

    
    contactPersonDTO?:  models.ContactPersonDTOBase ;

    @Type(() => models.InstallationDTOBase)
    installationDTOs?:  models.InstallationDTOBase[] ;


    legalCheck1?:  boolean ;


    legalCheck2?:  boolean ;


    createDate?:  number ;

}
