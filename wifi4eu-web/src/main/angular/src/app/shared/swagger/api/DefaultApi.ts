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


export const IDefaultApi = new OpaqueToken('IDefaultApi');

export interface IDefaultApi {


    /**
     * User details resource
     * 
     * @param c 
     */
    getIdentity<T extends models.UserContext>(c?: ClassType<T>): Observable<T>;
    /**
     * Country values
     * 
     */
    getSomething(): Observable<string>;
    /**
     * Test resource for Swagger implementation
     * 
     */
    getSomething_1(): Observable<string>;

}

@Injectable()
export class DefaultApi implements IDefaultApi {
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
     * User details resource
     * 
     * @param c
     */
    getIdentity<T extends models.UserContext>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getIdentityWithHttpInfo()
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
     * Country values
     * 
     */
    public getSomething(): Observable<string> {
        return this.getSomethingWithHttpInfo()
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }



    /**
     * Test resource for Swagger implementation
     * 
     */
    public getSomething_1(): Observable<string> {
        return this.getSomething_1WithHttpInfo()
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }



    /**
     * User details resource
     * 
     */
    private getIdentityWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/user-details`;


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
     * Country values
     * 
     */
    private getSomethingWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/country/country`;


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
     * Test resource for Swagger implementation
     * 
     */
    private getSomething_1WithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/test`;


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

}
