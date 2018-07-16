import * as models from './models';
import {Type} from "class-transformer";

export interface BenPubSupDTO {
    benPubSubId?: number;

    beneficiaryId?: number;

    publicationId?: number;

    supplierId?: number;

    awarded?: boolean;

    date?: Date;

    lefExport?: number;

    lefImport?: number;

    lefStatus?: number;

    bcExport?: number;

    bcImport?: number;

    bcStatus?: number;

    lcExport?: number;

    lcImport?: number;

    lcStatus?: number;

    lastAbacMessage?: string;

}




/*default implementation one might extend from (or use as is) */


export class BenPubSupDTOBase  implements BenPubSupDTO{

    benPubSubId?:  number ;


    beneficiaryId?:  number ;


    publicationId?:  number ;


    supplierId?:  number ;


    awarded?:  boolean ;

@Type(() => Date)
    date?:  Date ;


    lefExport?:  number ;


    lefImport?:  number ;


    lefStatus?:  number ;


    bcExport?:  number ;


    bcImport?:  number ;


    bcStatus?:  number ;


    lcExport?:  number ;


    lcImport?:  number ;


    lcStatus?:  number ;


    lastAbacMessage?:  string ;

}
