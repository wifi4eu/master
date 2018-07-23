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


export const IThreadApi = new OpaqueToken('IThreadApi');

export interface IThreadApi {


    /**
     * Set mediation to thread
     * 
     * @param c 
     * @param threadId 
     */
    askMediationThread<T extends models.ResponseDTO>(threadId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get thread by specific id
     * 
     * @param c 
     * @param threadId 
     */
    getThreadById<T extends models.ThreadDTO>(threadId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get thread by specific type
     * 
     * @param c 
     * @param type 
     * @param reason 
     */
    getThreadByTypeAndReason<T extends models.ResponseDTO>(type: number, reason: string, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class ThreadApi implements IThreadApi {
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
     * Set mediation to thread
     * 
     * @param c
     * @param threadId 
     */
    askMediationThread<T extends models.ResponseDTO>(threadId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.askMediationThreadWithHttpInfo(threadId)
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
     * Get thread by specific id
     * 
     * @param c
     * @param threadId 
     */
    getThreadById<T extends models.ThreadDTO>(threadId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getThreadByIdWithHttpInfo(threadId)
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
     * Get thread by specific type
     * 
     * @param c
     * @param type 
     * @param reason 
     */
    getThreadByTypeAndReason<T extends models.ResponseDTO>(type: number, reason: string, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getThreadByTypeAndReasonWithHttpInfo(type, reason)
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
     * Set mediation to thread
     * 
     * @param threadId 
     */
    private askMediationThreadWithHttpInfo(threadId: number ): Observable<Response> {
        const path = this.basePath + `/thread/${threadId}/setMediation`;
//        .replace('{' + 'threadId' + '}', String(threadId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'threadId' is not null or undefined
        if (threadId === null || threadId === undefined) {
            throw new Error('Required parameter threadId was null or undefined when calling askMediationThread.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/thread/${threadId}/setMediation".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get thread by specific id
     * 
     * @param threadId 
     */
    private getThreadByIdWithHttpInfo(threadId: number ): Observable<Response> {
        const path = this.basePath + `/thread/${threadId}`;
//        .replace('{' + 'threadId' + '}', String(threadId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'threadId' is not null or undefined
        if (threadId === null || threadId === undefined) {
            throw new Error('Required parameter threadId was null or undefined when calling getThreadById.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/thread/${threadId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get thread by specific type
     * 
     * @param type 
     * @param reason 
     */
    private getThreadByTypeAndReasonWithHttpInfo(type: number,  reason: string ): Observable<Response> {
        const path = this.basePath + `/thread/type/${type}/reason/${reason}`;
//        .replace('{' + 'type' + '}', String(type)) 
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)//        .replace('{' + 'reason' + '}', String(reason));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'type' is not null or undefined
        if (type === null || type === undefined) {
            throw new Error('Required parameter type was null or undefined when calling getThreadByTypeAndReason.');
        }
        // verify required parameter 'reason' is not null or undefined
        if (reason === null || reason === undefined) {
            throw new Error('Required parameter reason was null or undefined when calling getThreadByTypeAndReason.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/thread/type/${type}/reason/${reason}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
