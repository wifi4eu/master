import { ErrorDTO, ErrorDTOBase } from './ErrorDTO';

export interface ResponseDTO {
    success?: boolean;

    data?: any;

    error?: ErrorDTO;

    xtotalCount?: number;

}

export class ResponseDTOBase implements ResponseDTO{

    success?: boolean;

    data?: any;

    error?: ErrorDTOBase;

    xtotalCount?: number;
}
