export interface CountryDTO {
    iso2Code?: string;
    name?: string;
}

export interface MonitoringRowDTO {
    id?: number;
    countryCode?: string;
    municipality?: string;
    registrationNumber?: number;
    lefStatus?: string;
    lefAbacRef?: string;
    bcStatus?: string;
    bcAbacRef?: string;
    lcStatus?: string;
    lcAbacRef?: string;
    signatureDate?: string;
    counterSignatureDate?: string;
    docAresRef?: string;
    readyToBeCounterSigned?: Boolean;
    isSelected?: Boolean;
}

export interface ResponseDTO {
    success?: boolean;
    message?: any;
}
