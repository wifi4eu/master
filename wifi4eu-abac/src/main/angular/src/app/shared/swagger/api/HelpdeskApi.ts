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


export const IHelpdeskApi = new OpaqueToken('IHelpdeskApi');

export interface IHelpdeskApi {


    /**
     * Get all the helpdesk entries
     * 
     * @param c 
     */
    allHelpdeskIssues<T extends models.HelpdeskIssueDTO>(c?: ClassType<T>): Observable<T[]>;
    /**
     * create helpdesk comment
     * 
     * @param c 
     * @param body 
     */
    createHelpdeskComment<T extends models.ResponseDTO>(body?: models.HelpdeskCommentDTO, c?: ClassType<T>): Observable<T>;
    /**
     * create helpdesk issue
     * 
     * @param c 
     * @param body 
     */
    createHelpdeskIssue<T extends models.ResponseDTO>(body?: models.HelpdeskIssueDTO, c?: ClassType<T>): Observable<T>;
    /**
     * Get helpdesk issue by issueId
     * 
     * @param c 
     * @param issueId 
     */
    getHelpdeskIssue<T extends models.HelpdeskIssueDTO>(issueId: number, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class HelpdeskApi implements IHelpdeskApi {
    protected basePath = '/';
    public defaultHeaders: Headers = new Headers();
    public configuration: Configuration = new Configuration();

    constructor(protected http: Http, @Optional() @Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration){
        this.basePath=document.querySelector("html head base").getAttribute("href");
        if (configuration) {
            this.configuration = configuration;
        }
    }



    /**
     * Get all the helpdesk entries
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
     * create helpdesk comment
     * 
     * @param c
     * @param body 
     */
    createHelpdeskComment<T extends models.ResponseDTO>(body?: models.HelpdeskCommentDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.createHelpdeskCommentWithHttpInfo(body)
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
     * create helpdesk issue
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
     * Get helpdesk issue by issueId
     * 
     * @param c
     * @param issueId 
     */
    getHelpdeskIssue<T extends models.HelpdeskIssueDTO>(issueId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getHelpdeskIssueWithHttpInfo(issueId)
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
     * Get all the helpdesk entries
     * 
     */
    private allHelpdeskIssuesWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/helpdesk`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * create helpdesk comment
     * 
     * @param body 
     */
    private createHelpdeskCommentWithHttpInfo(body?: models.HelpdeskCommentDTO ): Observable<Response> {
        const path = this.basePath + `/helpdesk/comment`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * create helpdesk issue
     * 
     * @param body 
     */
    private createHelpdeskIssueWithHttpInfo(body?: models.HelpdeskIssueDTO ): Observable<Response> {
        const path = this.basePath + `/helpdesk`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get helpdesk issue by issueId
     * 
     * @param issueId 
     */
    private getHelpdeskIssueWithHttpInfo(issueId: number ): Observable<Response> {
        const path = this.basePath + `/helpdesk/${issueId}`;
//        .replace('{' + 'issueId' + '}', String(issueId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'issueId' is not null or undefined
        if (issueId === null || issueId === undefined) {
            throw new Error('Required parameter issueId was null or undefined when calling getHelpdeskIssue.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

}
