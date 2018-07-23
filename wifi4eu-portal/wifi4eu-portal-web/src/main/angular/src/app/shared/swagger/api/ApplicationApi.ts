// tslint:disable:no-unused-variable member-ordering
// noinspection ES6UnusedImports

import {serialize, deserialize, deserializeArray, plainToClass, classToPlain} from 'class-transformer';
import {Inject, Injectable, Optional, OpaqueToken} from '@angular/core';
import {
  Http,
  Headers,
  URLSearchParams,
  RequestMethod,
  RequestOptions,
  RequestOptionsArgs,
  Response,
  ResponseContentType
} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import * as models from '../model/models';
import {BASE_PATH} from '../variables';
import {Configuration} from '../configuration';
import {ClassType} from '../classType';


export const IApplicationApi = new OpaqueToken('IApplicationApi');

export interface IApplicationApi {


    /**
     * Get applications voucher info by call id
     * 
     * @param c 
     * @param applicationId 
     */
    applicationVoucherInfoDTOEndpoint<T extends models.ApplicationVoucherInfoDTO>(applicationId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Check if whether the correction request email option is available for a specific call
     * 
     * @param callId 
     */
    checkIfCorrectionRequestEmailIsAvailable(callId: number ): Observable<boolean>;
    /**
     * exportExcelDGConnApplicantsList
     * 
     * @param callId 
     * @param country 
     */
    exportExcelDGConnApplicantsList(callId: number,  country: string ): Observable<Array<string>>;
    /**
     * exportExcelDGConnApplicantsListSearchingName
     * 
     * @param callId 
     * @param country 
     * @param name 
     */
    exportExcelDGConnApplicantsListSearchingName(callId: number,  country: string,  name: string ): Observable<Array<string>>;
    /**
     * findDgconnApplicantsListByCallId
     * 
     * @param c 
     * @param callId 
     * @param country 
     * @param body 
     */
    findDgconnApplicantsListByCallId<T extends models.ResponseDTO>(callId: number, country: string, body?: models.PagingSortingDTO, c?: ClassType<T>): Observable<T>;
    /**
     * findDgconnApplicantsListByCallIdSearchingName
     * 
     * @param c 
     * @param callId 
     * @param country 
     * @param name 
     * @param body 
     */
    findDgconnApplicantsListByCallIdSearchingName<T extends models.ResponseDTO>(callId: number, country: string, name: string, body?: models.PagingSortingDTO, c?: ClassType<T>): Observable<T>;
    /**
     * Resource to generate ApplicantListItemDTO
     * 
     * @param c 
     */
    getApplicantListItem<T extends models.ApplicantListItemDTO>(c?: ClassType<T>): Observable<T>;
    /**
     * Get application by call and registration id
     * 
     * @param c 
     * @param callId 
     * @param registrationId 
     */
    getApplicationByCallIdAndRegistrationId<T extends models.ApplicationDTO>(callId: number, registrationId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get applications by specific call and lau id
     * 
     * @param c 
     * @param callId 
     * @param lauId 
     * @param currentDate 
     */
    getApplicationsByCallIdAndLauId<T extends models.ApplicationDTO>(callId: number, lauId: number, currentDate: number, c?: ClassType<T>): Observable<T[]>;
    /**
     * Get applications voucher2 info by call id
     * 
     * @param callId 
     */
    getApplicationsNotInvalidated(callId: number ): Observable<number>;
    /**
     * Get applications voucher info by call id
     * 
     * @param c 
     * @param callId 
     */
    getApplicationsVoucherInfoByCall<T extends models.ApplicationVoucherInfoDTO>(callId: number, c?: ClassType<T>): Observable<T[]>;
    /**
     * Get the last correction request email information
     * 
     * @param c 
     * @param callId 
     */
    getLastCorrectionRequestEmail<T extends models.CorrectionRequestEmailDTO>(callId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Resource to generate PagingSortingDTO
     * 
     * @param c 
     */
    getPagingSortingDTO<T extends models.PagingSortingDTO>(c?: ClassType<T>): Observable<T>;
    /**
     * Invalidate application
     * 
     * @param c 
     * @param body 
     */
    invalidateApplication<T extends models.ResponseDTO>(body?: models.ApplicationDTO, c?: ClassType<T>): Observable<T>;
    /**
     * Reject application
     * 
     * @param c 
     * @param body 
     */
    rejectApplicationVoucherAssigment<T extends models.ResponseDTO>(body?: number, c?: ClassType<T>): Observable<T>;
    /**
     * Select application
     * 
     * @param c 
     * @param body 
     */
    selectApplicationVoucherAssigment<T extends models.ResponseDTO>(body?: number, c?: ClassType<T>): Observable<T>;
    /**
     * Send request correction e-mails for a specific call
     * 
     * @param c 
     * @param callId 
     */
    sendCorrectionEmails<T extends models.ResponseDTO>(callId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Send legal documents correction request
     * 
     * @param c 
     * @param body 
     */
    sendLegalDocumentsCorrection<T extends models.ResponseDTO>(body?: models.ApplicationDTO, c?: ClassType<T>): Observable<T>;
    /**
     * Validate application
     * 
     * @param c 
     * @param body 
     */
    validateApplication<T extends models.ResponseDTO>(body?: models.ApplicationDTO, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class ApplicationApi implements IApplicationApi {
    protected basePath = 'http://localhost:8080/wifi4eu/api';
    public defaultHeaders: Headers = new Headers();
    public configuration: Configuration = new Configuration();

    constructor(protected http: Http,
                @Optional() @Inject(BASE_PATH) basePath: string,
                @Optional() configuration: Configuration) {
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
        }
    }



    /**
     * Get applications voucher info by call id
     * 
     * @param c
     * @param applicationId 
     */
    applicationVoucherInfoDTOEndpoint<T extends models.ApplicationVoucherInfoDTO>(applicationId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.applicationVoucherInfoDTOEndpointWithHttpInfo(applicationId)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }



    /**
     * Check if whether the correction request email option is available for a specific call
     * 
     * @param callId 
     */
    public checkIfCorrectionRequestEmailIsAvailable(callId: number ): Observable<boolean> {
        return this.checkIfCorrectionRequestEmailIsAvailableWithHttpInfo(callId)
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }



    /**
     * exportExcelDGConnApplicantsList
     * 
     * @param callId 
     * @param country 
     */
    public exportExcelDGConnApplicantsList(callId: number,  country: string ): Observable<Array<string>> {
        return this.exportExcelDGConnApplicantsListWithHttpInfo(callId, country)
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }



    /**
     * exportExcelDGConnApplicantsListSearchingName
     * 
     * @param callId 
     * @param country 
     * @param name 
     */
    public exportExcelDGConnApplicantsListSearchingName(callId: number,  country: string,  name: string ): Observable<Array<string>> {
        return this.exportExcelDGConnApplicantsListSearchingNameWithHttpInfo(callId, country, name)
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }




    /**
     * findDgconnApplicantsListByCallId
     * 
     * @param c
     * @param callId 
     * @param country 
     * @param body 
     */
    findDgconnApplicantsListByCallId<T extends models.ResponseDTO>(callId: number, country: string, body?: models.PagingSortingDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.findDgconnApplicantsListByCallIdWithHttpInfo(callId, country, body)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * findDgconnApplicantsListByCallIdSearchingName
     * 
     * @param c
     * @param callId 
     * @param country 
     * @param name 
     * @param body 
     */
    findDgconnApplicantsListByCallIdSearchingName<T extends models.ResponseDTO>(callId: number, country: string, name: string, body?: models.PagingSortingDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.findDgconnApplicantsListByCallIdSearchingNameWithHttpInfo(callId, country, name, body)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Resource to generate ApplicantListItemDTO
     * 
     * @param c
     */
    getApplicantListItem<T extends models.ApplicantListItemDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getApplicantListItemWithHttpInfo()
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Get application by call and registration id
     * 
     * @param c
     * @param callId 
     * @param registrationId 
     */
    getApplicationByCallIdAndRegistrationId<T extends models.ApplicationDTO>(callId: number, registrationId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getApplicationByCallIdAndRegistrationIdWithHttpInfo(callId, registrationId)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Get applications by specific call and lau id
     * 
     * @param c
     * @param callId 
     * @param lauId 
     * @param currentDate 
     */
    getApplicationsByCallIdAndLauId<T extends models.ApplicationDTO>(callId: number, lauId: number, currentDate: number, c?: ClassType<T>): Observable<T[]> {

        return this.getApplicationsByCallIdAndLauIdWithHttpInfo(callId, lauId, currentDate)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserializeArray(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }



    /**
     * Get applications voucher2 info by call id
     * 
     * @param callId 
     */
    public getApplicationsNotInvalidated(callId: number ): Observable<number> {
        return this.getApplicationsNotInvalidatedWithHttpInfo(callId)
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }




    /**
     * Get applications voucher info by call id
     * 
     * @param c
     * @param callId 
     */
    getApplicationsVoucherInfoByCall<T extends models.ApplicationVoucherInfoDTO>(callId: number, c?: ClassType<T>): Observable<T[]> {

        return this.getApplicationsVoucherInfoByCallWithHttpInfo(callId)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserializeArray(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Get the last correction request email information
     * 
     * @param c
     * @param callId 
     */
    getLastCorrectionRequestEmail<T extends models.CorrectionRequestEmailDTO>(callId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getLastCorrectionRequestEmailWithHttpInfo(callId)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Resource to generate PagingSortingDTO
     * 
     * @param c
     */
    getPagingSortingDTO<T extends models.PagingSortingDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getPagingSortingDTOWithHttpInfo()
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Invalidate application
     * 
     * @param c
     * @param body 
     */
    invalidateApplication<T extends models.ResponseDTO>(body?: models.ApplicationDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.invalidateApplicationWithHttpInfo(body)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Reject application
     * 
     * @param c
     * @param body 
     */
    rejectApplicationVoucherAssigment<T extends models.ResponseDTO>(body?: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.rejectApplicationVoucherAssigmentWithHttpInfo(body)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Select application
     * 
     * @param c
     * @param body 
     */
    selectApplicationVoucherAssigment<T extends models.ResponseDTO>(body?: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.selectApplicationVoucherAssigmentWithHttpInfo(body)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Send request correction e-mails for a specific call
     * 
     * @param c
     * @param callId 
     */
    sendCorrectionEmails<T extends models.ResponseDTO>(callId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.sendCorrectionEmailsWithHttpInfo(callId)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Send legal documents correction request
     * 
     * @param c
     * @param body 
     */
    sendLegalDocumentsCorrection<T extends models.ResponseDTO>(body?: models.ApplicationDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.sendLegalDocumentsCorrectionWithHttpInfo(body)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Validate application
     * 
     * @param c
     * @param body 
     */
    validateApplication<T extends models.ResponseDTO>(body?: models.ApplicationDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.validateApplicationWithHttpInfo(body)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }



    /**
     * Get applications voucher info by call id
     * 
     * @param applicationId 
     */
    private applicationVoucherInfoDTOEndpointWithHttpInfo(applicationId: number ): Observable<Response> {
        const path = this.basePath + `/application/voucherInfo/application/${applicationId}`;
//        .replace('{' + 'applicationId' + '}', String(applicationId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'applicationId' is not null or undefined
        if (applicationId === null || applicationId === undefined) {
            throw new Error('Required parameter applicationId was null or undefined when calling applicationVoucherInfoDTOEndpoint.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/application/voucherInfo/application/${applicationId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Check if whether the correction request email option is available for a specific call
     * 
     * @param callId 
     */
    private checkIfCorrectionRequestEmailIsAvailableWithHttpInfo(callId: number ): Observable<Response> {
        const path = this.basePath + `/application/checkIfCorrectionRequestEmailIsAvailable`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling checkIfCorrectionRequestEmailIsAvailable.');
        }
        if (callId !== undefined) {
            queryParameters.set('callId', <any>callId);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/application/checkIfCorrectionRequestEmailIsAvailable".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * exportExcelDGConnApplicantsList
     * 
     * @param callId 
     * @param country 
     */
    private exportExcelDGConnApplicantsListWithHttpInfo(callId: number,  country: string ): Observable<Response> {
        const path = this.basePath + `/application/exportExcelDGConnApplicantsList`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling exportExcelDGConnApplicantsList.');
        }
        // verify required parameter 'country' is not null or undefined
        if (country === null || country === undefined) {
            throw new Error('Required parameter country was null or undefined when calling exportExcelDGConnApplicantsList.');
        }
        if (callId !== undefined) {
            queryParameters.set('callId', <any>callId);
        }
        if (country !== undefined) {
            queryParameters.set('country', <any>country);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/application/exportExcelDGConnApplicantsList".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * exportExcelDGConnApplicantsListSearchingName
     * 
     * @param callId 
     * @param country 
     * @param name 
     */
    private exportExcelDGConnApplicantsListSearchingNameWithHttpInfo(callId: number,  country: string,  name: string ): Observable<Response> {
        const path = this.basePath + `/application/exportExcelDGConnApplicantsListSearchingName`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling exportExcelDGConnApplicantsListSearchingName.');
        }
        // verify required parameter 'country' is not null or undefined
        if (country === null || country === undefined) {
            throw new Error('Required parameter country was null or undefined when calling exportExcelDGConnApplicantsListSearchingName.');
        }
        // verify required parameter 'name' is not null or undefined
        if (name === null || name === undefined) {
            throw new Error('Required parameter name was null or undefined when calling exportExcelDGConnApplicantsListSearchingName.');
        }
        if (callId !== undefined) {
            queryParameters.set('callId', <any>callId);
        }
        if (country !== undefined) {
            queryParameters.set('country', <any>country);
        }
        if (name !== undefined) {
            queryParameters.set('name', <any>name);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/application/exportExcelDGConnApplicantsListSearchingName".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * findDgconnApplicantsListByCallId
     * 
     * @param callId 
     * @param country 
     * @param body 
     */
    private findDgconnApplicantsListByCallIdWithHttpInfo(callId: number,  country: string,  body?: models.PagingSortingDTO ): Observable<Response> {
        const path = this.basePath + `/application/findDgconnApplicantsListByCallId/${callId}`;
//        .replace('{' + 'callId' + '}', String(callId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling findDgconnApplicantsListByCallId.');
        }
        // verify required parameter 'country' is not null or undefined
        if (country === null || country === undefined) {
            throw new Error('Required parameter country was null or undefined when calling findDgconnApplicantsListByCallId.');
        }
        if (country !== undefined) {
            queryParameters.set('country', <any>country);
        }


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/application/findDgconnApplicantsListByCallId/${callId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * findDgconnApplicantsListByCallIdSearchingName
     * 
     * @param callId 
     * @param country 
     * @param name 
     * @param body 
     */
    private findDgconnApplicantsListByCallIdSearchingNameWithHttpInfo(callId: number,  country: string,  name: string,  body?: models.PagingSortingDTO ): Observable<Response> {
        const path = this.basePath + `/application/findDgconnApplicantsListByCallIdSearchingName/${callId}`;
//        .replace('{' + 'callId' + '}', String(callId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling findDgconnApplicantsListByCallIdSearchingName.');
        }
        // verify required parameter 'country' is not null or undefined
        if (country === null || country === undefined) {
            throw new Error('Required parameter country was null or undefined when calling findDgconnApplicantsListByCallIdSearchingName.');
        }
        // verify required parameter 'name' is not null or undefined
        if (name === null || name === undefined) {
            throw new Error('Required parameter name was null or undefined when calling findDgconnApplicantsListByCallIdSearchingName.');
        }
        if (country !== undefined) {
            queryParameters.set('country', <any>country);
        }
        if (name !== undefined) {
            queryParameters.set('name', <any>name);
        }


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/application/findDgconnApplicantsListByCallIdSearchingName/${callId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Resource to generate ApplicantListItemDTO
     * 
     */
    private getApplicantListItemWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/application/getApplicantListItem`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/application/getApplicantListItem".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get application by call and registration id
     * 
     * @param callId 
     * @param registrationId 
     */
    private getApplicationByCallIdAndRegistrationIdWithHttpInfo(callId: number,  registrationId: number ): Observable<Response> {
        const path = this.basePath + `/application/call/${callId}/registration/${registrationId}`;
//        .replace('{' + 'callId' + '}', String(callId)) 
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)//        .replace('{' + 'registrationId' + '}', String(registrationId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling getApplicationByCallIdAndRegistrationId.');
        }
        // verify required parameter 'registrationId' is not null or undefined
        if (registrationId === null || registrationId === undefined) {
            throw new Error('Required parameter registrationId was null or undefined when calling getApplicationByCallIdAndRegistrationId.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/application/call/${callId}/registration/${registrationId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get applications by specific call and lau id
     * 
     * @param callId 
     * @param lauId 
     * @param currentDate 
     */
    private getApplicationsByCallIdAndLauIdWithHttpInfo(callId: number,  lauId: number,  currentDate: number ): Observable<Response> {
        const path = this.basePath + `/application/call/${callId}/lau/${lauId}`;
//        .replace('{' + 'callId' + '}', String(callId)) 
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)//        .replace('{' + 'lauId' + '}', String(lauId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling getApplicationsByCallIdAndLauId.');
        }
        // verify required parameter 'lauId' is not null or undefined
        if (lauId === null || lauId === undefined) {
            throw new Error('Required parameter lauId was null or undefined when calling getApplicationsByCallIdAndLauId.');
        }
        // verify required parameter 'currentDate' is not null or undefined
        if (currentDate === null || currentDate === undefined) {
            throw new Error('Required parameter currentDate was null or undefined when calling getApplicationsByCallIdAndLauId.');
        }
        if (currentDate !== undefined) {
            queryParameters.set('currentDate', <any>currentDate);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/application/call/${callId}/lau/${lauId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get applications voucher2 info by call id
     * 
     * @param callId 
     */
    private getApplicationsNotInvalidatedWithHttpInfo(callId: number ): Observable<Response> {
        const path = this.basePath + `/application/valid/call/${callId}`;
//        .replace('{' + 'callId' + '}', String(callId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling getApplicationsNotInvalidated.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/application/valid/call/${callId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get applications voucher info by call id
     * 
     * @param callId 
     */
    private getApplicationsVoucherInfoByCallWithHttpInfo(callId: number ): Observable<Response> {
        const path = this.basePath + `/application/voucherInfo/call/${callId}`;
//        .replace('{' + 'callId' + '}', String(callId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling getApplicationsVoucherInfoByCall.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/application/voucherInfo/call/${callId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get the last correction request email information
     * 
     * @param callId 
     */
    private getLastCorrectionRequestEmailWithHttpInfo(callId: number ): Observable<Response> {
        const path = this.basePath + `/application/getLastCorrectionRequestEmail`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling getLastCorrectionRequestEmail.');
        }
        if (callId !== undefined) {
            queryParameters.set('callId', <any>callId);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/application/getLastCorrectionRequestEmail".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Resource to generate PagingSortingDTO
     * 
     */
    private getPagingSortingDTOWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/application/getPagingSortingDTO`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/application/getPagingSortingDTO".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Invalidate application
     * 
     * @param body 
     */
    private invalidateApplicationWithHttpInfo(body?: models.ApplicationDTO ): Observable<Response> {
        const path = this.basePath + `/application/invalidate`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/application/invalidate".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Reject application
     * 
     * @param body 
     */
    private rejectApplicationVoucherAssigmentWithHttpInfo(body?: number ): Observable<Response> {
        const path = this.basePath + `/application/reject`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/application/reject".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Select application
     * 
     * @param body 
     */
    private selectApplicationVoucherAssigmentWithHttpInfo(body?: number ): Observable<Response> {
        const path = this.basePath + `/application/select`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/application/select".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Send request correction e-mails for a specific call
     * 
     * @param callId 
     */
    private sendCorrectionEmailsWithHttpInfo(callId: number ): Observable<Response> {
        const path = this.basePath + `/application/sendCorrectionEmails`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling sendCorrectionEmails.');
        }
        if (callId !== undefined) {
            queryParameters.set('callId', <any>callId);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/application/sendCorrectionEmails".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Send legal documents correction request
     * 
     * @param body 
     */
    private sendLegalDocumentsCorrectionWithHttpInfo(body?: models.ApplicationDTO ): Observable<Response> {
        const path = this.basePath + `/application/sendLegalDocumentsCorrection`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/application/sendLegalDocumentsCorrection".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Validate application
     * 
     * @param body 
     */
    private validateApplicationWithHttpInfo(body?: models.ApplicationDTO ): Observable<Response> {
        const path = this.basePath + `/application/validate`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/application/validate".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
