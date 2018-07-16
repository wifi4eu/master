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


export const INutsApi = new OpaqueToken('INutsApi');

export interface INutsApi {


    /**
     * create Nuts
     * 
     * @param c 
     * @param body 
     */
    create<T extends models.ResponseDTO>(body?: models.NutsDTO, c?: ClassType<T>): Observable<T>;
    /**
     * get all nuts
     * 
     * @param c 
     */
    findAllNuts<T extends models.NutsDTO>(c?: ClassType<T>): Observable<T[]>;
    /**
     * get country regions
     * 
     * @param c 
     * @param countryCode 
     */
    findCountryRegions<T extends models.NutsDTO>(countryCode: string, c?: ClassType<T>): Observable<T[]>;
    /**
     * get nuts by code
     * 
     * @param c 
     * @param code 
     */
    findNutsByCode<T extends models.NutsDTO>(code: string, c?: ClassType<T>): Observable<T>;
    /**
     * get all nuts from level X
     * 
     * @param c 
     * @param level 
     */
    findNutsByLevel<T extends models.NutsDTO>(level: number, c?: ClassType<T>): Observable<T[]>;

}

@Injectable()
export class NutsApi implements INutsApi {
    protected basePath = 'http://localhost:7001/wifi4eu-financial/api';
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
     * create Nuts
     * 
     * @param c
     * @param body 
     */
    create<T extends models.ResponseDTO>(body?: models.NutsDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.createWithHttpInfo(body)
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
     * get all nuts
     * 
     * @param c
     */
    findAllNuts<T extends models.NutsDTO>(c?: ClassType<T>): Observable<T[]> {

        return this.findAllNutsWithHttpInfo()
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
     * get country regions
     * 
     * @param c
     * @param countryCode 
     */
    findCountryRegions<T extends models.NutsDTO>(countryCode: string, c?: ClassType<T>): Observable<T[]> {

        return this.findCountryRegionsWithHttpInfo(countryCode)
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
     * get nuts by code
     * 
     * @param c
     * @param code 
     */
    findNutsByCode<T extends models.NutsDTO>(code: string, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.findNutsByCodeWithHttpInfo(code)
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
     * get all nuts from level X
     * 
     * @param c
     * @param level 
     */
    findNutsByLevel<T extends models.NutsDTO>(level: number, c?: ClassType<T>): Observable<T[]> {

        return this.findNutsByLevelWithHttpInfo(level)
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
     * create Nuts
     * 
     * @param body 
     */
    private createWithHttpInfo(body?: models.NutsDTO ): Observable<Response> {
        const path = this.basePath + `/nuts`;


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
     * get all nuts
     * 
     */
    private findAllNutsWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/nuts`;


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
     * get country regions
     * 
     * @param countryCode 
     */
    private findCountryRegionsWithHttpInfo(countryCode: string ): Observable<Response> {
        const path = this.basePath + `/nuts/countryRegions/${countryCode}`;
//        .replace('{' + 'countryCode' + '}', String(countryCode));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'countryCode' is not null or undefined
        if (countryCode === null || countryCode === undefined) {
            throw new Error('Required parameter countryCode was null or undefined when calling findCountryRegions.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * get nuts by code
     * 
     * @param code 
     */
    private findNutsByCodeWithHttpInfo(code: string ): Observable<Response> {
        const path = this.basePath + `/nuts/code/${code}`;
//        .replace('{' + 'code' + '}', String(code));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'code' is not null or undefined
        if (code === null || code === undefined) {
            throw new Error('Required parameter code was null or undefined when calling findNutsByCode.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * get all nuts from level X
     * 
     * @param level 
     */
    private findNutsByLevelWithHttpInfo(level: number ): Observable<Response> {
        const path = this.basePath + `/nuts/level/${level}`;
//        .replace('{' + 'level' + '}', String(level));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'level' is not null or undefined
        if (level === null || level === undefined) {
            throw new Error('Required parameter level was null or undefined when calling findNutsByLevel.');
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
