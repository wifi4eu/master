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


export const ICallApi = new OpaqueToken('ICallApi');

export interface ICallApi {


    /**
     * Get the active publication of the call
     * 
     * @param c 
     */
    activeCall<T extends models.PublicationCallDTO>(c?: ClassType<T>): Observable<T>;
    /**
     * Get all the publication of the call
     * 
     * @param c 
     */
    allCalls<T extends models.PublicationCallDTO>(c?: ClassType<T>): Observable<T[]>;
    /**
     * create Call
     * 
     * @param c 
     * @param body 
     */
    createCall<T extends models.ResponseDTO>(body?: models.PublicationCallDTO, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class CallApi implements ICallApi {
    protected basePath = 'http://localhost:7001/wifi4eu/api';
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
     * Get the active publication of the call
     * 
     * @param c
     */
    activeCall<T extends models.PublicationCallDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.activeCallWithHttpInfo()
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
     * Get all the publication of the call
     * 
     * @param c
     */
    allCalls<T extends models.PublicationCallDTO>(c?: ClassType<T>): Observable<T[]> {

        return this.allCallsWithHttpInfo()
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
     * create Call
     * 
     * @param c
     * @param body 
     */
    createCall<T extends models.ResponseDTO>(body?: models.PublicationCallDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.createCallWithHttpInfo(body)
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
     * Get the active publication of the call
     * 
     */
    private activeCallWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/call/active`;


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
     * Get all the publication of the call
     * 
     */
    private allCallsWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/call`;


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
     * create Call
     * 
     * @param body 
     */
    private createCallWithHttpInfo(body?: models.PublicationCallDTO ): Observable<Response> {
        const path = this.basePath + `/call`;


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

}
