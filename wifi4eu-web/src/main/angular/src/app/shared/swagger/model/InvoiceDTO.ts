import * as models from './models';
import {Type} from "class-transformer";

export interface InvoiceDTO {
    invoiceId?: number;

    name?: string;

    serialNumber?: string;

    productNumber?: string;

    modelNumber?: string;

}




/*default implementation one might extend from (or use as is) */


export class InvoiceDTOBase  implements InvoiceDTO{

    invoiceId?:  number ;


    name?:  string ;


    serialNumber?:  string ;


    productNumber?:  string ;


    modelNumber?:  string ;

}
