import * as models from './models';
import {Type} from "class-transformer";

export interface InstallationDetailDTO {
    installationDetailId?: number;

    bidDTO?: models.BidDTO;

    invoiceDTOs?: Array<models.InvoiceDTO>;

}




/*default implementation one might extend from (or use as is) */


export class InstallationDetailDTOBase  implements InstallationDetailDTO{

    installationDetailId?:  number ;

    
    bidDTO?:  models.BidDTOBase ;

    @Type(() => models.InvoiceDTOBase)
    invoiceDTOs?:  models.InvoiceDTOBase[] ;

}
