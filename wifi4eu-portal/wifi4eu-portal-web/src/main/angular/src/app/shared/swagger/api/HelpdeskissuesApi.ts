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


export const IHelpdeskissuesApi = new OpaqueToken('IHelpdeskissuesApi');

export interface IHelpdeskissuesApi {


    /**
     * Get all the helpdesk issues
     * 
     * @param c 
     */
    allHelpdeskIssues<T extends models.HelpdeskIssueDTO>(c?: ClassType<T>): Observable<T[]>;
    /**
     * Create helpdesk issue
     * 
     * @param c 
     * @param body 
     */
    createHelpdeskIssue<T extends models.ResponseDTO>(body?: models.HelpdeskIssueDTO, c?: ClassType<T>): Observable<T>;
    /**
     * Get helpdesk issue by specific id
     * 
     * @param c 
     * @param issueId 
     */
    getHelpdeskIssueById<T extends models.HelpdeskIssueDTO>(issueId: number, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class HelpdeskissuesApi implements IHelpdeskissuesApi {
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
     * Get all the helpdesk issues
     * 
     * @param c
     */
    allHelpdeskIssues<T extends models.HelpdeskIssueDTO>(c?: ClassType<T>): Observable<T[]> {

        return this.allHelpdeskIssuesWithHttpInfo()
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
     * Create helpdesk issue
     * 
     * @param c
     * @param body 
     */
    createHelpdeskIssue<T extends models.ResponseDTO>(body?: models.HelpdeskIssueDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.createHelpdeskIssueWithHttpInfo(body)
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
     * Get helpdesk issue by specific id
     * 
     * @param c
     * @param issueId 
     */
    getHelpdeskIssueById<T extends models.HelpdeskIssueDTO>(issueId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getHelpdeskIssueByIdWithHttpInfo(issueId)
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
     * Get all the helpdesk issues
     * 
     */
    private allHelpdeskIssuesWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/helpdesk/issues`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/helpdesk/issues".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Create helpdesk issue
     * 
     * @param body 
     */
    private createHelpdeskIssueWithHttpInfo(body?: models.HelpdeskIssueDTO ): Observable<Response> {
        const path = this.basePath + `/helpdesk/issues`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/helpdesk/issues".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get helpdesk issue by specific id
     * 
     * @param issueId 
     */
    private getHelpdeskIssueByIdWithHttpInfo(issueId: number ): Observable<Response> {
        const path = this.basePath + `/helpdesk/issues/${issueId}`;
//        .replace('{' + 'issueId' + '}', String(issueId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'issueId' is not null or undefined
        if (issueId === null || issueId === undefined) {
            throw new Error('Required parameter issueId was null or undefined when calling getHelpdeskIssueById.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/helpdesk/issues/${issueId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
