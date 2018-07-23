import * as models from './models';
import {Type} from "class-transformer";

export interface RegistrationDTO {
    id?: number;

    userId?: number;

    municipalityId?: number;

    role?: string;

    status?: number;

    legalFile1Size?: number;

    legalFile1Mime?: string;

    legalFile2Size?: number;

    legalFile2Mime?: string;

    legalFile3Size?: number;

    legalFile3Mime?: string;

    legalFile4Size?: number;

    legalFile4Mime?: string;

    ipRegistration?: string;

    associationName?: string;

    organisationId?: number;

    uploadTime?: number;

    allFilesFlag?: number;

    mailCounter?: number;

    registrationWarningDTOList?: Array<models.RegistrationWarningDTO>;

    idUserPM?: number;

    idUserBPM?: number;

    idStatusBeneficiary?: number;

    compliance?: boolean;

    actionToBeTaken?: number;

    actionTaken?: number;

    conformity?: boolean;

    firstFalseCheck?: Date;

    dateRegistered?: Date;

    installationSiteSubmission?: Date;

    installationSiteRejection?: Date;

    installationSiteConfirmation?: Date;

}




/*default implementation one might extend from (or use as is) */


export class RegistrationDTOBase  implements RegistrationDTO{

    id?:  number ;


    userId?:  number ;


    municipalityId?:  number ;


    role?:  string ;


    status?:  number ;


    legalFile1Size?:  number ;


    legalFile1Mime?:  string ;


    legalFile2Size?:  number ;


    legalFile2Mime?:  string ;


    legalFile3Size?:  number ;


    legalFile3Mime?:  string ;


    legalFile4Size?:  number ;


    legalFile4Mime?:  string ;


    ipRegistration?:  string ;


    associationName?:  string ;


    organisationId?:  number ;


    uploadTime?:  number ;


    allFilesFlag?:  number ;


    mailCounter?:  number ;

    @Type(() => models.RegistrationWarningDTOBase)
    registrationWarningDTOList?:  models.RegistrationWarningDTOBase[] ;


    idUserPM?:  number ;


    idUserBPM?:  number ;


    idStatusBeneficiary?:  number ;


    compliance?:  boolean ;


    actionToBeTaken?:  number ;


    actionTaken?:  number ;


    conformity?:  boolean ;

@Type(() => Date)
    firstFalseCheck?:  Date ;

@Type(() => Date)
    dateRegistered?:  Date ;

@Type(() => Date)
    installationSiteSubmission?:  Date ;

@Type(() => Date)
    installationSiteRejection?:  Date ;

@Type(() => Date)
    installationSiteConfirmation?:  Date ;

}
