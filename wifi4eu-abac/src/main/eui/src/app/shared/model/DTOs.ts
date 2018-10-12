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
    lefDocAresRef?: string;
    lcDocAresRef?: string;
    readyToBeCounterSigned?: Boolean;
    isSelected?: Boolean;
}

export interface BAFMonitoringRowDTO {
    id?: number;
    countryCode?: string;
    accountName?: string;
    bafStatus?: string;
}

export interface ResponseDTO {
    success?: boolean;
    message?: any;
    batchRef?: string;
}

export interface UserDetailsDTO {
    userId?: string;
    email?: string;
    firstName?: string;
    lastName?: string;
    fullName?: string;
    roles?: string[];
}
