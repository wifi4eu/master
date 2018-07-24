export interface ErrorDTO {
    errorCode?: number;

    errorMessage?: string;
}

export class ErrorDTOBase implements ErrorDTO{

    errorCode?: number;

    errorMessage?: string;
}
