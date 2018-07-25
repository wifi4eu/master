export interface MonitoringRowDTO {
    id?: number;
    countryCode?: string;
    region?: string;
    wfStatus?: string;
}

export class MonitoringRowDTOBase implements MonitoringRowDTO{
    id?: number;
    countryCode?: string;
    region?: string;
    wfStatus?: string;
}
