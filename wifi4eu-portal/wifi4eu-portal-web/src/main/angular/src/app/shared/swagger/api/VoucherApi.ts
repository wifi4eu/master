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


export const IVoucherApi = new OpaqueToken('IVoucherApi');

export interface IVoucherApi {


    /**
     * Get all the voucher assignment
     * 
     * @param c 
     */
    allVoucherAssignments<T extends models.VoucherAssignmentDTO>(c?: ClassType<T>): Observable<T[]>;
    /**
     * Check freeze list is enabled
     * 
     * @param callId 
     */
    checkApplicationAreValidForFreezeList(callId: number ): Observable<boolean>;
    /**
     * Check pre-selected list enabled
     * 
     * @param assignmentId 
     */
    checkSavePreSelectionEnabled(assignmentId: number ): Observable<boolean>;
    /**
     * Export voucher simulation
     * 
     * @param assignmentId 
     * @param country 
     * @param municipality 
     * @param field 
     * @param direction 
     */
    exportExcelVoucherSimulation(assignmentId: number,  country: string,  municipality: string,  field: string,  direction: string ): Observable<Array<string>>;
    /**
     * Get voucher assignment by call
     * 
     * @param c 
     * @param callId 
     */
    getVoucherAssignmentAuxiliarByCall<T extends models.VoucherAssignmentAuxiliarDTO>(callId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get voucher assignment by call
     * 
     * @param c 
     * @param callId 
     */
    getVoucherAssignmentByCall<T extends models.VoucherAssignmentDTO>(callId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get voucher assignment auxiliar by call and status
     * 
     * @param c 
     * @param callId 
     * @param status 
     */
    getVoucherAssignmentByCallAndStatus<T extends models.VoucherAssignmentAuxiliarDTO>(callId: number, status: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get voucher assignment by id
     * 
     * @param c 
     * @param assignmentId 
     */
    getVoucherAssignmentById<T extends models.VoucherAssignmentDTO>(assignmentId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get voucher simulation by voucher assignment
     * 
     * @param c 
     * @param assignmentId 
     * @param country 
     * @param municipality 
     * @param page 
     * @param size 
     * @param field 
     * @param direction 
     */
    getVoucherSimulationByVoucherAssignment<T extends models.ResponseDTO>(assignmentId: number, country: string, municipality: string, page: number, size: number, field: string, direction: string, c?: ClassType<T>): Observable<T>;
    /**
     * Freeze simulation list
     * 
     * @param c 
     * @param assignmentId 
     * @param callId 
     */
    saveFreezeListSimulation<T extends models.ResponseDTO>(assignmentId: number, callId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Save simulation to pre-selected list
     * 
     * @param c 
     * @param assignmentId 
     * @param callId 
     */
    savePreListSimulation<T extends models.ResponseDTO>(assignmentId: number, callId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Send notifications  to applicants
     * 
     * @param c 
     * @param body 
     */
    sendNotificationForApplicants<T extends models.ResponseDTO>(body?: number, c?: ClassType<T>): Observable<T>;
    /**
     * Create voucher assignment
     * 
     * @param c 
     * @param body 
     */
    simulateVoucherAssignment<T extends models.ResponseDTO>(body?: number, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class VoucherApi implements IVoucherApi {
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
     * Get all the voucher assignment
     * 
     * @param c
     */
    allVoucherAssignments<T extends models.VoucherAssignmentDTO>(c?: ClassType<T>): Observable<T[]> {

        return this.allVoucherAssignmentsWithHttpInfo()
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
     * Check freeze list is enabled
     * 
     * @param callId 
     */
    public checkApplicationAreValidForFreezeList(callId: number ): Observable<boolean> {
        return this.checkApplicationAreValidForFreezeListWithHttpInfo(callId)
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }



    /**
     * Check pre-selected list enabled
     * 
     * @param assignmentId 
     */
    public checkSavePreSelectionEnabled(assignmentId: number ): Observable<boolean> {
        return this.checkSavePreSelectionEnabledWithHttpInfo(assignmentId)
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }



    /**
     * Export voucher simulation
     * 
     * @param assignmentId 
     * @param country 
     * @param municipality 
     * @param field 
     * @param direction 
     */
    public exportExcelVoucherSimulation(assignmentId: number,  country: string,  municipality: string,  field: string,  direction: string ): Observable<Array<string>> {
        return this.exportExcelVoucherSimulationWithHttpInfo(assignmentId, country, municipality, field, direction)
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }




    /**
     * Get voucher assignment by call
     * 
     * @param c
     * @param callId 
     */
    getVoucherAssignmentAuxiliarByCall<T extends models.VoucherAssignmentAuxiliarDTO>(callId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getVoucherAssignmentAuxiliarByCallWithHttpInfo(callId)
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
     * Get voucher assignment by call
     * 
     * @param c
     * @param callId 
     */
    getVoucherAssignmentByCall<T extends models.VoucherAssignmentDTO>(callId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getVoucherAssignmentByCallWithHttpInfo(callId)
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
     * Get voucher assignment auxiliar by call and status
     * 
     * @param c
     * @param callId 
     * @param status 
     */
    getVoucherAssignmentByCallAndStatus<T extends models.VoucherAssignmentAuxiliarDTO>(callId: number, status: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getVoucherAssignmentByCallAndStatusWithHttpInfo(callId, status)
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
     * Get voucher assignment by id
     * 
     * @param c
     * @param assignmentId 
     */
    getVoucherAssignmentById<T extends models.VoucherAssignmentDTO>(assignmentId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getVoucherAssignmentByIdWithHttpInfo(assignmentId)
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
     * Get voucher simulation by voucher assignment
     * 
     * @param c
     * @param assignmentId 
     * @param country 
     * @param municipality 
     * @param page 
     * @param size 
     * @param field 
     * @param direction 
     */
    getVoucherSimulationByVoucherAssignment<T extends models.ResponseDTO>(assignmentId: number, country: string, municipality: string, page: number, size: number, field: string, direction: string, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getVoucherSimulationByVoucherAssignmentWithHttpInfo(assignmentId, country, municipality, page, size, field, direction)
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
     * Freeze simulation list
     * 
     * @param c
     * @param assignmentId 
     * @param callId 
     */
    saveFreezeListSimulation<T extends models.ResponseDTO>(assignmentId: number, callId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.saveFreezeListSimulationWithHttpInfo(assignmentId, callId)
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
     * Save simulation to pre-selected list
     * 
     * @param c
     * @param assignmentId 
     * @param callId 
     */
    savePreListSimulation<T extends models.ResponseDTO>(assignmentId: number, callId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.savePreListSimulationWithHttpInfo(assignmentId, callId)
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
     * Send notifications  to applicants
     * 
     * @param c
     * @param body 
     */
    sendNotificationForApplicants<T extends models.ResponseDTO>(body?: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.sendNotificationForApplicantsWithHttpInfo(body)
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
     * Create voucher assignment
     * 
     * @param c
     * @param body 
     */
    simulateVoucherAssignment<T extends models.ResponseDTO>(body?: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.simulateVoucherAssignmentWithHttpInfo(body)
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
     * Get all the voucher assignment
     * 
     */
    private allVoucherAssignmentsWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/voucher/assignments`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/voucher/assignments".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Check freeze list is enabled
     * 
     * @param callId 
     */
    private checkApplicationAreValidForFreezeListWithHttpInfo(callId: number ): Observable<Response> {
        const path = this.basePath + `/voucher/assignment/check-freeze-enabled/by/call/${callId}`;
//        .replace('{' + 'callId' + '}', String(callId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling checkApplicationAreValidForFreezeList.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/voucher/assignment/check-freeze-enabled/by/call/${callId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Check pre-selected list enabled
     * 
     * @param assignmentId 
     */
    private checkSavePreSelectionEnabledWithHttpInfo(assignmentId: number ): Observable<Response> {
        const path = this.basePath + `/voucher/assignment/${assignmentId}/check-prelist-enabled`;
//        .replace('{' + 'assignmentId' + '}', String(assignmentId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'assignmentId' is not null or undefined
        if (assignmentId === null || assignmentId === undefined) {
            throw new Error('Required parameter assignmentId was null or undefined when calling checkSavePreSelectionEnabled.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/voucher/assignment/${assignmentId}/check-prelist-enabled".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Export voucher simulation
     * 
     * @param assignmentId 
     * @param country 
     * @param municipality 
     * @param field 
     * @param direction 
     */
    private exportExcelVoucherSimulationWithHttpInfo(assignmentId: number,  country: string,  municipality: string,  field: string,  direction: string ): Observable<Response> {
        const path = this.basePath + `/voucher/exportExcel/assignment/${assignmentId}/simulation`;
//        .replace('{' + 'assignmentId' + '}', String(assignmentId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'assignmentId' is not null or undefined
        if (assignmentId === null || assignmentId === undefined) {
            throw new Error('Required parameter assignmentId was null or undefined when calling exportExcelVoucherSimulation.');
        }
        // verify required parameter 'country' is not null or undefined
        if (country === null || country === undefined) {
            throw new Error('Required parameter country was null or undefined when calling exportExcelVoucherSimulation.');
        }
        // verify required parameter 'municipality' is not null or undefined
        if (municipality === null || municipality === undefined) {
            throw new Error('Required parameter municipality was null or undefined when calling exportExcelVoucherSimulation.');
        }
        // verify required parameter 'field' is not null or undefined
        if (field === null || field === undefined) {
            throw new Error('Required parameter field was null or undefined when calling exportExcelVoucherSimulation.');
        }
        // verify required parameter 'direction' is not null or undefined
        if (direction === null || direction === undefined) {
            throw new Error('Required parameter direction was null or undefined when calling exportExcelVoucherSimulation.');
        }
        if (country !== undefined) {
            queryParameters.set('country', <any>country);
        }
        if (municipality !== undefined) {
            queryParameters.set('municipality', <any>municipality);
        }
        if (field !== undefined) {
            queryParameters.set('field', <any>field);
        }
        if (direction !== undefined) {
            queryParameters.set('direction', <any>direction);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/voucher/exportExcel/assignment/${assignmentId}/simulation".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get voucher assignment by call
     * 
     * @param callId 
     */
    private getVoucherAssignmentAuxiliarByCallWithHttpInfo(callId: number ): Observable<Response> {
        const path = this.basePath + `/voucher/assignmentaux/call/${callId}`;
//        .replace('{' + 'callId' + '}', String(callId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling getVoucherAssignmentAuxiliarByCall.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/voucher/assignmentaux/call/${callId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get voucher assignment by call
     * 
     * @param callId 
     */
    private getVoucherAssignmentByCallWithHttpInfo(callId: number ): Observable<Response> {
        const path = this.basePath + `/voucher/assignment/call/${callId}`;
//        .replace('{' + 'callId' + '}', String(callId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling getVoucherAssignmentByCall.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/voucher/assignment/call/${callId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get voucher assignment auxiliar by call and status
     * 
     * @param callId 
     * @param status 
     */
    private getVoucherAssignmentByCallAndStatusWithHttpInfo(callId: number,  status: number ): Observable<Response> {
        const path = this.basePath + `/voucher/assignment/call/${callId}/status/${status}`;
//        .replace('{' + 'callId' + '}', String(callId)) 
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)//        .replace('{' + 'status' + '}', String(status));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling getVoucherAssignmentByCallAndStatus.');
        }
        // verify required parameter 'status' is not null or undefined
        if (status === null || status === undefined) {
            throw new Error('Required parameter status was null or undefined when calling getVoucherAssignmentByCallAndStatus.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/voucher/assignment/call/${callId}/status/${status}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get voucher assignment by id
     * 
     * @param assignmentId 
     */
    private getVoucherAssignmentByIdWithHttpInfo(assignmentId: number ): Observable<Response> {
        const path = this.basePath + `/voucher/assignments/${assignmentId}`;
//        .replace('{' + 'assignmentId' + '}', String(assignmentId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'assignmentId' is not null or undefined
        if (assignmentId === null || assignmentId === undefined) {
            throw new Error('Required parameter assignmentId was null or undefined when calling getVoucherAssignmentById.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/voucher/assignments/${assignmentId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get voucher simulation by voucher assignment
     * 
     * @param assignmentId 
     * @param country 
     * @param municipality 
     * @param page 
     * @param size 
     * @param field 
     * @param direction 
     */
    private getVoucherSimulationByVoucherAssignmentWithHttpInfo(assignmentId: number,  country: string,  municipality: string,  page: number,  size: number,  field: string,  direction: string ): Observable<Response> {
        const path = this.basePath + `/voucher/assignment/${assignmentId}/simulation`;
//        .replace('{' + 'assignmentId' + '}', String(assignmentId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'assignmentId' is not null or undefined
        if (assignmentId === null || assignmentId === undefined) {
            throw new Error('Required parameter assignmentId was null or undefined when calling getVoucherSimulationByVoucherAssignment.');
        }
        // verify required parameter 'country' is not null or undefined
        if (country === null || country === undefined) {
            throw new Error('Required parameter country was null or undefined when calling getVoucherSimulationByVoucherAssignment.');
        }
        // verify required parameter 'municipality' is not null or undefined
        if (municipality === null || municipality === undefined) {
            throw new Error('Required parameter municipality was null or undefined when calling getVoucherSimulationByVoucherAssignment.');
        }
        // verify required parameter 'page' is not null or undefined
        if (page === null || page === undefined) {
            throw new Error('Required parameter page was null or undefined when calling getVoucherSimulationByVoucherAssignment.');
        }
        // verify required parameter 'size' is not null or undefined
        if (size === null || size === undefined) {
            throw new Error('Required parameter size was null or undefined when calling getVoucherSimulationByVoucherAssignment.');
        }
        // verify required parameter 'field' is not null or undefined
        if (field === null || field === undefined) {
            throw new Error('Required parameter field was null or undefined when calling getVoucherSimulationByVoucherAssignment.');
        }
        // verify required parameter 'direction' is not null or undefined
        if (direction === null || direction === undefined) {
            throw new Error('Required parameter direction was null or undefined when calling getVoucherSimulationByVoucherAssignment.');
        }
        if (country !== undefined) {
            queryParameters.set('country', <any>country);
        }
        if (municipality !== undefined) {
            queryParameters.set('municipality', <any>municipality);
        }
        if (page !== undefined) {
            queryParameters.set('page', <any>page);
        }
        if (size !== undefined) {
            queryParameters.set('size', <any>size);
        }
        if (field !== undefined) {
            queryParameters.set('field', <any>field);
        }
        if (direction !== undefined) {
            queryParameters.set('direction', <any>direction);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/voucher/assignment/${assignmentId}/simulation".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Freeze simulation list
     * 
     * @param assignmentId 
     * @param callId 
     */
    private saveFreezeListSimulationWithHttpInfo(assignmentId: number,  callId: number ): Observable<Response> {
        const path = this.basePath + `/voucher/assignment/freeze-simulation-list`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'assignmentId' is not null or undefined
        if (assignmentId === null || assignmentId === undefined) {
            throw new Error('Required parameter assignmentId was null or undefined when calling saveFreezeListSimulation.');
        }
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling saveFreezeListSimulation.');
        }
        if (assignmentId !== undefined) {
            queryParameters.set('assignmentId', <any>assignmentId);
        }
        if (callId !== undefined) {
            queryParameters.set('callId', <any>callId);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/voucher/assignment/freeze-simulation-list".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Save simulation to pre-selected list
     * 
     * @param assignmentId 
     * @param callId 
     */
    private savePreListSimulationWithHttpInfo(assignmentId: number,  callId: number ): Observable<Response> {
        const path = this.basePath + `/voucher/assignment/save-prelist`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'assignmentId' is not null or undefined
        if (assignmentId === null || assignmentId === undefined) {
            throw new Error('Required parameter assignmentId was null or undefined when calling savePreListSimulation.');
        }
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling savePreListSimulation.');
        }
        if (assignmentId !== undefined) {
            queryParameters.set('assignmentId', <any>assignmentId);
        }
        if (callId !== undefined) {
            queryParameters.set('callId', <any>callId);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/voucher/assignment/save-prelist".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Send notifications  to applicants
     * 
     * @param body 
     */
    private sendNotificationForApplicantsWithHttpInfo(body?: number ): Observable<Response> {
        const path = this.basePath + `/voucher/assignment/send-notifications`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/voucher/assignment/send-notifications".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Create voucher assignment
     * 
     * @param body 
     */
    private simulateVoucherAssignmentWithHttpInfo(body?: number ): Observable<Response> {
        const path = this.basePath + `/voucher/assignment/simulate`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/voucher/assignment/simulate".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
