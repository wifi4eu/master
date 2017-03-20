import * as models from './models';
import {Type} from "class-transformer";

export interface BeneficiarySupplierPublicationDTO {
    benSupplierPublicationId?: number;

    legalEntityDTO?: models.LegalEntityDTO;

    supplierDTO?: models.SupplierDTO;

    publicationCallDTO?: models.CallDTO;

    createDate?: number;

}




/*default implementation one might extend from (or use as is) */


export class BeneficiarySupplierPublicationDTOBase  implements BeneficiarySupplierPublicationDTO{

    benSupplierPublicationId?:  number ;

    
    legalEntityDTO?:  models.LegalEntityDTOBase ;

    
    supplierDTO?:  models.SupplierDTOBase ;

    
    publicationCallDTO?:  models.CallDTOBase ;


    createDate?:  number ;

}
