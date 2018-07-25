export interface MonitoringRowDTO {
    id?: number;
    countryCode?: string;
    city?: string;
    wfStatus?: string;
}

export class MonitoringRowDTOBase implements MonitoringRowDTO{
    id?: number;
    countryCode?: string;
    city?: string;
    wfStatus?: string;
}
