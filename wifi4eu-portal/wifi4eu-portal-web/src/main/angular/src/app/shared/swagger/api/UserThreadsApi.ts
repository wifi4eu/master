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


export const IUserThreadsApi = new OpaqueToken('IUserThreadsApi');

export interface IUserThreadsApi {


    /**
     * Get userThreads by specific id
     * 
     * @param c 
     * @param userThreadsId 
     */
    getUserThreadsById<T extends models.UserThreadsDTO>(userThreadsId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get User by specific thread id
     * 
     * @param c 
     * @param threadId 
     */
    getUserThreadsByThreadId<T extends models.UserThreadsDTO>(threadId: number, c?: ClassType<T>): Observable<T[]>;
    /**
     * Get Threads by specific user id
     * 
     * @param c 
     * @param userId 
     */
    getUserThreadsByUserId<T extends models.UserThreadsDTO>(userId: number, c?: ClassType<T>): Observable<T[]>;

}

@Injectable()
export class UserThreadsApi implements IUserThreadsApi {
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
     * Get userThreads by specific id
     * 
     * @param c
     * @param userThreadsId 
     */
    getUserThreadsById<T extends models.UserThreadsDTO>(userThreadsId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getUserThreadsByIdWithHttpInfo(userThreadsId)
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
     * Get User by specific thread id
     * 
     * @param c
     * @param threadId 
     */
    getUserThreadsByThreadId<T extends models.UserThreadsDTO>(threadId: number, c?: ClassType<T>): Observable<T[]> {

        return this.getUserThreadsByThreadIdWithHttpInfo(threadId)
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
     * Get Threads by specific user id
     * 
     * @param c
     * @param userId 
     */
    getUserThreadsByUserId<T extends models.UserThreadsDTO>(userId: number, c?: ClassType<T>): Observable<T[]> {

        return this.getUserThreadsByUserIdWithHttpInfo(userId)
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
     * Get userThreads by specific id
     * 
     * @param userThreadsId 
     */
    private getUserThreadsByIdWithHttpInfo(userThreadsId: number ): Observable<Response> {
        const path = this.basePath + `/userThreads/${userThreadsId}`;
//        .replace('{' + 'userThreadsId' + '}', String(userThreadsId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'userThreadsId' is not null or undefined
        if (userThreadsId === null || userThreadsId === undefined) {
            throw new Error('Required parameter userThreadsId was null or undefined when calling getUserThreadsById.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/userThreads/${userThreadsId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get User by specific thread id
     * 
     * @param threadId 
     */
    private getUserThreadsByThreadIdWithHttpInfo(threadId: number ): Observable<Response> {
        const path = this.basePath + `/userThreads/threadId/${threadId}`;
//        .replace('{' + 'threadId' + '}', String(threadId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'threadId' is not null or undefined
        if (threadId === null || threadId === undefined) {
            throw new Error('Required parameter threadId was null or undefined when calling getUserThreadsByThreadId.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/userThreads/threadId/${threadId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get Threads by specific user id
     * 
     * @param userId 
     */
    private getUserThreadsByUserIdWithHttpInfo(userId: number ): Observable<Response> {
        const path = this.basePath + `/userThreads/userId/${userId}`;
//        .replace('{' + 'userId' + '}', String(userId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'userId' is not null or undefined
        if (userId === null || userId === undefined) {
            throw new Error('Required parameter userId was null or undefined when calling getUserThreadsByUserId.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/userThreads/userId/${userId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
