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
    bcStatus?: string;
    lcStatus?: string;
    signatureDate?: string;
    counterSignatureDate?: string;
    readyToBeCounterSigned?: Boolean;
}

export interface ResponseDTO {
    success?: boolean;
    message?: any;
}
