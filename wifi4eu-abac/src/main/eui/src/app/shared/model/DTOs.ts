export interface CountryDTO {
    cd?: string;
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
}

export interface ResponseDTO {
    success?: boolean;
    message?: any;
}
